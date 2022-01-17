package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import implantation.Membre;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;

class MembreTest {
  static Date creerDate(String date) {
    try {
      return new SimpleDateFormat("dd-MM-yyyy").parse(date);
    } catch (ParseException e) {
      throw new Error(e);
    }
  }

  Membre membre = new Membre("Lopez", "Roger", "roger.lopez@gmail.com", "lroger", "lroger29",
      "Brest", creerDate("10-02-1990"), "Rennes");

  // Tests sur la méthode setNom
  @Test
  void testSetNomCorrect() {
    assertEquals(1, membre.setNom("Martinez"));
  }
  
  @Test
  void testSetNomNull() {
    assertEquals(-1, membre.setNom(null));
  }

  @Test
  void testSetNomVide() {
    assertEquals(-1, membre.setNom(""));
  }

  @Test
  void testSetNomPasVisible() {
    assertEquals(-1, membre.setNom("  "));
  }


  // Tests sur la méthode setPrenom
  @Test
  void testSetPrenomCorrect() {
    assertEquals(1, membre.setPrenom("Louis"));
  }
  
  @Test
  void testSetPrenomNull() {
    assertEquals(-1, membre.setPrenom(null));
  }

  @Test
  void testSetPrenomVide() {
    assertEquals(-1, membre.setPrenom(""));
  }

  @Test
  void testSetPrenomPasVisible() {
    assertEquals(-1, membre.setPrenom("  "));
  }


  // Tests sur la méthode setAdresseMail
  @Test
  void testSetAdresseMailCorrect() {
    assertEquals(1, membre.setAdresseMail("r.lopez@gmail.com"));
  }
  
  @Test
  void testSetAdresseMailNull() {
    assertEquals(-1, membre.setAdresseMail(null));
  }

  @Test
  void testSetAdresseMailVide() {
    assertEquals(-1, membre.setAdresseMail(""));
  }

  @Test
  void testSetAdresseMailPasVisible() {
    assertEquals(-1, membre.setAdresseMail("  "));
  }


  // Tests sur la méthode setPseudo
  @Test
  void testSetPseudoCorrect() {
    assertEquals(1, membre.setPseudo("lolo29"));
  }
  
  @Test
  void testSetPseudoNull() {
    assertEquals(-1, membre.setPseudo(null));
  }

  @Test
  void testSetPseudoVide() {
    assertEquals(-1, membre.setPseudo(""));
  }

  @Test
  void testSetPseudoPasVisible() {
    assertEquals(-1, membre.setPseudo("  "));
  }


  // Tests sur la méthode setMotDePasse
  @Test
  void testSetMotDePasseCorrect() {
    assertEquals(1, membre.setMotDePasse("*_lolo29"));
  }
  
  @Test
  void testSetMotDePasseNull() {
    assertEquals(-1, membre.setMotDePasse(null));
  }

  @Test
  void testSetMotDePasseVide() {
    assertEquals(-1, membre.setMotDePasse(""));
  }

  @Test
  void testSetMotDePassePasVisible() {
    assertEquals(-1, membre.setMotDePasse("  "));
  }


  // Tests sur la méthode setVilleDeResidence
  @Test
  void testSetVilleDeResidenceCorrect() {
    assertEquals(1, membre.setVilleDeResidence("Quimper"));
  }
  
  @Test
  void testSetVilleDeResidenceNull() {
    assertEquals(-1, membre.setVilleDeResidence(null));
  }

  @Test
  void testSetVilleDeResidenceVide() {
    assertEquals(-1, membre.setVilleDeResidence(""));
  }

  @Test
  void testSetVilleDeResidencePasVisible() {
    assertEquals(-1, membre.setVilleDeResidence("  "));
  }


  // Tests sur la méthode setDateNaissance

  @Test
  void testSetDateNaissanceInferieureDateCourante() {
    assertEquals(1, membre.setDateNaissance(creerDate("15-08-1995")));
  }
  
  @Test
  void testSetDateNaissanceSuperieureDateNull() {
    assertEquals(-1, membre.setDateNaissance(null));
  }

  @Test
  void testSetDateNaissanceSuperieureDateCourante() {
    assertEquals(-1, membre.setDateNaissance(creerDate("24-07-3000")));
  }


  // Tests sur la méthode setLieuNaissance
  @Test
  void testSetLieuNaissanceCorrect() {
    assertEquals(1, membre.setLieuNaissance("Saint-Brieuc"));
  }
  
  @Test
  void testSetLieuNaissanceNull() {
    assertEquals(-1, membre.setLieuNaissance(null));
  }

  @Test
  void testSetLieuNaissanceVide() {
    assertEquals(-1, membre.setLieuNaissance(""));
  }

  @Test
  void testSetLieuNaissancePasVisible() {
    assertEquals(-1, membre.setLieuNaissance("  "));
  }

}
