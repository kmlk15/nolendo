

/**
 * @author kmlk15
 */
object BinaryTreeLevelOrder {

  case class Node(value: Int, left: Node, right: Node)
  var curr = List.empty[Node]
  var next = List.empty[Node]

  def main(args: Array[String]) {
    val tree = Node(1, Node(2, Node(4, null, null), Node(5, null, null)), Node(3, Node(6, null, null), Node(7, null, null)))
    
    printTree(tree)
  }

  def printTree(node: Node) {
    curr = curr :+ node

    while (curr.length > 0) {
      curr.foreach(i => {
        if (i.left != null)
          next = next :+ i.left
        if (i.right != null)
          next = next :+ i.right
      })
      println(curr.map(_.value).mkString(" "))

      curr = next
      next = List.empty[Node]
    }
  }
}