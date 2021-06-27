/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BakeryManagement;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author group project
 */
public class user_data_base {

    private static ArrayList<Admin> All_User = new ArrayList();

    user_data_base(){
        
    }
    
    user_data_base(Admin admin){
        if(!Exist(admin.user_id)){
        All_User.add(admin);
        }else{
            System.out.println("<-=-=-=- USER ALREADY EXIST -=-=-=->");
        }
    }
    
    private boolean Exist(String cnic){
        Admin temp;
        int i=0;
        while(i<All_User.size()){
            temp=(Admin)All_User.get(i);
            if(temp.user_id.equals(cnic)) {
                return true;
            }
            i++;
        }
        return false;
    }
    
    static boolean exist(String password, String loginId) {
        Admin temp;
        int i=0;
        while(i<All_User.size()){
            temp=(Admin)All_User.get(i);
            if(temp.getLogin_id().equals(loginId) && temp.getPassword().equals(password)) {
                return true;
            }
            i++;
        }
        return false;
    }

    static Admin exist(String friend) {
        Admin temp;
        int i=0;
        while(i<All_User.size()){
            temp=(Admin)All_User.get(i);
            if(temp.getPasswordResetKey().equals(friend)) return temp;
            i++;
        }
        return null;
    }
    
    static Admin Search(String id){
        Admin temp;
        int i=0;
        while(i<All_User.size()){
            temp=(Admin)All_User.get(i);
            if(temp.user_id.equals(id)) return temp;
            i++;
        }
        return null;
        
    }
    
    
    private static ObjectInputStream read;
    private static ObjectOutputStream add;
// to write on file
    public static void WriteFile() throws IOException {
        try {
            add = new ObjectOutputStream(new FileOutputStream("Users.hex"));
            for (int i = 0; i < All_User.size(); i++) {
                add.writeObject((Admin)All_User.get(i));
            }
            add.flush();
            add.close();
        } catch (IOException e) {
        }
    }
// to read from the file
    static void ReadFile() throws FileNotFoundException, IOException, ClassNotFoundException, EOFException {
        Admin temp ;
        try {
            read = new ObjectInputStream(new FileInputStream("Users.hex"));
            while (true) {
                temp = (Admin) read.readObject();
//                System.out.println(temp.getPhoneNumber());
                All_User.add(temp);
            }
        } catch (EOFException ex) { //This exception will be caught when EOF is reached
            System.out.print("");
        } catch (ClassNotFoundException | IOException ex) {
        } 
    }
}
