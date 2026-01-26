/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.radiuscalc;

import java.util.Scanner;

/**
 *
 * @author ktadlock2027
 */

//carry out calculations or circular items
//such as a circle, a sphere, a cone, a column
public class RadiusCalc {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("This program calculates round item numbers such as \n" +
                "1 - Area of a circle (pi r^2)\n" + //area of circle first
                "2 - Volume of a sphere (4/3 pi r^3)\n" + //then volume of a sphere
                "3 - Volume of a cone (pi r^2 h/3)\n" + //then volume of a cone
                "4 - Volume of a cylinder (pi r^2 h)"); //volume of a cylinder (b*h)
        System.out.println("Type the number for which one you want to calculate."); //user picks what thet want to be calculated. 
        int i = s.nextInt();
        if (i == 1){
            cCalc(); //area of circle
        }else if (i == 2){
            sCalc(); //sphere
        }else if(i == 3){
            cCalc2(); //cone
        }else if(i == 4){
            cCalc3(); //cylinder
        }
    }
    
    //the first thing I did was add a scanner to every method, so that the variables make sense and the program can run. 
    //the following four methods were rearranged to match the above order. 
    
    public static void cCalc(){ //circle is ordered first; RUNS PROPERLY
        System.out.println("enter the radius of your circle");
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        double result = Math.PI * Math.pow(r, 2); //pi*r^2 is the correct formula for area of a circle (pi*r^2) 
        System.out.println(result);
    }
    
    public static void sCalc(){ //sphere is ordered second; RUNS PROPERLY
        System.out.println("enter the radius of your sphere"); 
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        double result = ((Math.PI * Math.pow(r, 3) * 4)/3); //this is the correct formula for a sphere (4/3*pi*r^3); edited so that the program reads it in the proper order
        System.out.println(result); //I changed it from printing r, the radius, to the result. 
    }
    
    public static void cCalc2(){ //cone is ordered third; RUNS PROPERLY
        System.out.println("enter the radius of your cone, then height of your cone");
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int h = s.nextInt();
        double result = Math.PI * Math.pow(r, 2) * h/3; //volume of cone formula, fixed (pi*r^2*h/3)
        System.out.println(result); //I changed it from printing r, the radius, to the result. 
    }
    
    public static void cCalc3(){ //cylinder i ordered fourth; RUNS PROPERLY
        System.out.println("enter the radius of your cylinder, then height of your cylinder");
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int h = s.nextInt();
        double result = Math.PI * Math.pow(r, 2) * h; //volume for cylinder, fixed (pi*r^2*h)
        System.out.println(result);
    }
}