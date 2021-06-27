package BakeryManagement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author group project
 */
public class customer_handling {

    static void DashBoard() {
        String chose;
        System.out.print("1 :\t New Order\n2 :\t Edit Order\n3 :\t Cancel Order"
                + "\n0 :\t Go Back    ? ");
        chose = StringInt.string();
        System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
        while (!chose.equals("0")) {
            Order order = new Order();
            switch (chose) {
                case "1":
                    System.out.println("<-=-=-=- Adding New Order -=-=-=->");
                    System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                    System.out.print("Customer Name       ?   ");
                    order.setCustomer_name(StringInt.stringLine());
                    String next;
                    do {
                        System.out.print("Product Title       ?   ");
                        String title = StringInt.stringLine();
                        System.out.print("Total Pieces        ?   ");
                        long units = StringInt.Long();
                        order.addToCart(title, units);
                        System.out.println("Want To Add More Item to Cart  ?   ");
                        System.out.print("1 :\t Yes\n0 :\t No    ?");
                        next = StringInt.string();
                        System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                                + "-=-=-=-=-=>");
                    } while (!next.equals("0"));
                    order.GenerateBill();
                    Sale_Records.addSale(order);
                    System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                            + "-=-=-=-=-=>");
                    break;

                case "2": {
                    System.out.println("<-=-=-=- Updating Old Order -=-=-=->");
                    boolean flag = true;
                    System.out.print("Want To \n1 : Remove Item\n2 : Add Item to Cart     ?  ");
                    next = StringInt.string();
                    System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                            + "-=-=-=-=-=>");
                    if (next.equals("1")) {
                        System.out.print("Customer Name           ?   ");
                        String name = StringInt.stringLine();
                        order = Sale_Records.searchOrder(name);
                        if (order != null) {
                            String next1;
                            do {
                                System.out.println("Product Title         ?   ");
                                String title = StringInt.stringLine();
                                System.out.println("Units Want to Remove  ?   ");
                                long units = StringInt.Long();
                                order.removeFromCart(title, units);

                                System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                                        + "-=-=-=-=-=>");
                                System.out.println("Any Other Item          ?   ");
                                System.out.print("1 :\t Yes\n0 :\t No    ?");
                                next1 = StringInt.string();
                                System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                                        + "-=-=-=-=-=>");
                            } while (!next1.equals("0"));
                            System.out.println("<-=-=-=- New Bill -=-=-=->");
                            order.GenerateBill();
                        } else {
                            System.out.println("<-=-=-=- Order Does Not Found -=-=-=->");
                            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                        }
                    } else if (next.equals("2")) {
                        System.out.print("Customer Name           ?   ");
                        String name = StringInt.stringLine();
                        order = Sale_Records.searchOrder(name);
                        if (order != null) {
                            String next1;
                            do {
                                System.out.print("Product Title       ?   ");
                                String title = StringInt.stringLine();
                                System.out.print("Units Want to Add   ?   ");
                                long units = StringInt.Long();
                                order.addToCart(title, units);
                                System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                                        + "-=-=-=-=-=>");
                                System.out.println("Any Other Item          ?   ");
                                System.out.print("1 :\t Yes\n0 :\t No    ?   ");
                                next1 = StringInt.string();
                                System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                                        + "-=-=-=-=-=>");
                            } while (!next1.equals("0"));
                            System.out.println("           <-=-=-=- New Bill -=-=-=->");
                            order.GenerateBill();
                        } else {
                            System.out.println("<-=-=-=- Order Does Not Found -=-=-=->");
                            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                        }
                    }
                    break;
                }
                case "3":
                    System.out.print("Name     ?    ");
                    String name = StringInt.stringLine();
                    //    System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                    //          + "-=-=-=-=-=>");
                    Sale_Records.DeleteSale(name);
                    break;

                default:
                    System.out.println("<-=-=-=- INVALID CHOICE -=-=-=->");
                    System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                    break;
            }
            System.out.print("1 :\t New Order\n2 :\t Edit Order\n3 :\t Cancel Order"
                    + "\n0 :\t Go Back    ? ");
            chose = StringInt.string();
            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
        }

        try {
            Sale_Records.WriteFile();
        } catch (IOException ex) {
            Logger.getLogger(customer_handling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
