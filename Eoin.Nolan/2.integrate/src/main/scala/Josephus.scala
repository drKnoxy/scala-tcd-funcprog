package ie.tcd.sccs.funcprog.josephus

import scala.annotation.tailrec

// TODO import Java classes
import java.util.List
import java.util.LinkedList
import org.apache.commons.collections.iterators.LoopingListIterator

object Josephus {
  def findSurvivor(numOfSoldiers: Int, skipping: Int): Int = {
    require(numOfSoldiers >= 1)
    require(skipping >= 0)

    // TODO build linked list and put iterator on it
    val soldiers = new LinkedList();
    val iterator = new LoopingListIterator(soldiers);

    Range(1, numOfSoldiers+1).foreach(iterator.add);
    iterator.reset;


  /* TODO kill soldiers until one is left over and return it
    while (iterator.size > 1) {
      for (i <- 0 to skipping){ 
        iterator.next;
      }
      iterator.remove;
    }

    return iterator.next.asInstanceOf[Int];

    */

    return tailRecursive(iterator, numOfSoldiers, skipping);
  }

  def tailRecursive(iterator: LoopingListIterator, numOfSoldiers: Int, skipping: Int): Int = {
    if(iterator.size > 1){
        for (i <- 0 to skipping){ 
          iterator.next;
        }
        iterator.remove;
        tailRecursive(iterator, numOfSoldiers, skipping);     
      }else{
        return iterator.next.asInstanceOf[Int];
      }
  }

  def main(args: Array[String]): Unit = {
    assert(args.size == 2)

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt

    println(findSurvivor(numOfSoldiers, killingEvery-1))
  }
}
