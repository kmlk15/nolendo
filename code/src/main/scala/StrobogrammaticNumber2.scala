/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.
*/
object StrobogrammaticNumber2 {
  def main(args: Array[String]) {
    println(build(2).mkString(","))
    println(build(3).mkString(","))
    println(build(4).mkString(","))
  }
  
  def build(i: Int): List[String] = {
    def in(i: Int, list: List[String]): List[String] = {
      if (i == 0) {
        list
      } else {
        val add = if (i > 2) List("0", "1", "8") else List("1", "8")
        
        val result = list.flatMap(l => {
          add.map(n => {  
            n + l + n
          }) ++ List("6" + l + "9") ++ List("9" + l + "6")
        })
        in(i - 2, result)
      } 
    }
    if (i % 2 == 0) {
      in(i, List(""))      
    } else {
      in(i-1, List("0", "1", "8"))
    }
  }
  
}