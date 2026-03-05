/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vehiclescratch;

/**
 *
 * @author ktadlock2027
 */

//NOTES
//interface cannot be within class
   
public class VehicleScratch {
    public static void main(String[] args) {
        System.out.println("---CARS---");//CARS -- Brand, Speed, Passengers, Cargo, MPG, Color, Year
        Car Mustang = new Car("Ford", 120.0, 4, 1050.8, 16.5, "Dark Green", 1966); 
        System.out.println("\n" + Mustang);
        CinemaCar AstonMartin = new CinemaCar("Aston Martin", 145.0, 4, 350.0, 16.5, "Grey", 1964, "Ejection seat", "James Bond"); 
        System.out.println("\n" + AstonMartin);
        Truck Tacoma = new Truck("Toyota", 90.0, 5, 1367.5, 21.5, "Gray", 2020, 5.0);
        System.out.println("\n" + Tacoma);
        
        System.out.println("\n---BOATS---"); //BOATS -- Brand, Speed, Passengers, Cargo, Hull material, Rudder
        Boat ProStar = new Boat("MasterCraft", 45.0, 8, 1350.0, "Fiberglass", "Stern");
        System.out.println(ProStar);
        Boat Oceanis = new Boat("Beneteau", 950, 10, 4000.0, "Fiberglass", "Spade");
        System.out.println("\n" + Oceanis); 
        Submarine Virginia = new Submarine("Huntington Ingalls", 29.0, 132, 10000.0, "Steel", "X-shaped", "Trim Tanks"); 
        System.out.println("\n" + Virginia);
        Sailboat First27 = new Sailboat("Beneteau", 7.2, 4, 5291.0, "Fiberglass", "Spade",306.0); 
        System.out.println("\n" + First27);
        
        System.out.println("\n---AIRPLANES---"); //AIRPLANES -- Brand, Speed, Passengers, Cargo, Wingspan, WingShape
        Airplane Boeing787 = new Airplane("Boeing", 614.0, 500, 140000.0, 68.4, "Swept-back"); 
        System.out.println(Boeing787);
        Airplane Skyhawk = new Airplane("Cessna", 140.0, 4, 1000.0, 11.0, "Straight high-wing"); 
        System.out.println("\n" + Skyhawk);
        PropellerPlane Dash8Q400 = new PropellerPlane("De Havilland Canada", 414.0, 80, 18000.0, 28.4, "High-mounted, moderately tapered", 4.11); 
        System.out.println("\n" + Dash8Q400);
        AmphibiousPlane Caravan = new AmphibiousPlane("Cessna", 214.0, 14, 3000, 15.9, "High-mounted, straight", "Pontoons"); 
        System.out.println("\n" + Caravan);
        
        System.out.println("\n---SPACESHIPS---"); //includes brand, speed, passengers, cargo, and oxygen capacity(int)
        Spaceship Dragon2 = new Spaceship("SpaceX", 17500.0, 7, 6000.0, 588); 
        System.out.println(Dragon2);
        Starfighter TIEFighter = new Starfighter("Sienar Fleet Systems", 745.0, 1, 65.0, 6, "Imperial Star Destroyer");
        System.out.println("\n" + TIEFighter);
        Hyperspaceship Ghost = new Hyperspaceship("Corellian Engineering Corporation", 650.0, 8, 2204.62, 250, "Class 1"); 
        System.out.println("\n" + Ghost); //as seen in the show Star Wars Rebels & Ahsoka
        Hyperspaceship MilleniumFalcon = new Hyperspaceship("Corellian Engineerig Corporation", 1050.0, 8, 220462.0, 300, "Class 0.5");
        System.out.println("\n" + MilleniumFalcon); 
    }
}

class Vehicle implements Speedometer { //Brand, Speed, Passengers, Cargo
        //base (Class wide) variables
        protected String brandName = "";
        protected double speed = 0.0;
        protected int passengers = 0;
        protected double cargoWeight = 0.0;
        //Base default constructor
        public Vehicle(){
            brandName = "";
            speed = 0.0;
            passengers = 0;
            cargoWeight = 0.0;
        }
        public Vehicle(String inBrand, double inSpeed, int inPassengers, double inCargo){
            brandName = inBrand;
            speed = inSpeed;
            passengers = inPassengers;
            cargoWeight = inCargo;
        }
        //getters and setters
        public Vehicle(String inBrand){
            brandName = inBrand;
        }
        public String getBrand(){
            return brandName;
        }
        public void setBrand(String inBrand){
            brandName = inBrand;
        }
        public double getSpeed(){
            return speed;
        }
        public void setSpeed(double inSpeed){
            speed = inSpeed;
        }
        public int getPassengers(){
            return passengers;
        }
        public void setPassengers(int inPassengers){
            passengers = inPassengers;
        }
        public double getCargoWeight(){
            return cargoWeight;
        }
        public void setCargoWeight(double inCargoWeight){
            cargoWeight = inCargoWeight;
        }
        //Base toString
        public String toString(){
            String result = "";
            result = "Brand: " + getBrand() + "\n" + 
                "Speed (mph): " + getSpeed() + "\n" +
                "Passengers: " + getPassengers() + "\n" +
                "Cargo (lbs): " + getCargoWeight() + "\n";
                return result;
            }
    }

