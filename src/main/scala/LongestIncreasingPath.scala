

/**
 * @author kmlk15
 */
object LongestIncreasingPath {
  def main(args: Array[String]) {
    val input1 = Array(Array(9, 9, 4), Array(6, 6, 8), Array(2, 1, 1))
    val input2 = Array(Array(9, 9, 4), Array(6, 6, 8), Array(2, 1, 1))
    val input3 = Array(Array(1, 2, 3), Array(8, 9, 4), Array(7, 6, 5))
    
    println(doit(input1))
    println(doit(input2))
    println(doit(input3))
  }
  
  def doit(m: Array[Array[Int]]): Int = {
    var max = 0
    for (i <- 0 until m.length) {
      for (j <- 0 until m(i).length) {
        val c = walk(m, i, j, m(i)(j), 1)
        if (c > max) {
          max = c
        }
//        println("========= " + max + c)
      }
    }
    
    max    
  }
  
  def walk(m: Array[Array[Int]], x: Int, y: Int, cur: Int, count: Int): Int = {
//    println(x + " " + y + " " + cur + " " + count)
    var res = count
    if (x > 0 && m(x-1)(y) > cur) {
      val t = walk(m, x-1, y, m(x-1)(y), count + 1)
      if (t > res) res = t
    } 
    if (x < m.length-1 && m(x+1)(y) > cur) {
      val t = walk(m, x+1, y, m(x+1)(y), count + 1)
      if (t > res) res = t
    }    
    if (y > 0 && m(x)(y-1) > cur) {
      val t = walk(m, x, y-1, m(x)(y-1), count + 1)
      if (t > res) res = t
    }    
    if (y < m(x).length-1 && m(x)(y+1) > cur) {
      val t = walk(m, x, y+1, m(x)(y+1), count + 1)
      if (t > res) res = t
    }    
    
    res
  }
}