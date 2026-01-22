/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentcourses;

/**
 *
 * @author ktadlock2027
 */
public class StudentCourses {

    public static void main(String[] args) {
        Student st1 = new Student("Kathleen", "Tadlock"); 
        System.out.println(st1);
        Student st2 = new Student("Mikayla", "Novotny"); 
        System.out.println(st2); //add as many students as you want! the scores are hard-coded so they will all come out the same
    }
}
class Student {
    private String firstName, lastName; 
    Course c1 = new Course(); 
    int s1 = c1.setScore(87); 
    
    Course c2 = new Course(); 
    int s2 = c2.setScore(92); 
    
    Course c3 = new Course(); 
    int s3 = c3.setScore(77); 
    
    int average = (s1 + s2 + s3)/3; //the average score, truncated into a whole number for simplicity
    
    public Student(String first, String last) {
        firstName = first; 
        lastName = last; 
    }
    public String toString(){
        String result; 
        result = firstName + " " + lastName + "\n"
            + "The score on test #1 is: " + s1 + "\n"
            + "The score on test #2 is: " + s2 + "\n"
            + "The score on test #3 is: " + s3 + "\n"
            + "The average of the scores is " + average;
        return result; 
    }
    
    //need a get average method
    
}
class Course {
    public int score; //starts score @ zero
    
    public int setScore(int inScore){
    score = inScore;
    return score;
    }
    public int getScore(){
    return score;
    }
    //public String toString(){
      //  String courseResult; 
        //courseResult = "The score on the test is: " + score;
        //return courseResult; 
    //}
}
