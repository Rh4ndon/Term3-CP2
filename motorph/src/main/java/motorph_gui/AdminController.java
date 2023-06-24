package motorph_gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdminController {
    @FXML
    Button out;
    @FXML
    TextField empno;
    @FXML
    Label errorHandler;
    @FXML
    Label empname;
    @FXML
    Label birth;
    @FXML
    Label salary;
    @FXML
    Label hrate;
    @FXML
    Label leave;
    @FXML
    Label rice;
    @FXML
    Label phone;
    @FXML
    Label clothing;
    

      // variables for employee details
      static String emp_number = "";
      static String name = "";
      static String bday = "";
      static String basic_salary = "";
      static String rice_subsidy = "";
      static String phone_allowance = "";
      static String clothing_allowance = "";
      static String hourly_rate = "";
      static String no_leave = "";

    //Logout button
    @FXML
    private void logOut() throws IOException {
        App.setRoot("login");
    }

    @FXML
    private void searchID() throws IOException {
        searchEMP();
        
    }

    private void searchEMP() {
        String idno = empno.getText();
        

        try {
            // create br variable to hold csv file data
            // open our csv file with FileReader giving our path with csv_file variable
            BufferedReader br = new BufferedReader(new FileReader("employee-details.csv"));
            String line = "";

            // create a while loop and assign our csv file to line variable
            // until the end of the file {null}
            while((line = br.readLine()) != null) {
                // create an array of string variable that will hold each line
                // each array element is separated by comma
                // this will result to: employee = {"10001","Juan","Dela Cruz","etc"}
                // to access each element we have to declare: employee[0] for 10001, employee[1] for Juan and etc
                String[] details = line.split(",");

                if(details[0].equals(idno )) {
                    
                    
                    emp_number = details[0];
                    name = details[2];
                    bday = details[3];
                    basic_salary = details[4];
                    rice_subsidy = details[5];
                    phone_allowance = details[6];
                    clothing_allowance = details[7];
                    hourly_rate = details[9];
                    no_leave = details[10];

                   

                    empname.setText(name);
                    birth.setText(bday);
                    salary.setText(basic_salary);
                    hrate.setText(hourly_rate);
                    rice.setText(rice_subsidy);
                    phone.setText(phone_allowance);
                    clothing.setText(clothing_allowance);
                    leave.setText(no_leave + " days");
                   
                

                    

                    
                }
                else if (idno.isEmpty()) {
                    errorHandler.setText("Please enter you data.");
                    System.out.println("Please enter you data.");
                   
                }
                
            }

            br.close();
        } catch (Exception e) {
            // TODO: handle exception
            errorHandler.setText("Error Encountered!");
            System.out.println("Error Encountered!");
            
        }       
    }



    
}
