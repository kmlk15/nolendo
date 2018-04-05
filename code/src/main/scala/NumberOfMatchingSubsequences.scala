/*
Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

Example :
Input:
S = "abcde"
words = ["a", "bb", "acd", "ace"]
Output: 3
Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
Note:

All words in words and S will only consists of lowercase letters.
The length of S will be in the range of [1, 50000].
The length of words will be in the range of [1, 5000].
The length of words[i] will be in the range of [1, 50].

 */
object NumberOfMatchingSubsequences {

  def main(args: Array[String]): Unit = {
    println(check("abcde", List("a", "bb", "acd", "ace")))
  }

  def check(input: String, dict: List[String]): Int = {
    var count = 0
    var cur = List.empty[String]

    input.foreach(c => {
      val nowDict = dict.filter(_.startsWith(c.toString)).map(_.drop(1))
      val (upCur, nonCur) = cur.partition(_.startsWith(c.toString))
      println(c + " = " + count + " = " + nowDict.mkString(" ") + " ~ " + nonCur.mkString(" ") + " ~ " + upCur.map(_.drop(1)).mkString(" "))
      val now = nowDict ++ nonCur ++ upCur.map(_.drop(1))
      count = count + now.count(_.isEmpty)
      cur = now.filter(_.nonEmpty)
    })

    count
  }

  def take(in: List[String], c: String): List[String] = {
    in.filter(_.startsWith(c)).map(_.drop(1))
  }
}
