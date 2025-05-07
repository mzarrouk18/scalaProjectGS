package pilote

import cars.Voiture
import mylist.{Cons, Empty, class1}

case class Course(nom: String, gain: Double)

class Pilote(
              val nom: String,
              val prenom: String,
              val age: Int,
              val voiture: Voiture,
              val experience: Int,
              val palmares: Map[Course, Int]
            ) {

  def dejaChampion: Boolean = palmares.values.exists(_ == 1)

  def nombreDeVictoire: Int = palmares.values.count(_ == 1)

  def nombreDeFoisEnPodium: Int = palmares.values.count(_ <= 3)

  def totalDesGains: Double = palmares.map { case (course, classement) =>
    if (classement == 1) course.gain else 0.0
  }.sum

  def informationPalmares: String = {
    palmares.map { case (course, classement) =>
      s"Course: ${course.nom}, Classement: $classement"
    }.mkString("\n")
  }
}
