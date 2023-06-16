/**
 * Name: Darwin Smith
 * Email: dls002@ucsd.edu
 * PID: A17445596
 * 
 * This file contains my implementation of a MinHeap data structure in java,
 * which is contained within the MyMinHeap public class. Inside the class is
 * all the relevant methods and helper methods, as well as instance variables.
 */

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class contains my full implementation of a MinHeap data structure. E 
 * implements Comparable<E> and the class also implements MinHeapInterface<E>. 
 * It contains all of the instance variables and methods for the implementation
 */
public class MyMinHeap<E extends Comparable<E>> implements MinHeapInterface<E>{
    protected ArrayList<E> data;
    private static final int half = 2;
    private static final int dbl = 2;
    private static final int upOneIdx = 1;
    private static final int downOneIdx = 1;

    /**
     * This is a constructor for a MinHeap Object, which initializes the data
     * instance variable to be an empty ArrayList
     */
    public MyMinHeap(){
        data = new ArrayList<>();
    }

    /**
     * This is another constructor for a MinHeap Object, which initializes the
     * data instance variable using the collection argument passed in. If the 
     * collection or any of its elements are null, throws an exception
     * @param collection is the arg used to initialize the ArrayList data 
     * instance variable
     */
    public MyMinHeap(Collection<? extends E> collection){
        if (collection == null || collection.contains(null)){
            throw new NullPointerException();
        }
        data = new ArrayList<>(collection);
        for (int i = data.size()-1; i >= 0; i--){
            this.percolateDown(i);
        }
    }

    /**
     * This method inserts an element to the end of the data instance variable,
     * then calls the percolateUp helper method on the new element to shift it
     * to a position that does not violate heap properties. If the element is
     * null, throws an exception
     * @param element is the element to be added into the heap
     */
    public void insert(E element){
        if (element == null){throw new NullPointerException();}
        data.add(element);
        this.percolateUp(data.size()-1);
    }

    /**
     * This method returns the smallest value in the heap, which is the root
     * of the heap. Returns null if heap is empty
     * @return the root of the heap, which is the smallest value
     */
    public E getMin(){
        if (data.size() == 0){return null;}
        return data.get(0);
    }

    /**
     * This method removes the root of the heap, and then returns the value
     * that was removed. Returns null if heap is empty
     * @return the root of the heap
     */
    public E remove(){
        if (data.size() == 0){return null;}
        return deleteIndex(0);
    }

    /**
     * This method returns the size of the heap
     * @return the size of the heap, using the size method on the data instance
     * variable
     */
    public int size(){
        return data.size();
    }

    /**
     * This method clears the heap by clearing the data instance variable
     */
    public void clear(){
        data.clear();
    }

    /**
     * This helper method swaps the values at two indices of the data instance
     * variable
     * @param from is the first element to be swapped
     * @param to is the second element to be swapped
     */
    protected void swap(int from, int to){
        E temp = data.get(from);
        data.set(from,data.get(to));
        data.set(to,temp);
    }

    /**
     * This helper method returns the parent index of the element at the index
     * argument in the heap. 
     * @param index is the index of the element for which the parent is to be
     * found
     * @return the index of the parent of the element at the index arg
     */
    protected static int getParentIdx(int index){
        return (index-downOneIdx)/half;
    }

    /**
     * This helper method returns the index of the left child of the element at
     * the index arg in the heap
     * @param index is the index of the element for which the left child is to
     * be found
     * @return the index of the left child of the element at the index arg
     */
    protected static int getLeftChildIdx(int index){
        return (index*dbl)+upOneIdx;
    }

    /**
     * This helper method returns the index of the right child of the element at
     * the index arg in the heap
     * @param index is the index of the element for which the right child is to
     * be found
     * @return the index of the right child of the element at the index arg
     */
    protected static int getRightChildIdx(int index){
        return getLeftChildIdx(index)+upOneIdx;
    }

    /**
     * This method returns the smallest child of the element at the index arg
     * in the heap
     * @param index is the index of the element for which the smallest child
     * is to be found
     * @return the index of the smallest child of the element at the index arg
     */
    protected int getMinChildIdx(int index){
        int leftIdx = getLeftChildIdx(index);
        int rightIdx = getRightChildIdx(index);
        if (leftIdx >= data.size()){return -1;}
        if (rightIdx >= data.size()){return leftIdx;}
        else{
            if (data.get(leftIdx).compareTo(data.get(rightIdx)) > 0){
                return rightIdx;
            }
            else{return leftIdx;}
        }
    }

    /**
     * This method moves the element at the index arg up the heap until it no
     * longer violates heap properties by swapping with the parent
     * @param index is the index of the element to be percolated up in the heap
     */
    protected void percolateUp(int index){
        if (index == 0){return;}
        int parIdx = getParentIdx(index);
        while (data.get(parIdx).compareTo(data.get(index)) > 0){
            this.swap(index,parIdx);
            index = parIdx;
            if (index == 1){return;}
            parIdx = getParentIdx(index);
        }
    }

    /**
     * This method moves the element at the index arg down the heap until it no
     * longer violates heap properties by swapping with the smallest child
     * @param index is the index of the element to be percolated down in the heap
     */
    protected void percolateDown(int index){
        int minChildIdx = getMinChildIdx(index);
        if (minChildIdx == -1){return;}
        while (data.get(index).compareTo(data.get(minChildIdx)) > 0){
            this.swap(index,minChildIdx);
            index = minChildIdx;
            minChildIdx = getMinChildIdx(index);
            if (minChildIdx == -1){return;}
        }
    }

    /**
     * This method swaps in the last element of the heap with the element at
     * the index arg, then removes the element previously at the index and
     * returns it. It then calls percolate up and percolate down helper methods
     * to shift the swapped in element up or down the heap until heap
     * properties are not violated.
     * @param index is the index of the element to be removed and returned from
     * the heap
     * @return the element at the index arg
     */
    protected E deleteIndex(int index){
        E temp = data.get(index);
        data.set(index,data.get(data.size()-1));
        data.remove(data.size()-1);
        this.percolateDown(index);
        this.percolateUp(index);
        return temp;
    }
}
