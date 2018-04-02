import scala.collection.mutable.ListBuffer

/*
A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".

  We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.

Example 1:
  Input:
["9001 discuss.leetcode.com"]
Output:
["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
Explanation:
  We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.

Example 2:
  Input:
["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
Output:
["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
Explanation:
  We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.

Notes:

The length of cpdomains will not exceed 100.
The length of each domain name will not exceed 100.
Each address will have either 1 or 2 "." characters.
The input count in any count-paired domain will not exceed 10000.
The answer output can be returned in any order.
*/

object SubdomainVisitCount {

  def main(args: Array[String]) {
    val input1 = List("9001 discuss.leetcode.com")
    val input2 = List("900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org")

    println(check(input1))
    println(check(input2))
  }

  def check(input: List[String], current: List[(String, Int)] = List.empty): Map[String, Int] = {
    input match {
      case Nil => current.groupBy(_._1).mapValues(_.map(_._2).sum)
      case head :: tail => check(tail, current ++ extract(head))
    }
  }

  def extract(str: String): List[(String, Int)] = {
    val arr = str.split(" ")
    val count = arr(0).toInt
    val output = ListBuffer[(String, Int)]()
    val parts = arr(1).split('.')

    for (i <- parts.indices) {
      output += (parts.takeRight(i+1).mkString(".") -> count)
    }
    output.toList
  }

}
