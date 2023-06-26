import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditController {
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
    Button edit_emp;
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
    TextField leave_days;
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
    private void addPage(ActionEvent event) throws IOException {
        App.setRoot("add");
        
    }
    
    @FXML
    private void del() throws IOException {
        App.setRoot("delete");
    }

    @FXML
    private void editEmp() throws IOException {
     
        
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
        String leave = leave_days.getText();

        // opening original csv file
        String CSVFilename2 = "employee-details.csv";
        //creating temp file
        String tempFilename2 = CSVFilename2.replace(".csv", ".tmp");
        CSVReader reader2 = new CSVReader(new FileReader(CSVFilename2));
        //storing of data on an array
        String[] row;
        try(CSVWriter writer = new CSVWriter(new FileWriter(tempFilename2, true), ',', CSVWriter.NO_QUOTE_CHARACTER)){
            while((row = reader2.readNext()) != null){
                //if it encounters the employee number it will not write the details on the csv
                if(!row[0].equals(emp_id)){ //12346
                    writer.writeNext(row);
                }
            }
            reader2.close();
        } finally {
            //deleting the original file
            new File(CSVFilename2).delete();
            //renaming the temp file as the original so it will became the original
            new File(tempFilename2).renameTo(new File(CSVFilename2));
        }


         //Instantiating the CSVWriter class
         CSVWriter adwriter = new CSVWriter(new FileWriter("employee-details.csv",true), ',', CSVWriter.NO_QUOTE_CHARACTER);
         //Writing data to a csv file
         String row1[] = {emp_id, password, emp_name, emp_birth, basic_salary, rice_sub, phone_all, clothing_all, monthlyR,hourly_rate,leave };
         //Writing data to the csv file
         adwriter.writeNext(row1);
         //Flushing data from writer to file
         adwriter.flush();

         
         success.setText("Success Employee Details Was Edited!");
        
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
