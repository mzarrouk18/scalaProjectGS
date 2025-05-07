package pilote

import cars.Voiture
import mylist.{Cons, Empty, class1}
class ListPilotes(private val pilotes: class1[Pilote]) {

  def filtrerParTypeVoiture[T <: Voiture](clazz: Class[T]): class1[Pilote] =
    pilotes.filter(_.voiture.getClass == clazz)

  def ajouterPilote(pilote: Pilote): ListPilotes = new ListPilotes(pilotes.add(pilote))

  def supprimerPilote(pilote: Pilote): ListPilotes =
    new ListPilotes(pilotes.filter(_ != pilote))

  def foreach(f: Pilote => Unit): Unit = pilotes.foreach(f)

}

object ListPilotes {
  def apply(pilotes: Pilote*): ListPilotes = new ListPilotes(pilotes.foldRight(Empty: class1[Pilote])((p, acc) => Cons(p, acc)))
}