/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.todolist;

import java.util.ArrayList;
import java.util.Collections; 
import java.util.List; 

/**
 *
 * @author ktadlock2027
 */
public class ToDoList {

    public static void main(String[] args) {
        //create random list
        List<Task> toDo = new ArrayList<>(); //creates a list
        toDo.add(new Task(6, "Empty the Dishwasher", 1));
        toDo.add(new Task(4, "Fold Laundry", 8)); 
        toDo.add(new Task(2, "Do Homework", 10));
        toDo.add(new Task(5, "Clean Bedroom", 9));
        toDo.add(new Task(3, "Clean the Kitchen", 7));
        toDo.add(new Task(3, "Work Out", 2));
        toDo.add(new Task(1, "Coffee", 3));
        
        System.out.println("Before sorting: " + toDo);
        Collections.sort(toDo); //sorts the items
        System.out.println("After sorting: " + toDo);
    }
}

class Task implements Comparable<Task> {
    //create variables
    private int priority; 
    private String name; 
    private int complexity; 
    
    public Task (int priority, String name, int complexity){
        this.priority = priority; 
        this.name = name; 
        this.complexity = complexity; 
    }
    //getters
    public int getPriority() { //priority is from 1-anything
        return priority; 
    }
    public String getName() {
        return name; 
    }
    public int getComplexity() { //complexity is scaled 1-10
        return complexity; 
    }
    
    @Override
    public int compareTo(Task otherTask) {
    //if statement for complexity vs priority -- everything needs to be within compareTo
        if (this.priority != otherTask.getPriority()) { //for when priorities are not equal. 
            return Integer.compare(this.priority, otherTask.getPriority());
        } else {
            return Integer.compare(this.complexity, otherTask.getComplexity()); 
        }
    }
    @Override 
    public String toString() {
        return name + " (" + priority + ")"; 
    }
}