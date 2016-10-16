/*
You have a singly-linked list ↴ and want to check if it contains a cycle.
A singly-linked list is built with nodes, where each node has:

node.next—the next node in the list.
node.data—the data held in the node. For example, if our linked list stores people in line at the movies, node.data might be the person's name.
For example:

  public static class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }
}

A cycle occurs when a node’s next points back to a previous node in the list. The linked list is no longer linear with a beginning and end—instead, it cycles through a loop of nodes.

Write a function containsCycle() that takes the first node in a singly-linked list and returns a boolean indicating whether the list contains a cycle.
*/
object LinkedListWithCycle {
  
  case class Node(value: Int) {
    var next: Node = null
  }
  
  def main(args: Array[String]) {
    val a1 = Node(1)
    val a2 = Node(2)
    val a3 = Node(3)
    
    a1.next = a2
    a2.next = a3
    
    val b1 = Node(1)
    val b2 = Node(2)
    val b3 = Node(3)
    
    b1.next = b2
    b2.next = b3
    b3.next = b1

    val c1 = Node(1)
    val c2 = Node(2)
    val c3 = Node(3)
    val c4 = Node(4)
    
    c1.next = c2
    c2.next = c3
    c3.next = c4
    c4.next = c2
    
    println(check(a1))
    println(check(b1))
    println(check(c1))
  }
  
  def check(head: Node): Boolean = {
    var p1 = head
    var p2 = head.next
    var cycle = false
    
    while (p1 != null && p2 != null && !cycle) {
      if (p1 == p2) 
        cycle = true
      else {
        p1 = p1.next
        if (p2.next != null) {
          p2 = p2.next.next
        } else {
          p2 = p2.next
        }
      } 
    }
    cycle
  }
  
  
}