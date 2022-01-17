package eventgroup;

import eventgroup.view.RootController;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/** Appliation javafx. */
public class MainApp extends Application {

  private Stage primaryStage;
  private SplitPane rootLayout;

  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle("EventGroup");

    try {
      // Load root layout from fxml file.
      FXMLLoader rootLoader = new FXMLLoader();
      rootLoader.setLocation(MainApp.class.getResource("view/Root.fxml"));
      rootLayout = (SplitPane) rootLoader.load();

      RootController controller = rootLoader.getController();
      controller.setMainApp(this);


      // Show the scene containing the root layout.
      Scene scene = new Scene(rootLayout);
      

      primaryStage.setScene(scene);
      primaryStage.setResizable(false);
      primaryStage.show();



    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Disable reorder collumns.
   *
   * @param table table dans laquelle on va definir l'ordre des colonnes
   * @param columns colonnes de la table dans l'ordre
   */

  @SuppressWarnings({"rawtypes", "unchecked"})
  public static <S, T> void columnReorder(TableView table, TableColumn<S, T>... columns) {
    table.getColumns().addListener(new ListChangeListener() {
      public boolean suspended;

      @Override
      public void onChanged(Change change) {
        change.next();
        if (change.wasReplaced() && !suspended) {
          this.suspended = true;
          table.getColumns().setAll(((Object[]) columns));
          this.suspended = false;
        }
      }
    });
  }

  /**
   * Disable resize collumns.
   *
   * @param listerColumn column to prevent resize
   * @param width current width to set
   */

  @SuppressWarnings("rawtypes")
  public static void setExtremeSize(final TableColumn listerColumn, double width) {
    listerColumn.setMinWidth(width);
    listerColumn.setMaxWidth(width);
  }


  /**
   * Returns the main stage.
   *
   * @return Stage
   */
  public Stage getPrimaryStage() {
    return primaryStage;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
