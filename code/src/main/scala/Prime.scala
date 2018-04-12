object Prime {
  
  def main(args: Array[String]) {
    
    for (i <- 2 until 100) {
      if (check(i)) println(i)
    }
  }
  
  def check(i: Int): Boolean = {
    if (i % 2 == 0) return false
    else {
      for (j <- 3 until i by 2 if j * j < i) {
        if (i % j == 0) return false
      }
    }
    true
  }
}