/**
 * Name: Darwin Smith
 * Email: dls002@ucsd.edu
 * PID: A17445596
 * 
 * This file contains my implementation of an assortment of tests for the 
 * Student, Course, and Sanctuary classes. The tests in this file test a 
 * number of their individual methods, and test if the application of HashSet 
 * and HashMap are correct.
 */

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomTester {
    /**
     * Test Student equals method with non Student object as argument
     */
    @Test
    public void testStudentEquals(){
        Student stu1 = new Student("Bob","Joe","A203");
        String obj1 = "wow";
        assertEquals("Check if equals returns false",false,stu1.equals(obj1));
    }

    /**
     * Test Student compareTo method when Student passed as argument has same 
     * first and last name but lexicographically larger PID
     */
    @Test
    public void testStudentCompareTo(){
        Student stu1 = new Student("Bob","Joe","A113");
        Student stu2 = new Student("Bob","Joe","B113");
        assertEquals("Check if stu1 is smaller",-1,stu1.compareTo(stu2));
    }

    /**
     * Test Course drop method when class is not empty and the argument passed 
     * is a Student that does not exist in the course
     */
    @Test
    public void testCourseDrop(){
        Course co1 = new Course("CSE","12","Data Structures",10);
        Student stu1 = new Student("Bob","Joe","A113");
        Student stu2 = new Student("Bob","Joe","B113");
        co1.enrolled.add(stu1);
        assertEquals("Check if returns false",false,co1.drop(stu2));
        assertEquals("Check if size is still 1",1,co1.enrolled.size());
        assertEquals("Check if stu1 is still enrolled",true,
        co1.enrolled.contains(stu1));
    }

    /**
     * Test Course enroll method when class is already full
     */
    @Test
    public void testCourseEnroll(){
        Course co1 = new Course("CSE","12","Data Structures",1);
        Student stu1 = new Student("Bob","Joe","A113");
        Student stu2 = new Student("Bob","Joe","B113");
        co1.enrolled.add(stu1);
        assertEquals("Check if returns false",false,co1.enroll(stu2));
        assertEquals("Check if size still 1",1,co1.enrolled.size());
        assertEquals("Check if stu1 is still enrolled",true,
        co1.enrolled.contains(stu1));
    }

    /**
     * Test Course getRoster method when the course has 100 students
     */
    @Test
    public void testCourseGetRoster(){
        ArrayList<Student> correctRoster = new ArrayList<>();
        Course co1 = new Course("CSE","12","Data Structures",150);
        String PID = "0";
        for (int i = 0; i < 100; i++){
            PID = String.valueOf(Integer.parseInt(PID) + 1);
            Student stuToAdd = new Student("Bob","Joe",PID);
            co1.enrolled.add(stuToAdd);
            correctRoster.add(stuToAdd);
        }
        Collections.sort(correctRoster);
        assertEquals("Check if size 100",100,co1.enrolled.size());
        assertEquals("Check if roster is the same",correctRoster,
        co1.getRoster());
    }

    /**
     * Test Sanctuary constructor when argument passed for maxAnimals is negative
     */
    @Test
    public void testSanctConstructor(){
        try{
            Sanctuary sanct1 = new Sanctuary(-15,20);
            fail();
        }
        catch(IllegalArgumentException e){}
    }

    /**
     * Test Sanctuary rescue method when the number of animals passed as an 
     * argument would cause the total number of animals to exceed 
     * the maxAnimals
     */
    @Test
    public void testSanctRescuePartial(){
        Sanctuary sanct1 = new Sanctuary(5,2);
        sanct1.sanctuary.put("Panda",3);
        assertEquals("Check if returns 3",3,sanct1.rescue("Panda",5));
        assertEquals("Check if there are 5 pandas",5,
        (int)sanct1.sanctuary.get("Panda"));
    }

    /**
     * Test Sanctuary rescue method when the species passed as an arg is a new 
     * species and would cause the total number of species to exceed the 
     * maxSpecies
     */
    @Test
    public void testSanctRescueMaxSpecies(){
        Sanctuary sanct1 = new Sanctuary(5,1);
        sanct1.sanctuary.put("Panda",2);
        assertEquals("Check if returns 5",5,sanct1.rescue("Bear",5));
        assertEquals("Check if size is still 1",1,sanct1.sanctuary.size());
        assertEquals("Check if there are still 2 pandas",2,
        (int)sanct1.sanctuary.get("Panda"));
    }

    /**
     * Test Sanctuary release method when the species passed as an arg already 
     * exists and the number of animals to release is less than the number of 
     * animals of the species
     */
    @Test
    public void testSanctReleasePartial(){
        Sanctuary sanct1 = new Sanctuary(5,2);
        sanct1.sanctuary.put("Panda",4);
        sanct1.release("Panda",2);
        assertEquals("Check if there are 2 pandas",2,
        (int)sanct1.sanctuary.get("Panda"));
        assertEquals("Check if there is still 1 species",1,
        sanct1.sanctuary.size());
    }

    /**
     * Test Sanctuary release method when the species passed as an arg already 
     * exists and the number of animals to release is more than the number of 
     * animals of the species
     */
    @Test
    public void testSanctReleaseTooMany(){
        Sanctuary sanct1 = new Sanctuary(10,2);
        sanct1.sanctuary.put("Panda",4);
        try{
            sanct1.release("Panda",6);
            fail();
        }
        catch(IllegalArgumentException e){}
        
    }
}
