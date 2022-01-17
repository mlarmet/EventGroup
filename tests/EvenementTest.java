package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import implantation.Evenement;
import implantation.Lieu;
import implantation.TypeEvenement;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.Test;

class EvenementTest {
  Lieu lieu = new Lieu("Brest Arena", "centre", "link");
  TypeEvenement type = TypeEvenement.REPAS;
  Evenement evenement = new Evenement("MeetMeet 2022", "Rencontre", "img.jpg",
      LocalDateTime.of(2022, Month.MAY, 20, 13, 45, 0), lieu, type, 12);
  
  
  // Tests sur la méthode setNom
  @Test
  void testSetNomCorrect() {
    assertEquals(1, evenement.setNom("JustMeet"));
  }
  
  @Test
  void testSetNomNull() {
    assertEquals(-1, evenement.setNom(null));
  }

  @Test
  void testSetNomVide() {
    assertEquals(-1, evenement.setNom(""));
  }

  @Test
  void testSetNomPasVisible() {
    assertEquals(-1, evenement.setNom("  "));
  }


  // Tests sur la méthode setDescriptif
  @Test
  void testSetDescriptifCorrect() {
    assertEquals(1, evenement.setDescriptif("Repas buffet"));
  }
  
  @Test
  void testSetDescriptifNull() {
    assertEquals(-1, evenement.setDescriptif(null));
  }

  @Test
  void testSetDescriptifVide() {
    assertEquals(-1, evenement.setDescriptif(""));
  }

  @Test
  void testSetDescriptifPasVisible() {
    assertEquals(-1, evenement.setDescriptif("  "));
  }


  // Tests sur la méthode setImage
  @Test
  void testSetImageCorrect() {
    assertEquals(1, evenement.setImage("img2.jpg"));
  }

  @Test
  void testSetImageVide() {
    assertEquals(-1, evenement.setImage(""));
  }

  @Test
  void testSetImagePasVisible() {
    assertEquals(-1, evenement.setImage("  "));
  }


  // Tests sur la méthode setDateHoraire
  @Test
  void testSetDateHoraireNull() {
    assertEquals(-1, evenement.setDateHoraire(null));
  }
  
  @Test
  void testSetDateHoraireAvantLaCourrante() {
    assertEquals(-1, evenement.setDateHoraire(LocalDateTime.of(2022, Month.JUNE, 25, 15, 0, 0)));
  }

  @Test
  void testSetDateHoraireApresLaCourrante() {
    assertEquals(1, evenement.setDateHoraire(LocalDateTime.of(3000, Month.MAY, 20, 13, 45, 30)));
  }


  // Tests sur la méthode setNomLieu
  @Test
  void testSetNomLieuCorrect() {
    assertEquals(1, evenement.setNomLieu("Place liberté"));
  }
  
  @Test
  void testSetNomLieuNull() {
    assertEquals(-1, evenement.setNomLieu(null));
  }

  @Test
  void testSetNomLieuVide() {
    assertEquals(-1, evenement.setNomLieu(""));
  }

  @Test
  void testSetNomLieuPasVisible() {
    assertEquals(-1, evenement.setNomLieu("  "));
  }


  // Tests sur la méthode setDescriptifLieu
  @Test
  void testSetDescriptifLieuCorrect() {
    assertEquals(1, evenement.setDescriptifLieu("centre ville"));
  }
  
  @Test
  void testSetDescriptifLieuNull() {
    assertEquals(-1, evenement.setDescriptifLieu(null));
  }

  @Test
  void testSetDescriptifLieuVide() {
    assertEquals(-1, evenement.setDescriptifLieu(""));
  }

  @Test
  void testSetDescriptifLieuPasVisible() {
    assertEquals(-1, evenement.setDescriptifLieu("  "));
  }

  
  // Tests sur la méthode setLienLieu
  @Test
  void testSetLienLieuCorrect() {
    assertEquals(1, evenement.setLienLieu("map.google.liberte.com"));
  }
  
  @Test
  void testSetLienLieuNull() {
    assertEquals(-1, evenement.setLienLieu(null));
  }

  @Test
  void testSetLienLieuVide() {
    assertEquals(-1, evenement.setLienLieu(""));
  }

  @Test
  void testSetLienLieuPasVisible() {
    assertEquals(-1, evenement.setLienLieu("  "));
  }
  
  
  // Tests sur la méthode setType
  @Test
  void testSetTypeNull() {
    assertEquals(-1, evenement.setType(null));
  }
  
  @Test
  void testSetTypeCorrect() {
    assertEquals(1, evenement.setType(TypeEvenement.ANIMATION));
  }
  
  // Tests sur la méthode setNombreMaxPersonne
  @Test
  void testSetNombreMaxPersonneCorrecte() {
    assertEquals(1, evenement.setNombreMaxPersonne(10));
  }

  @Test
  void testSetNombreMaxPersonneIncorrect() {
    assertEquals(1, evenement.setNombreMaxPersonne(10));
  }

}
