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
public class User implements Serializable{

    
    String name,phone_number,Address,user_id;
    dateOfBirth date_of_birth;
    User(){
        
    }
    
    User(String name,dateOfBirth date_of_birth,String phone_number,String Address,String user_id) {
        this.Address=Address;
        this.date_of_birth=date_of_birth;
        this.name=name;
        this.phone_number=phone_number;
        this.user_id=user_id;
    }
    

    

}
