import CheapestFlightsWithinKStops.Flight

import scala.util.Try

/*
There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.

Now given all the cities and fights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
Example 2:
Input:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
Note:

The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.

 */
object CheapestFlightsWithinKStops {

  def main(args: Array[String]): Unit = {
    val edges = Set(Flight(0,1,100), Flight(1,2,100), Flight(0,2,500))

    println(check(edges, 0, 2, 1))
    println(check(edges, 0, 2, 0))
    println(check(edges, 0, 3, 0))

    println(state(edges, 0, 2, 1))
    println(state(edges, 0, 2, 0))
    println(state(edges, 0, 3, 0))
  }

  def check(edges: Set[Flight], current: Int, destination: Int, stop: Int, currentFare: Int = 0): Int = {
    if (destination == current) currentFare
    else if (stop < 0) Integer.MAX_VALUE
    else {
      val (possibleStep, nextSteps) = edges.partition(_.src == current)

      if (possibleStep.isEmpty) currentFare
      else {
        val fare = possibleStep.map(f => check(nextSteps, f.dst, destination, stop - 1, currentFare + f.price)).min
        if (fare == Integer.MAX_VALUE) -1 else fare
      }
    }
  }

  def state(edges: Set[Flight], current: Int, destination: Int, stop: Int): Int = {
    var cost = Array.fill[Int](edges.size)(1000000)
    cost(0) = 0

    for (i <- 0 to stop) {
      val tmp = cost.clone()
      edges.foreach(f => {
        tmp(f.dst) = Math.min(tmp(f.dst), cost(f.src) + f.price)
        // println(i + " = " + f + " ~ " + tmp.mkString(" "))
      })
      cost = tmp
    }

    if (destination >= cost.length || cost(destination) == 0) -1 else cost(destination)

  }

  case class Flight(src: Int, dst: Int, price: Int)

}
