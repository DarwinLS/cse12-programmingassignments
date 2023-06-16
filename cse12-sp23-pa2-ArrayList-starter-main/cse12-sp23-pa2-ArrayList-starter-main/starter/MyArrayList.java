/**
 * Name: Darwin Smith
 * Email: dls002@ucsd.edu
 * PID: A17445596
 * 
 * This file contains the full implementation of MyArrayList, which serves as
 * my own implementation of an ArrayList that includes many of the methods
 */

/**
 * The MyArrayList class is where the constructors for MyArrayList as well as 
 * the methods for the class are implemented.
 */
 public class MyArrayList<E> implements MyList<E>{
    Object[] data;
    int size = 0;
    /**
     * No arg constructor that sets capacity to 5
     */
    public MyArrayList(){
        data = new Object[5];
    }
    /**
     * Constructor that takes @param initialCapacity as the initial capacity
     */
    public MyArrayList(int initialCapacity){
        if (initialCapacity < 0){
            throw new IllegalArgumentException();
        }
        data = new Object[initialCapacity];
    }
    /**
     * Constructor that takes @param arr and sets MyArrayList object equal
     * to the parameter array
     */
    public MyArrayList(E[] arr){
        if (arr == null){data = new Object[5];}
        else{
            size = arr.length;
            data = arr;
        }
    }
    /**
     * method that takes an @param requiredCapacity and increases the capacity
     * of the MyArrayList object by 3 if the current capacity is above 0, sets
     * it to 5 if the current capacity is 0, and if the capacity is still less
     * than requiredCapacity, it sets the capacity to requiredCapacity
     */
    public void expandCapacity(int requiredCapacity){
        int capInc = 3;
        int defaultCap = 5;
        int minCap = 0;
        Object[] tempArr;
        if (requiredCapacity < data.length){
            throw new IllegalArgumentException();
        }
        if (data.length > minCap && requiredCapacity <= data.length + capInc){
            tempArr = data;
            data = new Object[tempArr.length + 3];
            for (int i = 0; i < tempArr.length; i++){
                data[i] = tempArr[i];
            }
        }
        else if (data.length == 0 && requiredCapacity <= defaultCap){
            data = new Object[defaultCap];
        }
        else{
            tempArr = data;
            data = new Object[requiredCapacity];
            for (int i = 0; i < tempArr.length; i++){
                data[i] = tempArr[i];
            }
        }
    }
    /**
     * method that @return the capacity of the MyArrayList object
     */
    public int getCapacity(){
        return data.length;
    }
    /**
     * insets the @param element at the @param index in the MyArrayList
     * object, moving elements after the index up one index.
     */
    public void insert(int index, E element){
        if (index < 0 || index > this.size){
            throw new IndexOutOfBoundsException();
        }
        if (this.size == data.length){
            this.expandCapacity(this.size+1);
        }
        for (int i = this.size; i > index; i--){
            data[i] = data[i-1];
        }
        data[index] = element;
        this.size += 1;
    }
    /**
     * inserts the @param element at the end of the MyArrayList object, 
     * at the current size.
     */
    public void append(E element){
        if (this.size == data.length){
            this.expandCapacity(this.size+1);
        }
        data[size] = element;
        this.size += 1;
    }
    /**
     * inserts the @param element at the first index of the MyArrayList object,
     * pushing elements after the index up one index.
     */
    public void prepend(E element){
        if (this.size == data.length){
            this.expandCapacity(this.size+1);
        }
        for (int i = this.size; i > 0; i--){
            data[i] = data[i-1];
        }
        data[0] = element;
        this.size += 1;
    }
    /**
     * @return the element in the MyArrayList object at @param index
     */
    public E get(int index){
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        return (E)data[index];
    }
    /**
     * @return the element at the @param index of the original MyArrayList
     * object and sets the value at the index to @param element
     */
    public E set(int index, E element){
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        E valAtInd = (E)data[index];
        data[index] = element;
        return valAtInd;
    }
    /**
     * @return the element at @param index, then remove the value at index
     * and shift all elements after the index down 1.
     */
    public E remove(int index){
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        E valAtInd = (E)data[index];
        for (int i = index; i < this.size-1; i++){
            data[i] = data[i+1];
        }
        data[this.size-1] = null;
        this.size -= 1;
        return valAtInd;
    }
    /**
     * @return the size value of the MyArrayList object
     */
    public int size(){
        return this.size;
    }
}
