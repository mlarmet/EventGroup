package eventgroup.view;

import eventgroup.MainApp;
import eventgroup.model.Evenement;
import eventgroup.model.GestionEvenements;
import eventgroup.model.Membre;
import java.io.IOException;
import java.util.Optional;
import java.util.function.Consumer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/** Classe de controle de la page Evenement. */
@SuppressWarnings("rawtypes")
public class EvenementController {

  @SuppressWarnings("unused")
  private MainApp mainApp;
  @FXML
  private TableView<Evenement> tableView;
  @FXML
  private TableColumn colImage;
  @FXML
  private TableColumn colNom;
  @FXML
  private TableColumn colType;
  @FXML
  private TableColumn colDate;
  @FXML
  private TableColumn colLieu;
  @FXML
  private TableColumn colDescription;
  @FXML
  private TableColumn colAction;

  private ObservableList<Evenement> personData = FXCollections.observableArrayList();

  public EvenementController() {}



  /**
   * Initialise la classe controller de evement. Appele automatiquement apres que le fichier fxml
   * est été chargé.
   */
  @SuppressWarnings("unchecked")
  @FXML
  private void initialize() {

    MainApp.columnReorder(tableView, colImage, colNom, colType, colDate, colLieu, colDescription);

    tableView.widthProperty().addListener((obs, oldVal, newVal) -> {
      double width = tableView.getWidth();
      int nbColumns = tableView.getColumns().size();

      tableView.getColumns().forEach(new Consumer() {
        @Override
        public void accept(Object t) {
          TableColumn col = (TableColumn) t;
          MainApp.setExtremeSize(col, width / nbColumns);
        }
      });

    });

    Callback<TableColumn<Evenement, String>, TableCell<Evenement, String>> cellFactory = //
        new Callback<TableColumn<Evenement, String>, TableCell<Evenement, String>>() {
          @Override
          public TableCell<Evenement, String> call(final TableColumn<Evenement, String> param) {

            TableCell<Evenement, String> cell = new TableCell<Evenement, String>() {

              @Override
              public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                  setText(null);
                  setGraphic(null);
                } else {
                  // ImageView btnEdit = new ImageView(new
                  // Image("file:resources/icon-modifier.png"));
                  ImageView btnSup = new ImageView(new Image("file:resources/icon-supprimer.png"));

                  // btnEdit.setCursor(Cursor.HAND);
                  btnSup.setCursor(Cursor.HAND);

                  // permet de clicker sur les parties transparentes des images
                  // btnEdit.setPickOnBounds(true);
                  btnSup.setPickOnBounds(true);

                  // btnEdit.setFitHeight(25);
                  // btnEdit.setFitWidth(25);

                  btnSup.setFitHeight(25);
                  btnSup.setFitWidth(25);

                  HBox actionCell = (HBox) new HBox();
                  actionCell.setAlignment(Pos.CENTER);
                  // actionCell.setSpacing(15.0);
                  actionCell.getChildren().addAll(btnSup);

                  btnSup.setOnMouseClicked(event -> {
                    // alert

                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation suppresion");
                    alert.setHeaderText("Voulez-vous vraiment supprimer cet evenement ?");

                    Optional<ButtonType> option = alert.showAndWait();

                    if (option.get() == ButtonType.OK) {
                      String nomEv = getTableView().getItems().get(getIndex()).getNom();
                      GestionEvenements.supprimerEvenement(GestionEvenements.getEvenement(nomEv));
                      reloadTableEvenement();
                    }
                  });

                  /*
                   * btnEdit.setOnMouseClicked(event -> { Membre membre =
                   * getTableView().getItems().get(getIndex()); openStage("Editer Membre",
                   * membre.getPseudo()); });
                   */

                  setText(null);
                  setGraphic(actionCell);

                }
              }
            };
            return cell;
          }
        };

    colAction.setCellFactory(cellFactory);


    for (Evenement e : GestionEvenements.getEvenements()) {
      personData.add(e);
      System.out.println(e.getDateHoraire());
    }

    tableView.getItems().addAll(personData);

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
   * Affiche la page ajout evenement dans le layout de droite de root.
   */

  @FXML
  public void showAjoutEvenementView() {

    try {
      // Load person overview.
      Parent root = null;

      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApp.class.getResource("view/AjoutEvenement.fxml"));

      root = (VBox) loader.load();

      AjoutEvenementController controller = loader.getController();

      Stage stage = new Stage();
      controller.setDialogStage(stage);
      controller.setMainApp(mainApp);

      stage.setTitle("Ajouter événement");
      stage.setResizable(false);
      stage.setScene(new Scene(root));
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.showAndWait();

      this.reloadTableEvenement();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void reloadTableEvenement() {
    tableView.setItems(FXCollections.observableArrayList(GestionEvenements.getEvenements()));
    tableView.refresh();
  }
}
