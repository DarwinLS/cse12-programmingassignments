/**
 * Name: Darwin Smith
 * Email: dls002@ucsd.edu
 * PID: A17445596
 * 
 * This file contains all of the tests I created to test my 
 * MyArrayList methods from MyArrayList.java
 */
import static org.junit.Assert.*;

import org.junit.*;

/**
 * MyArrayHiddenTester is the class that contains all the tests that will 
 * be run by Junit to test the MyArrayList methods 
*/
public class MyArrayListHiddenTester {
    // Do not change the method signatures!
    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test 
     */
    @Before
    public void setUp() throws Exception {
        
    }

    /**
     * Aims to test the constructor when the input argument
     * is not valid
     */
    @Test
    public void testConstructorInvalidArg(){
        int invalidCap = -1;
        try{
            MyArrayList<Integer> testArr = new MyArrayList<>(invalidCap);
            fail();
        }
        catch(IllegalArgumentException e){}
    }

    /**
     * Aims to test the constructor when the input argument is null
     */
    @Test
    public void testConstructorNullArg(){
        MyArrayList<Integer> testArr = new MyArrayList<>(null);
        assertEquals("Is the array length 5?", 5, testArr.data.length);
    }

    /**
     * Aims to test the constructor when the input array has null elements
     */
    @Test
    public void testConstructorArrayWithNull(){
        String[] arrToInput = {"bruh","wow",null,"ez",null};
        MyArrayList<String> testArr = new MyArrayList<>(arrToInput);
        assertEquals("Check if size is 5", 5, testArr.size);
    }

    /**
     * Aims to test the append method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendAtCapacity(){
        String[] arrToInput = {"bruh","wow","ez"};
        MyArrayList<String> testArr = new MyArrayList<>(arrToInput);
        testArr.append("crazy");
        assertEquals("Check if capacity is 6 (3+3)", 6, testArr.data.length);
        assertEquals("Check if size is 4 (3+1)", 4, testArr.size);

    }

    /**
     * Aims to test the append method when null is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendNull(){
        String[] arrToInput = {"bruh","wow","ez"};
        MyArrayList<String> testArr = new MyArrayList<>(arrToInput);
        testArr.append(null);
        assertEquals("Check if capacity is 6 (3+3)", 6, testArr.data.length);
        assertEquals("Check if size is 4 (3+1)", 4, testArr.size);
    }

    /**
     * Aims to test the prepend method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testPrependAtCapacity(){
        String[] arrToInput = {"bruh","wow","ez"};
        MyArrayList<String> testArr = new MyArrayList<>(arrToInput);
        testArr.prepend("no cap");
        assertEquals("Check if capacity is 6 (3+3)", 6, testArr.data.length);
        assertEquals("Check if size is 4 (3+1)", 4, testArr.size);
    }
    
    /**
     * Aims to test the prepend method when a null element is added
     * Checks reflection on size and capacity
     * Checks whether null was added successfully
     */
    @Test
    public void testPrependNull(){
        String[] arrToInput = {"bruh","wow","ez"};
        MyArrayList<String> testArr = new MyArrayList<>(arrToInput);
        testArr.prepend(null);
        assertEquals("Check if capacity is 6 (3+3)", 6, testArr.data.length);
        assertEquals("Check if size is 4 (3+1)", 4, testArr.size);
    }
    
    /**
     * Aims to test the insert method when input index is out of bounds
     */
    @Test
    public void testInsertOutOfBounds(){
        String[] arrToInput = {"bruh","wow","ez"};
        MyArrayList<String> testArr = new MyArrayList<>(arrToInput);
        try{
            testArr.insert(10,"wowzers");
            fail();
        }
        catch(IndexOutOfBoundsException e){}
    }

    /**
     * Insert multiple (eg. 1000) elements sequentially beyond capacity -
     * Check reflection on size and capacity
     * Hint: for loop could come in handy
     */
    @Test
    public void testInsertMultiple(){
        MyArrayList<String> testArr = new MyArrayList<>();
        for (int i = 0; i < 10; i++){
            testArr.insert(0,"ez");
        }
        assertEquals("Check if capacity is 11", 11, testArr.data.length);
        assertEquals("Check if size is 10 (10*1)", 10, testArr.size);
    }

    /**
     * Aims to test the get method when input index is out of bound
     */
    @Test
    public void testGetOutOfBound(){
        String[] arrToInput = {"bruh","wow","ez"};
        MyArrayList<String> testArr = new MyArrayList<>(arrToInput);
        try{
            testArr.get(500);
            fail();
        }
        catch(IndexOutOfBoundsException e){}
    }

    /**
     * Aims to test the set method when input index is out of bound
     */
    @Test
    public void testSetOutOfBound(){
        String[] arrToInput = {"bruh","wow","ez"};
        MyArrayList<String> testArr = new MyArrayList<>(arrToInput);
        try{
            testArr.set(200, "ez");
            fail();
        }
        catch(IndexOutOfBoundsException e){}
    }

    /**
     * Aims to test the remove method when removing multiple items from a list
     */
    @Test
    public void testRemoveMultiple(){
        String[] arrToInput = {"bruh","wow","ez"};
        MyArrayList<String> testArr = new MyArrayList<>(arrToInput);
        testArr.remove(1);
        testArr.remove(0);
        assertEquals("Check if size is 1 (3-2)", 1, testArr.size);
        String[] expectedArr = {"ez",null,null};
        assertArrayEquals("Check contents of data", expectedArr, testArr.data);
    }

    /**
     * Aims to test the remove method when input index is out of bound
     */
    @Test
    public void testRemoveOutOfBound(){
        String[] arrToInput = {"bruh","wow","ez"};
        MyArrayList<String> testArr = new MyArrayList<>(arrToInput);
        try{
            testArr.remove(-3);
            fail();
        }
        catch(IndexOutOfBoundsException e){}
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is strictly less than the current capacity
     */
    @Test
    public void testExpandCapacitySmaller(){
        String[] arrToInput = {"bruh","wow","ez"};
        MyArrayList<String> testArr = new MyArrayList<>(arrToInput);
        try{
            testArr.expandCapacity(2);
            fail();
        }
        catch(IllegalArgumentException e){}
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is greater than current capacity+3 and default capacity
     */
    @Test
    public void testExpandCapacityLarge(){
        String[] arrToInput = {"bruh","wow","ez"};
        MyArrayList<String> testArr = new MyArrayList<>(arrToInput);
        testArr.expandCapacity(10);
        assertEquals("Check if capacity is 10", 10, testArr.data.length);
    }
    

}
