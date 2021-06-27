package BakeryManagement;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order implements Serializable{

    private String customer_name, date;
    long total_bill;
    private static long number = 0;
    long order_number;
    private ArrayList<Products> cart = new ArrayList();

    Order() {
        this.date = LocalDate.now().toString();
        order_number= ++number;
    }

    Order(String customer_name) {
        this.customer_name = customer_name;
        this.date = LocalDate.now().toString();
        order_number=++number;
    }

    public void removeFromCart(String title, long units) {
        int i = 0;
        Products obj = null;
        while (i < cart.size()) {
            obj = (Products) cart.get(i);
            if (obj.title.equals(title)) {
                if (obj.pieces == units) {
                    total_bill-=(obj.unit_price*units);
                    cart.remove(obj);
                    return;
                } else {
                    obj.pieces -= units;
                    total_bill-=(obj.unit_price*units);
                    return;
                }
            } else {
                i++;
            }
        }
    }

    public void addToCart(String title, long units) {
        Products obj = Stock.SearchFromStock(title);
        if(obj!=null){
        Products temp = new Products(obj);
        if (Stock.takeOut(temp.id, units)) {
            temp.pieces = units;
            getCart().add(temp);
            this.total_bill = this.total_bill + (temp.unit_price * units);
        } else {
            System.out.println("<-=-=-=- Out Of Stock. NExt. -=-=-=->");
            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
        }
        }else{
            System.out.println("<-=-=-=- Sorry We Dont Have The Item -=-=-=->");
        }

    }

    public void GenerateBill() {
        System.out.println("\t\t<-=-=-=- BILL -=-=-=->\n");
        System.out.println("\tOrder Number      :    " + order_number);
        System.out.println("\tCustomer Name     :    " + this.customer_name);
        System.out.println("\tDate              :    " + this.date);
        System.out.println("\t           Items Are       ");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println("\tTitle   : " + cart.get(i).title + "\t :   "
                    + "RS."+(cart.get(i).pieces * cart.get(i).unit_price));
        }
        System.out.println("\tTotal             :    " + "RS."+this.total_bill);
     //   System.out.println("\t\tCash Received     :    " + amount_received);
     //   System.out.println("\t\tChange            :    "
     //           + (amount_received - total_bill));
     //   if ((amount_received - total_bill) < 0) {
     //       System.out.println("\t\tYou Have to Pay " + (amount_received - total_bill) + " more \n"
     //               + "<-=-=-=- Thank You For Shopping -=-=-=->");
     //   } else {
        System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
    }

    /**
     * @return the customer_name
     */
    public String getCustomer_name() {
        return customer_name;
    }

    /**
     * @param customer_name the customer_name to set
     */
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the order_number
     */
    public long getOrder_number() {
        return order_number;
    }

    /**
     * @param aOrder_number the order_number to set
     */
    public void setOrder_number(long aOrder_number) {
        order_number = aOrder_number;
    }

    /**
     * @return the cart
     */
    public ArrayList<Products> getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(ArrayList<Products> cart) {
        this.cart = cart;
    }

}
