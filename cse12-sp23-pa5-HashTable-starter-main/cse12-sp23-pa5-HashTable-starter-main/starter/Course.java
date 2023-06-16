/**
 * Name: Darwin Smith
 * Email: dls002@ucsd.edu
 * PID: A17445596
 * 
 * This file contains my implementation a Course class, which uses HashSet to 
 * store objects of the Student class. This file also contains the constructor 
 * and a number of methods that can be used to access certain instance 
 * variables of the course as well as manipulate and view the enrollment
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
 * The Course class contains the instance variables for a Course object as well
 * as a constructor and the methods that can be used with Course objects
 */
public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;

    /**
     * This is the constructor for the Course object, which assigns the 
     * arguments to their respective instance variables, as well as initiates 
     * the enrolled HashSet instance variable. If the String args are null or 
     * the capacity arg is less than or equal to 0, throws an exception
     * @param department is the argument stored in the department instance 
     * variable
     * @param number is the argument stored in the number instance variable
     * @param description is the argument stored in the description instance 
     * variable
     * @param capacity is the argument stored in the capacity instance variable
     */
    public Course(String department, String number, String description, 
    int capacity){
        if (department == null || number == null || description == null || 
        capacity <= 0){
            throw new IllegalArgumentException();
        }
        enrolled = new HashSet<>();
        this.capacity = capacity;
        this.department = department;
        this.number = number;
        this.description = description;
    }

    /**
     * This method returns the String stored in the department instance 
     * variable
     * @return the String department instance variable
     */
    public String getDepartment(){
        return this.department;
    }

    /**
     * This method returns the String stored in the number instance 
     * variable
     * @return the String number instance variable
     */
    public String getNumber(){
        return this.number;
    }

    /**
     * This method returns the String stored in the description instance 
     * variable
     * @return the String description instance variable
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * This method returns the int stored in the capacity instance 
     * variable
     * @return the int capacity instance variable
     */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     * This method enrolls the student in the course by adding the Student 
     * object to the HashSet if the course is not full. Returns true or false 
     * depending on whether the enrollement was successful. If the argument is 
     * null, throws an exception
     * @param student is the Student object passed as an argument
     * @return boolean true or false depending of if the enrollment was 
     * successful or not
     */
    public boolean enroll(Student student){
        if (student == null){throw new IllegalArgumentException();}
        if (enrolled.size() < this.capacity){
            return enrolled.add(student);
        }
        return false;
    }

    /**
     * This method drops a student from the course by removing the Student 
     * object from the HashSet, and returns true or false depending on whether 
     * the removal was successful or not. If the argument is null, throws an
     * exception
     * @param student is the Student object passed as an argument
     * @return boolean true or false depending of if the drop was successful or
     * not
     */
    public boolean drop(Student student){
        if (student == null){throw new IllegalArgumentException();}
        return enrolled.remove(student);
    }

    /**
     * This method clears the HashSet, effectively canceling the course
     */
    public void cancel(){
        enrolled.clear();
    }

    /**
     * This method returns true or false depending on whether the HashSet size
     * is equal to the capacity of the course
     * @return boolean true or false depending on if course is full
     */
    public boolean isFull(){
        return enrolled.size() == this.capacity;
    }

    /**
     * This method returns the number of students enrolled in the course, based
     * on the HashSet size
     * @return the int HashSet size of the course
     */
    public int getEnrolledCount(){
        return enrolled.size();
    }

    /**
     * This method returns the number of available spots in the course by 
     * subtracting the number of students enrolled from the capacity of the 
     * course
     * @return the int number of available spots in the course
     */
    public int getAvailableSeats(){
        return this.capacity - enrolled.size();
    }

    /**
     * This method returns the enrolled students in the form of a shallow copy
     * HashSet of the enrolled HashSet of the Course object
     * @return a HashSet containing the enrolled students in the course
     */
    public HashSet<Student> getStudents(){
        HashSet<Student> toReturn = enrolled;
        return toReturn;
    }

    /**
     * This method returns an ArrayList object of all the students in the
     * course, using an iterator to go through the enrolled HashSet and add
     * all of the Student objects to the ArrayList
     * @return the ArrayList containing all the Student objects enrolled in
     * the course
     */
    public ArrayList<Student> getRoster(){
        Iterator<Student> iter = enrolled.iterator();
        ArrayList<Student> roster = new ArrayList<>();
        while (iter.hasNext()){roster.add(iter.next());}
        Collections.sort(roster);
        return roster;
    }

    /**
     * This method returns the instance variables of the Course object
     * excluding the HashSet as a formatted string
     * @return a string containing the instance variables of the Course object
     * and excluding the HashSet
     */
    @Override
    public String toString(){
        return String.format("%s %s [%d] %s",department,number,capacity,
        description);
    }
}
