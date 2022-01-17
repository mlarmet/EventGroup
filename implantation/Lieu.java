package implantation;

/** Description de classe Lieu. */
public class Lieu {
  /** Description nom du lieu. */
  private String nom;
  /** Description descriptif du lieu. */
  private String descriptif;
  /** Description lien google map du lieu. */
  private String lien;

  /**
   * Constructeur de la classe Lieu.
   *
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

  /**
   * Modifie le nom du lieu.
   *
   * @param nom nouveau nom du lieu
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
    return descriptif;
  }

  /**
   * Modifie la description de l'evenement.
   *
   * @param descriptif nouvelle description du lieu
   * @return -1 si la nouvelle description est vide ou nulle, 1 si la modification est correcte
   */
  public int setDescriptif(String descriptif) {
    if (descriptif == null || descriptif.isBlank() || descriptif.isEmpty()) {
      return -1;
    }

    this.descriptif = descriptif;
    return 1;
  }

  public String getLien() {
    return lien;
  }

  /**
   * Modifie la description de l'evenement.
   *
   * @param lien nouveau lien google map du lieu
   * @return -1 si le nouveau lien est vide ou null, 1 si la modification est correcte
   */
  public int setLien(String lien) {
    if (lien == null || lien.isBlank() || lien.isEmpty()) {
      return -1;
    }

    this.lien = lien;
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
    if (!(obj instanceof Lieu)) {
      return false;
    }
    Lieu lieu = (Lieu) obj;
    return (this.nom.equals(lieu.nom) && this.descriptif.equals(lieu.descriptif)
        && this.lien.equals(lieu.lien));
  }

}
