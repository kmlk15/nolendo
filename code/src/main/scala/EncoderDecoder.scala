/**
Problem Description:

Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}

Machine 2 (receiver) has the function:

vector<string> decode(string s) {
  //... your code
  return strs;
} 

So Machine 1 does:

string encoded_string = encode(strs);

and Machine 2 does:

vector<string> strs2 = decode(encoded_string);

strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note:

    The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
    Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
    Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 */

object EncoderDecoder {
  def main(args: Array[String]) {
    println(encode(List("aaa", "b!b", "1234567890")))
    println(decode(encode(List("aaa", "b!b", "1234567890"))).mkString(" "))
  }
  
  def encode(input: List[String]): String = {
    input.map(i => {
      i.size + "#" + i      
    }).mkString("")
  }
  
  def decode(input: String): List[String] = {
    val array = input.toCharArray
    var result = List.empty[String]
    var cur = 0
    var len = ""
    while (cur < array.size) {
      if (len != "" && array(cur) == '#') {
        val tmp = for (i <- cur+1 to cur+len.toInt) yield {
          array(i)            
        }
        result = result :+ tmp.mkString("")
        cur = cur + len.toInt
        len = ""
      } else {
        len = len + array(cur)
      }
      cur = cur + 1
    }
    
    result
  }
}