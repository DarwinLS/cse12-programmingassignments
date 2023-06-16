/**
 * Name: Darwin Smith
 * Email: dls002@ucsd.edu
 * PID: A17445596
 * 
 * This file contains all the custom made tests for the MyLinkedList class in
 * MyLinkedList.java. It seeks to test certain inputs for certain methods of
 * the MyLinkedList class.
 */
import java.util.AbstractList;
/**
 * This class contains my implementation of a doubly linked linked list in 
 * java. It includes methods to allow for the ability manipulate the linked
 * list in a variety of ways. It also includes a Node class, which is used
 * when storing elements in the linked list.
 */
public class MyLinkedList<E> extends AbstractList<E> {

    int size;
    Node head;
    Node tail;

    /**
     * A Node class that holds data and references to previous and next Nodes.
     */
    protected class Node {
        E data;
        Node next;
        Node prev;

        /** 
         * Constructor to create singleton Node 
         * @param element Element to add, can be null	
         */
        public Node(E element) {
            // Initialize the instance variables
            this.data = element;
            this.next = null;
            this.prev = null;
        }

        /** 
         * Set the parameter prev as the previous node
         * @param prev new previous node
         */
        public void setPrev(Node prev) {
            this.prev = prev;		
        }

        /** 
         * Set the parameter next as the next node
         * @param next new next node
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /** 
         * Set the parameter element as the node's data
         * @param element new element 
         */
        public void setElement(E element) {
            this.data = element;
        }

        /** 
         * Accessor to get the next Node in the list 
         * @return the next node
         */
        public Node getNext() {
            return this.next;
        }
        /** 
         * Accessor to get the prev Node in the list
         * @return the previous node  
         */
        public Node getPrev() {
            return this.prev;
        } 
        /** 
         * Accessor to get the Nodes Element 
         * @return this node's data
         */
        public E getElement() {
            return this.data;
        } 
    }

    //  Implementation of the MyLinkedList Class
    /**
     * This is the contructor for the MyLinkedList object, serving as a doubly
     * linked list. It does not take any args, initiates the head and tail
     * nodes, and initiates the int size to 0.
     */
    public MyLinkedList() {
        /* Add your implementation here */
        // TODO
        this.head = new Node(null);
        this.tail = new Node(null);
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;
    }

    /**
     * This method returns the int size field of the specific MyLinkedList
     * object
     * @return the int size field of MyLinkedList object
     */
    @Override
    public int size() {
        // need to implement the size method
        // TODO
        return size;
    }

    /**
     * This method returns the element of the node at the specified index arg
     * in the MyLinkedList object.
     * @param index is the index of the node of which the element is desired
     * @return the type E element stored in the node at the index
     */
    @Override
    public E get(int index) {
        // TODO
        Node current = this.head;
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i <= index; i++){
            current = current.getNext();
        }
        return current.getElement();
    }

    /**
     * This method creates a new node with the data arg and inserts it in the
     * MyLinkedList object at the specified index arg
     * @param index is the index at which the new node is to be added
     * @param data is the data that will be stored as the element of the
     * new node
     */
    @Override
    public void add(int index, E data) {
        /* Add your implementation here */
        // TODO
        if (data == null){
            throw new NullPointerException();
        }
        if (index < 0 || index > this.size){
            throw new IndexOutOfBoundsException();
        }
        if (index == size){this.add(data);}
        else{
            Node toAdd = new Node(data);
            Node tempNext = getNth(index);
            Node tempPrev = tempNext.getPrev();
            toAdd.setNext(tempNext);
            toAdd.setPrev(tempPrev);
            tempPrev.setNext(toAdd);
            tempNext.setPrev(toAdd);
            size += 1;
        }
    }

    /**
     * This method creates a new node with the data arg and inserts it at the
     * end of the MyLinkedList object, then returns true.
     * @param data is the data that will be stored as the element of the
     * new node
     * @return the boolean true
     */
    @Override
    public boolean add(E data) {
        // TODO
        if (data == null){
            throw new NullPointerException();
        }
        Node toAdd = new Node(data);
        Node tempPrev = this.tail.getPrev();
        toAdd.setNext(this.tail);
        toAdd.setPrev(tempPrev);
        tempPrev.setNext(toAdd);
        this.tail.setPrev(toAdd);
        size += 1;
        return true;
    }

    /**
     * This method sets the element value of the node at the index arg 
     * in the MyLinkedList object to the data arg and returns the
     * original element
     * @param index is the index of the node for which the element will be
     * given a new value
     * @param data is the value which will be set as the element of the node
     * at the index
     * @return the original element value of the node at the index
     */
    @Override
    public E set(int index, E data) {
        // TODO
        if (data == null){
            throw new NullPointerException();
        }
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        Node nodeToChange = getNth(index);
        E tempData = nodeToChange.getElement();
        nodeToChange.setElement(data);
        return tempData;
    }

    /**
     * This method removes the node at the index arg in the MyLinkedList object
     * and returns the element of that node
     * @param index is the index of the node to be removes from the
     * MyLinkedList object
     * @return the element of the node being removed
     */
    @Override
    public E remove(int index) {
        // TODO
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        Node toRemove = getNth(index);
        Node tempPrev = toRemove.getPrev();
        Node tempNext = toRemove.getNext();
        tempPrev.setNext(tempNext);
        tempNext.setPrev(tempPrev);
        size -= 1;
        return toRemove.getElement();
    }

    /**
     * This method clears the MyLinkedList object, removing all nodes except
     * the head and tail
     */
    @Override
    public void clear() {
        /* Add your implementation here */
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        size = 0;
    }

    /**
     * This method returns true if the MyLinkedList object is 
     * empty based on size and false otherwise
     * @return true or false depending on if size is 0 or not
     */
    @Override
    public boolean isEmpty() {
        // TODO
        if (size == 0){return true;}
        return false;
    }

    /**
     * This method returns the node at the index arg in the MyLinkedList object
     * @param index is the index of the node to be returned
     * @return the node at the index arg
     */
    protected Node getNth(int index) {
        // TODO
        Node current = this.head;
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i <= index; i++){
            current = current.getNext();
        }
        return current;
    }
}
