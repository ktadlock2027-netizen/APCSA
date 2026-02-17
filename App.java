/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.darrays;

import java.util.Random; 
import java.util.*; 

/**
 *
 * @author ktadlock2027
 */
public class App {
    public static void main(String[] args) {
        
        //"Fill the 4 arrays with the 4 suits of playing cards, from Ace to King (1 to 13)." 
        //We have 4 arrays of all the suits
        
        ArrayList<String> deckList = new ArrayList(); //creates new ArrayList
        
        String[][] deckOfCards = {
            {"Ace of Hearts", "Two of Hearts", "Three of Hearts", "Four of Hearts", "Five of Hearts", "Six of Hearts", "Seven of Hearts", "Eight of Hearts", "Nine of Hearts", "Ten of Hearts", "Jack of Hearts", "Queen of Hearts", "King of Hearts"},
            {"Ace of Spades", "Two of Spades", "Three of Spades", "Four of Spades", "Five of Spades", "Six of Spades", "Seven of Spades", "Eight of Spades", "Nine of Spades", "Ten of Spades", "Jack of Spades", "Queen of Spades", "King of Spades"},
            {"Ace of Diamonds", "Two of Diamonds", "Three of Diamonds", "Four of Diamonds", "Five of Diamonds", "Six of Diamonds", "Seven of Diamonds", "Eight of Diamonds", "Nine of Diamonds", "Ten of Diamonds", "Jack of Diamonds", "Queen of Diamonds", "King of Diamonds"},
            {"Ace of Clubs", "Two of Clubs", "Three of Clubs", "Four of Clubs", "Five of Clubs", "Six of Clubs", "Seven of Clubs", "Eight of Clubs", "Nine of Clubs", "Ten of Clubs", "Jack of Clubs", "Queen of Clubs", "King of Clubs"},
            }; 
        
        Random generator = new Random(); 
        
        for(int i = 0; i < deckOfCards.length; i++){
            for (int j = 0; j < deckOfCards[i].length; j++){
                deckList.add(deckOfCards[i][j]); //turns the 2D array into an ArrayList
            }
        }
        
        //AHA moment: it's like coordinates! the first index corresponds to which array, the second index corresponds to which string in the array
        
        System.out.println("Deck size: " + deckList.size());
        System.out.println(); //just adding these for a new line so that it prints nicer
                
        System.out.println("The first hand is: ");
        while (deckList.size() > 47) {
            int card = generator.nextInt(deckList.size());
            System.out.println(deckList.get(card));
            deckList.remove(card);
        }
        System.out.println("New deck size: " + deckList.size());
        System.out.println();
        
        System.out.println("The second hand is: ");
        while (deckList.size() > 42) {
            int card = generator.nextInt(deckList.size());
            System.out.println(deckList.get(card));
            deckList.remove(card);
        }
        System.out.println("New deck size: " + deckList.size());
        System.out.println();
        
        System.out.println("The third hand is: ");
        while (deckList.size() > 37) {
            int card = generator.nextInt(deckList.size());
            System.out.println(deckList.get(card));
            deckList.remove(card);
        }
        System.out.println("New deck size: " + deckList.size());
        System.out.println();
        
        System.out.println("The fourth hand is: ");
        while (deckList.size() > 32) {
            int card = generator.nextInt(deckList.size());
            System.out.println(deckList.get(card));
            deckList.remove(card);
        }
    }
}