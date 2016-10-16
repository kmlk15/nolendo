/**
 * @author kmlk15
 */
object Premutation {
  def main(args: Array[String]) {
    val input = "abcd"
    
    println(build(input).mkString(" "))
  }
  
  def build(arr: String): Array[String] = {
    if (arr.size == 2) {
      Array(arr, arr.reverse)
    } else {
      val result = for (i <- 0 until arr.size) yield {
        build(arr.substring(0, i) + arr.substring(i+1)).map(x => {
          arr.charAt(i).toString + x  
        })   
      } 
      result.toArray.flatten
    }
  }
}