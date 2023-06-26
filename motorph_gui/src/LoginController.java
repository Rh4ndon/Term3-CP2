import java.io.IOException;


import java.io.BufferedReader;
import java.io.FileReader;




import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;






public class LoginController {

     // variables for employee details
     static String emp_number = "";
     static String pass = "";
     static String name = "";
     static String bday = "";
     static String month = "";
     static double basic_salary = 0;
     static double rice_subsidy = 0;
     static double phone_allowance = 0;
     static double clothing_allowance = 0;
     static double hourly_rate = 0d;
     static double gross = 0;
     static double sss = 0;
     static double pagibig = 0;
     static double phealth = 0;
     static double withholding = 0;
     static double perks = 0;
     static double deductions = 0;
     static double net = 0;
     static double totalh = 0;
     static double leave = 0;
     
     
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
        String admin = "admin";
        String pass = password.getText();

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

                if(details[0].equals(user) && details[1].equals(pass)) {
                    wrongLogIn.setText("Success!");
                    // put all details in the variables
                    if (details[0].equals(admin)){
                       
                        App.setRoot("admin");
                    }
                    else {
                    emp_number = details[0];
                    pass = details[1];
                    name = details[2];
                    bday = details[3];
                    basic_salary = Double.parseDouble(details[4]);
                    rice_subsidy = Double.parseDouble(details[5]);
                    phone_allowance = Double.parseDouble(details[6]);
                    clothing_allowance = Double.parseDouble(details[7]);
                    month = details[8];
                    hourly_rate = Double.parseDouble(details[9]);
                    leave = Double.parseDouble(details[10]);

                    

                    print_details();
                    
                    String ss = String.valueOf(Math.round(sss));                    
                    String gros = Double.toString(Math.round(gross));
                    String pag = String.valueOf(Math.round(pagibig));
                    String ph = String.valueOf(Math.round(phealth));
                    String wh = String.valueOf(Math.round(withholding));
                    String td = String.valueOf(Math.round(deductions));
                    String th = String.valueOf(Math.round(totalh));
                    String tp = String.valueOf(Math.round(perks));
                    String ni = String.valueOf(Math.round(net));
                    String lea = String.valueOf(Math.round(leave));
                    String basic = String.valueOf(Math.round(basic_salary));
                    String rice = String.valueOf(Math.round(rice_subsidy));
                    String phone = String.valueOf(Math.round(phone_allowance));
                    String clothing = String.valueOf(Math.round(clothing_allowance));
                    String hourly = String.valueOf(Math.round(hourly_rate));

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("payroll.fxml"));
                    loader.load();
                    PayrollController payrollController = loader.getController();
                    String[] empData = {emp_number,bday,name,ss,pag,ph,wh,td,th,tp,ni,gros,lea,pass,basic,rice,phone,clothing,month,hourly};
                    payrollController.displayDetails(empData);
                                       
                    App.setRoot("payroll");
                }
                    
                    
                }
                else if (user.isEmpty() && pass.isEmpty()) {
                    wrongLogIn.setText("Please enter you data.");
                }
                else {
                    wrongLogIn.setText("Wrong username or password!!");
                }
            }

            br.close();
        } catch (Exception e) {
            // TODO: handle exception
            wrongLogIn.setText("Error Encountered!");
        }       
        
    }
    

    public static void print_details() {
        gross = total_hours() * hourly_rate;
        sss = compute_sss();
        pagibig = compute_pagibig();
        phealth = compute_philhealth();
        withholding = compute_withholding();
        perks = (rice_subsidy+phone_allowance+clothing_allowance)/4;
        deductions = sss+pagibig+phealth+withholding;
        net = gross - deductions;
        totalh = total_hours();
    }



    // calculate and return total hours work in a week
    public static int total_hours()
    {
        // sept 11, 2022 - sept 19, 2022
        int total = 0;
        for(int i = 0; i <6; i++)
        {
            int out = 17;
            int in = 8;
            int breaktime = 1;
            total += (out - in) - breaktime;
        }
               
        return total;
    }

    public static double compute_sss()
    {
        // check the beginning and return the rate
        if(basic_salary < 3250){
            return 135;
        }

        // not in the beginning, check the end and return rate
        if(basic_salary >= 24751){
            return 1125;
        }

        double rate = 157.5;
        double rrate = 0;
        // not in the beginning and end, it must be inside
        // iterate every 500 then increase rate by 22.5 for every iteration
        for(double i = 3250; i < 24751; i += 500){
            // System.out.println(String.format("%s - %s = %s",i, i+500, rate));
            // for every iteration check salary range
            if(basic_salary >= i && basic_salary < i+500){
                // we're inside that means we satisfy the salary range
                // save the rateso we can return it, then exit the loop 
                rrate = rate;
                break;
            }
            rate += 22.5;
        }
        // no explanation needed
        return rrate;
    }

    public static double compute_pagibig()
    {
        if(basic_salary <= 1500){
            return basic_salary * 0.01;
        } else {
            return basic_salary * 0.02;
        }
    }

    public static double compute_philhealth()
    {
        double base = (basic_salary * 0.03) / 2;
        if(base <= 300){
            return 300;
        }else if(base >= 1800){
            return 1800;
        }else{
            return base;
        }
    }

    public static double compute_withholding()
    {
        double total_deductions = compute_pagibig()+compute_philhealth()+compute_philhealth();
        double taxable_income = basic_salary - total_deductions;
        double tax = 0;

        if(taxable_income <= 20832){
            return 0;
        }else if(taxable_income > 20832 && taxable_income < 33333){
            tax =  (taxable_income - 20833) * .02;
        }else if(taxable_income >= 33333 && taxable_income < 66667){
            tax =  (taxable_income - 33333) * .25 + 2500;
        }else if(taxable_income >= 66667 && taxable_income < 166667){
            tax = (taxable_income - 66667) * .3 + 10883;
        }else if(taxable_income >= 166667 && taxable_income < 666667){
            tax = (taxable_income - 166667) * .32 + 40833.33;
        }else{
            tax = (taxable_income - 666667) * .35 + 200833.33;
        }

        return tax / 4;
    }

    public static int sum(int x, int y)
    {
        return x + y;
    }


}
