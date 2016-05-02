/*
Each order is represented by an "order id" (an integer).

We have our lists of orders sorted numerically already, in arrays. Write a function to merge our arrays of orders into one sorted array.

For example:

  int[] myArray     = new int[]{3, 4, 6, 10, 11, 15};
  int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

System.out.println(mergeArrays(myArray, alicesArray));
// prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]

*/
object MergeSortedArrays {
  def main(args: Array[String]) {
    val a = Array(3, 4, 6, 10, 11, 15)
    val b = Array(1, 5, 8, 12, 14, 19)
    println(merge(a, b).mkString(" "))
  }
  
  def merge(a: Array[Int], b: Array[Int]): Array[Int] = {
    if (a.isEmpty) b
    else if (b.isEmpty) a
    else if (a.head < b.head) Array(a.head) ++ merge(a.tail, b)
    else Array(b.head) ++ merge(a, b.tail)
  }
}