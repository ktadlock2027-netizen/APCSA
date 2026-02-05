/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.weekdays;

import java.util.Arrays; 

/**
 *
 * @author ktadlock2027
 */
public class WeekDays {

    public static void main(String[] args) {
        String[] weekDays = {"\nMonday", "\nTuesday", "\nWednesday", "\nThursday", "\nFriday", "\nSaturday", "\nSunday"};
        System.out.println("The whole seven day week: " + Arrays.toString(weekDays));

        //now need to remove items from the list
        String valueToRemove1 = "\nSunday"; //remove Sunday; need to make sure to include \n
        String valueToRemove2 = "\nSaturday"; //remove Saturday
        int count = 0; 
        for (String s : weekDays) { //identifies code with weekDays
            if (s.equals(valueToRemove1) || s.equals(valueToRemove2)) { //removes valueToRemove1 and 2
                count++; 
            }
        }
        String[] weekDaysNew = new String[weekDays.length - count]; 
        for (int i = 0, j = 0; i < weekDays.length; i++){
            if (!weekDays[i].equals(valueToRemove1) && !weekDays[i].equals(valueToRemove2)){ //removes valueToRemove 1 and 2
                weekDaysNew[j++] = weekDays[i]; 
            }
        }
        
        System.out.println(Arrays.toString(weekDaysNew));
    }
}