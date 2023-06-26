
import com.opencsv.*;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DeleteController {
    @FXML
    Button out;
    @FXML
    Button home;
    @FXML
    Button addemp;
    @FXML
    Button editemp;
    @FXML
    Button delete;
    @FXML
    Button add_emp;
    @FXML
    TextField fname;
    @FXML
    TextField pass;
    @FXML
    TextField empid;
    @FXML
    TextField salary;
    @FXML
    TextField hrate;
    @FXML
    TextField birth;
    @FXML
    TextField rice;
    @FXML
    TextField phone;
    @FXML
    TextField clothing;
    @FXML
    TextField monthly;
    @FXML
    Label success;



    

     

    //Logout button
    @FXML
    private void logOut() throws IOException {
        App.setRoot("login");
    }

    @FXML
    private void homePage() throws IOException {
        App.setRoot("admin");
    }
   

    @FXML
    private void edit() throws IOException {
        App.setRoot("edit");
    }

    @FXML
    private void del() throws IOException {
        App.setRoot("delete");
    }

    @FXML
    private void addEmp() throws IOException {
        String leave = "5";
        String emp_name = fname.getText();
        String password = pass.getText();
        String emp_id = empid.getText();
        String basic_salary = salary.getText();
        String emp_birth = birth.getText();
        String hourly_rate = hrate.getText();
        String rice_sub = rice.getText();
        String phone_all = phone.getText();
        String clothing_all = clothing.getText();
        String monthlyR = monthly.getText();

         //Instantiating the CSVWriter class
         BufferedWriter adwriter = new BufferedWriter(new FileWriter("employee-details.csv", true));
         //Writing data to a csv file
         String row[] = {emp_id, password, emp_name, emp_birth, basic_salary, rice_sub, phone_all, clothing_all, hourly_rate, leave};
         //Writing data to the csv file
         adwriter.write(emp_id + "," + password + "," + emp_name + "," + emp_birth + ","  + basic_salary + "," + rice_sub + "," + phone_all + "," + clothing_all + "," + monthlyR + "," + hourly_rate + "," + leave);
         //Flushing data from writer to file
         adwriter.flush();

         success.setText("Success Employee Was Added To CSV!!!");
        
         fname.setText("");
         pass.setText("");
         empid.setText("");
         salary.setText("");
         birth.setText("");
         hrate.setText("");
         rice.setText("");
         phone.setText("");
         clothing.setText("");
         monthly.setText("");

        
    }

  



    
}
