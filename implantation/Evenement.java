package implantation;

import java.time.LocalDateTime;

/**
 * Description de la classe Evenement.
 */
public class Evenement {
  /** Description nom de l'evenement. */
  private String nom;
  /** Description description de l'evenement. */
  private String descriptif;
  /** Description image de profil de l'evenement. */
  private String image;
  /** Description date et horaire de l'evenement. */
  private LocalDateTime dateHoraire;
  /** Description lieu de l'evenement. */
  private Lieu lieu;
  /** Description type de l'evenement. */
  private TypeEvenement type;
  /** Description nombre maximum de personnes dans l'evenement. */
  private int nombreMaxPersonne;

  /**
   * Constructeur de la classe Evenement.
   *
   * @param nom nom de l'evenement
   * @param descriptif description de l'evenement
   * @param image image de profil de l'evenement
   * @param dateHoraire date et horaire de l'evenement
   * @param lieu lieu de l'evenement
   * @param type type de l'evenement
   * @param nombreMaxPersonne nombre maximum de personnes dans l'evenement
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
    return this.nom;
  }

  /**
   * Modifie le nom de l'evenement.
   *
   * @param nom nouveau nom de l'evenement
   * @return -1 si le nouveau nom est vide ou null, 1 si la modification est correcte
   */
  public int setNom(String nom) {
    if (nom == null || nom.isBlank() || nom.isEmpty()) {
      return -1;
    }

    this.nom = nom;
    return 1;
  }

  public String getDescriptif() {
    return this.descriptif;
  }

  /**
   * Modifie la description de l'evenement.
   *
   * @param descriptif nouvelle description de l'evenement
   * @return -1 si la nouvelle description est vide ou nulle, 1 si la modification est correcte
   */
  public int setDescriptif(String descriptif) {
    if (descriptif == null || descriptif.isBlank() || descriptif.isEmpty()) {
      return -1;
    }

    this.descriptif = descriptif;

    return 1;
  }

  public String getImage() {
    return this.image;
  }

  /**
   * Modifie le nom de l'image de l'evenement.
   *
   * @param image nouveau nom de l'image de l'evenement
   * @return -1 si le nouveau est nom est vide, 1 si la modification est correcte
   */
  public int setImage(String image) {
    if (image.isBlank() || image.isEmpty()) {
      return -1;
    }

    this.image = image;
    return 1;
  }

  public LocalDateTime getDateHoraire() {
    return this.dateHoraire;
  }

  /**
   * Modifie la date et l'horaire de l'evenement.
   *
   * @param dateHoraire date et horaire de l'evenement
   * @return -1 si la nouvelle date est nulle ou est inférieure a la date actuelle, 1 si la
   *         modification est correcte
   */
  public int setDateHoraire(LocalDateTime dateHoraire) {
    if (dateHoraire == null || dateHoraire.isBefore(LocalDateTime.now())) {
      return -1;
    }

    this.dateHoraire = dateHoraire;
    return 1;
  }

  public Lieu getLieu() {
    return this.lieu;
  }

  /**
   * Modifie le nom du lieu de l'evenement.
   *
   * @param nom nouveau nom du lieu de l'evenement
   * @return -1 si le nouveau nom est incorrect (null ou vide), 1 si la modification est correcte
   */
  public int setNomLieu(String nom) {
    if (this.lieu.setNom(nom) == -1) {
      return -1;
    }

    return 1;
  }

  /**
   * Modifie le descriptif du lieu de l'evenement.
   *
   * @param descriptif nouveau descriptif du lieu de l'evenement
   * @return -1 si le nouveau descriptif est incorrect (null ou vide), 1 si la modification est
   *         correcte
   */
  public int setDescriptifLieu(String descriptif) {
    if (this.lieu.setDescriptif(descriptif) == -1) {
      return -1;
    }
    return 1;
  }

  /**
   * Modifie le lien google du lieu de l'evenement.
   *
   * @param lien nouveau lien google du lieu de l'evenement
   * @return -1 si le nouveau lien est incorrect (null ou vide), 1 si la modification est correcte
   */
  public int setLienLieu(String lien) {
    if (this.lieu.setLien(lien) == -1) {
      return -1;
    }
    return 1;
  }

  public TypeEvenement getType() {
    return this.type;
  }

  /**
   * Modifie le type de l'evenement.
   *
   * @param type nouveau type de l'evenement
   * @return -1 si le nouveau type est null, 1 si la modification est correcte
   */
  public int setType(TypeEvenement type) {
    if (type == null) {
      return -1;
    }
    this.type = type;
    return 1;
  }

  public int getNombreMaxPersonne() {
    return this.nombreMaxPersonne;
  }

  /**
   * Modifie le nombre maximum de personnes à l'evenement.
   *
   * @param nombreMaxPersonne nouveau nombre max de personne de l'evenement
   * @return -1 si le nouveau nombre est negatif ou égale à 0, 1 si la modification est correcte
   */
  public int setNombreMaxPersonne(int nombreMaxPersonne) {
    if (nombreMaxPersonne < 1) {
      return -1;
    }
    this.nombreMaxPersonne = nombreMaxPersonne;
    return 1;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Evenement)) {
      return false;
    }
    Evenement evenement = (Evenement) obj;
    return (this.nom.equals(evenement.nom) && this.descriptif.equals(evenement.descriptif)
        && this.image.equals(evenement.image) && this.dateHoraire.equals(evenement.dateHoraire)
        && this.lieu.equals(evenement.lieu) && this.type.equals(evenement.type)
        && this.nombreMaxPersonne == evenement.nombreMaxPersonne);
  }

}
