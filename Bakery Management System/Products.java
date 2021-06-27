package BakeryManagement;

import java.io.Serializable;




/**
 *
 * @author group project
 */
public class Products implements Serializable{

    String title, id;
    int unit_price;
    long pieces;

    Products() {

    }

    Products(String title, String id, int unit_price, long pieces) {
        this.id = id;
        this.title = title;
        this.unit_price = unit_price;
        this.pieces = pieces;
    }
    
    Products(Products obj){
        this(obj.title,obj.id,obj.unit_price,obj.pieces);
    }

    void addProduct() {
        Stock.addToStock(this);
    }

    void Display() {
        System.out.println("    Product Id        :    " + this.id);
        System.out.println("    Product Title     :    " + this.title);
        System.out.println("    Stock of Pieces   :    " + this.pieces);
        System.out.println("    Unit Price        :    " + this.unit_price);
        System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
    }
}
