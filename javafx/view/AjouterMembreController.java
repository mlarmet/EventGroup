package eventgroup.view;

import eventgroup.MainApp;
import eventgroup.model.GestionEvenements;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/** Classe de controle de la page membre. */
public class AjouterMembreController implements GestionEvenements {

  private Stage dialogStage;

  @SuppressWarnings("unused")
  private MainApp mainApp;
  private String pseudo;

  @FXML
  private TextField inputPrenom;
  @FXML
  private TextField inputNom;
  @FXML
  private TextField inputPseudo;
  @FXML
  private TextField inputEmail;
  @FXML
  private TextField inputMotDePasse;
  @FXML
  private DatePicker inputDateNaissance;
  @FXML
  private TextField inputVilleResidence;
  @FXML
  private TextField inputLieuNaissance;


  public AjouterMembreController() {

  }

  /**
   * Initialise la classe controller de ajouter membre. Appele automatiquement apres que le fichier
   * fxml est été chargé.
   */
  @FXML
  private void initialize() {

    inputDateNaissance.setPromptText("jj/mm/yyyy");

  }

  public void setDialogStage(Stage dialogStage) {
    this.dialogStage = dialogStage;
  }

  /**
   * Appele par l'application MainApp pour en faire reference.
   *
   * @param mainApp appliation principale
   */
  public void setMainApp(MainApp mainApp) {
    this.mainApp = mainApp;
  }

  /**
   * Set pseudo du membre à modifier.
   */
  public void setPseudo(String pseudo) {
    if (pseudo != null && !pseudo.trim().isEmpty()) {
      this.pseudo = pseudo;

      inputNom.setText(GestionEvenements.getMembre(this.pseudo).getNom());
      inputPrenom.setText(GestionEvenements.getMembre(this.pseudo).getPrenom());
      inputPseudo.setText(GestionEvenements.getMembre(this.pseudo).getPseudo());
      inputEmail.setText(GestionEvenements.getMembre(this.pseudo).getAdresseMail());
      inputMotDePasse.setText(GestionEvenements.getMembre(this.pseudo).getMotDePasse());

      Date dateNaissance = GestionEvenements.getMembre(this.pseudo).getDateNaissance();
      inputDateNaissance.setValue(dateTolocalDate(dateNaissance));

      inputVilleResidence.setText(GestionEvenements.getMembre(this.pseudo).getVilleDeResidence());
      inputLieuNaissance.setText(GestionEvenements.getMembre(this.pseudo).getLieuNaissance());
    } else {
      this.pseudo = null;
    }
  }

  /**
   * Fonction appele lorsque l'on clique sur ok quand on ajouter un membre.
   */
  @FXML
  public void clickOk() {
    String nom = inputNom.getText();
    String prenom = inputPrenom.getText();
    String pseudoInput = inputPseudo.getText();
    String email = inputEmail.getText();
    String motDePasse = inputMotDePasse.getText();
    String villeResidence = inputVilleResidence.getText();
    String lieuResidence = inputLieuNaissance.getText();

    Date dateNaissance = localDateToDate(inputDateNaissance.getValue());

    /*
     * if (nom.trim().isEmpty() || prenom.trim().isEmpty() || pseudoInput.trim().isEmpty() ||
     * email.trim().isEmpty() || motDePasse.trim().isEmpty() || villeResidence.trim().isEmpty() ||
     * lieuResidence.trim().isEmpty() || dateNaissance == null) {
     * 
     * Alert alert = new Alert(AlertType.ERROR); alert.setTitle("Erreur formulaire");
     * alert.setHeaderText("Champ(s) vide(s)");
     * alert.setContentText("Un ou plusieurs champs sont vides.");
     * 
     * alert.showAndWait();
     * 
     * } else {
     */
    if (this.pseudo != null) {

      if ((GestionEvenements.modifierNomMembre(GestionEvenements.getMembre(this.pseudo),
          nom)) == false) {

        getAlert(AlertType.ERROR, "Erreur nom", "Nom incorrect", "Ce nom est incorrect")
            .showAndWait();

        return;
      }

      GestionEvenements.modifierPrenomMembre(GestionEvenements.getMembre(this.pseudo), prenom);
      GestionEvenements.modifierAdresseMailMembre(GestionEvenements.getMembre(this.pseudo), email);
      GestionEvenements.modifierMotDePasseMembre(GestionEvenements.getMembre(this.pseudo),
          motDePasse);
      GestionEvenements.modifierVilleDeResidenceMembre(GestionEvenements.getMembre(this.pseudo),
          villeResidence);
      GestionEvenements.modifierLieuNaissanceMembre(GestionEvenements.getMembre(this.pseudo),
          lieuResidence);
      GestionEvenements.modifierDateNaissanceMembre(GestionEvenements.getMembre(this.pseudo),
          dateNaissance);

      // si on modifie le pseudo, on regarde si il est pas deja pris
      // sinon on ne regarde pas
      if (!this.pseudo.equalsIgnoreCase(pseudoInput)) {
        if (GestionEvenements.modifierPseudoMembre(GestionEvenements.getMembre(this.pseudo),
            pseudoInput) == 0) {

          getAlert(AlertType.ERROR, "Erreur pseudo", "Pseudo déjà utilisé",
              "Ce pseudo est déjà utilisé par un autre utilisateur").showAndWait();

          return;
        }
      }


    } else {

      if (GestionEvenements.ajouterMembre(nom, prenom, email, pseudoInput, motDePasse,
          villeResidence, dateNaissance, lieuResidence) == -1) {

        getAlert(AlertType.ERROR, "Erreur pseudo", "Pseudo déjà utilisé",
            "Ce pseudo est déjà utilisé par un autre utilisateur").showAndWait();

        return;
      }

      // }

      this.dialogStage.close();

    }
  }

  /** Auto create alert. */
  public Alert getAlert(AlertType type, String title, String titreMessage, String message) {
    Alert alert = new Alert(type);
    alert.setTitle(title);
    alert.setHeaderText(titreMessage);
    alert.setContentText(message);

    return alert;
    // alert.showAndWait();
  }

  private Date localDateToDate(LocalDate date) {
    return (date != null ? Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()) : null);
  }

  private LocalDate dateTolocalDate(Date date) {
    return (date != null ? date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null);
  }

  /**
   * Fonction appele lorsque l'on clique sur annuler quand on ajouter un membre.
   */
  @FXML
  public void clickAnnuler() {
    this.dialogStage.close();
  }

}
