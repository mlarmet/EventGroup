package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import implantation.Evenement;
import implantation.GestionEvenements;
import implantation.Membre;
import implantation.TypeEvenement;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class TestsIntegration {

  @Test
  void test1() {
    Set<Membre> vide = new HashSet<>();

    // ensemble des membres vide
    assertEquals(vide, GestionEvenements.getMembres());

    // création d'un membre avec prenom incorrect
    assertEquals(0, GestionEvenements.ajouterMembre("Dubois", "   ", "nathalie.dubois@gmail.com",
        "ndubois", "nat12", "Lorient", MembreTest.creerDate("03-11-1985"), "Lorient"));

    // ensemble des membres toujours vide
    assertEquals(vide, GestionEvenements.getMembres());

    // création de la membre Nathalie Dubois
    assertEquals(1,
        GestionEvenements.ajouterMembre("Dubois", "Nathalie", "nathalie.dubois@gmail.com",
            "ndubois", "nat12", "Lorient", MembreTest.creerDate("03-11-1985"), "Lorient"));

    Set<Membre> membres = new HashSet<>();

    // récupération de la membre Nathalie Dubois a partir de son pseudo
    assertNotEquals(null, GestionEvenements.getMembre("ndubois"));
    membres.add(GestionEvenements.getMembre("ndubois"));

    // création à nouveau de la membre Nathalie Dubois
    assertEquals(-1,
        GestionEvenements.ajouterMembre("Dubois", "Nathalie", "nathalie.dubois@gmail.com",
            "ndubois", "nat12", "Lorient", MembreTest.creerDate("03-11-1985"), "Lorient"));
    assertEquals(membres, GestionEvenements.getMembres());

    // création d'un nouveau membre Nicolas Dubois
    assertEquals(1, GestionEvenements.ajouterMembre("Dubois", "Nicolas", "nicolas.dubois@gmail.com",
        "nicodubois", "nico12", "Lorient", MembreTest.creerDate("19-10-1988"), "Lorient"));

    membres.add(GestionEvenements.getMembre("nicodubois"));
    assertEquals(membres, GestionEvenements.getMembres());

    // modification du pseudo de Nicolas en lui donnant le même pseudo que Nathalie
    assertEquals(0, GestionEvenements
        .modifierPseudoMembre(GestionEvenements.getMembre("nicodubois"), "ndubois"));

    // modification du pseudo de Nicolas en lui donnant un pseudo non utilisé
    assertEquals(1, GestionEvenements
        .modifierPseudoMembre(GestionEvenements.getMembre("nicodubois"), "nico56"));

    // récupération du membre Nicolas avec son ancien pseudo
    assertEquals(null, GestionEvenements.getMembre("nicodubois"));

    // récupération du membre Nicolas avec son nouveau pseudo
    assertNotEquals(null, GestionEvenements.getMembre("nico56"));

    /*// création d'un nouveau membre Jean-Chritophe Roland
    assertEquals(1,
        GestionEvenements.ajouterMembre("Roland", "Christophe", "christophe.roland@gmail.com",
            "jc_22", "js#22", "Lannion", MembreTest.creerDate("19-10-1980"), "Lannion"));
    membres.add(GestionEvenements.getMembre("jc_22"));*/

    // récupération de la liste des membres
    assertEquals(membres, GestionEvenements.getMembres());

    Set<Evenement> evenements = new HashSet<>(); // ensemble vide

    // récupération des évènements, vide
    assertEquals(evenements, GestionEvenements.getEvenements());

    // création d'un évènement Event1
    assertEquals(1,
        GestionEvenements.ajouterEvenement("Event1", "Rencontre et échanges autour d'un repas",
            "img.jpg", LocalDateTime.of(2022, Month.JULY, 5, 14, 30, 0), "Parc vert",
            "espace libre", "map.google.parc-vert.com", TypeEvenement.REPAS, 10));
    evenements.add(GestionEvenements.getEvenement("Event1"));

    // création d'un évènement Event2
    assertEquals(1,
        GestionEvenements.ajouterEvenement("Event2", "Animations, musique", "img2.jpg",
            LocalDateTime.of(2022, Month.AUGUST, 15, 18, 00, 0), "Parc vert", "espace libre",
            "map.google.parc-vert.com", TypeEvenement.ANIMATION, 8));
    evenements.add(GestionEvenements.getEvenement("Event2"));

    // récupération des évènements (Event1 et Event2)
    assertEquals(evenements, GestionEvenements.getEvenements());
  }

}
