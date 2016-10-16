/**
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to num2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/
object IntersectionOfTwoArrays {
  def main(args: Array[String]) {
    val a = List(1, 2, 2, 1)
    val b = List(2, 2)
    
    println(check(a, b))
  }
  
  def check(a: List[Int], b: List[Int]): List[Int] = {
    val sa = a.sortWith((x: Int, y: Int) => x < y)
    val sb = b.sortWith((x: Int, y: Int) => x < y)
    
    var result = List.empty[Int]
    var ca = 0
    var cb = 0
       
    while (ca < sa.length && cb < sb.length) {
      if (sa(ca) == sb(cb)) {
        result = result :+ sa(ca)
        ca = ca + 1
        cb = cb + 1
      } else if (sa(ca) < sb(cb)) {
        ca = ca + 1
      } else {
        cb = cb + 1
      }
    }
    
    result
  }
  
}