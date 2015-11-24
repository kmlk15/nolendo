import play.api.libs.json.Json
import play.api.libs.json.JsValue

object Test {

  def main(args: Array[String]) {

    val s = """{"reachability":""}"""

    lazy val jsObj = Json

    val js = jsObj.parse(s)
    
    println((js \ "reachability").asOpt[Int])
    
    println((js \ "reachability").asOpt[String])
  }

}