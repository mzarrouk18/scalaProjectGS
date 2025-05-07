package competition

import java.time.LocalDate
import scala.util.Random
import cars.Voiture
import pilote.{Pilote, ListPilotes}

class Course(
              val listePilotes: ListPilotes,
              val champion: Option[Pilote],
              val date: LocalDate,
              val circuit: Circuit,
              val typeVoiture: Class[_ <: Voiture],
              val gain: Double
            ) {

  def podiumRandom(): List[(Pilote, Int)] = {
    val pilotes = listePilotes.filtrerParTypeVoiture(typeVoiture)
    Random.shuffle(pilotes).zipWithIndex.map { case (p, i) => (p, i + 1) }
  }

  def podiumCalcule(): List[(Pilote, Int)] = {
    val pilotes = listePilotes.filtrerParTypeVoiture(typeVoiture)
    pilotes.sort((p1, p2) => comparePilotes(p1, p2)).zipWithIndex.map { case (p, i) => (p, i + 1) }
  }

  private def comparePilotes(p1: Pilote, p2: Pilote): Int = {
    val performance1 = p1.voiture.vitesse / p1.voiture.acceleration
    val performance2 = p2.voiture.vitesse / p2.voiture.acceleration
    performance2.compareTo(performance1)
  }
}

