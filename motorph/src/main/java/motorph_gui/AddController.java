package motorph_gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;
import com.opencsv.*;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddController {
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



    

     

    //Logout button
    @FXML
    private void logOut() throws IOException {
        App.setRoot("login");
    }

    @FXML
    private void home() throws IOException {
        App.setRoot("admin");
    }
    @FXML
    private void add() throws IOException {
        App.setRoot("add");
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
    private void addEMP() throws IOException {
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

         //Instantiating the CSVWriter class
         CSVWriter adwriter = new CSVWriter(new FileWriter("employee-details.csv",true), ',', CSVWriter.NO_QUOTE_CHARACTER);
         //Writing data to a csv file
         String row[] = {emp_id, password, emp_name, emp_birth, basic_salary, rice_sub, phone_all, clothing_all, hourly_rate, leave};
         //Writing data to the csv file
         adwriter.writeNext(row);
         //Flushing data from writer to file
         adwriter.flush();
        
        

        
    }

  



    
}
