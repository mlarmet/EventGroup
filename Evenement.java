import java.time.LocalDateTime;

/**
 * Description de la classe evenement.
 */
public class Evenement {
  /**Description Nom de l evenement.*/
  private String nom;
  /**Description description de l'evenement.*/
  private String descriptif;
  /**Description image de profile de l'evenement.*/
  private String image;
  /**Description date et horraire de l'evenement.*/
  private LocalDateTime dateHoraire;
  /**Description lieu de l'evenement.*/
  private Lieu lieu;
  /**Description type de l'evenement.*/
  private TypeEvenement type;
  /**Description nombre maximum de personne dans l'evenement.*/
  private int nombreMaxPersonne;

  /**
   * Constructeur de la classe Evenement.

   * @param nom nom de l'evenement
   * @param descriptif description de l'evenement
   * @param image image de profile de l'evenement
   * @param dateHoraire date et horraire de l'evenement
   * @param lieu lieu de l'evenement
   * @param type type de l'evenement
   * @param nombreMaxPersonne nombre maximum de personne dans l'evenement
   */
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
