import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;



public class App extends Application {
    
    private static Stage stg;

    private static Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        scene = new Scene(loadFXML("edit"), 700, 400);
        Image icon = new Image("logo-no-background.png");
        stage.getIcons().add(icon);
        stage.setTitle("Motor PH");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
