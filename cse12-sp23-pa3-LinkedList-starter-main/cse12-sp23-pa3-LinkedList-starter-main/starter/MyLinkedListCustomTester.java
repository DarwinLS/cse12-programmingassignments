/**
 * Name: Darwin Smith
 * Email: dls002@ucsd.edu
 * PID: A17445596
 * 
 * This file contains all the custom made tests for the MyLinkedList class in
 * MyLinkedList.java. It seeks to test certain inputs for certain methods of
 * the MyLinkedList class.
 */
/**
 * IMPORTANT: Do not change the method headers. Your tests will be run against
 * good and bad implementations of MyLinkedList. You will only receive points
 * if your test passes when run on a good implementation and fails for the
 * corresponding bad implementation.
 */

import static org.junit.Assert.*;
import org.junit.*;
/**
 * This class contains all the custom tests used to test certain inputs on
 * certain methods of the MyLinkedList class.
 */
public class MyLinkedListCustomTester {

	// Optional: add test variables here
	private MyLinkedList<String> testLListEmpty;
	private MyLinkedList<String> testLListNonEmpty;
	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */
	@Before
	public void setUp() throws Exception {
		// Optional: add setup here
		testLListEmpty = new MyLinkedList<>();
		testLListNonEmpty = new MyLinkedList<>();
	}

	private void populate() {
        MyLinkedList<String>.Node node0 =  
            this.testLListNonEmpty.new Node("item 1");
        MyLinkedList<String>.Node node1 =  
            this.testLListNonEmpty.new Node("item 2");
        MyLinkedList<String>.Node node2 =  
            this.testLListNonEmpty.new Node("item 3");

        this.testLListNonEmpty.head.next = node0;
        node0.prev = this.testLListNonEmpty.head;
        node0.next = node1;
        node1.prev = node0;
        node1.next = node2;
        node2.prev = node1;
        node2.next = this.testLListNonEmpty.tail;
        this.testLListNonEmpty.tail.prev = node2;
        this.testLListNonEmpty.size = 3;
    }

	/**
	 * Aims to test the add(E data) method with a valid argument.
	 */
	@Test
	public void testCustomAdd() {
		// TODO: add your test here
		this.populate();
		assertEquals("returns true",true,testLListNonEmpty.add("item 4"));
		/*
		assertEquals("Check if length is 1",1,testLListEmpty.size());
		assertEquals("Check if get method returns 'item 1' at index 0",
		"item 1",testLListEmpty.get(0));
		assertEquals("Check if tail points to new node",testLListEmpty.tail.getPrev(),testLListEmpty.getNth(0));
		assertEquals("Check if head points to new node",testLListEmpty.head.getNext(),testLListEmpty.getNth(0));
		assertEquals("Check if new node next points to tail",testLListEmpty.getNth(0).getNext(),testLListEmpty.tail);
		assertEquals("Check if new node prev points to head",testLListEmpty.getNth(0).getPrev(),testLListEmpty.head);
		testLListNonEmpty.add("item 4");
		assertEquals("Check if length is 4",4,testLListNonEmpty.size());
		assertEquals("Check if get method returns 'item 4' at index 3",
		"item 4",testLListNonEmpty.get(3));
		assertEquals("Check if get method returns 'item 4' at index 3",
		"item 3",testLListNonEmpty.get(2));
		assertEquals("Check if get method returns 'item 4' at index 3",
		"item 2",testLListNonEmpty.get(1));
		assertEquals("Check if get method returns 'item 4' at index 3",
		"item 1",testLListNonEmpty.get(0));
		assertEquals("Check if tail previous is new index","item 4",
		testLListNonEmpty.tail.getPrev().getElement());
		assertEquals("Check if previous next points to tail nodes previous",
		testLListNonEmpty.tail.getPrev(),testLListNonEmpty.getNth(2).getNext());
		assertEquals("Check if head next is still item 1","item 1",
		testLListNonEmpty.head.getNext().getElement());
		assertEquals("Check if item 1 prev points to head",testLListNonEmpty.getNth(0).getPrev(),testLListNonEmpty.head);
		testLListNonEmpty.add("item 5");
		assertEquals("Check if length is 5",5,testLListNonEmpty.size());
		assertEquals("Check if get method returns 'item 5' at index 4",
		"item 5",testLListNonEmpty.get(4));
		assertEquals("Check if get method returns 'item 4' at index 3",
		"item 4",testLListNonEmpty.get(3));
		assertEquals("Check if get method returns 'item 4' at index 3",
		"item 3",testLListNonEmpty.get(2));
		assertEquals("Check if get method returns 'item 4' at index 3",
		"item 2",testLListNonEmpty.get(1));
		assertEquals("Check if get method returns 'item 4' at index 3",
		"item 1",testLListNonEmpty.get(0));
		assertEquals("Check if tail previous is new index","item 5",
		testLListNonEmpty.tail.getPrev().getElement());
		try{
			testLListNonEmpty.add(null);
			fail();
		}
		catch(NullPointerException e){}
		*/
	}
	
	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the beginning of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToStart() {
		// TODO: add your test here
		this.populate();
		testLListNonEmpty.add(0,"item 4");
		assertEquals("Check if length is 3",4,testLListNonEmpty.size());
		assertEquals("Check if get method returns 'item 4' at index 0",
		"item 4",testLListNonEmpty.get(0));
	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the middle of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToMiddle() {
		// TODO: add your test here
		this.populate();
		testLListNonEmpty.add(1,"item 4");
		testLListNonEmpty.add(2,"item 5");
		assertEquals("Check if length is 5",5,testLListNonEmpty.size());
		assertEquals("Check if get method returns 'item 5' at index 2",
		"item 5",testLListNonEmpty.get(2));
	}

	/**
	 * Aims to test the remove(int index) method. Remove from an empty list.
	 */
	@Test
	public void testCustomRemoveFromEmpty() {
		// TODO: add your test here
		this.populate();
		try{
			testLListEmpty.remove(0);
			fail();
		}
		catch(IndexOutOfBoundsException e){}
	}

	/**
	 * Aims to test the remove(int index) method.
	 * Remove a valid argument from the middle of MyLinkedList.
	 */
	@Test
	public void testCustomRemoveFromMiddle() {
		// TODO: add your test here
		this.populate();
		assertEquals("Check is return 'item 2'","item 2",testLListNonEmpty.remove(1));
		assertEquals("Check if size is 2",2,testLListNonEmpty.size());
		assertEquals("Check if data at index 1 is item 3","item 3",testLListNonEmpty.get(1));
		assertEquals("Check if first node points to last node",testLListNonEmpty.head.getNext().getNext(),testLListNonEmpty.tail.getPrev());
		assertEquals("Check if last node points to first node",testLListNonEmpty.tail.getPrev().getPrev(),testLListNonEmpty.head.getNext());
	}
	/**
	 * Aims to test the set(int index, E data) method.
	 * Set an out-of-bounds index with a valid data argument.
	 */
	@Test
	public void testCustomSetIdxOutOfBounds() {
		// TODO: add your test here
		this.populate();
		try{
			testLListNonEmpty.set(5,"item 4");
			fail();
		}
		catch(IndexOutOfBoundsException e){}
	}
}
