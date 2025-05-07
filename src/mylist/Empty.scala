package mylist

case object Empty extends class1[Nothing] {
  def head: Nothing = throw new NoSuchElementException("Head of Empty List")
  def tail: class1[Nothing] = throw new UnsupportedOperationException("Tail of Empty List")
  def isEmpty: Boolean = true
  def add[B](element: B): class1[B] = Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: Nothing => B): class1[B] = Empty
  def filter(predicate: Nothing => Boolean): class1[Nothing] = Empty
  def flatMap[B](transformer: Nothing => class1[B]): class1[B] = Empty

  def foreach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int): class1[Nothing] = Empty
  def zipWith[B, C](list: class1[B], zip: (Nothing, B) => C): class1[C] =
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Empty
  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}
