/**
 * Name: Darwin Smith
 * Email: dls002@ucsd.edu
 * PID: A17445596
 * 
 * This file contains my tests for the MyDeque, MyStack, and MyQueue classes 
 * that I implemented in other java files. The tests include thorough tests of 
 * the methods of the classes.
 */
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contains all of the tests for the MyDeque, MyStack, and MyQueue
 * classes that I implemented, including tests for their methods.
 */
public class CustomTester {
    /**
     * Tests the MyDeque constructor, including with a negative arg
     */
    @Test
    public void testDequeConstructor(){
        MyDeque<String> deque = new MyDeque<>(5);
        assertEquals("Check if size is 0",0,deque.size);
        assertEquals("Check if front is 0",0,deque.front);
        assertEquals("Check if rear is 0",0,deque.rear);
        assertEquals("Check if data.length is 5",5,deque.data.length);
        try{
            MyDeque<String> deque2 = new MyDeque<>(-3);
            fail();
        }
        catch(IllegalArgumentException e){}
    }

    /**
     * Tests the MyDeque expandCapacity method, including a deque with elements
     * and one without elements
     */
    @Test
    public void testExpandCapacity(){
        MyDeque<String> deque = new MyDeque<>(3);
        deque.data[2] = "first";
        deque.data[0] = "second";
        deque.data[1] = "third";
        deque.front = 2;
        deque.rear = 1;
        deque.size = 3;
        deque.expandCapacity();
        assertEquals("Check if size is double",6,deque.data.length);
        assertEquals("Check if front is 0",0,deque.front);
        assertEquals("Check if rear is 2",2,deque.rear);
        assertEquals("Check if front is first","first",deque.data[0]);
        assertEquals("Check if rear is third","third",deque.data[2]);
        MyDeque<String> deque2 = new MyDeque<>(0);
        deque2.expandCapacity();
        assertEquals("Check if size is 10",10,deque2.data.length);
        assertEquals("Check if front is 0",0,deque2.front);
        assertEquals("Check if rear is 0",0,deque2.rear);
        MyDeque<String> deque3 = new MyDeque<>(3);
        deque3.front = 2;
        deque3.rear = 1;
        deque3.size = 0;
        deque3.expandCapacity();
        assertEquals("Check if rear is 0",0,deque3.rear);
        assertEquals("Check if front 0",0,deque3.front);
    }

    /**
     * Tests the MyDeque addFirst method, including on a deque with some 
     * elements, full of elements, and with a null argument
     */
    @Test
    public void testAddFirst(){
        MyDeque<String> deque = new MyDeque<>(5);
        deque.data[3] = "first";
        deque.data[4] = "second";
        deque.data[0] = "third";
        deque.front = 3;
        deque.rear = 0;
        deque.size = 3;
        deque.addFirst("fourth");
        assertEquals("Check if front is 2",2,deque.front);
        assertEquals("Check if rear is 0",0,deque.rear);
        assertEquals("Check if size is 4",4,deque.size);
        assertEquals("Check if front is fourth","fourth",deque.data[2]);
        assertEquals("Check if rear is third","third",deque.data[0]);
        try{
            deque.addFirst(null);
            fail();
        }
        catch(NullPointerException e){}
        MyDeque<String> deque2 = new MyDeque<>(3);
        deque2.data[1] = "first";
        deque2.data[2] = "second";
        deque2.data[0] = "third";
        deque2.front = 1;
        deque2.rear = 0;
        deque2.size = 3;
        deque2.addFirst("fourth");
        assertEquals("Check if front is 5",5,deque2.front);
        assertEquals("Check if rear is 2",2,deque2.rear);
        assertEquals("Check if size is 4",4,deque2.size);
        assertEquals("Check if front is fourth","fourth",deque2.data[5]);
        assertEquals("Check if rear is third","third",deque2.data[2]);

    }

    /**
     * Tests the MyDeque addLast method, including on a deque with some 
     * elements, full of elements, and with a null argument
     */
    @Test
    public void testAddLast(){
        MyDeque<String> deque = new MyDeque<>(5);
        deque.data[3] = "first";
        deque.data[4] = "second";
        deque.data[0] = "third";
        deque.front = 3;
        deque.rear = 0;
        deque.size = 3;
        deque.addLast("fourth");
        assertEquals("Check if front is 3",3,deque.front);
        assertEquals("Check if rear is 1",1,deque.rear);
        assertEquals("Check if size is 4",4,deque.size);
        assertEquals("Check if front is first","first",deque.data[3]);
        assertEquals("Check if rear is fourth","fourth",deque.data[1]);
        try{
            deque.addLast(null);
            fail();
        }
        catch(NullPointerException e){}
        MyDeque<String> deque2 = new MyDeque<>(3);
        deque2.data[1] = "first";
        deque2.data[2] = "second";
        deque2.data[0] = "third";
        deque2.front = 1;
        deque2.rear = 0;
        deque2.size = 3;
        deque2.addLast("fourth");
        assertEquals("Check if front is 0",0,deque2.front);
        assertEquals("Check if rear is 3",3,deque2.rear);
        assertEquals("Check if size is 4",4,deque2.size);
        assertEquals("Check if front is first","first",deque2.data[0]);
        assertEquals("Check if rear is fourth","fourth",deque2.data[3]);
    }

    /**
     * Tests the MyDeque removeFirst method, including on a deque with elements
     * and without elements
     */
    @Test
    public void testRemoveFirst(){
        MyDeque<String> deque = new MyDeque<>(5);
        deque.data[3] = "first";
        deque.data[4] = "second";
        deque.data[0] = "third";
        deque.front = 3;
        deque.rear = 0;
        deque.size = 3;
        assertEquals("Check if return first","first",deque.removeFirst());
        assertEquals("Check if front is 4",4,deque.front);
        assertEquals("Check if rear is 0",0,deque.rear);
        assertEquals("Check if size is 2",2,deque.size);
        assertEquals("Check if front is second","second",deque.data[4]);
        assertEquals("Check if rear is third","third",deque.data[0]);
        MyDeque<String> deque2 = new MyDeque<>(5);
        assertEquals("Check if return null",null,deque2.removeFirst());
    }

    /**
     * Tests the MyDeque removeLast method, including on a deque with elements
     * and without elements
     */
    @Test
    public void testRemoveLast(){
        MyDeque<String> deque = new MyDeque<>(5);
        deque.data[4] = "first";
        deque.data[0] = "second";
        deque.data[1] = "third";
        deque.front = 4;
        deque.rear = 1;
        deque.size = 3;
        assertEquals("Check if return third","third",deque.removeLast());
        assertEquals("Check if front is 4",4,deque.front);
        assertEquals("Check if rear is 0",0,deque.rear);
        assertEquals("Check if size is 2",2,deque.size);
        assertEquals("Check if front is first","first",deque.data[4]);
        assertEquals("Check if rear is second","second",deque.data[0]);
        MyDeque<String> deque2 = new MyDeque<>(5);
        assertEquals("Check if return null",null,deque2.removeLast());
    }

    /**
     * Tests the MyStack implementation
     */
    @Test
    public void testMyStack(){
        MyStack<String> stack = new MyStack<>(5);
        stack.push("first");
        stack.pop();
        assertTrue(stack.empty());
    }

    /**
     * Tests the MyQueue implementation
     */
    @Test
    public void testMyQueue(){
        MyQueue<String> queue = new MyQueue<>(5);
        queue.enqueue("first");
        queue.enqueue("second");
        assertEquals("Check if the size is 2",2,queue.size());
    }
}
