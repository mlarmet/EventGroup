package eventgroup.view;

import eventgroup.MainApp;
import eventgroup.model.Evenement;
import eventgroup.model.GestionEvenements;
import eventgroup.model.Lieu;
import eventgroup.model.TypeEvenement;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/** Controller de la fenetre pour ajouter un evenement. */
public class AjoutEvenementController {

  @SuppressWarnings("unused")
  private MainApp mainApp;
  @FXML
  private Stage dialogstage;

  @FXML
  private TextField nom;

  @FXML
  private TextArea descriptif;

  @FXML
  private TextField image;

  @FXML
  private DatePicker date;

  @FXML
  private TextField heure;

  @FXML
  private TextField minutes;

  @FXML
  private TextField nomLieu;

  @FXML
  private TextArea descriptifLieu;

  @FXML
  private TextField lienGoogle;

  @FXML
  private ComboBox<TypeEvenement> type;

  @FXML
  private TextField nb;

  @FXML
  private Label message;

  public AjoutEvenementController() {

  }

  @FXML
  private void initialize() {
    ObservableList<TypeEvenement> list = FXCollections.observableArrayList(TypeEvenement.AG,
        TypeEvenement.REPAS, TypeEvenement.ANIMATION, TypeEvenement.CHANTIER_COLLECTIF);
    type.setItems(list);
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
   * Fonction appele lors d'un click sur le boutton + dans la page membre.
   */
  @FXML
  public void clickAddEvenementForm() {
    int h = 0;
    int min = 0;
    int res = 0;
    Lieu lieu = new Lieu(null, null, null);
    Evenement evenement = new Evenement(null, null, null, null, lieu, null, 0);
    if (evenement.setNom(nom.getText()) == 1) {
      if (evenement.setDescriptif(descriptif.getText()) == 1) {
        if (evenement.setImage(image.getText()) == 1) {
          if (date.getValue() != null) {
            try {
              h = Integer.parseInt(heure.getText());
              min = Integer.parseInt(minutes.getText());

              if (h >= 1 && h <= 24 && min >= 0 && min <= 59) {
                LocalDateTime dateHoraire = LocalDateTime.of(date.getValue().getYear(),
                    date.getValue().getMonth(), date.getValue().getDayOfMonth(), h, min, 0);

                evenement.setDateHoraire(dateHoraire);
                if (evenement.setNomLieu(nomLieu.getText()) == 1) {
                  if (evenement.setDescriptif(descriptifLieu.getText()) == 1) {
                    if (evenement.setLienLieu(lienGoogle.getText()) == 1) {
                      if (evenement.setType(type.getValue()) == 1) {
                        int nbr = Integer.parseInt(nb.getText());
                        if (evenement.setNombreMaxPersonne(nbr) == 1) {
                          res = GestionEvenements.ajouterEvenement(evenement);
                          this.dialogstage.close();


                          if (res == -1) {
                            message.setTextFill(Color.RED);
                            message.setText("Un événement protant ce nom existe déjà");
                          } else {
                            message.setTextFill(Color.GREEN);
                            message.setText("L'événement a été ajouté");
                          }
                        } else {
                          message.setTextFill(Color.RED);
                          message.setText("Dernier champ incorrect");
                        }
                      } else {
                        message.setTextFill(Color.RED);
                        message.setText("Type incorrect");
                      }
                    } else {
                      message.setTextFill(Color.RED);
                      message.setText("Lien manquant");
                    }
                  } else {
                    message.setTextFill(Color.RED);
                    message.setText("Descriptif incorrect");
                  }
                } else {
                  message.setTextFill(Color.RED);
                  message.setText("Nom lieu incorrect");
                }

              } else {
                message.setTextFill(Color.RED);
                message.setText("Heure incorrecte");
              }

              // System.out.println(GestionEvenements.getEvenements().size());
            } catch (NumberFormatException e) {
              // TODO Auto-generated catch block
              message.setTextFill(Color.RED);
              message.setText(
                  "Les champs heure et nombre max de personnes doivent contenir des nombres");
            }
          } else {
            message.setTextFill(Color.RED);
            message.setText("La date est manquante");
          }

        } else {
          message.setTextFill(Color.RED);
          message.setText("Image manquante");
        }
      } else {
        message.setTextFill(Color.RED);
        message.setText("Descriptif incorrect");
      }

    } else {
      message.setTextFill(Color.RED);
      message.setText("Nom incorrect");
    }

  }

  public void setDialogStage(Stage stage) {
    this.dialogstage = stage;
  }

}
