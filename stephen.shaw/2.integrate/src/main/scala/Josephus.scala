package ie.tcd.sccs.funcprog.josephus

import org.apache.commons.collections.iterators.LoopingListIterator

import java.util.List
import java.util.LinkedList

object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)

    val theList = new LinkedList()
    val iterator = new LoopingListIterator(theList)
        
    for (i <- 1 to numOfSoldiers) {
        iterator.add(i)        
    }

    iterator.reset

    while (iterator.size > 1) {
        for (i <- 1 to skipping + 1) iterator.next
        iterator.remove
    }
    
    // Comes out as java.lang.Object
    iterator.next.asInstanceOf[Int]
  }

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt

    println(findSurvivor(numOfSoldiers, killingEvery-1))
  }
}
