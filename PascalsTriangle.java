/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pascalstriangle;

import java.util.Scanner; 

/**
 *
 * @author ktadlock2027
 */
public class PascalsTriangle {
    public static int pascal(int row, int col) {
        if (col == 0 || col ==  row) {
            return 1; 
        }
        return pascal(row - 1, col - 1) + pascal(row - 1, col); //repeatedly calls
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        System.out.println("Please enter, as an integer, how many rows of Pascal's Triangle you would like to be shown.");
        int rowsNum; 
        rowsNum = scan.nextInt(); 
        System.out.println("You entered: " + rowsNum);

        //need a for loop to add number of rows
        //needs to be in its own class
        for(int i = 0; i < rowsNum; i++){ //loops the rows of numbers without making it infinite! 
            for (int j = 0; j <= i; j++){
                System.out.print(pascal(i, j) + ", "); //do print instead of println so it doesn't go to a new line
            }
            System.out.println();
        }
    }
}