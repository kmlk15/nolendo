/*
Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
*/
object MissingRange {
  def main(args: Array[String]) {
    val input = List(0, 1, 3, 50, 75)  
    
    println(build(List(0, 1, 3, 50, 75, 98), 0, 99).mkString(","))
    println(build(List(3, 4, 5, 7, 75, 76, 99), 0, 99).mkString(","))
  }
  
  def build(input: List[Int], start: Int, end: Int): List[String] = {
    var result = List.empty[String]
    var cur = start
    
    input.foreach(item => {
      if (cur < item) {
        if (item - cur == 1) {
          result = result :+ cur.toString
        } else {
          result = result :+ cur + "-" + (item - 1)
        }
      }
      cur = item + 1
    })
    if (cur <= end) {
      if (end == cur) {
        result = result :+ cur.toString
      } else {
        result = result :+ cur + "-" + end
      }
    }
    
    result
  }
  
}