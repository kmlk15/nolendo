

/**
 * @author kmlk15
 */
object KthToLastNode {
  
  case class Node(value: Int) {
    var next: Node = null
  }
  
  
  def main(args: Array[String]) {
    
    val a = Node(1)
    val b = Node(2)
    val c = Node(3)
    val d = Node(4)
    
    a.next = b
    b.next = c
    c.next = d
    
    val ans = findRight(2, a)
    println(ans)
  }
  
  def findRight(k: Int, n: Node): Node = {
    var c = n
    var a = n
    var l = 1
    while (c.next != null) {
      c = c.next
      l += 1
    }
    
    var r = l - k
    while (r > 0) {
      a = a.next
      r -= 1
    }
    
    a    
  } 
}