package eventgroup.view;

import eventgroup.MainApp;
import eventgroup.model.GestionEvenements;
import eventgroup.model.Membre;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.function.Consumer;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/** Classe de controle de la page membre. */

public class MembreController {

  @SuppressWarnings("unused")
  private MainApp mainApp;

  @FXML
  private TableView<Membre> tableView;
  @FXML
  private TableColumn<Membre, String> colPseudo;
  @FXML
  private TableColumn<Membre, String> colPrenom;
  @FXML
  private TableColumn<Membre, String> colNom;
  @FXML
  private TableColumn<Membre, String> colNaissance;
  @FXML
  private TableColumn<Membre, String> colAction;

  private boolean popupOpen;

  public MembreController() {
    popupOpen = false;
  }

  /**
   * Initialise la classe controller de membre. Appele automatiquement apres que le fichier fxml est
   * été chargé.
   */
  @SuppressWarnings("unchecked")
  @FXML
  private void initialize() {

    MainApp.columnReorder(tableView, colPseudo, colPrenom, colNom, colNaissance, colAction);

    tableView.widthProperty().addListener((obs, oldVal, newVal) -> {
      double width = tableView.getWidth();
      int nbColumns = tableView.getColumns().size();

      tableView.getColumns().forEach(new Consumer<Object>() {

        @Override
        public void accept(Object t) {
          TableColumn<Membre, String> col = (TableColumn<Membre, String>) t;
          MainApp.setExtremeSize(col, width / nbColumns);
        }

      });
    });


    Callback<TableColumn<Membre, String>, TableCell<Membre, String>> cellFactory = //
        new Callback<TableColumn<Membre, String>, TableCell<Membre, String>>() {
          @Override
          public TableCell<Membre, String> call(final TableColumn<Membre, String> param) {

            TableCell<Membre, String> cell = new TableCell<Membre, String>() {

              @Override
              public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                  setText(null);
                  setGraphic(null);
                } else {
                  ImageView btnEdit = new ImageView(new Image("file:resources/icon-modifier.png"));
                  ImageView btnSup = new ImageView(new Image("file:resources/icon-supprimer.png"));
                  
                  btnEdit.setCursor(Cursor.HAND);
                  btnSup.setCursor(Cursor.HAND);
                  
                  //permet de clicker sur les parties transparentes des images
                  btnEdit.setPickOnBounds(true);
                  btnSup.setPickOnBounds(true);
                  
                  btnEdit.setFitHeight(25);
                  btnEdit.setFitWidth(25);

                  btnSup.setFitHeight(25);
                  btnSup.setFitWidth(25);

                  HBox actionCell = (HBox) new HBox();
                  actionCell.setAlignment(Pos.CENTER);
                  actionCell.setSpacing(15.0);
                  actionCell.getChildren().addAll(btnEdit, btnSup);

                  btnSup.setOnMouseClicked(event -> {
                    // alert

                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation suppresion");
                    alert.setHeaderText("Voulez-vous vraiment supprimer ce membre ?");

                    Optional<ButtonType> option = alert.showAndWait();

                    if (option.get() == ButtonType.OK) {
                      String pseudo = getTableView().getItems().get(getIndex()).getPseudo();
                      GestionEvenements.supprimerMembre(GestionEvenements.getMembre(pseudo));
                      reloadTableMembre();
                    }
                  });

                  btnEdit.setOnMouseClicked(event -> {
                    Membre membre = getTableView().getItems().get(getIndex());
                    openStage("Editer Membre", membre.getPseudo());
                  });

                  setText(null);
                  setGraphic(actionCell);

                }
              }
            };
            return cell;
          }
        };

    colAction.setCellFactory(cellFactory);



    GestionEvenements.ajouterMembre("larmet", "maxence", "mail", "mlarmet", "motdepase", "brest",
        new Date(), "stbrieuc");
    GestionEvenements.ajouterMembre("larmet", "maxence", "mail", "larmetma", "motdepase", "brest",
        new Date(), "stbrieuc");

    this.reloadTableMembre();

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
  public void clickAddMembre() {
    if (!popupOpen) {
      popupOpen = true;

      this.openStage("Ajouter Membre", null);

    }
  }

  /** Ouvre une fenetre popup pour ajouter un membre. */
  public void openStage(String title, String pseudo) {
    try {
      Parent root = null;

      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApp.class.getResource("view/AjouterMembre.fxml"));

      root = (AnchorPane) loader.load();

      AjouterMembreController controller = loader.getController();

      Stage stage = new Stage();
      controller.setDialogStage(stage);
      controller.setMainApp(mainApp);
      // controller.setMembreController(this, pseudo);
      controller.setPseudo(pseudo);

      stage.setTitle(title);
      stage.setResizable(false);
      stage.setScene(new Scene(root));
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.showAndWait();

      popupOpen = false;
      this.reloadTableMembre();

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void reloadTableMembre() {
    tableView.setItems(FXCollections.observableArrayList(GestionEvenements.MEMBRES));
    tableView.refresh();
  }



}
