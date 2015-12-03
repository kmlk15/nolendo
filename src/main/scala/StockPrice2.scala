object StockPrice2 {

  def main(args: Array[String]) {

    val input = List(4, 3, 7, 8, 9, 2, 10, 4 ,13)

    var min = Integer.MAX_VALUE
    var max = Integer.MIN_VALUE
    var amin = 0
    var amax = 0
    
    input.foreach(i => {
      if (i < min) {
        if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
          if ((max - min) > (amax - amin)) {
            amax = max
            amin = min
          }
          max = Integer.MIN_VALUE
        } 
        min = i
      } else if (i > max) {
        max = i
      }
    })
    if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
      if ((max - min) > (amax - amin)) {
        amax = max
        amin = min
      }
    }
    
    println(amin + " ~ " + amax + " ~ " + (amax - amin))
  }

  
}