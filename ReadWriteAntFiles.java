/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package readwriteantfiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; 

/**
 *
 * @author ktadlock2027
 */
public class ReadWriteAntFiles {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //public static void main(String[] args) {
        
        //Enter ur info! 
        Scanner scan = new Scanner(System.in); 
        System.out.println("Please enter your name(no spaces) .");
        String name; 
        name = scan.next(); 
        System.out.println("Please enter your email address.");
        String email; 
        email = scan.next(); 
        System.out.println("Please enter your graduation year.");
        int year; 
        year = scan.nextInt(); 
        System.out.println("Please enter your username(no spaces).");
        String username; 
        username = scan.next(); 
        
        
        
            String filePath = "Contacts/contacts.txt";
            String outPath = "Contacts/contacts.txt";
            String contentToWrite = name + ", " + email + ", " + year + ", " + username; 
        // Write to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            //writer.write(contentToWrite);
            writer.append(contentToWrite + "\n");
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
        System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
        // Read from file
        try (BufferedReader reader = new BufferedReader(new FileReader(outPath))) {
            String line;
            System.out.println("\nReading from the file:");
            while ((line = reader.readLine()) != null) {
            System.out.println(line);
            }
        } catch (IOException e) {
        System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
    }
}