package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import implantation.Lieu;
import org.junit.jupiter.api.Test;

class LieuTest {

  Lieu lieu = new Lieu("Hotel de ville", "centre ville", "google.map.hotelville.com");

  // Tests la méthode setNom
  @Test
  void testSetNomCorrect() {
    assertEquals(1, lieu.setNom("Place Rodez"));
  }
  
  @Test
  void testSetNomNull() {
    assertEquals(-1, lieu.setNom(null));
  }

  @Test
  void testSetNomVide() {
    assertEquals(-1, lieu.setNom(""));
  }

  @Test
  void testSetNomPasVisible() {
    assertEquals(-1, lieu.setNom("  "));
  }

  // Tests la méthode setDescriptif
  @Test
  void testSetDescriptifCorrect() {
    assertEquals(1, lieu.setDescriptif("proches des restaurants"));
  }
  
  @Test
  void testSetDescriptifNull() {
    assertEquals(-1, lieu.setDescriptif(null));
  }

  @Test
  void testSetDescriptifVide() {
    assertEquals(-1, lieu.setDescriptif(""));
  }

  @Test
  void testSetDescriptifPasVisible() {
    assertEquals(-1, lieu.setDescriptif("  "));
  }

  // Tests la méthode setLien
  @Test
  void testSetLienCorrect() {
    assertEquals(1, lieu.setLien("proches des restaurants"));
  }
  
  @Test
  void testSetLienNull() {
    assertEquals(-1, lieu.setLien(null));
  }

  @Test
  void testSetLienVide() {
    assertEquals(-1, lieu.setLien(""));
  }

  @Test
  void testSetLienPasVisible() {
    assertEquals(-1, lieu.setLien("  "));
  }

}
