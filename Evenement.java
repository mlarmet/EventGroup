import java.time.LocalDateTime;

public class Evenement {
  private String nom;
  private String descriptif;
  private String image;
  private LocalDateTime dateHoraire;
  private Lieu lieu;
  private TypeEvenement type;
  private int nombreMaxPersonne;

  public Evenement(String nom, String descriptif, String image, LocalDateTime dateHoraire,
      Lieu lieu, TypeEvenement type, int nombreMaxPersonne) {
    this.nom = nom;
    this.descriptif = descriptif;
    this.image = image;
    this.dateHoraire = dateHoraire;
    this.lieu = lieu;
    this.type = type;
    this.nombreMaxPersonne = nombreMaxPersonne;
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

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public LocalDateTime getDateHoraire() {
    return dateHoraire;
  }

  public void setDateHoraire(LocalDateTime dateHoraire) {
    this.dateHoraire = dateHoraire;
  }

  public Lieu getLieu() {
    return lieu;
  }

  public void setLieu(Lieu lieu) {
    this.lieu = lieu;
  }

  public TypeEvenement getType() {
    return type;
  }

  public void setType(TypeEvenement type) {
    this.type = type;
  }

  public int getNombreMaxPersonne() {
    return nombreMaxPersonne;
  }

  public void setNombreMaxPersonne(int nombreMaxPersonne) {
    this.nombreMaxPersonne = nombreMaxPersonne;
  }



}
