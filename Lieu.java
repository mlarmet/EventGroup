/** Classe Lieu. */
public class Lieu {
  /**Description nom du lieu.*/
  private String nom;
  /**Description descriptif du lieu.*/
  private String descriptif;
  /**Description lien google map du lieu.*/
  private String lien;

  /**
   * Constructeur de la class Lieu.

   * @param nom nom du lieu
   * @param descriptif descriptif du lieu
   * @param lien lien google du lieu
   */
  public Lieu(String nom, String descriptif, String lien) {
    this.nom = nom;
    this.descriptif = descriptif;
    this.lien = lien;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getDescriptif() {
    return descriptif;
  }

  public void setDescriptif(String descriptif) {
    this.descriptif = descriptif;
  }

  public String getLien() {
    return lien;
  }

  public void setLien(String lien) {
    this.lien = lien;
  }



}
