object Paths {
  def main(args: Array[String]) {
    val x = List("0", "0")
    val y = List("1", "1")
    val z = List("2", "2")
    
    run(x, y, List.empty[String]).foreach(println)
    
    run3(x, y, z, List.empty[String]).foreach(println)
  }
  
  def run(x: List[String], y: List[String], current: List[String]): List[String] ={
    if (x.length == 0) {
      List((current ++ y).mkString(""))
    } else if (y.length == 0) {
      List((current ++ x).mkString(""))
    } else {
      run(x.tail, y, current :+ x.head) ++ run(x, y.tail, current :+ y.head)
    }
  }

  def run3(x: List[String], y: List[String], z: List[String], current: List[String]): List[String] ={
    if (x.length == 0) {
      run(y, z, current)
    } else if (y.length == 0) {
      run(x, z, current)
    } else if (z.length == 0) {
      run(x, y, current)
    } else {
      run3(x.tail, y, z, current :+ x.head) ++ run3(x, y.tail, z, current :+ y.head) ++ run3(x, y, z.tail, current :+ z.head)
    }
  }

}