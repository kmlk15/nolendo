
// NOT DONE


/**
 * @author kmlk15
 */
object WaterTank {
  def main(args: Array[String]) {
    
    val input = List(2,10,4,6,1,7,9,8,11,5,3)
    
    

  }
  
  def walk(input: List[Int]): Double = {
    val d = input.map(_.toDouble)
    
    var gh = 0d
    var lh = 0d
    var sum = 0d
    var count = 0d
    
    d.foreach(i => {
      if (gh < i) {
        sum -= count
      }
      
    })
    
    0d
  } 
}