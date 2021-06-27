package BakeryManagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author group project
 */
public class Sale_Records {

    private static long Total_Sale_of_day = 0;
    private static ArrayList<Order> saleRecord = new ArrayList();

    static void addSale(Order temp) {
        saleRecord.add(temp);
        Total_Sale_of_day += temp.total_bill;
    }

    static void DeleteSale(String name) {
        Order temp = searchOrder(name);
        if (temp != null) {
            ArrayList<Products> cart=temp.getCart();
            for(int i=0;i<cart.size();i++){
                Stock.addToStock(cart.get(i));
            }
            Total_Sale_of_day -= temp.total_bill;
            saleRecord.remove(temp);
            System.out.println("<-=-=-=- Successfuly Removed -=-=-=->");
            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
        } else {
            System.out.println("<-=-=-=- Order Does Not Found -=-=-=->");
            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
        }
    }

    static void showSaleRecord() {
        int i = 0;
        for(;i<saleRecord.size();i++){
            saleRecord.get(i).GenerateBill();
            
        }
    }

    static Order searchOrder(String name) {
        int i = 0;
        Order obj = null;
        while (i < saleRecord.size()) {
            obj = (Order) saleRecord.get(i);
            if (obj.getCustomer_name().equals(name)) {
                return obj;
            } else {
                i++;
            }
        }
        return null;
    }

    private static ObjectInputStream read;
    private static ObjectOutputStream add;
// to write on file

    public static void WriteFile() throws IOException {
        try {
            add = new ObjectOutputStream(new FileOutputStream("SaleRecord.hex"));
            for (int i = 0; i < saleRecord.size(); i++) {
                add.writeObject(saleRecord.get(i));
            }
            add.flush();
            add.close();
        } catch (IOException ex) {
            System.out.println("<-=-=-=- Erorr In Filing -=-=-=->");
        }
    }
// to read from the file

    static void ReadFile() throws FileNotFoundException, IOException, ClassNotFoundException, EOFException {
        Order temp = null;
        try {
            read = new ObjectInputStream(new FileInputStream("SaleRecord.hex"));
            while (true) {
                temp = (Order) read.readObject();
                Total_Sale_of_day += temp.total_bill;
//                System.out.println(temp.getPhoneNumber());
                saleRecord.add(temp);
            }
        } catch (EOFException ex) { //This exception will be caught when EOF is reached
            System.out.print("");
        } catch (ClassNotFoundException | IOException ex) {
        }
    }
}
