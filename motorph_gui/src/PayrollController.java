import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


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
    @FXML
    Label noofleave;
    @FXML
    Label success;

    @FXML
    TextField reason;
    @FXML
    DatePicker dateOf;
    @FXML
    TextField daysOf;


    

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
    static String lea = "";
    static String pass = "";
    static String basic = "";
    static String rice = "";
    static String phone = "";
    static String clothes = "";
    static String month = "";
    static String hour = "";

    @FXML
    public void initialize() throws IOException {
        // initialization code here...
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
        noofleave.setText(lea);
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
        lea = empData[12];
        pass = empData[13];
        basic = empData[14];
        rice = empData[15];
        phone = empData[16];
        clothes = empData[17];
        month = empData[18];
        hour = empData[19];
      

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

    
 

    @FXML
    private void applyLeave() throws IOException {

        int leave_rec = Integer.parseInt(lea);
        try{
           
    
            int days_of = Integer.parseInt(daysOf.getText());

            int leaveLeft = leave_rec - days_of;

            String reason_of = reason.getText();
             LocalDate dates_of = dateOf.getValue();
             DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            String dateOfl = dates_of.format(formatters);

   
            //Instantiating the CSVWriter class
            CSVWriter adwriter = new CSVWriter(new FileWriter("employee-leave.csv",true), ',', CSVWriter.NO_QUOTE_CHARACTER);
            //Writing data to a csv file
            String leave_days = String.valueOf(days_of);

            
            String row1[] = {cemp_number, cname, dateOfl, leave_days, reason_of};
            //Writing data to the csv file
            adwriter.writeNext(row1);
            //Flushing data from writer to file
            adwriter.flush();



        String leavesOfEmp = String.valueOf(Math.round(leaveLeft));
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
                if(!row[0].equals(cemp_number)){ //12346
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
            CSVWriter adwriter5 = new CSVWriter(new FileWriter("employee-details.csv",true), ',', CSVWriter.NO_QUOTE_CHARACTER);
            //Writing data to a csv file
            String emprow[] = {cemp_number, pass, cname, cbday, basic, rice, phone, clothes, month,hour,leavesOfEmp };
            //Writing data to the csv file
            adwriter5.writeNext(emprow);
            //Flushing data from writer to file
            adwriter5.flush();

            success.setText("Application Sent");


        }
        catch (NumberFormatException e){

            success.setText("Input Number for Days ");
        }
       
    
        
    }

   


}
