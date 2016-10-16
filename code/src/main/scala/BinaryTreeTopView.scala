

/**
 * @author kmlk15
 */
object BinaryTreeTopView {
  
  case class Node(value: Int, left: Node, right: Node)
  var curr = List.empty[Node]

  def main(args: Array[String]) {
    val tree = Node(1, Node(2, Node(4, null, null), Node(5, null, null)), Node(3, Node(6, null, null), Node(7, null, null)))
    
    side(tree)
    side2(tree)
  }

  def side(node: Node) {
    left(node)
    if (node.right != null) {
      right(node.right)
    }
    
    println(curr.map(_.value).mkString(" "))
  }
  
  def side2(node: Node) {
    var cur = node
    var list = List.empty[Node]
    
    while (cur != null) {
      list = cur :: list
      cur = cur.left
    }
    cur = node.right
    
    while (cur != null) {
      list = list :+ cur
      cur = cur.right
    }
    println(list.map(_.value).mkString(" "))
  }
  
  def left(node: Node) {
    if (node.left != null) {
      left(node.left)
    }
    curr = curr :+ node
  }

  def right(node: Node) {
    curr = curr :+ node
    if (node.right != null) {
      right(node.right)
    }
  }
  
  
}