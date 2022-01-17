package eventgroup.view;

import eventgroup.MainApp;
import java.util.function.Consumer;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/** Classe de controle de la page Evenement. */
@SuppressWarnings("rawtypes")
public class EvenementController {

  @SuppressWarnings("unused")
  private MainApp mainApp;
  @FXML
  private TableView tableView;
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

  public EvenementController() {

  }

  /**
   * Initialise la classe controller de membre. Appele automatiquement apres que le fichier fxml est
   * été chargé.
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
  public void clickAddEvenement() {
    System.out.println("Ajout evenement");
  }

}
