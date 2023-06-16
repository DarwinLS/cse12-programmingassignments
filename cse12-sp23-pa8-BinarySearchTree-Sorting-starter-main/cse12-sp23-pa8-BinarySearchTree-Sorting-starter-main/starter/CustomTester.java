/**
 * Name: Darwin Smith
 * Email: dls002@ucsd.edu
 * PID: A17445596
 * 
 * This file contains all of my tests for the successor method and MyBST 
 * classes. It includes tests for some of the methods in the implementations 
 * for both.
 */
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * This class contains all of my tests for the different methods in my
 * implementation of the MyBST and successor methods. It also includes a setup
 * method and relevant instance variables.
 */
public class CustomTester {
    MyBST<Integer, Integer> tree;
    MyBST<Integer,Integer> emptyTree;

    /**
     * This method is the setup for the two BST objects that will be used in
     * the tests that follow
     */
    @Before
    public void setup() {
        MyBST.MyBSTNode<Integer, Integer> root =
                new MyBST.MyBSTNode<>(4, 1, null);
        MyBST.MyBSTNode<Integer, Integer> two =
                new MyBST.MyBSTNode<>(2, 1, root);
        MyBST.MyBSTNode<Integer, Integer> six =
                new MyBST.MyBSTNode<>(6, 1, root);
        MyBST.MyBSTNode<Integer, Integer> one =
                new MyBST.MyBSTNode<>(1, 2, two);
        MyBST.MyBSTNode<Integer, Integer> three =
                new MyBST.MyBSTNode<>(3, 30, two);
        MyBST.MyBSTNode<Integer, Integer> five =
                new MyBST.MyBSTNode<>(5, 50, six);

        this.tree = new MyBST<>();
        this.tree.root = root;
        root.setLeft(two);
        root.setRight(six);
        two.setLeft(one);
        two.setRight(three);
        six.setLeft(five);
        tree.size = 6;

        this.emptyTree = new MyBST<>();
        emptyTree.size = 0;
    }

    /**
     * This test method tests the MyBSTNode successor method
     */
    @Test
    public void testSuccessor(){
        MyBST.MyBSTNode<Integer,Integer> curr = tree.root.getLeft().getLeft();
        assertEquals("Successor should be 2",(Integer)2,
        curr.successor().getKey());
        curr = curr.successor();
        assertEquals("Successor should be 3",(Integer)3,
        curr.successor().getKey());
        curr = curr.successor();
        assertEquals("Successor should be 4",(Integer)4,
        curr.successor().getKey());
        curr = curr.successor();
        assertEquals("Successor should be 5",(Integer)5,
        curr.successor().getKey());
        curr = curr.successor();
        assertEquals("Successor should be 6",(Integer)6,
        curr.successor().getKey());
        curr = curr.successor();
        assertEquals("Successor should be null",null,curr.successor());
    }

    /**
     * This test method tests the MyBST insert method
     */
    @Test
    public void testInsert(){
        assertEquals("should return null",null,emptyTree.insert(4, 1));
        assertEquals("root of emptyTree should change",(Integer)4,
        emptyTree.root.getKey());
        assertEquals("size should be 1",1,emptyTree.size);
        assertEquals("should return 1",(Integer)1,emptyTree.insert(4,2));
        assertEquals("value of root should change",(Integer)2,
        emptyTree.root.getValue());
        assertEquals("size should still be 1",1,emptyTree.size);
        assertEquals("should return null",null,tree.insert(7,3));
        assertEquals("size should now be 7",7,tree.size);
        assertEquals("right child of six should be 7",(Integer)7,
        tree.root.getRight().getRight().getKey());
    }

    /**
     * This test method tests the MyBST search method
     */
    @Test
    public void testSearch(){
        assertEquals("should return null",null,emptyTree.search(3));
        assertEquals("should return null",null,tree.search(null));
        assertEquals("should return null",null,tree.search(20));
        assertEquals("should return 50",(Integer)50,tree.search(5));
        assertEquals("should return 30",(Integer)30,tree.search(3));
    }

    /**
     * This test method tests the MyBST remove method
     */
    @Test
    public void testRemove(){
        assertEquals("should return null",null,tree.remove(7));
        assertEquals("should return null",null,tree.remove(null));
        assertEquals("should return 6",(Integer)1,tree.remove(6));
        assertEquals("should return null",null,tree.remove(6));
        assertEquals("should return 50",(Integer)50,tree.remove(5));
        assertEquals("should return 1",(Integer)1,tree.remove(2));
        assertEquals("left child of node should be 3",(Integer)3,
        tree.root.getLeft().getKey());
        assertEquals("left child of node should be 1",(Integer)1,
        tree.root.getLeft().getLeft().getKey());
        assertEquals("right child of node should be null",null,
        tree.root.getRight());
    }

    /**
     * This test method tests the MyBST inorder method
     */
    @Test
    public void testInOrder(){
        ArrayList<MyBST.MyBSTNode<Integer,Integer>> expected = new ArrayList<>();
        expected.add(tree.root.getLeft().getLeft());
        expected.add(tree.root.getLeft());
        expected.add(tree.root.getLeft().getRight());
        expected.add(tree.root);
        expected.add(tree.root.getRight().getLeft());
        expected.add(tree.root.getRight());
        assertEquals("ArrayLists should be same",expected,tree.inorder());
    }
}
