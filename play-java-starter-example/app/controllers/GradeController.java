package controllers;

import io.ebean.Ebean;
import models.User;
import models.Grade;
import models.AccGrade;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Date;

public class GradeController extends Controller {
    //成績のデータを返す
    public Result gradeList(String username) {
        User user = Ebean.find(User.class).where().eq("username",username).findOne();
        return ok(Json.toJson(user.grade));
    }
//userと同じ志望校の人の成績を返す
    public Result gradesList(String username) {
        User user = Ebean.find(User.class).where().eq("username",username).findOne();
        List<Grade> all_grades = Ebean.find(Grade.class).findList();
        List<Grade> grades = new ArrayList<>();
        for(Grade grade : all_grades){
            if(grade.user.uni_area.equals(user.uni_area)
               && grade.user.university.equals(user.university)
               && grade.user.major.equals(user.major))
            {
                grades.add(grade);

            }
        }
        return ok(Json.toJson(grades));
    }

    public Result accGradeList(String username){
        List<AccGrade> acc = Ebean.find(AccGrade.class).where().eq("username",username)
                                .orderBy("registeredAt asc").findList();
        return ok(Json.toJson(acc));
    }

    public Result registerGrade(String username) {
        try {
            final Map<String, String[]> request = request().body().asFormUrlEncoded();
            User user = Ebean.find(User.class).where().eq("username",username).findOne();
            String subject = request.get("register-subject")[0];
            int now = Integer.parseInt(request.get("register-now")[0]);
            //String tag = request.get("register-tag")[0];
            final Grade entry = new Grade(username,subject,now,"tag");
            entry.user = user;
            entry.save();
            return gradeList(username);
        } catch (Exception e) {
            System.out.println(e);
            return badRequest();
        }
    }

    public Result editGrade() {
        try {
            final Map<String, String[]> request = request().body().asFormUrlEncoded();
            // モデル更新
            String username = request.get("username")[0];
            User user = Ebean.find(User.class).where().eq("username",username).findOne();
            int index = Integer.parseInt(request.get("index")[0]);
            int new_grade = Integer.parseInt(request.get("new-grade")[0]);
            user.grade.get(index).nowGrade = new_grade;
            user.save();
            return gradeList(username);
        } catch (Exception e) {
            System.out.println(e);
            return badRequest();
        }
    }

    public Result removeGrade(){
        try {
            final Map<String, String[]> request = request().body().asFormUrlEncoded();
            // モデル削除
            String username = request.get("username")[0];
            User user = Ebean.find(User.class).where().eq("username",username).findOne();
            int index = Integer.parseInt(request.get("index")[0]);
            Grade grade = Ebean.find(Grade.class).where().eq("id",user.grade.get(index).id).findOne();
            //userでリストから削除したのちgrade自体を削除
            user.grade.remove(index);
            grade.delete();
            user.save();
            return gradeList(username);
        } catch (Exception e) {
            System.out.println(e);
            return badRequest();
        }

    }

    public Result registerAccGrade(String username) {
        try {
            final Map<String, String[]> request = request().body().asFormUrlEncoded();
            User user = Ebean.find(User.class).where().eq("username",username).findOne();
            Date date = new Date();
//            String tag = request.get("tag")[0];
            for (String key : request.keySet()) {
                if(!key.equals("csrfToken")) {
                    final AccGrade entry = new AccGrade(username, key, Integer.parseInt(request.get(key)[0]),"tag",date.getTime());
                    entry.user = user;
                    entry.save();

                }
            }

            return accGradeList(username);
        } catch (Exception e) {
            System.out.println(e);
            return badRequest();
        }
    }

}
