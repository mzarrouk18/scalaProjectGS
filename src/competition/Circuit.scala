package competition
import java.time.LocalDate
import scala.util.Random
import cars.Voiture
import pilote.{Pilote, ListPilotes}

  case class Circuit(
                      nom: String,
                      lieu: String,
                      longueur: Double,
                      difficulte: Int
                    )

