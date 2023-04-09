package motorph_gui;


import java.io.IOException;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.util.Arrays;


public class PayrollController {
    
    @FXML
    private Button login;
    @FXML
    private Button reload;
    @FXML
    private Button exit;
    @FXML
    Label empname;
    @FXML
    Label empno;
    @FXML
    Label fbday;
    @FXML
    Label sss;
    @FXML
    Label pagibig;
    @FXML
    Label phealth;
    @FXML
    Label wtax;
    @FXML
    Label tdeduct;
    @FXML
    Label hwork;
    @FXML
    Label gincom;
    @FXML
    Label tperks;
    @FXML
    Label netincome;

    // variables for employee details
    static String cname = "";
    static String cemp_number = "";
    static String cbday = "";
    static String cgross = "";
    static String csss = "";
    static String cpagibig = "";
    static String cphealth = "";
    static String WT = "";
    static String TD = "";
    static String HW = "" +"d";
    static String TP = "";
    static String NI = "";

    
    @FXML
    private void refresh() throws IOException {
      
      empno.setText(cemp_number);
      empname.setText(cname);
      fbday.setText(cbday);
      sss.setText(csss); 
      pagibig.setText(cpagibig);
      phealth.setText(cphealth);
      wtax.setText(WT); 
      tdeduct.setText(TD);
      hwork.setText(HW);
      tperks.setText(TP); 
      netincome.setText(NI);
      gincom.setText(cgross);
      
    }
    
    @FXML
    public void displayDetails(String [] empData){
        cemp_number = empData[0];
        cname = empData[2];
        cbday = empData[1];
        cgross = empData[11];
        csss = empData[3];
        cpagibig = empData[4];
        cphealth = empData[5];
        WT = empData[6];
        TD = empData[7];
        HW = empData[8];
        TP = empData[9];
        NI = empData[10];
        System.out.println(cname);

    }
    
    

    //Logout button
    @FXML
    private void back() throws IOException {
        App.setRoot("login");
    }
    //Exit window button
    @FXML
    public void close() {
    Stage stage = (Stage) exit.getScene().getWindow();
    stage.close();
    }

    
    





}
