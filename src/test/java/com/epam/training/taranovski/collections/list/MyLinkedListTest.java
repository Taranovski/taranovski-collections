/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.list;

import com.epam.training.taranovski.collections.exceptions.MyIndexOutOfBoundsException;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oleksandr_Taranovsky
 */
public class MyLinkedListTest {

    /**
     *
     */
    public MyLinkedListTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Test
    public void testDefaultConcstuctor() {
        MyLinkedList<Integer> instance = new MyLinkedList();
        assertTrue(instance.isEmpty());
    }

    /**
     *
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testGetFromEmptyList() {
        MyLinkedList<Integer> instance = new MyLinkedList();
        instance.getFirst();
    }

    /**
     * Test of addFirst method, of class MyLinkedList.
     */
    @Test
    public void testAddFirst() {
        System.out.println("addFirst");
        Integer e1 = 1;
        Integer e2 = 2;
        Integer e3 = 3;
        MyLinkedList<Integer> instance = new MyLinkedList();
        instance.addFirst(e1);
        instance.addFirst(e2);
        instance.addFirst(e3);
        assertTrue(e3 == instance.getFirst());
        assertTrue(e1 == instance.getLast());
        assertTrue(instance.size() == 3);

    }

    /**
     * Test of addLast method, of class MyLinkedList.
     */
    @Test
    public void testAddLast() {
        System.out.println("addLast");
        Integer e1 = 1;
        Integer e2 = 2;
        Integer e3 = 3;
        MyLinkedList<Integer> instance = new MyLinkedList();
        instance.addLast(e1);
        instance.addLast(e2);
        instance.addLast(e3);
        assertTrue(e1 == instance.getFirst());
        assertTrue(e3 == instance.getLast());
        assertTrue(instance.size() == 3);

    }

    /**
     * Test of getFirst method, of class MyLinkedList.
     */
    @Test
    public void testGetFirst() {
        System.out.println("getFirst");
        MyLinkedList<String> instance = new MyLinkedList();
        String expResult = "1";
        instance.add(expResult);
        String result = instance.getFirst();
        assertEquals(expResult, result);

    }

    /**
     * Test of getLast method, of class MyLinkedList.
     */
    @Test
    public void testGetLast() {
        System.out.println("getLast");
        MyLinkedList<String> instance = new MyLinkedList();
        String expResult = "1";
        instance.add(expResult);
        String result = instance.getLast();
        assertEquals(expResult, result);

    }

