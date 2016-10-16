

/**
 * @author kmlk15
 */
object BinaryTreeDepthOrder {

  case class Node(value: Int, left: Node, right: Node)
  var curr = List.empty[Node]
  var next = List.empty[Node]
  var pre = List.empty[Int]
  var in = List.empty[Int]
  var post = List.empty[Int]
  
  def main(args: Array[String]) {
    val tree = Node(1, Node(2, Node(4, null, null), Node(5, null, null)), Node(3, Node(6, null, null), Node(7, null, null)))
    
    preorder(tree)
    println("Preorder: " + pre.mkString(" "))
    inorder(tree)
    println("Inorder: " + in.mkString(" "))
    postorder(tree)
    println("Postorder: " + post.mkString(" "))
  }

  def preorder(node: Node) {
    if (node != null) {
      pre = pre :+ node.value
      preorder(node.left)
      preorder(node.right)
    }
  }

  def inorder(node: Node) {
    if (node != null) {
      inorder(node.left)
      in = in :+ node.value
      inorder(node.right)
    }
  }

  def postorder(node: Node) {
    if (node != null) {
      postorder(node.left)
      postorder(node.right)
      post = post :+ node.value
    }
  }
  
}