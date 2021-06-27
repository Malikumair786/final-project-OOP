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
class login implements LoginInterface {

    static boolean Login() {
        boolean bool = true;
        String user_name, password;
        int attempts = 0;
        System.out.println("<-=-=-=- Logging -=-=-=->");
            System.out.print("Login Id    :    ");
            user_name = StringInt.stringLine();
            System.out.print("Password    :    ");
            password = StringInt.stringLine();
            bool = user_data_base.exist(password, user_name);
            if(!bool){
                System.out.println("<-=-=-=- Invalid User Name OR Password -=-=-=->");
                System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            }
        return bool;
    }

    static void resetPassword(Admin admin) {
        String pass1, pass2;
        System.out.print("LOGIN ID       :    ");
        String loginId = StringInt.stringLine();
        admin.setLogin_id(loginId);
        do {
            System.out.print("New Password    :    ");
            pass1 = StringInt.stringLine();
            System.out.print("Retype Password :    ");
            pass2 = StringInt.stringLine();

            if (!pass1.equals(pass2)) {
                System.out.println("<-=-=-=- Password misMatch ReType -=-=-=->");
                System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            }
        } while (!pass1.equals(pass2));
        admin.setPassword(pass2);
        System.out.println("<-=-=-=- SUCCESSFULY RESETED -=-=-=->");
        System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
    }

    static void forgetPassword() {
        String user_name;
        String chose = "1";
        System.out.println("        RESETING PASSWORD ");
        System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
        while (chose.equals("1")) {
            System.out.print("Best Friend Name   : ");
            user_name = StringInt.stringLine();
            Admin admin = user_data_base.exist(user_name);

            if (admin != null) {
                resetPassword(admin);
                return;
            } else {
                System.out.println("   <-- Invalid Information -->");
                System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                System.out.print("1 :    Try Again   \n0 :    Go Back To Main Menu       ?    ");
                chose = StringInt.string();
                System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
            }
        }
    }
}
