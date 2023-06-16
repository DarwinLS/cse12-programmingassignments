/**
 * Name: Darwin Smith
 * Email: dls002@ucsd.edu
 * PID: A17445596
 * 
 * This file contains my tests for my implementation of the MyListIterator, 
 * including for all of the methods
 */

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.*;

public class MyListIteratorCustomTester {

    MyLinkedList linkList1;
    MyLinkedList.MyListIterator iter1;

    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test.
     */
    @Before
    public void setUp() throws Exception {
        linkList1 = new MyLinkedList();
        linkList1.add("noob");
        linkList1.add("wowzers");
        linkList1.add("crazy");
        iter1 = linkList1.new MyListIterator();
    }

    /**
     * Aims to test the next() method when iterator is at end of the list 
     */
    @Test
    public void testNextEnd() {
        iter1.right = linkList1.tail;
        iter1.left = linkList1.tail.getPrev();
        iter1.idx = linkList1.size;
        try{
            iter1.next();
            fail();
        }
        catch(NoSuchElementException e){}
    }

    /**
     * Aims to test the previous() method when iterator is at the start of the 
     * list 
     */
    @Test
    public void testPreviousStart() {
        try{
            iter1.previous();
            fail();
        }
        catch(NoSuchElementException e){}
    }

    /**
     * Aims to test the add(E e) method when an invalid element is added
     */
    @Test
    public void testAddInvalid() {
        try{
            iter1.add(null);
            fail();
        }
        catch(NullPointerException e){}
    }

    /**
     * Aims to test the set(E e) method when canRemoveOrSet is false
     */
    @Test
    public void testCantSet() {
        try{
            iter1.set("bonkers");
            fail();
        }
        catch(IllegalStateException e){}
    }


    /**
     * Aims to test the set(E e) method when an invalid element is set
     */
    @Test
    public void testSetInvalid() {
        try{
            iter1.set(null);
            fail();
        }
        catch(NullPointerException e){}
    }

    /**
     * Aims to test the remove() method when canRemoveOrSet is false
     */
    @Test
    public void testCantRemove() {
        try{
            iter1.remove();
            fail();
        }
        catch(IllegalStateException e){}
    }

    /**
     * Aims to tests the hasNext() method at the end of a list
     */
    @Test
    public void testHasNextEnd() {
        iter1.right = linkList1.tail;
        iter1.left = linkList1.tail.getPrev();
        iter1.idx = linkList1.size;
        assertEquals("Should return false",false,iter1.hasNext());
    }

    /**
     * Aims to test the hasPrevious() method at the start of a list
     */
    @Test
    public void testHasPreviousStart() {
        assertEquals("Should return false",false,iter1.hasPrevious());
    }

    /**
     * Aims to test the previousIndex() method at the start of a list
     */
    @Test
    public void testPreviousIndexStart() {
        assertEquals("Should return -1",-1,iter1.previousIndex());
    }

    /**
     * Aims to test the nextIndex() method at the end of a list
     */
    @Test
    public void testNextIndexEnd() {
        iter1.right = linkList1.tail;
        iter1.left = linkList1.tail.getPrev();
        iter1.idx = linkList1.size;
        assertEquals("Should return 3",3,iter1.nextIndex());
    }
}
