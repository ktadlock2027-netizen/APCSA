/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sorting;

/**
 *
 * @author ktadlock2027
 */
public class Sorting {

    public static void main(String[] args) {
         Contact[] friends = new Contact[9];
        friends[0] = new Contact("John", "Smith", "610-555-7384");
        friends[1] = new Contact("Sarah", "Barnes", "215-555-3827");
        friends[2] = new Contact("Aaron", "Riley", "733-555-2969");
        friends[3] = new Contact("Laura", "Ramone", "663-555-3984");
        friends[4] = new Contact("Larry", "Smith", "464-555-3489");
        friends[5] = new Contact("Frank", "Phelps", "322-555-2284");
        friends[6] = new Contact("Mario", "Guzman", "804-555-9066");
        friends[7] = new Contact("Marsha", "Grant", "464-555-3489");
        friends[8] = new Contact("Joey", "Grant", "464-555-3489");
        //calling the sort on the array, which implements Comparable
        
        Sort.selectionSort(friends);
        System.out.println("*** Selection Sort ***");
        for (Contact friend : friends)
            System.out.println(friend);
    }
}

class Sort{ 
    public static void selectionSort(Comparable[] list) {
        int min;
        Comparable temp;
        for (int index = 0; index < list.length-1; index++) {
            min = index;
            for (int scan = index+1; scan < list.length; scan++)
                if (list[scan].compareTo(list[min]) < 0){
                    min = scan;
                }
            // Swap the values
            temp = list[min];
            list[min] = list[index];
            list[index] = temp;
        }
    }
/**
* @param args the command line arguments
*/
}
class Contact implements Comparable
{
    private String firstName, lastName, phone;
    // Constructor: Sets up this contact with the specified data.
    public Contact(String first, String last, String telephone)
    {
        firstName = first;
        lastName = last;
        phone = telephone;
    }
    // Returns a description of this contact as a string.
    public String toString()
    {
        return lastName + ", " + firstName + "\t" + phone;
    }
    // Returns a description of this contact as a string.
    public boolean equals(Object other) {
        return (lastName.equals(((Contact)other).getLastName()) &&
        firstName.equals(((Contact)other).getFirstName()));
    }
    // Uses both last and first names to determine ordering.
    public int compareTo(Object other) {
        int result;
        String otherFirst = ((Contact)other).getFirstName();
        String otherLast = ((Contact)other).getLastName();
        //if (lastName.equals(otherLast))
        //    result = firstName.compareTo(otherFirst);
        //else
        //    result = lastName.compareTo(otherLast);
        String otherPhone = ((Contact)other).getNumber(); 
        if (phone.equals(otherPhone) && lastName.equals(otherLast)) {
            result = firstName.compareTo(otherFirst); //if they have the same number and first name, it sorts by first name
        } else if (phone.equals(otherPhone)) { //if they have the same last name, it sorts by phone
            result = lastName.compareTo(otherLast);
        } else {
            result = phone.compareTo(otherPhone); //if they have nothing in common/frst name only then it only sorts by phone
        }
        return result;
    }
    // First name accessor.
    public String getFirstName() {
        return firstName;
    }
    // Last name accessor.
    public String getLastName() {
        return lastName;
    }
    public String getNumber() {
        return phone; 
    }
}
