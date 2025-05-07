package mylist

abstract class class1[+A] {
  def head: A
  def tail: class1[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): class1[B]
  def printElements: String

  def map[B](transformer: A => B): class1[B]
  def filter(predicate: A => Boolean): class1[A]
  def flatMap[B](transformer: A => class1[B]): class1[B]

  def foreach(f: A => Unit): Unit
  def sort(compare: (A, A) => Int): class1[A]
  def zipWith[B, C](list: class1[B], zip: (A, B) => C): class1[C]
  def fold[B](start: B)(operator: (B, A) => B): B


}
