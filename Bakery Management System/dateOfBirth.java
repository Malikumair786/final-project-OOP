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
class dateOfBirth implements Serializable{
    private int month,day,year;
    
    public dateOfBirth (int theDay, int theMonth, int theYear ){
        month=checkmonth(theMonth);
        day=checkday(theDay);
        year=theYear;
    }
    private int checkmonth (int testMonth){
        if (testMonth > 0 && testMonth<=12) return testMonth;
        else{
            System.out.println("<-=-=-=- Invalid month -=-=-=->\n" + testMonth + " set to 1");
            return 1;
        }
    }
    private int checkday(int testDay){
        int daysofmonth[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
        if (testDay > 0 && testDay <= daysofmonth[month]){
            return testDay;
        }
        else{
            if (month==2 && testDay==29 && (year%400==0 || (year%4==0 && year%100!=0))) return testDay;
            else{
                System.out.println("Invalid date "+ testDay + " set to 1");
                return 1;
            }
        }
    }
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    @Override
    public String toString(){
        return day +" "+ month+" " + year;
    }
    
}
