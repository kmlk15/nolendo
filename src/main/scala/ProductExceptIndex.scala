object ProductExceptIndex {
  def main(args: Array[String]) {
    val list = Array(1d, 7d, 3d, 4d)
    var result = Array(1d, 1d, 1d, 1d)
    var n = 1d
    
    for (i <- 1 until 4) {
      n = n * list(i-1)
      result(i) = n
    }
        
    n = 1d
    for (i <- list.length - 2 to 0 by -1) {
      n = n * list(i+1)
      result(i) = result(i) * n 
    }
    
    result.foreach(println)
  }
  
  
  
}