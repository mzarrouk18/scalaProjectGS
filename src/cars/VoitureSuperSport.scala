package cars

case class VoitureSuperSport(
                              override val nom: String,
                              override val vitesse: Int,
                              override val acceleration: Double,
                              override val moteur: String,
                              override val prix: Double,
                              override val nombreDeCourse: Int,
                              override val marque: String
                            ) extends Voiture(nom, vitesse, acceleration, moteur, prix, nombreDeCourse, marque)


