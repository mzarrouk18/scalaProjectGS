package mylist
import mylist.class1
import mylist.Cons
import mylist.Empty
import java.time.LocalDate
import cars.{VoitureClassique, VoitureSport, VoitureSuperSport}
import pilote.{Pilote, ListPilotes}
import competition.{Circuit, Course}
import exceptions.Rules

    //    val list = Cons(1, Cons(2, Cons(3, Empty)))
    //    println(list.printElements)  // Output: 1 2 3
    //    println(list.map(_ * 2).printElements)  // Output: 2 4 6
    //    println(list.filter(_ % 2 == 0).printElements)  // Output: 2
    //    println(list.flatMap(e => Cons(e, Cons(e + 1, Empty))).printElements)  // Output: 1 2 2 3 3 4
    //    list.foreach(println)  // Outputs: 1, 2, 3
    //    println(list.sort((x, y) => y - x).printElements)  // Output: 3 2 1
    //    println(list.zipWith(Cons("a", Cons("b", Cons("c", Empty))), (x: Int, y: String) => s"$x-$y").printElements)  // Output: 1-a 2-b 3-c
    //    println(list.fold(0)(_ + _))  // Output: 6
    // Circuits
    object Main extends App {

      // Circuits
      val circuit1 = Circuit("Monaco", "Monaco", 3.34, 7)
      val circuit2 = Circuit("Silverstone", "UK", 5.89, 5)

      // Voitures
      val classicCar = VoitureClassique("Golf GTI", 250, 7.0, "V6", 30000, 0, "Volkswagen")
      val sportCar = VoitureSport("Ferrari 488", 320, 3.0, "V8", 200000, 5, "Ferrari")
      val superSportCar = VoitureSuperSport("Bugatti Chiron", 420, 2.4, "W16", 3000000, 10, "Bugatti")

      // Pilotes
      val pilote1 = new Pilote("John", "Doe", 30, classicCar, 5, Map())
      val pilote2 = new Pilote("Alice", "Smith", 22, sportCar, 2, Map())
      val pilote3 = new Pilote("Max", "Speed", 35, superSportCar, 8, Map())
      val pilote4 = new Pilote("Jane", "Racer", 27, sportCar, 3, Map())

      // Liste des pilotes
      val listePilotes = ListPilotes(pilote1, pilote2, pilote3, pilote4)

      // Vérifications des règles
      println("Validation des règles :")
      listePilotes.foreach(p => Rules.validateAge(p))
      listePilotes.foreach(p => println(Rules.validateSpeed(p.voiture).getOrElse("Vitesse correcte")))

      // Courses
      val course1 = new Course(listePilotes, None, LocalDate.now(), circuit1, classOf[VoitureSport], 50000)
      val course2 = new Course(listePilotes, None, LocalDate.now(), circuit2, classOf[VoitureSuperSport], 100000)

      // Simulation des courses
      println("Podium Random :")
      course1.podiumRandom().foreach { case (pilote, rank) =>
        println(s"Pilote: ${pilote.nom} ${pilote.prenom} - Position: $rank")
      }

      println("\nPodium Calculé :")
      course2.podiumCalcule().foreach { case (pilote, rank) =>
        println(s"Pilote: ${pilote.nom} ${pilote.prenom} - Position: $rank")
      }

      // Informations des pilotes
      println("\nInformations des pilotes :")
      listePilotes.foreach { pilote =>
        println(s"${pilote.nom} ${pilote.prenom} - Gains: ${pilote.totalDesGains}")
      }
    }