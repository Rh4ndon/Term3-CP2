
import com.opencsv.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
    Button del_emp;
    
    @FXML
    TextField empid;
    
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
    private void addPage() throws IOException {
        App.setRoot("add");
        
    }

    @FXML
    public void delEmp() throws IOException {
        
        delete();
        
    }

    @FXML
    public void delete() throws IOException{
        
        String emp_id = empid.getText();

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
                }else{
                    success.setText("Employee Details not found in the CSV!");
                }
            }
            reader2.close();
        } finally {
            //deleting the original file
            new File(CSVFilename2).delete();
            //renaming the temp file as the original so it will became the original
            new File(tempFilename2).renameTo(new File(CSVFilename2));

            success.setText("Employee Was Deleted To CSV!!!");
            empid.setText("");
        }
        
       
        



    }

    



    
}
