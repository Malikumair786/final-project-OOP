/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BakeryManagement;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author group project
 */
public class RUNNER {

    public static void main(String[] args) throws IOException {
        login logIn = new login();
        String chose = "1";
        boolean bool = true;
        String user_name, password;
        File f = new File("Users.hex");
        if (f.length() == 0) {
            System.out.println("To Use The Program Need To Register First   :");
            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            registration.RegisterNewUser();
            user_data_base.WriteFile();
        } else {
            try {
                File dbf = new File("Users.hex");
                File stokf = new File("Users.hex");
                File srf = new File("Users.hex");
                if (dbf.length() > 0) {
                    user_data_base.ReadFile();
                }
                if (stokf.length() > 0) {
                    Stock.ReadFile();
                }
                if (srf.length() > 0) {
                    Sale_Records.ReadFile();
                }
            } catch (FileNotFoundException | ClassNotFoundException | EOFException ex) {
                Logger.getLogger(RUNNER.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("<----| Welcome to Niazi's |---->\n");
        System.out.println("<-=-=-=- Admin -=-=-=->");
        while (!chose.equals("0")) {
            //   System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            System.out.print("1 :    LOGIN     \n2 :    FORGET PASSWORD \n3 :    "
                    + "REGISTER \n0 :    Close Application   ?   ");
            chose = StringInt.string();

            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            switch (chose) {
                case "1":
                    if (login.Login()) {
                        try {
                            Admin_dash_board();
                        } catch (FileNotFoundException | ClassNotFoundException ex) {
                            System.out.println("Error At Dash Board");
                        }
                    }
                    break;
                case "2":
                    login.forgetPassword();
                    break;
                case "3":
                    registration.RegisterNewUser();
                    System.out.println("<-=-=-=- Successfuly Registered -=-=-=->");
                    break;
                case "0":
                    System.out.println("<-=-=-=- Clossing Application..... -=-=-=->");
                    System.out.println("Loading......\nDONE");
                    System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                    break;
                default:
                    System.out.println("<-=-=-=- INVALID CHOISE -=-=-=->");
                    System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                    break;
            }
        }
    }

    private static void Admin_dash_board() throws IOException, FileNotFoundException, ClassNotFoundException {

        String chose = "1";
        while (!chose.equals("0")) {
            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            System.out.print("1 :    STOCK HANDLING     \n2 :    CUSTOMER HANDLING     "
                    + "\n3 :    REGISTRATION HANDLING    \n4 :    SALE RECORDS\n0 :    LOGOUT    ? ");
            chose = StringInt.string();

            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            if (chose.equals("1")) {
                stock_handling.DashBoard();
            } else if (chose.equals("2")) {
                customer_handling.DashBoard();
            } else if (chose.equals("3")) {
                registration.registrationBoard();
            } else if (chose.equals("4")) {

                String s;
                System.out.println("\n<-=-=-=- SALE RECORDS -=-=-=->\n");
                System.out.print("1 :    SEARCH AN ORDER      \n2 :    SHOW ALL THE ORDERS     "
                        + "\n0 :    GO BACK TO MAIN MENU    ? ");
                s = StringInt.string();

                while (!s.equals("0")) {
                    switch (s) {
                        case "1":
                            System.out.println("\n<-=-=-=- SEARCHING ORDER -=-=-=->\n");
                            System.out.print("Customer Name :    ");
                            String name = StringInt.stringLine();
                            Order temp = Sale_Records.searchOrder(name);
                            if (temp != null) {
                                temp.GenerateBill();
                            } else {
                                System.out.println("<-=-=-=- RECORD DOES NOT FOUND -=-=-=->");
                            }
                            break;

                        case "2":
                            System.out.println("<-=-=-=- SALES HISTORY -=-=-=->");
                            Sale_Records.showSaleRecord();
                            break;

                        default:
                            System.out.println("\t<-=-=-=- INVALID CHOICE -=-=-=->");
                            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                            break;

                    }
                    System.out.println("\n<-=-=-=- SALE RECORDS -=-=-=->\n");
                    System.out.print("1 :    SEARCH AN ORDER      \n2 :    SHOW ALL THE ORDERS     "
                            + "\n0 :    GO BACK TO MAIN MENU    ? ");
                    s = StringInt.string();
                }
            } else if (chose.equals("0")) {
                System.out.println("    EXITING..... ");
                System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            } else {
                System.out.println("\t<-=-=-=- INVALID CHOICE -=-=-=->");
            }
        }
        user_data_base.WriteFile();
        Stock.WriteFile();
        Sale_Records.WriteFile();
    }
}
