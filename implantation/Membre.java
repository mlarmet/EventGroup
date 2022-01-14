package implantation;

import java.util.Date;

/**
 * Class membre.
 */
public class Membre {
  /** Description nom du membre. */
  private String nom;
  /** Description prenom du membre. */
  private String prenom;
  /** Description adresse mail du membre. */
  private String adresseMail;
  /** Description pseudo du membre. */
  private String pseudo;
  /** Description mot de passe du membre. */
  private String motDePasse;
  /** Description ville de résidence du membre. */
  private String villeDeResidence;
  /** Description date de naissance du membre. */
  private Date dateNaissance;
  /** Description lieu de naissance du membre. */
  private String lieuNaissance;

  /**
   * Constructeur de la classe Membres.
   *
   * @param nom nom du membre
   * @param prenom prenom du membre
   * @param adresseMail adresse email du membre
   * @param pseudo pseudo du membre
   * @param motDePasse mot de passe du membre
   * @param villeDeResidence adresse du membre
   * @param dateNaissance date de naissance du membre
   * @param lieuNaissance lieu de naissance du membre
   */
  public Membre(String nom, String prenom, String adresseMail, String pseudo, String motDePasse,
      String villeDeResidence, Date dateNaissance, String lieuNaissance) {

    this.nom = nom;
    this.prenom = prenom;
    this.adresseMail = adresseMail;
    this.pseudo = pseudo;
    this.motDePasse = motDePasse;
    this.villeDeResidence = villeDeResidence;
    this.dateNaissance = dateNaissance;
    this.lieuNaissance = lieuNaissance;
  }

  public String getNom() {
    return nom;
  }

  /**
   * Modifie la description de l'evenement.
   *
   * @param nom nouveau nom du membre
   * @return -1 si le nouveau nom est vide, 1 si la modification est correct
   */
  public int setNom(String nom) {
    if (nom.isBlank() || nom.isEmpty()) {
      return -1;
    }
    this.nom = nom;
    return 1;
  }

  public String getPrenom() {
    return prenom;
  }

  /**
   * Modifie le prenom du membre.
   *
   * @param prenom nouveau prenom du membre
   * @return -1 si le nouveau prenom est vide, 1 si la modification est correct
   */
  public int setPrenom(String prenom) {
    if (prenom.isBlank() || prenom.isEmpty()) {
      return -1;
    }
    this.prenom = prenom;
    return 1;
  }

  public String getAdresseMail() {
    return adresseMail;
  }

  /**
   * Modifie l'adresse email du membre.
   *
   * @param adresseMail nouvel emai du membre
   * @return -1 si le nouvel email est vide, 1 si la modification est correct
   */
  public int setAdresseMail(String adresseMail) {
    if (adresseMail.isBlank() || adresseMail.isEmpty()) {
      return -1;
    }
    this.adresseMail = adresseMail;
    return 1;
  }

  public String getPseudo() {
    return pseudo;
  }

  /**
   * Modifie le pseudo du membre.
   *
   * @param pseudo nouveau pseudo du membre
   * @return -1 si le nouveau pseudo est vide, 1 si la modification est correct
   */
  public int setPseudo(String pseudo) {
    if (pseudo.isBlank() || pseudo.isEmpty()) {
      return -1;
    }
    this.pseudo = pseudo;
    return 1;
  }

  public String getMotDePasse() {
    return motDePasse;
  }

  /**
   * Modifie le mot de passe du membre.
   *
   * @param motDePasse nouveau mot de passe du membre
   * @return -1 si le nouveau mot de passe est vide, 1 si la modification est correct
   */
  public int setMotDePasse(String motDePasse) {
    if (motDePasse.isBlank() || motDePasse.isEmpty()) {
      return -1;
    }
    this.motDePasse = motDePasse;
    return 1;
  }

  public String getVilleDeResidence() {
    return this.villeDeResidence;
  }

  /**
   * Modifie la ville de résidence du membre.
   *
   * @param villeDeResidence nouvelle ville de résidence du membre
   * @return -1 si la nouvelle ville de résidence est vide, 1 si la modification est correct
   */
  public int setVilleDeResidence(String villeDeResidence) {
    if (villeDeResidence.isBlank() || villeDeResidence.isEmpty()) {
      return -1;
    }
    this.villeDeResidence = villeDeResidence;
    return 1;
  }


  public Date getDateNaissance() {
    return dateNaissance;
  }

  /**
   * Modifie la date de naissance du membre.
   *
   * @param dateNaissance nouvelle date de naissance du membre
   * @return -1 si la nouvelle date est supérieur à la date actuelle, 1 si la modification est
   *         correct
   */
  public int setDateNaissance(Date dateNaissance) {
    // si sup à 0 alors dateNaissance est supérieur à aujourd'hui.
    if (dateNaissance.compareTo(new Date()) > 0) {
      return -1;
    }

    this.dateNaissance = dateNaissance;
    return 1;
  }

  public String getLieuNaissance() {
    return lieuNaissance;
  }

  /**
   * Modifie le lieu de naissance du membre.
   *
   * @param lieuNaissance nouveau lieu de naissance du membre
   * @return -1 si le nouveau lieu est vide, 1 si la modification est correct
   */
  public int setLieuNaissance(String lieuNaissance) {
    if (lieuNaissance.isBlank() || lieuNaissance.isEmpty()) {
      return -1;
    }
    this.lieuNaissance = lieuNaissance;
    return 1;
  }



}
