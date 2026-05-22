/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oregontrail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; 
import javax.sound.sampled.*;
import java.io.File;
import java.util.*;

//import java.util.ArrayList; 
//import java.util.Collections; 

/**
 *
 * @author ktadlock2027
 */
public class OregonTrail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ESTABLISH EACH CHARACTER 
        //each character has the same  base qualities; they have individual interfaces that add to certain characteristics
        Banker banker1 = new Banker(6, 100, 2, 100); 
        Carpenter carpenter1 = new Carpenter(6, 100, 2, 100); 
        Farmer farmer1 = new Farmer(6, 100, 2, 100); 
        //INTRODUCTON TEXT FILE -------------------------------------------------------------------------
        String filePath = "Contacts/contacts.txt";
        String outPath = "Introduction/introduction.txt"; //outpath determines where the file reads from
        // Read from file
        try (BufferedReader reader = new BufferedReader(new FileReader(outPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
            System.out.println(line);
            }
        } catch (IOException e) {
        System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
        //SELECT CHARACTER ------------------------------------------------------------------------------
        Scanner scan = new Scanner(System.in); 
        System.out.println("\n" + "Before you begin, select which character you would like to be." + "\n" +
                "Type 'b' for banker, 'c' for carpenter, and 'f' for farmer."); 
        String character; 
        String characterPath; //shows the program which character file to read from
        //loop it so that a user has to enter one of the specific keys
        while (true){
            character = scan.next(); //reads to a different text file for each character
            if (character.equals("b")) {
                characterPath = "Introduction/banker.txt"; 
                System.out.println(banker1);
                break; 
            } else if (character.equals("c")) {
                characterPath = "Introduction/carpenter.txt"; 
                System.out.println(carpenter1);
                break; 
            } else if (character.equals("f")) { 
                characterPath = "Introduction/farmer.txt"; 
                System.out.println(farmer1);
                break; 
            } else {
               System.out.println("Wrong key entered. Please select one of the options."); 
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(characterPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
            System.out.println(line);
            }
        } catch (IOException e) {
        System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
        //BEGIN THE TRAIL -----------------------------------------------------------------------------
        System.out.println("\n" + "You are now ready to begin the trail!" + "\n" +
                "In which month would you like to depart?" + "\n" +
                "Type 'a' for April, 'm' for May, and 'j' for June.");
        String month; 
        String monthPath; //shows the program which month file to read from
        while (true) { //same loop and same file path system as before
            month = scan.next(); 
            if (month.equals("a")){ 
                monthPath = "TrailStart/april.txt"; 
                break; 
            } else if (month.equals("m")) {
                monthPath = "TrailStart/may.txt";
                break; 
            } else if (month.equals("j")) {
                monthPath = "TrailStart/june.txt";
                break; 
            } else {
                System.out.println("Wrong key entered. Please select one of the options.");
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(monthPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
            System.out.println(line);
            }
        } catch (IOException e) {
        System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
        if (month.equals("a")){ 
            String aprilChoice; 
            aprilChoice = scan.next(); 
            if (aprilChoice.equals("a")) {
                System.out.println("You were successfully pulled out of the mud and can continue on to the Kansas River Crossing.");
            } else if (aprilChoice.equals("b")) {
                System.out.println("You managed to get your wagon out, but broke one of the wheels in the process." + "\n" 
                + "Continue on to the Kansas River Crossing.");
                if (character.equals("c")) {
                    System.out.println("You are a carpenter, so you're able to fix the wagon.");
                } 
            }
        }
        if (month.equals("j")) {
            String juneChoice; 
            juneChoice = scan.next(); 
            if (juneChoice.equals("a")) {
                System.out.println("Continue on the trail to the Kansas River Crossing.");
            } else {
                System.out.println("You chose to wait until next year. GAME OVER.");
                System.exit(0);//game terminates if you wait until next year
            }
        }
        //KANSAS RIVER CROSSING ---------------------------------------------------------------------
        System.out.println();
        SoundClass sound1 = new SoundClass();
        sound1.filePath = "Kansas River Crossing/rippling-water-1.wav";
        sound1.createTimeForSound();
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }        
        SoundClass.clip.stop();
        try (BufferedReader reader = new BufferedReader(new FileReader("Kansas River Crossing/kansasRiverWelcome.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
            System.out.println(line);
            }
        } catch (IOException e) {
        System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
        String choiceKansas; 
        String kansasPath; 
        while (true) {
            choiceKansas = scan.next(); 
            if (choiceKansas.equals("a")) {
                kansasPath = "Kansas River Crossing/ferry.txt"; 
                break; 
            } else if (choiceKansas.equals("b")) {
                kansasPath = "Kansas River Crossing/ford.txt"; 
                break; 
            } else if (choiceKansas.equals("c")) {
                kansasPath = "Kansas River Crossing/wait.txt"; 
                break; 
            } else {
                System.out.println("Wrong key entered. Please select one of the options.");
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(kansasPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
            System.out.println(line);
            }
        } catch (IOException e) {
        System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
        if (choiceKansas.equals("b")) {
                String choiceFerry; 
                choiceFerry = scan.next(); 
                if (choiceFerry.equals("a")) {
                    System.out.println("You chose to ford straight across. The current is too strong!" +
                            "\n" + "Your wagon sinks and your party drowns. GAME OVER.");
                    System.exit(0); 
                } else if (choiceFerry.equals("b")) {
                    System.out.println("You chose to ford the river diagonally. Wise choice!" + "\n" + 
                            "You crossed the river safely and with little issue. Continue on the trail.");
                }
            }
        //END KANSAS RIVER PORTION -------------------------------------------------------------------------
        //BEGIN TREK TO CHIMNEY ROCK AND WYOMING -----------------------------------------------------------
        System.out.println();
        sound1.filePath = "RoadToWyoming/wagonSound.wav";
        sound1.createTimeForSound();
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }        
        SoundClass.clip.stop();        try (BufferedReader reader = new BufferedReader(new FileReader("RoadToWyoming/intro.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
            System.out.println(line);
            }
        } catch (IOException e) {
        System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
        String choicePace; 
        String pacePath; 
        while (true) {
            choicePace = scan.next();  
            if (choicePace.equals("a")) {
                pacePath = "RoadToWyoming/fast.txt"; 
                break; 
            } else if (choicePace.equals("b")) {
                pacePath = "RoadToWyoming/rest.txt"; 
                break; 
            } else {
                System.out.println("Wrong key entered. Please select one of the options.");
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(pacePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
            System.out.println(line);
            }
        } catch (IOException e) {
        System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
        String choiceFast;
        String choiceOx; 
        if (choicePace.equals("a")) { //this was the choice to take fast pace
            choiceFast = scan.next(); 
            if (choiceFast.equals("a")) { //chose to buy new ox
                System.out.println("You just barely made it to Fort Laramie, and you were able to buy an ox. Continue.");
            } else if (choiceFast.equals("b")) { //chose to go without
                System.out.println("The load is too much for the oxen. Do you: " + "\n"
                + "a. Offload spare parts. You don't need to take everything." + "\n" 
                + "b. Push onwards. You can't leave anything behind.");
                choiceOx = scan.next();
                if (choiceOx.equals("a")) { //offload spare parts
                    System.out.println("Wise choice. The oxen are able to continue and you make it to Fort Laramie.");
                } else if (choiceOx.equals("b")) { //keep going
                    System.out.println("The load is too much. Another ox dies. You are stranded on the trail." + "\n" 
                    + "GAME OVER");
                    System.exit(0);
                }
            }
        }
        String choiceRest; 
        if (choicePace.equals("b")) { //you chose to take midday breaks
            choiceRest = scan.next(); 
            if (choiceRest.equals("a")) {
                System.out.println("You chose to keep going. Luckily, your party member recovers and you continue on.");
            } else if (choiceRest.equals("b")) { 
                System.out.println("You found a doctor at Fort Laramie, but they say your party member will need weeks to heal." + "\n" 
                + "By the time your party member recovers, it will be winter, and too late to continue the trail." + "\n" 
                + "You are stuck at Fort Laramie. Maybe you can try again next year." + "\n"
                + "GAME OVER.");
                System.exit(0); 
            }
        }
        //END ROAD TO WYOMING AND FORT LARAMIE STRETCH ---------------------------------------------------
        //BEGIN POST-LARAMIE CHOICES
        System.out.println();
        try (BufferedReader reader = new BufferedReader(new FileReader("PostLaramieChoices/intro.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
            System.out.println(line);
            }
        } catch (IOException e) {
        System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
        String shortcutPath; 
        String choiceShortcut; 
        while (true) {
            choiceShortcut = scan.next();
            if (choiceShortcut.equals("a") && month.equals("j")) { //means choices earlier on still have consequence
                shortcutPath = "PostLaramieChoices/shortcutJune.txt"; 
                break; 
            } else if (choiceShortcut.equals("a")) {
                shortcutPath = "PostLaramieChoices/shortcutOther.txt"; 
                break; 
            } else if (choiceShortcut.equals("b")) {
                shortcutPath = "PostLaramieChoices/shortcutNot.txt"; 
                break; 
            } else {
                System.out.println("Wrong key entered. Please select one of the options.");
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(shortcutPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
            System.out.println(line);
            }
        } catch (IOException e) {
        System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
        if (choiceShortcut.equals("a") && month.equals("j")) {
                System.exit(0); 
            }
        //END POST LARAMIE PORTION -----------------------------------------------------------------------
        //BEGIN COLUMBIA RIVER ROUTE ---------------------------------------------------------------------
        System.out.println();
        try (BufferedReader reader = new BufferedReader(new FileReader("ColumbiaRiver/intro.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
            System.out.println(line);
            }
        } catch (IOException e) {
        System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
        String choiceColumbia; 
        choiceColumbia = scan.next(); 
        while (true) {
           if (choiceColumbia.equals("a")) {
               System.out.println("Fording might have worked in the past, but the Columbia is too strong!" + "\n" 
               + "Your wagon sinks and your party drowns." + "\n" 
               + "GAME OVER"); 
               System.exit(0); 
           } else if (choiceColumbia.equals("b")) {
               System.out.println("You made it across the Columbia River! This was the final trial before Oregon." + "\n" 
               + "You are now in Oregon and can begin your new life on the West Coast. Congratulations!" + "\n" 
               + "YOU WIN");
               System.exit(0); 
           } else {
                System.out.println("Wrong key entered. Please select one of the options.");
            }
        }
        //END OF GAME -------------------------------------------------------------------------------------
    }
}

class PlaySound {
    public static void main(String[] args) {
        //create sound object
        SoundClass chaching = new SoundClass();
        //create a time slot for the sound to play
        chaching.createTimeForSound();
    }
}
class SoundClass{
    private static Clip currentClip; 
    public static Clip clip; 
    //a file path same a text files - so inside the project
    //you should find your own wav sound file (millions out there) 
    String filePath; // Replace with your file path; sounds/75235__creek23__cha-ching.wav
    //syntax for playing sounds - do not change this!
    public static void playSound(String filePath) {
        try {
            if (currentClip != null && currentClip.isRunning()) {
                currentClip.stop();
                currentClip.close();
            }
            File soundFile = new File(filePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.setFramePosition(0);
            System.out.println("Playing the sound");
            clip.start();
            // Keep the program running until the sound finishes playing
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                clip.close();
                }
            });
        } 
        catch (UnsupportedAudioFileException | IOException |
        LineUnavailableException e) {
        e.printStackTrace();
        }
    }
    //you must create some time for the sound, or it will be played in 0 seconds
    public void createTimeForSound() {
        TimerTask task = new TimerTask() {
            public void run() {
                playSound(filePath);
            }
        };
    Timer timer = new Timer("Timer");
    //1000 miliseconds, aka 1 second. Your clip may require more time.
    long delay = 1000l;
    timer.schedule(task, delay);
    }
}

class Character { 
    protected int oxen; 
    protected int money; 
    protected int spareParts; 
    protected int food; 
    
    public Character(int oxen1, int money1, int spareParts1, int food1){
        oxen = oxen1;
        money = money1;
        spareParts = spareParts1;
        food = food1;
    }
    //getters and setters
    public int getOxen() {
        return oxen; 
    }
    public int getMoney() {
        return money; 
    }
    public int getSpareParts() {
        return spareParts; 
    }
    public int getFood() {
        return food; 
    }
    public String toString(){
        String result = "";
        result = "Your character has " + getOxen() + " oxen, " + getMoney() + " money, spare parts " + spareParts + ", and " + getFood() + " food.";
            return result;
    }
} 


class Banker extends Character { //these classes alter some of the object characteristics
    public Banker (int oxen1, int money1, int spareParts1, int food1) {
        super (oxen1, money1, spareParts1, food1); 
    }
    public String toString() { 
        String result = super.toString(); 
        return result; 
    }
    @Override
    public int getMoney() {
            return super.getMoney() + 20; //adds extra money to the banker 
    }
}
class Carpenter extends Character { 
    public Carpenter (int oxen1, int money1, int spareParts1, int food1) {
        super (oxen1, money1, spareParts1, food1); 
    }
    public String toString() { 
        String result = super.toString(); 
        return result; 
    }
    @Override
    public int getSpareParts() {
            return super.getSpareParts() + 4; //adds spare parts for the carpenter
    }
}
class Farmer extends Character { 
    public Farmer (int oxen1, int money1, int spareParts1, int food1) {
        super (oxen1, money1, spareParts1, food1); 
    }
    public String toString() { 
        String result = super.toString(); 
        return result; 
    }
    @Override
    public int getOxen() {
            return super.getOxen() + 2; //adds extra oxen to the character 
    }
    @Override
    public int getFood() {
            return super.getFood() + 50; //adds extra oxen to the character 
    }
}