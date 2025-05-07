package mylist

case class Cons[+A](h: A, t: class1[A]) extends class1[A] {
  def head: A = h
  def tail: class1[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): class1[B] = Cons(element, this)
  def printElements: String = {
    @annotation.tailrec
    def loop(current: class1[A], acc: String): String = current match {
      case Empty => acc
      case Cons(h, t) => loop(t, if (acc.isEmpty) s"$h" else s"$acc $h")
    }
    loop(this, "")
  }

  def map[B](transformer: A => B): class1[B] = Cons(transformer(h), t.map(transformer))

  def filter(predicate: A => Boolean): class1[A] = {
    if (predicate(h)) Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def flatMap[B](transformer: A => class1[B]): class1[B] =
    transformer(h).fold[class1[B]](t.flatMap(transformer))((acc, element) => new Cons(element, acc))

  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A, A) => Int): class1[A] = {
    def insert(element: A, sortedList: class1[A]): class1[A] = sortedList match {
      case Empty => Cons(element, Empty)
      case Cons(h, t) =>
        if (compare(element, h) <= 0) Cons(element, sortedList)
        else Cons(h, insert(element, t))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B, C](list: class1[B], zip: (A, B) => C): class1[C] = list match {
    case Cons(h2, t2) => Cons(zip(h, h2), t.zipWith(t2, zip))
    case _ => throw new RuntimeException("Lists do not have the same length")
  }

  def fold[B](start: B)(operator: (B, A) => B): B =
    t.fold(operator(start, h))(operator)
}
