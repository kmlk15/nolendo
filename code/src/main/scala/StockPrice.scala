object StockPrice {

  def main(args: Array[String]) {

    val input = List(4, 3, 7, 8, 9, 2, 10, 4 ,13)

    var min = Integer.MAX_VALUE
    var max = Integer.MIN_VALUE
    var map = Map.empty[Int, (Int, Int)]
    
    input.foreach(i => {
      if (i < min) {
        if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
          map = map ++ Map((max - min) -> (min, max))
          max = Integer.MIN_VALUE
        } 
        min = i
      } else if (i > max) {
        max = i
      }
    })
    if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
      map = map ++ Map((max - min) -> (min, max))
    }
    
    println(map.toList.sortWith((a, b) => a._1 > b._1).head)
  }

  
}