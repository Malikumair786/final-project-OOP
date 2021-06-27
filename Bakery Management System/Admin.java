/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BakeryManagement;

import java.io.Serializable;

/**
 *
 * @author group project
 */
public class Admin extends User implements Serializable {
    
    private String login_id,password,PasswordResetKey;
    
    Admin(){
        
    }
    
    Admin(String name,dateOfBirth date_of_birth,String phone_number,String Address,
            String user_id,String loginId,String password,String PasswordResetKey){
        super(name,date_of_birth,phone_number,Address,user_id);
        this.login_id=loginId;
        this.password=password;
        this.PasswordResetKey=PasswordResetKey;
    }
    
    void Display() {
        System.out.println("    NAME            :    " + this.name);
        System.out.println("    CNIC-ID         :    " + this.user_id);
        System.out.println("    ADDRESS         :    " + this.Address);
        System.out.println("    DATE OF BIRTH   :    " + this.date_of_birth.toString());
        System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
    }
    
    /**
     * @return the login_id
     */
    public String getLogin_id() {
        return login_id;
    }

    /**
     * @param login_id the login_id to set
     */
    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the PasswordResetKey
     */
    public String getPasswordResetKey() {
        return PasswordResetKey;
    }

    /**
     * @param PasswordResetKey the PasswordResetKey to set
     */
    public void setPasswordResetKey(String PasswordResetKey) {
        this.PasswordResetKey = PasswordResetKey;
    }
    
    
}
