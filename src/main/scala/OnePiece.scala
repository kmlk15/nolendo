import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import java.io.StringWriter
import org.apache.commons.io.IOUtils
import java.io.File
import java.io.FileOutputStream
import java.io.BufferedInputStream
import org.apache.http.client.ResponseHandler
import org.apache.http.HttpResponse
import org.apache.commons.io.FileUtils
import java.io.FileInputStream
import java.io.InputStreamReader
import java.io.BufferedReader
import scala.collection.JavaConversions
import org.joda.time.DateTime._

// File List is at : http://www.ktkkt.com/playdata/75/331.js?54924.7

object OnePiece {

  def main(args: Array[String]) {

    args.length match {
      case 2 =>
        time(args(1), args(0) + ".mp4")
      case _ =>
        val fis = new FileInputStream("list")
        val isr = new InputStreamReader(fis, "UTF-8")
        val br = new BufferedReader(isr)
        try {
          var line = br.readLine()
          while (line != null) {
            val spt = line.split(" ")
            time(spt(1), spt(0) + ".mp4")
            line = br.readLine()
          }
        } finally {
          br.close
          isr.close
          fis.close
        }
    }

  }

  def time(id: String, fn: String) {
    println("Downloading " + fn)
    val start = now
    var succeed = download(id, fn)
    while (!succeed) {
      succeed = download(id, fn)
    }
    val diff = now.getMillis - start.getMillis
    val sec = (diff.toDouble / 1000 % 60).toInt
    val min = (diff.toDouble / (60 * 1000)).toInt
    println("Download Completed - " + min + " minutes " + sec + " seconds")
  }

  def download(id: String, fn: String): Boolean = {
    val httpclient = HttpClients.createDefault()
    val httpget = new HttpGet("http://api.ktkkt.com/tyyp.php?v=" + id + "&t=ck")
    val response = httpclient.execute(httpget)

    try {
      val writer = new StringWriter
      IOUtils.copy(response.getEntity.getContent, writer, "UTF-8")

      val xml = scala.xml.XML.loadString(writer.toString)

      (xml \ "video").foreach(video => {
        val f = (video \ "file").text
        val fileGet = new HttpGet(f);
        val file = new File(fn)
        val fileResponse = httpclient.execute(fileGet, new FileDownloadResponseHandler(file))
      })
      true
    } catch {
      case e: Exception => false
    } finally {
      response.close
      IOUtils.closeQuietly(httpclient)
    }
  }

  class FileDownloadResponseHandler(target: File) extends ResponseHandler[File] {
    override def handleResponse(response: HttpResponse) = {
      FileUtils.copyInputStreamToFile(response.getEntity.getContent, target)

      target
    }
  }
}