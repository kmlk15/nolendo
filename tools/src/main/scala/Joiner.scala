import java.io.File

object Joiner {

  def main(args: Array[String]) {
	val d = new File(args(0))  
    
    val list = d.listFiles.filter(_.isFile).map(_.getName()).filter(_.contains(".mp4")).toList

    list.groupBy(s => s.substring(0, s.lastIndexOf("-"))).foreach { case (k, v) => {
      val group = v.map(name => {
        val prefix = name.split('.')(0)
        println(s"./ffmpeg -i $name -c copy -bsf:v h264_mp4toannexb -f mpegts $prefix.ts")
        println("sleep 1")
        
        prefix
      })
      val sorted = group.sortWith((a: String, b: String) => a.split('-').last.toInt < b.split('-').last.toInt).map(n => s"$n.ts")
      println(s"./ffmpeg -i 'concat:${sorted.mkString("|")}' -c copy -bsf:a aac_adtstoasc $k.mp4")
      println("sleep 1")
      println(s"rm -rf ${sorted.mkString(" ")}")
    }}
  }
  
}