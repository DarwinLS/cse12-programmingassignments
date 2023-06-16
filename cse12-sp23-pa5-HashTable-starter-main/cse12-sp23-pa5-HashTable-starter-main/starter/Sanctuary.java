/**
 * Name: Darwin Smith
 * Email: dls002@ucsd.edu
 * PID: A17445596
 * 
 * This file contains my implementation a Sanctuary class, which uses a HashMap
 * to store animals and the number of those animals as key and value, 
 * respectively. This file contains the methods and constructor that go with
 * the Sanctuary class
 */

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Sanctuary class contains my full implementation, including instance
 * variables, the constructor, and the methods that can be used with
 * Sanctuary objects
 */
public class Sanctuary {
    HashMap<String,Integer> sanctuary;
    private final int maxAnimals;
    private final int maxSpecies;

    /**
     * This is the constructor for a Sanctuary object, which assigns the 
     * arguments to their respective instance variables as well as initiates 
     * the HashMap instance variable. If maxSpecies is greater than maxAnimals 
     * or either arguments are less than or equal to 0, throw an exception
     * @param maxAnimals is the argument to be stored in the maxAnimals 
     * instance variable
     * @param maxSpecies is the argument to be stored in the maxSpecies 
     * instance variable
     */
    public Sanctuary(int maxAnimals, int maxSpecies){
        if (maxSpecies > maxAnimals || maxAnimals <= 0 || maxSpecies <= 0){
            throw new IllegalArgumentException();
        }
        sanctuary = new HashMap<>();
        this.maxAnimals = maxAnimals;
        this.maxSpecies = maxSpecies;
    }

    /**
     * This method returns the number of animals of a species in the Sanctuary 
     * HashMap. If the species is not in the HashMap, returns 0. If the 
     * argument is null, throws an exception.
     * @param species is the species passed as an argument to be used to find
     * the number of animals of the species
     * @return the int number of animals of the species passed as an arg
     */
    public int countForSpecies(String species){
        if (species == null){throw new IllegalArgumentException();}
        if (sanctuary.get(species) == null){return 0;}
        return sanctuary.get(species);
    }

    /**
     * This method returns the total number of animals in the Sanctuary HashMap
     * across all species, using an ArrayList to add the individual values
     * @return the int number of total animals in the Sanctuary HashMap
     */
    public int getTotalAnimals(){
        ArrayList<Integer> values = new ArrayList<>(sanctuary.values());
        int total = 0;
        for (Integer counts : values){
            total += counts;
        }
        return total;
    }

    /**
     * This method returns the total number of species in the Sanctuary HashMap
     * by accessing the size of the HashMap
     * @return the total number of species in the Sanctuary HashMap
     */
    public int getTotalSpecies(){
        return sanctuary.size();
    }

    /**
     * This method returns the maxAnimals instance variable of the Sanctuary 
     * object
     * @return the int value of maxAnimals instance variable of the Sanctuary 
     * object
     */
    public int getMaxAnimals(){
        return this.maxAnimals;
    }

    /**
     * This method returns the maxSpecies instance variable of the Sanctuary 
     * object
     * @return the int value of maxSpecies instance variable of the Sanctuary 
     * object
     */
    public int getMaxSpecies(){
        return this.maxSpecies;
    }

    /**
     * This method takes a species and the number of animals of the species as 
     * arguments, and adds them to the Sanctuary HashMap. If the number of 
     * species or the total number of animals will be exceeded by the
     * addition, then it will add what it can without exceeding them and return
     * the number of animals that could not be added. If the species arg is
     * null or the number of animals to add is less than or equal to 0, throw
     * an exception
     * @param species is the species passed as an argument to have animals
     * added to in the Sanctuary HashMap
     * @param num is the number passed as an argument of animals to add
     * @return the number of animals unsuccessfully added
     */
    public int rescue(String species, int num){
        if (num <= 0 || species == null){throw new IllegalArgumentException();}
        if (!sanctuary.containsKey(species) && sanctuary.size() == maxSpecies){
            return num;
        }
        int rescuable;
        if (this.getTotalAnimals() + num > this.maxAnimals){
            rescuable = this.maxAnimals - this.getTotalAnimals();
            num -= rescuable;
        }
        else{
            rescuable = num;
            num = 0;
        }
        if (sanctuary.containsKey(species)){
            sanctuary.put(species,(int)sanctuary.get(species) + rescuable);
            return num;
        }
        sanctuary.put(species,rescuable);
        return num;
    }

    /**
     * This method removes animals of a species from the Sanctuary HashMap
     * according to the species and number of animal arguments passed.
     * If the operation will result in removal of all of the animals of 
     * a species, the species will be removed from the HashMap. If the num
     * arg is less than or equal to 0, or num is less than the number of 
     * animals of species in the HashMap, or species is null, or species
     * is not contained in the HashMap, throw an exception
     * @param species is the species passed as an argument to have animals
     * removed from in the Sanctuary HashMap
     * @param num is the number of animals to remove
     */
    public void release(String species, int num){
        if (num <= 0 || num > sanctuary.get(species) || species == null || 
        !sanctuary.containsKey(species)){
            throw new IllegalArgumentException();
        }
        if ((int)sanctuary.get(species) == num){sanctuary.remove(species);}
        else{sanctuary.put(species,(int)sanctuary.get(species) - num);}
    }
}
