

/**
 * @author kmlk15
 */
object PremutationWithDupEntries {
  def main(args: Array[String]) {
    val input = "aab"

    println(build(input).mkString(" "))
  }

  def build(str: String): Set[String] = {
    var result = Set(str)

    val arr = str.toCharArray()
    for (i <- 0 until arr.size) {
      for (j <- 0 until arr.size) {
        if (i != j && arr(i) != arr(j)) {
          val cur = arr.clone
          val tmp = cur(i)
          cur(i) = cur(j)
          cur(j) = tmp
          
          result = result ++ Set(cur.mkString(""))
        }
      }
    }

    result
  }

}