// Car Class inherits from Vehicle Class
class Car extends Vehicle{ 
    int wheels = 4;
    String color = ""; //this variable is only for this class, car
    boolean spoiler = false;
    boolean stereo = false;
    double mpg = 0.0; //has an extra variable, mpg, only for the car class
    int year = 0; 
    
    public Car(String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG, String inColor, int inYear){
        super(inBrand, inSpeed, inPassengers, inCargo); //uses the super constructor to get the variables from the other class
        mpg = inMPG; //also include the extra variable
        color = inColor; 
        year = inYear; 
    }
    public boolean getSpoiler(){
        return spoiler;
    }
    //another additional variable
        public void setStereo(boolean inStereo){
            stereo = inStereo;
        }
        public boolean getStereo(){
            return stereo;
        }
    //overrides the super getSpeed method
    @Override
    public double getSpeed() {
        if (spoiler)
            return super.getSpeed() + 20; //ooo ads 20 mph to speed? 
        else
            return super.getSpeed(); 
        }
    public void setMpg(double mpg) {
        this.mpg = mpg;
        }
    public double getMPG(){
            if(stereo)
                return mpg - (mpg/10); 
            else
                return mpg; 
        }
    public String getColor(){
            return color;
        }
    public void setColor(String inColor){
            color = inColor;
        }
    public int getYear(){
            return year;
        }
    public void setYear(int inYear){
            year = inYear;
        }
    //usesd the super toString, as well as adding the new variable to it.
    public String toString(){
        String result = super.toString() +
        "MPG: " + this.getMPG() + "\n" 
        + "Color: " + this.getColor() + "\n"
        + "Year: " + this.getYear(); 
        return result;
        }
}
//CHANGE THIS
class Truck extends Car { //different bc it has a bed and a cab
    double bedSize = 0; 
    
    public Truck(String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG, String inColor, int inYear, double inBedSize){
        super(inBrand, inSpeed, inPassengers, inCargo, inMPG, inColor, inYear); 
        bedSize = inBedSize; 
    }
    public double getBedSize(){
            return bedSize;
        }
    public void setBedSize(double inBedSize){
            bedSize = inBedSize;
        }
    public String toString() { 
        String result = super.toString() + "\n" + 
        "Bed Size(ft): " + this.getBedSize(); 
        return result; 
    }
}

class CinemaCar extends Car { //different bc featured in movies
    String specialAbility = ""; 
    String movie = ""; 

    public CinemaCar(String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG, String inColor, int inYear, String inSpecialAbility, String inMovie){
        super(inBrand, inSpeed, inPassengers, inCargo, inMPG, inColor, inYear); 
        specialAbility = inSpecialAbility; 
        movie = inMovie; 
    }
    public String getSpecialAbility(){
        return specialAbility;
    }
    public void setSpecialAbility(String inSpecialAbility){
        specialAbility = inSpecialAbility;
    }
    public String getMovie(){
        return movie;
    }
    public void setMovie(String inMovie){
        movie = inMovie;
    }
    public String toString() { 
        String result = super.toString() + "\n" +
        "Special Ability: " + this.getSpecialAbility() + 
        "\n" + "Movie Featured: " + this.getMovie(); 
        return result; 
    }    
}

class Boat extends Vehicle {
    String hull = ""; //this is hull material. could be fiberglass, aluminum, steel, or wood
    String rudder = ""; //this is the type of rudder. this scould be Transom, Spade, Skeg, or Balanced
    
    public Boat(String inBrand, double inSpeed, int inPassengers, double inCargo, String inHull, String inRudder){
    super (inBrand, inSpeed, inPassengers, inCargo);
    hull = inHull; 
    rudder =  inRudder; 
    }
    //getters and setters
    public String getHull(){
        return hull; 
        }
    public void setHull(String inHull) {
        hull = inHull; 
    }
    public String getRudder(){
        return rudder; 
        }
    public void setRudder(String inRudder) {
        rudder = inRudder; 
    }
    public String toString(){
        String result = super.toString() + 
                "Hull: " + this.getHull() + "\n" 
                + "Rudder: " + this.getRudder(); 
        return result; 
    }
}

class Submarine extends Boat { 
    String ballast = ""; 
    
    public Submarine(String inBrand, double inSpeed, int inPassengers, double inCargo, String inHull, String inRudder, String inBallast) { 
        super(inBrand, inSpeed, inPassengers, inCargo, inHull, inRudder);
        ballast = inBallast; 
    }
    public String getBallast(){
        return ballast; 
        }
    public void setBallast(String inBallast) {
        ballast = inBallast; 
    }
    public String toString() {
        String result = super.toString() + "\n" 
            + "Ballast type: " + this.getBallast(); 
        return result; 
    }
}

class Sailboat extends Boat {
    double sailSize = 0.0; 
    
