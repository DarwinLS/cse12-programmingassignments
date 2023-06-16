/**
 * Name: Darwin Smith
 * Email: dls002@ucsd.edu
 * PID: A17445596
 * 
 * This file contains my implementation of a deque which is in the MyDeque
 * class. The class contains the full implementation of the MyDeque.
 */

/**
 * This class implements the DequeInterface and contains all of the instance
 * variables and methods that are part of my deque implementation.
 */
public class MyDeque <E> implements DequeInterface <E>{
    Object[] data;
    int size;
    int rear;
    int front;

    /**
     * This is the constructor for MyDeque objects, which initializes the data
     * array with the argument and initiates the other instance variables. If 
     * the argument is negative, throws an exception
     * @param initialCapacity is the length for the array to be initiated with
     */
    public MyDeque(int initialCapacity){
        if (initialCapacity < 0){throw new IllegalArgumentException();}
        data = new Object[initialCapacity];
        size = 0;
        rear = 0;
        front = 0;
    }

    /**
     * This method returns the number of elements currently added to the deque
     * and excluding nulls
     * @return the int size instance variable, which is the number of elements
     * currently added to the deque and excluding nulls
     */
    public int size(){
        return size;
    }

    /**
     * This method sets the length of the data array instance variable to 10 if
     * it is 0, or doubles it. If there are elements, it transfers them to the 
     * updated array with the same front, rear, and size instance variables,
     * but instead ordered starting from index 0.
     */
    public void expandCapacity(){
        int defaultLength = 10;
        Object[] tempArray = new Object[data.length];
        if (data.length == 0){
            data = new Object[defaultLength];
        }
        else{
            tempArray = data;
            int dbl = 2;
            data = new Object[data.length*dbl];
            int increment = 0;
            for (int i = front; i != rear; i=(i+1)%tempArray.length){
                data[increment] = tempArray[i];
                increment += 1;
            }
            data[increment] = tempArray[rear];
            front = 0;
            if (size == 0){rear = 0;}
            else {
                rear = size-1;
            }
        }
    }

    /**
     * This method takes an argument and adds it to the beginning of the deque,
     * shifting the front instance variable and increasing the size. If the
     * deque is full, calls expandCapacity on itself. If the argument is null,
     * throws an exception
     * @param element is the element to be added to the deque
     */
    public void addFirst(E element){
        if (element == null){throw new NullPointerException();}
        if (data.length == size){this.expandCapacity();}
        if (size == 0){data[0] = element;}
        else{
            if (front == 0){
                data[data.length-1] = element;
                front = data.length-1;
            }
            else{
                data[(front - 1) % data.length] = element;
                front = (front - 1) % data.length;
            }
        }
        size += 1;
    }

    /**
     * This method takes an argument and adds it to the end of the deque,
     * shifting the rear instance variable and increasing the size. If the
     * deque is full, calls expandCapacity on itself. If the argument is null,
     * throws an exception
     * @param element is the element to be added to the deque
     */
    public void addLast(E element){
        if (element == null){throw new NullPointerException();}
        if (data.length == size){this.expandCapacity();}
        if (size == 0){data[0] = element;}
        else{
            data[(rear + 1) % data.length] = element;
            rear = (rear + 1) % data.length;
        }
        size += 1;
    }

    /**
     * This method returns and removes the element at the front instance
     * variable index, replacing it with null and shifting the front instance
     * variable and decreasing the size. If the size already 0, returns null.
     * @return the element at the front instance variable index, or null if 
     * there are none
     */
    public E removeFirst(){
        if (size == 0){return null;}
        Object toReturn = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size -= 1;
        return (E)toReturn;
    }

    /**
     * This method returns and removes the element at the rear instance
     * variable index, replacing it with null and shifting the rear instance
     * variable and decreasing the size. If the size already 0, returns null.
     * @return the element at the rear instance variable index, or null if 
     * there are none
     */
    public E removeLast(){
        if (size == 0){return null;}
        Object toReturn = data[rear];
        data[rear] = null;
        if (rear == 0){rear = data.length-1;}
        else{
            rear = (rear - 1) % data.length;
        }
        size -= 1;
        return (E)toReturn;
    }

    /**
     * This method returns the element at the front instance variable index,
     * consequently returning null if there are no elements.
     */
    public E peekFirst(){
        if (size == 0){return null;}
        return (E)data[front];
    }

    /**
     * This method returns the element at the rear instance variable index,
     * consequently returning null if there are no elements.
     */
    public E peekLast(){
        if (size == 0){return null;}
        return (E)data[rear];
    }
}
