package motorph_gui;


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
      displayUser(cname);
      displaySSS(csss);
      displayBday(cbday);
      displayNo(cemp_number);
      displayPag(cpagibig);
      displayPh(cphealth);
      displayWh(WT);
      displayTd(TD);
      displayTp(TP);
      displayTh(cphealth);
      displayNi(NI);
      displayEmp(cgross);
      
    }
    @FXML
    public void displayUser (String name) {
        cname = name; 
        empname.setText(cname);      
    }
    @FXML
    public void displayNo (String emp_number) {
        cemp_number = emp_number; 
        empno.setText(cemp_number);      
    }
    @FXML
    public void displayBday (String bday) {
        cbday = bday; 
        fbday.setText(bday);      
    }
    @FXML
    public void displaySSS (String ss) {
        csss = ss; 
        sss.setText(csss);  
      
    }
    @FXML
    public void displayPag (String pag) {
        cpagibig = pag; 
        pagibig.setText(cpagibig);  
            
    }
    @FXML
    public void displayPh (String ph) {
        cphealth = ph; 
        phealth.setText(cphealth);  
            
    }
    @FXML
    public void displayWh (String wh) {
        WT = wh;
        wtax.setText(WT);                    
    }
    @FXML
    public void displayTd (String td) {
        TD = td;
        tdeduct.setText(TD);                    
    }
    @FXML
    public void displayTh (String th) {
        HW = th;
        hwork.setText(HW);                    
    }
    @FXML
    public void displayTp (String tp) {
        TP = tp;
        tperks.setText(TP);                    
    }
    @FXML
    public void displayNi (String ni) {
        NI = ni;
        netincome.setText(NI);                    
    }
    @FXML
    public void displayEmp (String gros) {
        cgross = gros;
        gincom.setText(gros);                    
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
