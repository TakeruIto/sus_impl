
package views.html.calendar

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <title>"""),_display_(/*5.13*/title),format.raw/*5.18*/("""</title>
    <link rel="stylesheet" href=""""),_display_(/*6.35*/routes/*6.41*/.Assets.versioned("stylesheets/calendar.css")),format.raw/*6.86*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*7.55*/routes/*7.61*/.Assets.versioned("images/favicon.png")),format.raw/*7.100*/("""">
    <link rel="stylesheet" href=""""),_display_(/*8.35*/routes/*8.41*/.Assets.versioned("stylesheets/fontawesome-free-5.5.0-web/css/all.css")),format.raw/*8.112*/("""">
</head>
<body>
    <main>
            """),format.raw/*13.35*/("""
            """),_display_(/*14.14*/content),format.raw/*14.21*/("""
       """),format.raw/*15.8*/("""</main>
    <script src=""""),_display_(/*16.19*/routes/*16.25*/.Assets.versioned("/javascripts/jquery/jquery.js")),format.raw/*16.75*/(""""></script>
    <script src=""""),_display_(/*17.19*/routes/*17.25*/.Assets.versioned("/javascripts/calendar.js")),format.raw/*17.70*/(""""></script>
    <script src=""""),_display_(/*18.19*/routes/*18.25*/.Assets.versioned("/javascripts/fetch/fetch.js")),format.raw/*18.73*/(""""></script>

</body>
</html>"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Dec 11 10:59:55 JST 2018
                  SOURCE: /cs-home/cs-student/kinota.w.aa/Desktop/git/sus_impl/play-java-starter-example/app/views/calendar/main.scala.html
                  HASH: 28ca19e2eab731f0f86de509003b5c750be922a0
                  MATRIX: 961->1|1085->32|1163->84|1188->89|1257->132|1271->138|1336->183|1419->240|1433->246|1493->285|1556->322|1570->328|1662->399|1731->533|1772->547|1800->554|1835->562|1888->588|1903->594|1974->644|2031->674|2046->680|2112->725|2169->755|2184->761|2253->809
                  LINES: 28->1|33->2|36->5|36->5|37->6|37->6|37->6|38->7|38->7|38->7|39->8|39->8|39->8|43->13|44->14|44->14|45->15|46->16|46->16|46->16|47->17|47->17|47->17|48->18|48->18|48->18
                  -- GENERATED --
              */
          