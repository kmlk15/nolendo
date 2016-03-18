

/**
 * @author kmlk15
 */
object PascalTriangle {
  
  def main(args: Array[String]) {
    build(15).foreach(i => println(i.mkString(" ")))
  }
  
  def build(n: Int): List[List[Int]] = {
    val f = List(1)
    var r = List(f)
    if (n == 1) {
      r
    } else {
      var t = f
      for (i <- 2 to n) {
        var c = t.toArray
        var a = f       
        for (j <- 1 until i - 1) {
          a = a :+ c(j-1) + c(j)
        }
        a = a ++ f
        t = a
        r = r :+ a
      } 
      r        
    }
    
  }
}