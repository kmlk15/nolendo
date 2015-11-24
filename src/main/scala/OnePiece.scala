import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import java.io.StringWriter
import org.apache.commons.io.IOUtils

object OnePiece {

  def main(args: Array[String]) {

    val id = args(0)
    
    val httpclient = HttpClients.createDefault()
    val httpget = new HttpGet("http://dmdata.leyingtuan.com/mobileapp/ckplayer65/video.php?url=" + id + "_tudou")
    val response = httpclient.execute(httpget)

    try {
      val writer = new StringWriter
      IOUtils.copy(response.getEntity.getContent, writer, "UTF-8")

      val xml = scala.xml.XML.loadString(writer.toString)

      (xml \ "video").foreach(video => {
        val f = (video \ "file").text
        println(f)
      })

    } finally {
      response.close()
    }

  }

}