    /**
     * Test of removeFirst method, of class MyLinkedList.
     */
    @Test
    public void testRemoveFirst() {
        System.out.println("removeFirst");
        MyLinkedList<Integer> instance = new MyLinkedList();
        Integer expResult = 1;
        assertTrue(instance.isEmpty());
        instance.add(expResult);
        assertTrue(!instance.isEmpty());
        Integer result = instance.removeFirst();
        assertEquals(expResult, result);
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of removeLast method, of class MyLinkedList.
     */
    @Test
    public void testRemoveLast() {
        System.out.println("removeLast");
        MyLinkedList<Integer> instance = new MyLinkedList();
        Integer expResult = 1;
        assertTrue(instance.isEmpty());
        instance.add(expResult);
        Integer result = instance.removeLast();
        assertEquals(expResult, result);
        assertEquals(expResult, result);
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of descendingIterator method, of class MyLinkedList.
     */
    @Test
    public void testDescendingIterator() {
        System.out.println("descendingIterator");
        MyLinkedList instance = new MyLinkedList();
        Iterator expResult = null;
        Iterator result = instance.descendingIterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class MyLinkedList.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        MyLinkedList instance = new MyLinkedList();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class MyLinkedList.
     */
    @Test
    public void testAdd_GenericType() {
        System.out.println("add");
        String e = " nulle";
        MyLinkedList<String> instance = new MyLinkedList();
        instance.add("blah");
        instance.add("blah2");
        boolean result = instance.add(e);
        System.out.println(result);
        assertTrue(result);
        assertTrue(instance.getFirst() == "blah");
        assertTrue(instance.getLast() == e);

    }

    /**
     * Test of add method, of class MyLinkedList.
     */
    @Test
    public void testAdd_int_GenericType() {
        System.out.println("add");
        int index = 1;
        String e = " nulle";
        MyLinkedList<String> instance = new MyLinkedList();
        instance.add("blah");
        instance.add("blah2");
        boolean result = instance.add(index, e);
        assertTrue(result);
        assertTrue(instance.getFirst() == "blah");
        assertTrue(instance.getLast() == "blah2");
        assertTrue(instance.get(index) == e);
    }

    /**
     * Test of addAll method, of class MyLinkedList.
     */
    @Test
    public void testAddAll_GenericType() {
        System.out.println("addAll");
        Object[] c = null;
        MyLinkedList instance = new MyLinkedList();
        boolean expResult = false;
        boolean result = instance.addAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class MyLinkedList.
     */
    @Test
    public void testAddAll_int_GenericType() {
        System.out.println("addAll");
        int index = 0;
        Object[] c = null;
        MyLinkedList instance = new MyLinkedList();
        boolean expResult = false;
        boolean result = instance.addAll(index, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class MyLinkedList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        MyLinkedList<String> instance = new MyLinkedList();
        String expResult = "1null";
        instance.add(expResult);
        String result = instance.get(index);
        assertTrue(expResult == result);

    }

    /**
     * Test of remove method, of class MyLinkedList.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        int index = 1;
        MyLinkedList<String> instance = new MyLinkedList();
        String expResult = "dfdhfnull";
        instance.add("111");
        instance.add(expResult);
        instance.add("122");
        
        assertTrue(instance.getFirst() == "111");
        assertTrue(instance.getLast()== "122");
        assertTrue(instance.size() == 3);
        
        String result = instance.remove(index);
        assertTrue(expResult == result);
        
        assertTrue(instance.getFirst() == "111");
        assertTrue(instance.getLast()== "122");
        assertTrue(instance.size() == 2);
        
    }

    /**
     * Test of clear method, of class MyLinkedList.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        MyLinkedList instance = new MyLinkedList();
        Object reference = new Object();
        Object reference1 = new Object();
        Object reference2 = new Object();
        
        assertTrue(instance.isEmpty());
        
        instance.add(reference);
        instance.add(reference1);
        instance.add(reference2);
        assertTrue(!instance.isEmpty());
        assertTrue(instance.size() == 3);
        instance.clear();
        assertTrue(instance.isEmpty());
        
    }

    /**
     * Test of isEmpty method, of class MyLinkedList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        MyLinkedList instance = new MyLinkedList();
        assertTrue(instance.isEmpty());
        instance.add(new Object());
        assertTrue(!instance.isEmpty());
        instance.clear();
        assertTrue(instance.isEmpty());
        instance.add(new Object());
        instance.removeFirst();
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of set method, of class MyLinkedList.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int index = 1;
        String e = "null1";
        MyLinkedList<String> instance = new MyLinkedList();
        boolean expResult = true;

        instance.add("blah");
        instance.add("blahblah");
        instance.add("blahblahblah");

        boolean result = instance.set(index, e);
        assertTrue(result);
        assertTrue(instance.getFirst() == "blah");
        assertTrue(instance.getLast() == "blahblahblah");
        assertTrue(instance.get(index) == e);

    }

    /**
     * Test of indexOf method, of class MyLinkedList.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        Object o = null;
        MyLinkedList instance = new MyLinkedList();
        int expResult = 0;
        int result = instance.indexOf(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class MyLinkedList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        MyLinkedList<Integer> instance = new MyLinkedList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        instance.add(result);
        result = instance.size();
        assertTrue(result == 1);
        instance.add(result);
        result = instance.size();
        assertTrue(result == 2);

    }

    /**
     * Test of toArray method, of class MyLinkedList.
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        MyLinkedList<String> instance = new MyLinkedList();
        String[] expResult = {"111", "2222", "sdafasdf"};
        instance.addAll(expResult);
        
        String[] result = instance.toArray();
        
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of offer method, of class MyLinkedList.
     */
    @Test
    public void testOffer() {
        System.out.println("offer");
        Object e = null;
        MyLinkedList instance = new MyLinkedList();
        boolean expResult = false;
        boolean result = instance.offer(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peek method, of class MyLinkedList.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        MyLinkedList instance = new MyLinkedList();
        Object expResult = null;
        Object result = instance.peek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of poll method, of class MyLinkedList.
     */
    @Test
    public void testPoll() {
        System.out.println("poll");
        MyLinkedList instance = new MyLinkedList();
        Object expResult = null;
        Object result = instance.poll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of push method, of class MyLinkedList.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Object e = null;
        MyLinkedList instance = new MyLinkedList();
        boolean expResult = false;
        boolean result = instance.push(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pop method, of class MyLinkedList.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        MyLinkedList instance = new MyLinkedList();
        Object expResult = null;
        Object result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
