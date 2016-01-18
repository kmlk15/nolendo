import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import java.io.StringWriter
import org.apache.commons.io.IOUtils
import java.io.File
import java.io.FileOutputStream

object OnePiece {

  def main(args: Array[String]) {

    val id = args(0)
    
    val httpclient = HttpClients.createDefault()
    //val httpget = new HttpGet("http://dmdata.leyingtuan.com/mobileapp/ckplayer65/video.php?url=" + id + "_tudou")
    val httpget = new HttpGet("http://api.ktkkt.com/tyyp.php?v=" + id + "&t=ck")
    val response = httpclient.execute(httpget)

    try {
      val writer = new StringWriter
      IOUtils.copy(response.getEntity.getContent, writer, "UTF-8")

      val xml = scala.xml.XML.loadString(writer.toString)

      (xml \ "video").foreach(video => {
        val f = (video \ "file").text

        val fileGet = new HttpGet(f);
        val fileResponse = httpclient.execute(fileGet)
        try {
          val fileEntity = fileResponse.getEntity()
          if (fileEntity != null) {
            val file = new File(id + ".flv")
            val outputStream = new FileOutputStream(file)
            val inputStream = fileEntity.getContent()
            IOUtils.copy(inputStream, outputStream)
            outputStream.close
          }
        } finally {
          fileResponse.close
        }
      })

    } finally {
      response.close()
    }
  }
}