package BakeryManagement;

import java.util.ArrayList;

/**
 *
 * @author group project
 */
import java.io.*;

public class Stock implements Serializable {

    private static ArrayList<Products> pStock = new ArrayList();

    static void addToStock(Products obj) {
        Products product = searchFromStock(obj.id);
        if (product != null) {
            product.pieces = product.pieces + obj.pieces;
            product.unit_price = obj.unit_price;
            System.out.println("Product Is Successfuly Added :");
            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
        } else {
            pStock.add(obj);
            System.out.println("New Product Is Successfuly Added :");
            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");

        }
    }

    static void deleteFromStock(String id) {
        int i = 0;
        Products obj = null;
        while (i < pStock.size()) {
            obj = (Products) pStock.get(i);
            if (obj.id.equals(id)) {
                pStock.remove(i);
                break;
            } else {
                i++;
            }
        }
        System.out.println("<-=-=-=- Successfuly Deleted -=-=-=->");
        System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
    }

    static void DeleteFromStock(String title) {
        int i = 0;
        Products obj = null;
        while (i < pStock.size()) {
            obj = (Products) pStock.get(i);
            if (obj.title.equals(title)) {
                pStock.remove(i);
                break;
            } else {
                i++;
            }
        }
        System.out.println("<-=-=-=- Successfuly Deleted -=-=-=->");
        System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
    }

    static Products searchFromStock(String id) {
        int i = 0;
        Products obj = null;
        while (i < pStock.size()) {
            obj = (Products) pStock.get(i);
            if (obj.id.equals(id)) {
                return obj;
            } else {
                i++;
            }
        }
        return null;
    }

    static Products SearchFromStock(String title) {
        int i = 0;
        Products obj = null;
        while (i < pStock.size()) {
            obj = (Products) pStock.get(i);
            if (obj.title.equals(title)) {
                return obj;
            } else {
                i++;
            }
        }
        return null;
    }

    static void displayStock() {
        System.out.println("<-=-=-=- Available Stock Is -=-=-=->");
        System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
        for (int i = 0; i < pStock.size(); i++) {
            System.out.println("Product Id        :    " + pStock.get(i).id);
            System.out.println("Product Title     :    " + pStock.get(i).title);
            System.out.println("Stock of Pieces   :    " + pStock.get(i).pieces);
            System.out.println("Unit Price        :    " + pStock.get(i).unit_price);
            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
        }
    }

    static boolean isAvailableInStock(String title) {
        Products obj = SearchFromStock(title);
        if (obj != null && obj.pieces > 0) {
            System.out.println("Stock is Available   :    " + obj.pieces + "pieces");
            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            return true;
        } else {
            System.out.println("Out Of stock         :");
            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            return false;
        }
    }

    static boolean takeOut(String id, double units) {
        Products obj = searchFromStock(id);
        if (obj.pieces >= units) {
            obj.pieces -= units;
            return true;
        } else {
            return false;
        }
    }

    private static ObjectInputStream read;
    private static ObjectOutputStream add;
// to write on file

    public static void WriteFile() throws IOException {
        try {
            add = new ObjectOutputStream(new FileOutputStream("Stock.hex"));
            for (int i = 0; i < pStock.size(); i++) {
                add.writeObject(pStock.get(i));
            }
            add.flush();
            add.close();
        } catch (IOException ex) {
            System.out.println("<-=-=-=- Erorr In Filing -=-=-=->");
        }
    }
// to read from the file

    static void ReadFile() throws FileNotFoundException, IOException, ClassNotFoundException, EOFException {
        Products temp = null;
        try {
            read = new ObjectInputStream(new FileInputStream("Stock.hex"));
            while (true) {
                temp = (Products) read.readObject();
                pStock.add(temp);
            }
        } catch (EOFException ex) { //This exception will be caught when EOF is reached
            System.out.print("");
        } catch (ClassNotFoundException | IOException ex) {
        }
    }
}
