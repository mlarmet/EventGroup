import java.util.Date;

/**Class membre.
 */
public class Membres {
  /**Description nom du membre.*/
  private String nom;
  /**Description prenom du membre.*/
  private String prenom;
  /**Description adresse mail du membre.*/
  private String adresseMail;
  /**Description pseudo du membre.*/
  private String pseudo;
  /**Description mot de passe du membre.*/
  private String motDePasse;
  /**Description adresse postale du membre.*/
  private String adressePostale;
  /**Description date de naissance du membre.*/
  private Date dateNaissance;
  /**Description lieu de naissance du membre.*/
  private String lieuNaissance;

  /**
   * Constructeur de la classe Membres.

   * @param nom nom du membre
   * @param prenom prenom du membre
   * @param adresseMail adresse email du membre
   * @param pseudo pseudo du membre
   * @param motDePasse mot de passe du membre
   * @param adressePostale adresse du membre
   * @param dateNaissance date de naissance du membre
   * @param lieuNaissance lieu de naissance du membre
   */
  public Membres(String nom, String prenom, String adresseMail, String pseudo, String motDePasse,
      String adressePostale, Date dateNaissance, String lieuNaissance) {

    this.nom = nom;
    this.prenom = prenom;
    this.adresseMail = adresseMail;
    this.pseudo = pseudo;
    this.motDePasse = motDePasse;
    this.adressePostale = adressePostale;
    this.dateNaissance = dateNaissance;
    this.lieuNaissance = lieuNaissance;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getAdresseMail() {
    return adresseMail;
  }

  public void setAdresseMail(String adresseMail) {
    this.adresseMail = adresseMail;
  }

  public String getPseudo() {
    return pseudo;
  }

  public void setPseudo(String pseudo) {
    this.pseudo = pseudo;
  }

  public String getMotDePasse() {
    return motDePasse;
  }

  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }

  public String getAdressePostale() {
    return adressePostale;
  }

  public void setAdressePostale(String adressePostale) {
    this.adressePostale = adressePostale;
  }

  public Date getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(Date dateNaissance) {
    this.dateNaissance = dateNaissance;
  }

  public String getLieuNaissance() {
    return lieuNaissance;
  }

  public void setLieuNaissance(String lieuNaissance) {
    this.lieuNaissance = lieuNaissance;
  }



}
