import scala.collection.mutable.Map

/**
 * @author kmlk15
 */
object MapNodes {
  def main(args: Array[String]) {
    val input = List((1, 2), (1, 3), (2, 4), (2, 5), (3, 6), (3, 7), (3, 8), (4, 9), (4, 10))

    var ans = Map.empty[Int, List[Int]]
    var mapping = Map.empty[Int, Int]

    input.foreach(i => {
      mapping = mapping + (i._2 -> i._1)
      if (ans.contains(i._1)) {
        ans(i._1) = ans(i._1) :+ i._2
      } else {
        ans = ans + (i._1 -> List(i._2))
      }
      def get(in: Int, m: Map[Int, Int]): List[Int] = {
        if (m.contains(in)) {
          m(in) :: get(m(in), m)
        } else {
          Nil
        }
      }

      get(i._1, mapping).foreach(g => {
        ans(g) = ans(g) :+ i._2
      })
    })

    ans.foreach(println)

  }

}