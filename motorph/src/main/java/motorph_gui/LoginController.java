package motorph_gui;

import java.io.IOException;




import java.io.BufferedReader;
import java.io.FileReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController {

     // variables for employee details
     static String emp_number = "";
     static String name = "";
     static String bday = "";
     static double basic_salary = 0;
     static double rice_subsidy = 0;
     static double phone_allowance = 0;
     static double clothing_allowance = 0;
     static double hourly_rate = 0d;
     static double gross = 0;

    @FXML
    private Button button;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    Stage stage;

    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();
    }
    
    @FXML
    private void checkLogin() throws IOException {

        String user = username.getText();
        String pass = password.getText();

        try {
            // create br variable to hold csv file data
            // open our csv file with FileReader giving our path with csv_file variable
            BufferedReader br = new BufferedReader(new FileReader("employee-details.txt"));
            String line = "";

            // create a while loop and assign our csv file to line variable
            // until the end of the file {null}
            while((line = br.readLine()) != null) {
                // create an array of string variable that will hold each line
                // each array element is separated by comma
                // this will result to: employee = {"10001","Juan","Dela Cruz","etc"}
                // to access each element we have to declare: employee[0] for 10001, employee[1] for Juan and etc
                String[] details = line.split(",");

                if(details[0].equals(user) && details[1].equals(pass)) {
                    // put all details in the variables
                    emp_number = details[0];
                    name = details[2];
                    bday = details[3];
                    basic_salary = Double.parseDouble(details[4]);
                    rice_subsidy = Double.parseDouble(details[5]);
                    phone_allowance = Double.parseDouble(details[6]);
                    clothing_allowance = Double.parseDouble(details[7]);
                    hourly_rate = Double.parseDouble(details[9]);

                    wrongLogIn.setText("Success!");
                    App.setRoot("menu");
                }
                else if (user.isEmpty() && pass.isEmpty()) {
                    wrongLogIn.setText("Please eneter you data.");
                }
                else {
                    wrongLogIn.setText("Wrong username or password!!");
                }
            }

            br.close();
        } catch (Exception e) {
            // TODO: handle exception
            wrongLogIn.setText("File not found!");
        }

        


       
        
    }
    
}
