object Prime {
  
  def main(args: Array[String]) {
    
    for (i <- 3 until 100) {
      if (check(i, 2)) println(i)
    }
  }
  
  def check(i: Double, m: Double): Boolean = {
    i % m match {
      case 0 => false
      case _ => i / m match {
        case x if x > m => check(i, m+1)
        case _ => true
      }
      
    }
    
  }
}