    public Sailboat(String inBrand, double inSpeed, int inPassengers, double inCargo, String inHull, String inRudder, double inSailSize) {
        super(inBrand, inSpeed, inPassengers, inCargo, inHull, inRudder);
        sailSize = inSailSize; 
    }
    public double getSailSize(){
        return sailSize;
    }
    public void setSailSize(double inSailSize){
        sailSize = inSailSize;
    }
    public String toString() {
        String result = super.toString() + "\n" + 
            "Sail Size (sq ft): " + this.getSailSize(); 
        return result; 
    } 
}

class Airplane extends Vehicle {
    double wingspan = 0.0; 
    String wingShape = ""; 
    
    public Airplane(String inBrand, double inSpeed, int inPassengers, double inCargo, double inWingspan, String inWingShape) {
        super(inBrand, inSpeed, inPassengers, inCargo); 
        wingspan = inWingspan; 
        wingShape = inWingShape; 
    }
    public double getWingspan(){
        return wingspan; 
        }
    public void setWingspan(double inWingspan) {
        wingspan = inWingspan; 
    }
    public String getWingShape(){
        return wingShape; 
        }
    public void setWingShape(String inWingShape) {
        wingShape = inWingShape; 
    }
    public String toString(){
        String result = super.toString() + 
            "Wingspan (meters): " + this.getWingspan() + "\n"
            + "WingShape: " + this.getWingShape(); 
        return result; 
    }
}

class PropellerPlane extends Airplane { //different because they have propellers
    double diameter = 0.0; 
    
    public PropellerPlane(String inBrand, double inSpeed, int inPassengers, double inCargo, double inWingspan, String inWingShape, double inDiameter) {
        super(inBrand, inSpeed, inPassengers, inCargo, inWingspan, inWingShape); 
        diameter = inDiameter; 
    }
    public double getDiameter(){
            return diameter;
        }
    public void setDiameter(int inDiameter){
            diameter = inDiameter;
        }
    public String toString() {
        String result = super.toString() + "\n" +
            "Diameter of Propeller(meters): " + this.getDiameter(); 
        return result; 
    }
}
class AmphibiousPlane extends Airplane { //different because they can float
    String device = ""; 
    
    public AmphibiousPlane(String inBrand, double inSpeed, int inPassengers, double inCargo, double inWingspan, String inWingShape, String inDevice) {
        super(inBrand, inSpeed, inPassengers, inCargo, inWingspan, inWingShape); 
        device = inDevice; 
    }
    public String getDevice(){
        return device; 
        }
    public void setDevice(String inDevice) {
        device = inDevice; 
    }
    public String toString() {
        String result = super.toString() + "\n" + 
            "Flotation Device: " + this.getDevice(); 
        return result; 
    }
}

class Spaceship extends Vehicle { //brand, speed, passengers, cargo weight
    int oxygen = 0; 
    
    public Spaceship(String inBrand, double inSpeed, int inPassengers, double inCargo, int inOxygen){ 
        super(inBrand, inSpeed, inPassengers, inCargo); 
        oxygen = inOxygen; 
    }
    public int getOxygen(){
        return oxygen;
    }
    public void setOxygen(int inOxygen){
        oxygen = inOxygen;
    }
    public String toString() {
        String result = super.toString() + 
            "Oxygen Capacity (kg): " + this.getOxygen(); 
        return result; 
    }
}

class Starfighter extends Spaceship { //starfighters are like TIE fighters. they don't have hyperdrives and rely on larger ships to travel long distances
    String carrier = ""; //carrier is the kind of ship that carries the starfighters. ex: star destroyer carries TIE fighters
    
    public Starfighter(String inBrand, double inSpeed, int inPassengers, double inCargo, int inOxygen, String inCarrier) {
        super(inBrand, inSpeed, inPassengers, inCargo, inOxygen);
        carrier = inCarrier;
    }
    public String getCarrier(){
        return carrier;
    }
    public void setCarrier(String inCarrier){
        carrier = inCarrier;
    }
    public String toString() {
        String result = super.toString() + "\n" +
            "Carrier Ship: " + this.getCarrier(); 
        return result; 
    }
}

class Hyperspaceship extends Spaceship {
    String hyperdrive = ""; //hyperdrive is the kind of engine that allows a ship to travel through hyperspace. there are different kinds
    
    public Hyperspaceship(String inBrand, double inSpeed, int inPassengers, double inCargo, int inOxygen, String inHyperdrive) {
        super(inBrand, inSpeed, inPassengers, inCargo, inOxygen); 
        hyperdrive = inHyperdrive; 
    }
    public String getHyperdrive(){
        return hyperdrive;
    }
    public void setHyperdrive(String inHyperdrive){
        hyperdrive = inHyperdrive;
    }
    public String toString() {
        String result = super.toString() + "\n" +
            "Hyperdrive Class: " + this.getHyperdrive(); 
        return result; 
    }
}

interface Speedometer { 
    public void setSpeed(double inSpeed);
    public double getSpeed();
}