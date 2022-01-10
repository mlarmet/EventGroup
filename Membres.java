import java.util.Date;

public class Membres {

  private String nom;
  private String prenom;
  private String adresseMail;
  private String pseudo;
  private String motDePasse;
  private String adressePostale;
  private Date dateNaissance;
  private String lieuNaissance;

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
