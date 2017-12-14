
/*
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
For example:
Given a binary tree {1,2,3,4,5},

	  1
   / \
  2   3
 / \
4   5
 
return the root of the binary tree [4,5,2,#,#,3,1].
 
    4
   / \
  5   2
 / \
3   1

*/

object BinaryTreeUpsideDown {

  case class Node(value: Int) {
    var left: Node = null
    var right: Node = null
  }
  var curr = List.empty[Node]
  var next = List.empty[Node]

  def main(args: Array[String]) {
    val tree = Node(1)
    tree.left = Node(2)
    tree.right = Node(3)
    tree.left.left = Node(4)
    tree.left.right = Node(5)
    
    printTree(run(tree))
  }

  def run(root: Node): Node = {    
    var node = root
    var right: Node = null
    var parent: Node = null
    while (node != null) {
//      val left =     
//      left = parent.right
//      right = parent
//      parent = parent.left
//      parent.left = left
//      parent.right = right
    }
    parent 
  }
  
  

  def printTree(node: Node) {
    curr = curr :+ node

    while (curr.length > 0) {
      curr.foreach(i => {
        if (i.value != 0) {
          if (i.left != null)
            next = next :+ i.left
          else 
            next = next :+ Node(0)
          if (i.right != null)
            next = next :+ i.right
          else 
            next = next :+ Node(0)
        }
      })
      println(curr.map(_.value).mkString(" "))

      curr = next
      next = List.empty[Node]
    }
  }
}
