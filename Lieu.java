
public class Lieu {
  private String nom;
  private String descriptif;
  private String lien;

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
