/**
 * Name: Darwin Smith
 * Email: dls002@ucsd.edu
 * PID: A17445596
 * 
 * This file contains my implementation of a Student class, which stores a 
 * first name, last name, and PID, in a unique object for each student. This 
 * file also contains methods that can be used with the Student class.
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
 * The Student class contains the instance variables for the student first
 * name, last name, and PID, as well as the constructor and methods that
 * can be used with Student objects
 */
public class Student implements Comparable<Student>{
    private final String firstName;
    private final String lastName;
    private final String PID;

    /**
     * This is the constructor for Student objects, which assigns the arguments
     * to their respective instance variables. It throws an exception if any of
     * the arguments are null
     * @param firstName is the argument stored in the firstName instance 
     * variable
     * @param lastName is the argument stored in the lastName instance
     * variable
     * @param PID is the argument stored in the PID instance variable
     */
    public Student(String firstName, String lastName, String PID){
        if (firstName == null || lastName == null || PID == null){
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.PID = PID;
    }

    /**
     * This method returns the String stored in the firstName instance variable
     * @return the String firstName instance variable of the Student object
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * This method returns the String stored in the lastName instance variable
     * @return the String lastName instance variable of the Student object
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * This method returns the String stored in the PID instance variable
     * @return the String PID instance variable of the Student object
     */
    public String getPID(){
        return this.PID;
    }

    /**
     * This method returns boolean true or false depending on whether the 
     * hashcode of the object passed as an argument equals the hashcode of the 
     * Student object
     * @param o is the argument which will have its hashcode compared to the 
     * hashcode of the Student object
     * @return boolean true or false depending on whether the hashcodes are 
     * equal
     */
    @Override
    public boolean equals(Object o){
        return o.hashCode() == this.hashCode();
    }

    /**
     * This method returns the hashcode using the Objects.hash function of the 
     * Student objects first name, last name, and PID, in that order
     * @return the int hashcode of the the Student firstName, lastName, and PID
     * in that order
     */
    @Override
    public int hashCode(){
        return Objects.hash(this.firstName,this.lastName,this.PID);
    }

    /**
     * This method returns the output of the compareTo method on the last names 
     * of this Student object and the Student object passed as an argument. If 
     * the first names are equal, it compares the first names. If the first 
     * names are equal, it compares the PIDs. If the argument passed is null, 
     * throws an exception
     * @param o is the Student object passed as an argument
     * @return the int output of the .compareTo method on this Student object 
     * and the Student object passed as an argument
     */
    public int compareTo(Student o){
        if (o == null){
            throw new NullPointerException();
        }
        if (this.lastName.compareTo(o.getLastName()) != 0){
            return this.lastName.compareTo(o.getLastName());
        }
        else if (this.firstName.compareTo(o.getFirstName()) != 0){
            return this.firstName.compareTo(o.getFirstName());
        }
        else {
            return this.PID.compareTo(o.getPID());
        }
    }
}
