/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package furtherprocessantfiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; 
import java.util.ArrayList; 
import java.util.Collections; 

/**
 *
 * @author ktadlock2027
 */
public class FurtherProcessAntFiles {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean keepGoing = true; 
        
        Scanner scan = new Scanner(System.in); 
        
        ArrayList <Contact> list = new ArrayList(); 
        ArrayList <Contact> newContacts = new ArrayList(); 
        
        String filePath = "Contacts/contacts.txt";
            String outPath = "Contacts/contacts.txt";
            String contentToWrite = list.toString(); 
            
            // Read from file
            try (BufferedReader reader = new BufferedReader(new FileReader(outPath))) {
                String line;
                System.out.println("\nReading from the file:");
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(", ");
                    if (parts.length == 3) {
                        Contact c = new Contact(parts[0], parts[1], parts[2]);
                        list.add(c);
                        System.out.println(c);
                    }
                }
            } catch (IOException e) {
            System.err.println("An error occurred while reading from the file: " + e.getMessage());
            }
        
            
        String name;
        String year; 
        String email; 
        String input; 
        
        while (keepGoing == true) {
            System.out.println("To add contact details, please type a." + "\n" 
                    + "To begin sorting contacts, type any other letter.");
                    input = scan.next();
                    
            while (input.equals("a")){  //while loop inside the while loop
                System.out.println("Please enter the contact's name.");
                name = scan.next();
                System.out.println("Please enter the contact's graduation year.");
                year = scan.next();
                System.out.println("Please enter the contact's email.");
                email = scan.next();

                Contact test = new Contact(name, year, email); 
                    if (!list.contains(test)) {
                        list.add(test);
                        newContacts.add(test);
                    } else {
                        System.out.println("Duplicate contact — not added.");
                    }
                System.out.println(test);     
                System.out.println("Type 'a' to continue, type 'stop' stop.");
                input = scan.next();
                System.out.println("All contacts: ");

                for (Contact fullList : list) {
                System.out.println(fullList); 
                }
            }
            //ask how to sort
            System.out.println("To sort by name, type 'n'." + "\n" +
                    "To sort by graduation year, type 'y'." + "\n" +
                    "\t" + "If the graduation years are the same, the contacts will be sorted by name." + "\n" +
                    "To sort by email, type 'e'.");
            String sortInput = scan.next(); 
            //---SORTER---
            if (sortInput.equals("n")) {
                Collections.sort(list, (a, b) -> a.getName().compareTo(b.getName())); 
            } else if (sortInput.equals("y")) { //if years are the same, will default to names
               Collections.sort(list, (a, b) -> {
                int result = a.getYear().compareTo(b.getYear());
                if (result == 0) {
                    return a.getName().compareTo(b.getName());
                }
                return result;
            });
            } else if (sortInput.equals("e")) {
                Collections.sort(list, (a, b) -> a.getEmail().compareTo(b.getEmail())); 
            }
            System.out.println("Sorted list: " + "\n" + list);    
            
            //ASK TO REPEAT
            System.out.println("Would you like to add more to the list? Type 'yes' or 'no'.");
            String again;
            again = scan.next();
            if (!again.equalsIgnoreCase("yes")) {
            keepGoing = false;
            }
            
        }
        //ADDS NEW ENTRIES TO THE TEX FILE
            // Write to file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                //writer.write(contentToWrite);
                //writer.append(contentToWrite + "\n");
                for (Contact c : newContacts) {
                    writer.append(c.toString());
                    writer.newLine();
                }
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
            }    } 
}
class Contact { //implements Comparable<Contact> //use this to make objects    
    String name; 
    String year; 
    String email;
    public Contact(String name, String year, String email) {
        this.name = name;
        this.year = year;
        this.email = email;
    }
    public String toString() {
        String result; 
        result = name + ", " + year + ", " + email; //add new line character? 
        return result; 
    }
    public String getName() { //priority is from 1-anything
        return name; 
    }
    public String getYear() {
        return year; 
    }
    public String getEmail() { //complexity is scaled 1-10
        return email; 
    }
}