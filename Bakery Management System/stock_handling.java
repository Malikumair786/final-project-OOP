/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BakeryManagement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author group project
 */
public class stock_handling {

    static void DashBoard() {
        String chose;

        System.out.print("1 :    Add Product\n2 :    Search OR Show Details of a"
                + " Product\n3 :    Delete Product\n4 :    Report of The Stock\n"
                + "0 :    Go Back    ? ");
        chose = StringInt.string();
        System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
        while (!chose.equals("0")) {

            boolean flag = true;
            switch (chose) {
                case "1":
                    Products temp = new Products();
                    System.out.print("Product Id        ?    ");
                    temp.id = StringInt.stringLine();
                    System.out.print("Product Title     ?    ");
                    temp.title = StringInt.stringLine();
                    System.out.print("Total Pieces      ?    ");

                    temp.pieces = StringInt.Long();
                    System.out.print("Unit Price        ?    ");
                    temp.unit_price = StringInt.integer();
                    Stock.addToStock(temp);
                    System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                            + "-=-=-=-=-=>");
                    break;

                case "2":
                    System.out.print("Search By \n1 :    Id\n2 :    Title    ?");
                    chose = StringInt.string();
                    System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                            + "-=-=-=-=-=>");

                    switch (chose) {
                        case "1":
                            System.out.print("Product Id        ?    ");
                            String id = StringInt.stringLine();
                            temp = Stock.searchFromStock(id);
                            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                                    + "-=-=-=-=-=-=-=>");
                            System.out.println("\tSearched Product is : ");
                            if (null != temp) {
                                temp.Display();
                            } else {
                                System.out.println("<-=-=-=- Order Does Not Exist -=-=-=->");
                            }
                            break;
                        case "2":
                            System.out.print("Product title        ?    ");
                            String title = StringInt.stringLine();
                            temp = Stock.SearchFromStock(title);
                            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                                    + "-=-=-=-=-=-=-=>");
                            System.out.println("\tSearched Product is : ");
                            temp.Display();
                            break;
                        default:
                            System.out.println("<-=-=-=-Invalid Choice-=-=-=->");
                            break;
                    }
                    break;

                case "3":
                    System.out.print("Delete By \n1 :    Id\n2 :    Title    ?");
                    chose = StringInt.string();
                    System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                            + "-=-=-=-=-=>");
                    switch (chose) {
                        case "1":
                            System.out.print("Product Id        ?    ");
                            String id = StringInt.string();
                            Stock.deleteFromStock(id);
                            break;
                        case "2":
                            System.out.print("Product title        ?    ");
                            String title = StringInt.stringLine();
                            Stock.DeleteFromStock(title);
                            break;
                        default:
                            System.out.println("<-=-=-=- Invalid Choice -=-=-=->");
                            break;
                    }
                    break;

                case "4":
                    Stock.displayStock();
                    break;

                default:
                    System.out.println("\t<-=-=-=- INVALID CHOICE -=-=-=->");
                    System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                    break;
            }
            System.out.print("1 :    Add Product\n2 :    Search OR Show Details of a"
                    + " Product\n3 :    Delete Product\n4 :    Report of The Stock\n"
                    + "0 :    Go Back    ? ");
            chose = StringInt.string();
            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
        }

        try {
            Stock.WriteFile();
        } catch (IOException ex) {
            Logger.getLogger(stock_handling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
