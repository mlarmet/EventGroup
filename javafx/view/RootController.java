package eventgroup.view;

import eventgroup.MainApp;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.control.SplitPane.Divider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/** Classe de controle de la page membre. */
public class RootController {

  private MainApp mainApp;
  @FXML
  private SplitPane rootLayout;
  @FXML
  private AnchorPane rightPane;
  @FXML
  private AnchorPane leftPane;

  public RootController() {

  }

  /**
   * Initialise la classe controller de membre. Appele automatiquement apres que le fichier fxml est
   * été chargé.
   */
  @FXML
  private void initialize() {
    // Desactive la possibilite de deplacer le curseur de separation
    Divider divider = rootLayout.getDividers().get(0);
    divider.positionProperty().addListener(new ChangeListener<Number>() {
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldvalue,
          Number newvalue) {
        divider.setPosition(0.15);
      }
    });

    this.showMembreView();
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
   * Affiche la page evenement dans le layout de droite de root.
   */
  public void showEvenementView() {

    try {
      // Load person overview.
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApp.class.getResource("view/Evenement.fxml"));

      VBox evenement = (VBox) loader.load();

      AnchorPane.setTopAnchor(evenement, 0.0);
      AnchorPane.setBottomAnchor(evenement, 0.0);
      AnchorPane.setLeftAnchor(evenement, 0.0);
      AnchorPane.setRightAnchor(evenement, 0.0);

      if (rightPane.getChildren().size() > 0) {
        rightPane.getChildren().remove(0);
      }
      rightPane.getChildren().add(evenement);

      EvenementController controller = loader.getController();
      controller.setMainApp(mainApp.getMainApp());


    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Affiche la page membre dans le layout de droite root.
   */
  public void showMembreView() {

    try {
      // Load person overview.
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApp.class.getResource("view/Membre.fxml"));

      VBox membre = (VBox) loader.load();

      AnchorPane.setTopAnchor(membre, 0.0);
      AnchorPane.setBottomAnchor(membre, 0.0);
      AnchorPane.setLeftAnchor(membre, 0.0);
      AnchorPane.setRightAnchor(membre, 0.0);

      if (rightPane.getChildren().size() > 0) {
        rightPane.getChildren().remove(0);
      }
      rightPane.getChildren().add(membre);

      MembreController controller = loader.getController();
      controller.setMainApp(this.mainApp);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
