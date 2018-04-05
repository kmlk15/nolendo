object LoveRectangle {

  def main(args: Array[String]) {
    
    println(findLove(Retangle(1, 5, 10, 4), Retangle(3, 7, 15, 11)))
    
    println(findLove(Retangle(1, 5, 10, 4), Retangle(13, 11, 5, 1)))

    println(findLove(Retangle(1, 5, 10, 4), Retangle(2, 6, 1, 1)))
    
    println(findLove(Retangle(1, 5, 10, 4), Retangle(11, 9, 1, 1)))
  }
  
  def findLove(r1: Retangle, r2: Retangle): Retangle = {
    val x = r1.x > r2.x match {
      case true => r1.x
      case _ => r2.x
    }
    
    val y = r1.y > r2.y match {
      case true => r1.y
      case _ => r2.y
    }
    
    val w = (r1.x + r1.w) < (r2.x + r2.w) match {
      case true => r1.x + r1.w - x
      case _ => r2.x + r2.w - x
    }
    
    val h = (r1.y + r1.h) < (r2.y + r2.h) match {
      case true => r1.y + r1.h - y
      case _ => r2.y + r2.h - y
    }
    
    (w <= 0 || h <= 0) match {
      case true => Retangle(0, 0, 0, 0) 
      case _ => Retangle(x, y, w, h)
    }
  }

  case class Retangle(x: Int, y: Int, w: Int, h: Int) {

    override def toString = s"X: $x, Y: $y, W: $w, H: $h"

  }
}

