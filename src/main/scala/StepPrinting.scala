object StepPrinting {

  def main(args: Array[String]) {
    val input = List(3, 4, 5, 7, 75, 76, 99)
    println(step(input, 1, 100))
  }

  def step(input: List[Int], start: Int, end: Int): String = {
    var output = List.empty[String]
    var cur = start
    
    input.foreach(item => {
      if (cur < item) {
        if (item - cur == 1) {
          output = output :+ cur.toString
        } else {
          output = output :+ cur + "-" + (item-1)  
        }
      }
      cur = item+1
    })
    if (cur <= end) {
      if (end - cur == 1) {
        output = output :+ cur.toString
      } else if (end == cur) {
        output = output :+ end.toString  
      } else {
        output = output :+ cur + "-" + end
      }
    }
    
    output.mkString(",")    
  }

}