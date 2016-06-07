/*
 You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter). 
 */
object SubstringWithConcatenationOfAllWords {
  def main(args: Array[String]) {
    val input = "barfoothefoobarman"
    val words = Array("bar", "foo")
    val words2 = Array("foo", "the")
    
    println(find(input, words))
    println(find(input, words2))
  }
  
  def find(input: String, words: Array[String]): List[Int] = {
    var result = List.empty[Int]
    var index = 0
    var i = 0
    var tw = words.clone
    
    while (i < input.length) {
      val cur = input.substring(i, Math.min(i+3, input.length-1))
      tw = tw.filter(x => x != cur)
      if (tw.size == words.size) {
        i = i + 1
        index = index + 1
      } else {
        if (tw.isEmpty) {
          tw = words.clone
          result = result :+ index
          index = i + 3 
        }
        i = i + 3
      }
    }
    
    result
  }
}