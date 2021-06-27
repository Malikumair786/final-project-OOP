/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BakeryManagement;


/**
 *
 * @author group project
 */
public class registration {

    public static void registrationBoard() {
        
        String chose ;
        System.out.print("1 :\t REGISTER NEW USER\n2 :\t SEARCH FOR USER RECORDS"
                + "\n0 :\t GO BACK TO MAIN MANU    ? ");
        chose = StringInt.string();
        System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
        while (!chose.equals("0")) {
            switch (chose) {
                case "1":
                    System.out.println("<-=-=-=- REGISTRATION FORM -=-=-=->");
                    RegisterNewUser();
                    break;

                case "2": {
                    System.out.println("<-=-=-=- SEARCHING USER RECORD -=-=-=->");
                    System.out.print("CNIC :    ?  ");
                    String id = StringInt.stringLine();
                    Admin admin = user_data_base.Search(id);
                    if (admin != null) {
                        admin.Display();
                    } else {
                        System.out.println("<-=-=-=- NO RECORD FOUND -=-=-=->");
                        System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                    }
                    break;
                }

                default:
                    System.out.println("\t<-=-=-=- INVALID CHOICE -=-=-=->");
                    break;
            }
            System.out.print("1 :\t REGISTER NEW USER\n2 :\t SEARCH FOR USER RECORD"
                    + "\n0 :\t GO BACK TO MAIN MANU    ? ");
            chose = StringInt.string();
            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
        }
    }

    public static void RegisterNewUser() {
        new Registration_Form().setVisible(true);
/*
        String chose = null;
        boolean bool = true;
        System.out.print("Name               :    ");
        String name = StringInt.stringLine();
        System.out.print("Phone Number       :    ");
        String phone_number = StringInt.stringLine();
        System.out.print("CNIC Number        :    ");
        String user_id = StringInt.stringLine();
        System.out.print("Address            :    ");
        String Address = StringInt.stringLine();
        dateOfBirth dob = null;
        System.out.print("Date Of Birth     \n");
        System.out.print("Day                :    ");
        int day = StringInt.integer();
        System.out.print("Month              :    ");
        int month = StringInt.integer();
        System.out.print("Year               :    ");
        int year = StringInt.integer();
        dob = new dateOfBirth(day, month, year);
        System.out.print("LogIn ID           :    ");
        String loginId = StringInt.string();
        System.out.print("Password           :    ");
        String password = StringInt.string();
        System.out.print("Password Reset Key :    ");
        String resetKey = StringInt.string();
        Admin newAdmin = new Admin(name, dob, phone_number, Address, user_id, loginId, password, resetKey);
        user_data_base udb = new user_data_base(newAdmin);
        */
        //new Admin
    }

}
