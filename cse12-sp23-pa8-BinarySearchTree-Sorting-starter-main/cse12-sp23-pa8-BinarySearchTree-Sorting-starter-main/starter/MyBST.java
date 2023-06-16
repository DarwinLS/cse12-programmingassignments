/**
 * Name: Darwin Smith
 * Email: dls002@ucsd.edu
 * PID: A17445596
 * 
 * This file contains my implementation of a Binary Search Tree, which is
 * inside the MyBST class. It contains the methods and nested class MyBSTNode
 * that are relevant to the implementation
 */
import java.util.ArrayList;

/**
 * This class contains the full implementation of the Binary Search Tree,
 * including all instance variables, methods, and the nested MyBSTNode class
 * for the Nodes that go in the tree
 */
public class MyBST<K extends Comparable<K>, V> {
    MyBSTNode<K, V> root = null;
    int size = 0;

    /**
     * returns the size of the MyBST object
     * @return the size of the MyBST object, which is the number of nodes
     */
    public int size() {
        return size;
    }

    /**
     * This method inserts a new node with the key and value args in its
     * correct spot in the BST. If there is already a node in the tree with the
     * same key, it replaces that nodes value with the value arg and returns 
     * the previous value. When there is no replacement, it returns null.
     * @param key is the key to be assigned to the new node
     * @param value is the value to be assigned to the new node
     * @return the previous value instance variable of the MyBSTNode object if
     * it is being replaced, or null otherwise
     */
    public V insert(K key, V value) {
        int zero = 0;
        if (key == null){throw new NullPointerException();}
        if (size == zero){
            root = new MyBSTNode<K,V>(key,value,null);
            size += 1;
            return null;
        }
        MyBSTNode<K,V> curr = this.root;
        while (curr != null){
            if (key.compareTo(curr.getKey()) < zero){
                if (curr.getLeft() == null){
                    size += 1;
                    MyBSTNode<K,V> add = new MyBSTNode<>(key,value,curr);
                    curr.setLeft(add);
                    return null;
                }
                curr = curr.getLeft();
            }
            else if (key.compareTo(curr.getKey()) > zero){
                if (curr.getRight() == null){
                    size += 1;
                    MyBSTNode<K,V> add = new MyBSTNode<>(key,value,curr);
                    curr.setRight(add);
                    return null;
                }
                curr = curr.getRight();
            }
            else {
                break;
            }
        }
        V temp = curr.getValue();
        curr.setValue(value);
        return temp;
    }

    /**
     * This method returns the value instance variable of the MyBSTNode that
     * matches the key argument provided in the tree, or null if the Node isn't
     * found
     * @param key is the key of the Node to be searched for
     * @return the value instance variable of the found Node, or null otherwise
     */
    public V search(K key) {
        int zero = 0;
        if (key == null || size == zero){return null;}
        MyBSTNode<K,V> curr = this.root;
        while (curr != null){
            if (key.compareTo(curr.getKey()) == zero){
                return curr.getValue();
            }
            if (key.compareTo(curr.getKey()) < zero){
                curr = curr.getLeft();
            }
            else {curr = curr.getRight();}
        }
        return null;
    }

    /**
     * This method removes the MyBSTNode matching the provided key arg, and
     * shifts the positions of relevant Nodes so the structure of the tree is
     * still correct. It returns the value instance variable of the MyBSTNode
     * object being removed, or null if the Node is not found
     * @param key is the key of the Node to be searched for and removed
     * @return the value instance variable of the Node being removed, or null
     * otherwise
     */
    public V remove(K key) {
        int zero = 0;
        boolean left = true;
        boolean isRoot = true;
        V toReturn = null;
        if (key == null || size == zero){return null;}
        MyBSTNode<K,V> curr = this.root;
        while (curr != null){
            if (key.compareTo(curr.getKey()) == zero){
                size -= 1;
                toReturn = curr.getValue();
                if (curr.getLeft() == null && curr.getRight() == null){
                    if (isRoot){
                        this.root = null;
                    }
                    else{
                        if (left){
                            curr.getParent().setLeft(null);
                        }
                        else {
                            curr.getParent().setRight(null);
                        }
                    }
                }
                else if (curr.getLeft() != null && curr.getRight() == null){
                    curr.getLeft().setParent(curr.getParent());
                    if (isRoot){
                        this.root = curr.getLeft();
                    }
                    else{
                        if (left){
                            curr.getParent().setLeft(curr.getLeft());
                        }
                        else {
                            curr.getParent().setRight(curr.getLeft());
                        }
                    }
                }
                else if (curr.getLeft() == null && curr.getRight() != null){
                    curr.getRight().setParent(curr.getParent());
                    if (isRoot){
                        this.root = curr.getRight();
                    }
                    else{
                        if (left){
                            curr.getParent().setLeft(curr.getRight());
                        }
                        else {
                            curr.getParent().setRight(curr.getRight());
                        }
                    }
                }
                else {
                    curr.setKey(curr.successor().getKey());
                    curr.setValue(curr.successor().getValue());
                    remove(curr.getKey());
                }
            }
            if (key.compareTo(curr.getKey()) < zero){
                curr = curr.getLeft();
                left = true;
            }
            else {
                curr = curr.getRight();
                left = false;
            }
            isRoot = false;
        }
        return toReturn;
    }

