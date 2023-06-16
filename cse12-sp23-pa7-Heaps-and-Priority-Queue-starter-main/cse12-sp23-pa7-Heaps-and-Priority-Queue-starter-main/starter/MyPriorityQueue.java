/**
 * Name: Darwin Smith
 * Email: dls002@ucsd.edu
 * PID: A17445596
 * 
 * This file contains my implementation of a PriorityQueue in java inside the 
 * MyPriorityQueue class using my implementation of the MinHeap. The class 
 * contains the instance variables and relevant methods for the implementation
 */
import java.util.Collection;

/**
 * This class contains the implementation of the PriorityQueue. E implements
 * Comparable<E>
 */
public class MyPriorityQueue<E extends Comparable<E>>{
    protected MyMinHeap<E> heap;

    /**
     * This is the constructor for a MyPriorityQueue Object. It initializes the
     * MyMinHeap instance variable as empty
     */
    public MyPriorityQueue(){
        heap = new MyMinHeap<>();
    }

    /**
     * This is the constructor for a MyPriorityQueue Object. It initializes the
     * MyMinHeap instance variable using the collection argument.
     * @param collection is the collection to be used to initialize the heap 
     * instance variable
     */
    public MyPriorityQueue(Collection<? extends E> collection){
        heap = new MyMinHeap<>(collection);
    }

    /**
     * This method adds elements to the priorityqueue using the MinHeap insert
     * method, which adds the element and then percolates it up until no heap
     * properties are violated
     * @param element is the element to be added to the PriorityQueue
     */
    public void push(E element){
        heap.insert(element);
    }

    /**
     * This method returns the first element in the PriorityQueue, which is
     * the root and smallest element in the MinHeap instance variable
     * @return the first element in the PriorityQueue, which is the root of
     * the MinHeap
     */
    public E peek(){
        return heap.getMin();
    }

    /**
     * This method removes and returns the first element in the PriorityQueue,
     * which uses the MinHeap remove method to remove and return the root of 
     * the MinHeap.
     * @return the first element in the PriorityQueue, which is the root of the
     * MinHeap instance variable
     */
    public E pop(){
        return heap.remove();
    }

    /**
     * This method returns the length of the PriorityQueue, which uses the size
     * method of the MinHeap.
     * @return the length of the PriorityQueue using the MinHeap size method on
     * the MinHeap instance variable
     */
    public int getLength(){
        return heap.size();
    }

    /**
     * This method clears the priorityQueue using the MinHeap clear method
     */
    public void clear(){
        heap.clear();
    }
}
