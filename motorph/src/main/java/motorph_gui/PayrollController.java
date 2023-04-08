package motorph_gui;

import motorph_gui.LoginController;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class PayrollController {


    
    @FXML
    private Button login;
    @FXML
    public Button exit;
    @FXML
    private Label empname;

    @FXML
    private void back() throws IOException {
        App.setRoot("login");
    }


    

    @FXML
    public void close(ActionEvent event) {
    Stage stage = (Stage) exit.getScene().getWindow();
    stage.close();
}

    @FXML
    public void displayDetails () throws IOException{
        
    }
    





}
