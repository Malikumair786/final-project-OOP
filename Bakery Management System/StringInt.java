/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BakeryManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author group project
 */
public class StringInt {
    static String stringLine() {
        boolean flag;
        String password = null;
        Scanner scan = new Scanner(System.in);
        do {
            try {
                flag = false;
                password = scan.nextLine();
            } catch (InputMismatchException e) {
                scan=new Scanner(System.in);
                System.out.println("<-=-=-=- Invalid Syntax Try Again -=-=-=->");
                flag = true;
            }
        } while (flag);
        return password;
    }

    static String string() {
        boolean flag;
        String password = null;
        Scanner scan = new Scanner(System.in);
        do {
            try {
                flag = false;
                password = scan.next();
            } catch (InputMismatchException e) {
                scan=new Scanner(System.in);
                System.out.println("<-=-=-=- Invalid Syntax Try Again < No Spaces String Only > -=-=-=->");
                flag = true;
            }
        } while (flag);
        return password;
    }
    static int integer() {
        boolean flag;
        int i=1;
        Scanner scan = new Scanner(System.in);
        do {
            try {
                flag = false;
                i = scan.nextInt();
            } catch (InputMismatchException e) {
                scan=new Scanner(System.in);
                System.out.println("<-=-=-=- Invalid Input Try Again < Integers Only > -=-=-=->");
                flag = true;
            }
        } while (flag);
        return i;
    }
    
    static long Long() {
        boolean flag;
        long i=1;
        Scanner scan = new Scanner(System.in);
        do {
            try {
                flag = false;
                i = scan.nextLong();
            } catch (InputMismatchException e) {
                scan=new Scanner(System.in);
                System.out.println("<-=-=-=- Invalid Input Try Again < Integers Only > -=-=-=->");
                flag = true;
            }
        } while (flag);
        return i;
    }
}