    /**
     * This method returns an ArrayList of the MyBSTNode objects in the tree in
     * order of their keys from smallest to greatest, using the successor
     * method
     * @return an ArrayList of the MyBSTNode objects ordered from least to
     * greatest in terms of keys
     */
    public ArrayList<MyBSTNode<K, V>> inorder() {
        MyBSTNode<K,V> curr = this.root;
        ArrayList<MyBSTNode<K,V>> toReturn = new ArrayList<>();
        while (curr.getLeft() != null){
            curr = curr.getLeft();
        }
        while (curr != null){
            toReturn.add(curr);
            curr = curr.successor();
        }
        return toReturn;
    }

    /**
     * This nested class contains the full implementation of the MyBSTNode
     * object to be used as the Node in the BST. Includes the relevant instance
     * variables and methods
     */
    static class MyBSTNode<K, V> {
        private static final String TEMPLATE = "Key: %s, Value: %s";
        private static final String NULL_STR = "null";

        private K key;
        private V value;
        private MyBSTNode<K, V> parent;
        private MyBSTNode<K, V> left = null;
        private MyBSTNode<K, V> right = null;

        /**
         * Creates a MyBSTNode storing specified data
         *
         * @param key    the key the MyBSTNode will store
         * @param value  the data the MyBSTNode will store
         * @param parent the parent of this node
         */
        public MyBSTNode(K key, V value, MyBSTNode<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        /**
         * Return the key stored in the the MyBSTNode
         *
         * @return the key stored in the MyBSTNode
         */
        public K getKey() {
            return key;
        }

        /**
         * Set the key stored in the MyBSTNode
         *
         * @param newKey the key to be stored
         */
        public void setKey(K newKey) {
            this.key = newKey;
        }

        /**
         * Return data stored in the MyBSTNode
         *
         * @return the data stored in the MyBSTNode
         */
        public V getValue() {
            return value;
        }

        /**
         * Set the data stored in the MyBSTNode
         *
         * @param newValue the data to be stored
         */
        public void setValue(V newValue) {
            this.value = newValue;
        }

        /**
         * Return the parent
         *
         * @return the parent
         */
        public MyBSTNode<K, V> getParent() {
            return parent;
        }

        /**
         * Set the parent
         *
         * @param newParent the parent
         */
        public void setParent(MyBSTNode<K, V> newParent) {
            this.parent = newParent;
        }

        /**
         * Return the left child
         *
         * @return left child
         */
        public MyBSTNode<K, V> getLeft() {
            return left;
        }

        /**
         * Set the left child
         *
         * @param newLeft the new left child
         */
        public void setLeft(MyBSTNode<K, V> newLeft) {
            this.left = newLeft;
        }

        /**
         * Return the right child
         *
         * @return right child
         */
        public MyBSTNode<K, V> getRight() {
            return right;
        }

        /**
         * Set the right child
         *
         * @param newRight the new right child
         */
        public void setRight(MyBSTNode<K, V> newRight) {
            this.right = newRight;
        }

        /**
         * This method returns the successor node of THIS MyBSTNode object. If
         * there is no successor, returns null
         * @return the successor node of this node, or null otherwise
         */
        public MyBSTNode<K, V> successor() {
            if (this.getRight() != null){
                MyBSTNode<K,V> curr = this.getRight();
                while (curr.getLeft() != null){
                    curr = curr.getLeft();
                }
                return curr;
            }
            else{
                MyBSTNode<K,V> curr = this;
                MyBSTNode<K,V> parent = this.getParent();
                while (parent != null && curr == parent.getRight()){
                    curr = parent;
                    parent = curr.getParent();
                }
                return parent;
            }
        }

        /**
         * This method compares if two node objects are equal.
         *
         * @param obj The target object that the currect object compares to.
         * @return Boolean value indicates if two node objects are equal
         */
        public boolean equals(Object obj) {
            if (!(obj instanceof MyBSTNode))
                return false;

            MyBSTNode<K, V> comp = (MyBSTNode<K, V>) obj;

            return ((this.getKey() == null ? comp.getKey() == null :
                    this.getKey().equals(comp.getKey()))
                    && (this.getValue() == null ? comp.getValue() == null :
                    this.getValue().equals(comp.getValue())));
        }

        /**
         * This method gives a string representation of node object.
         *
         * @return "Key:Value" that represents the node object
         */
        public String toString() {
            return String.format(
                    TEMPLATE,
                    this.getKey() == null ? NULL_STR : this.getKey(),
                    this.getValue() == null ? NULL_STR : this.getValue());
        }
    }

}
