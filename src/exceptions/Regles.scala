package exceptions

import cars.{VoitureClassique, VoitureSport, VoitureSuperSport}
import pilote.Pilote
import competition.Course
import scala.util.{Try, Success, Failure}

object Rules {

  def validateAge(pilote: Pilote): Unit = {
    try {
      if (pilote.age < 18) throw new InvalideAgeException("Le pilote doit avoir au moins 18 ans")
    } catch {
      case e: InvalideAgeException => println(e.getMessage)
    }
  }

  def validateSpeed(voiture: cars.Voiture): Option[String] = voiture match {
    case v: VoitureClassique if v.vitesse >= 0 && v.vitesse <= 260 => None
    case v: VoitureSport if v.vitesse >= 0 && v.vitesse <= 330 => None
    case v: VoitureSuperSport if v.vitesse >= 0 && v.vitesse <= 400 => None
    case _ => Some("La vitesse de la voiture est hors des limites autorisées")
  }

  def validateRank(rank: Int): Try[Int] = {
    Try {
      if (rank < 1 || rank > 12) throw new RankRaceException("Le classement doit être entre 1 et 12")
      else rank
    }
  }

  def validateCarType(course: Course): Try[Class[_ <: cars.Voiture]] = {
    Try {
      val carTypes = course.listePilotes.filtrerParTypeVoiture(course.typeVoiture).map(_.voiture.getClass).distinct
      if (carTypes.size > 1) throw new TypeCarException("La course doit comporter un seul type de voiture")
      else course.typeVoiture
    }
  }
}
