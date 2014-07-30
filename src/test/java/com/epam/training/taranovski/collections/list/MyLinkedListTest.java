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
        MyLinkedList<String> instance = new MyLinkedList();
        String[] array1 = {"1", "22", "333", "4444"};
        String[] array2 = {"4444", "333", "22", "1"};
        instance.addAll(array1);
        assertTrue(instance.size() == 4);

        Iterator iterator = instance.descendingIterator();
        int i = 0;
        while (iterator.hasNext()) {
            assertTrue(iterator.next() == array2[i]);
            i++;
        }

        iterator = instance.descendingIterator();
        i = 0;
        while (iterator.hasNext()) {
            assertTrue(iterator.next() == array2[i]);
            i++;
        }

        iterator = instance.descendingIterator();
        i = 4;
        while (iterator.hasNext()) {
            assertTrue(instance.size() == i);
            iterator.remove();
            i--;
        }
        assertTrue(instance.isEmpty());

    }

    /**
     * Test of iterator method, of class MyLinkedList.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        MyLinkedList<String> instance = new MyLinkedList();
        String[] array1 = {"1", "22", "333", "4444"};
        String[] array2 = array1;
        instance.addAll(array1);
        assertTrue(instance.size() == 4);

        Iterator iterator = instance.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            assertTrue(iterator.next() == array2[i]);
            i++;
        }

        iterator = instance.iterator();
        i = 0;
        while (iterator.hasNext()) {
            assertTrue(iterator.next() == array2[i]);
            i++;
        }

        iterator = instance.iterator();
        i = 4;
        while (iterator.hasNext()) {
            assertTrue(instance.size() == i);
            iterator.remove();
            i--;
        }
        assertTrue(instance.isEmpty());
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
        MyLinkedList<String> instance = new MyLinkedList();
        String[] expResult = {"111", "2222", "sdafasdf"};

        instance.add("blah");

        boolean result = instance.addAll(expResult);
        assertTrue(result);
        assertTrue(instance.get(1) == "111");
        assertTrue(instance.get(2) == "2222");
        assertTrue(instance.get(3) == "sdafasdf");

    }

    /**
     * Test of addAll method, of class MyLinkedList.
     */
    @Test
    public void testAddAll_int_GenericType() {
        System.out.println("addAll");
        MyLinkedList<String> instance = new MyLinkedList();
        String[] expResult = {"111", "2222", "sdafasdf"};

        instance.add("blah1");
        instance.add("blah2");
        instance.add("blah3");
        instance.add("blah4");

        boolean result = instance.addAll(2, expResult);
        assertTrue(result);
        assertTrue(instance.get(2) == "111");
        assertTrue(instance.get(3) == "2222");
        assertTrue(instance.get(4) == "sdafasdf");
        assertTrue(instance.get(0) == instance.getFirst());
        assertTrue(instance.get(6) == instance.getLast());
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
        assertTrue(instance.getLast() == "122");
        assertTrue(instance.size() == 3);

        String result = instance.remove(index);
        assertTrue(expResult == result);

        assertTrue(instance.getFirst() == "111");
        assertTrue(instance.getLast() == "122");
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
        String o = "null123";
        MyLinkedList<String> instance = new MyLinkedList();
        int expResult = 2;
        instance.add("123");
        instance.add("blahblahblah");
        instance.add(o);
        instance.add("12adfgsdf3");

        int result = instance.indexOf(o);
        assertEquals(expResult, result);
        assertTrue(instance.indexOf("myblah") == -1);

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
        Integer e = 1;
        MyLinkedList<Integer> instance = new MyLinkedList();
        boolean result = instance.offer(e);
        assertTrue(result);
        assertTrue(instance.getFirst() == e);
        assertTrue(instance.getLast() == e);
        Integer e1 = 2;
        result = instance.offer(e1);
        assertTrue(result);
        assertTrue(instance.getFirst() == e);
        assertTrue(instance.getLast() == e1);
        Integer e2 = 3;
        result = instance.offer(e2);
        assertTrue(result);
        assertTrue(instance.getFirst() == e);
        assertTrue(instance.getLast() == e2);
    }

    /**
     * Test of peek method, of class MyLinkedList.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        MyLinkedList<String> instance = new MyLinkedList();
        String expResult = "peek1";

        assertTrue(instance.isEmpty());
        instance.add(expResult);
        assertTrue(!instance.isEmpty());

        String result = instance.peek();
        assertEquals(expResult, result);

    }

    /**
     * Test of poll method, of class MyLinkedList.
     */
    @Test
    public void testPoll() {
        System.out.println("poll");
        MyLinkedList<String> instance = new MyLinkedList();
        String expResult = "null1132123";

        instance.add(expResult);
        instance.add("blah");
        assertTrue(instance.size() == 2);

        String result = instance.poll();
        assertEquals(expResult, result);
        assertTrue(instance.size() == 1);
        assertTrue(instance.getFirst() == "blah");
    }

    /**
     * Test of push method, of class MyLinkedList.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Integer e = 1;
        MyLinkedList<Integer> instance = new MyLinkedList();

        assertTrue(instance.isEmpty());
        boolean result = instance.push(e);
        assertTrue(result);
        assertTrue(!instance.isEmpty());
        assertTrue(instance.getFirst() == e);
        assertTrue(instance.getLast() == e);
        Integer e1 = 2;

        result = instance.push(e1);
        assertTrue(result);
        assertTrue(instance.getFirst() == e);
        assertTrue(instance.getLast() == e1);

    }

    /**
     * Test of pop method, of class MyLinkedList.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        MyLinkedList<String> instance = new MyLinkedList();
        String expResult = "null1";

        assertTrue(instance.isEmpty());
        instance.add(expResult);
        assertTrue(!instance.isEmpty());

        String result = instance.pop();
        assertEquals(expResult, result);
        assertTrue(instance.isEmpty());

    }

    /**
     * Test of set method, of class MyLinkedList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testSet1() {
        System.out.println("set");
        int index = 0;
        Object e = "nuldfsdfl";
        MyLinkedList instance = new MyLinkedList();

        boolean result = instance.set(index, e);
        assertTrue(result);

    }

    /**
     * Test of getFirst method, of class MyLinkedList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testGetFirst1() {
        System.out.println("getFirst");
        MyLinkedList instance = new MyLinkedList();
        Object result = instance.getFirst();

    }

    /**
     * Test of remove method, of class MyLinkedList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testRemove1() {
        System.out.println("remove");
        int index = 0;
        MyLinkedList instance = new MyLinkedList();
        Object result = instance.remove(index);

    }

    /**
     * Test of getLast method, of class MyLinkedList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testGetLast1() {
        System.out.println("getLast");
        MyLinkedList instance = new MyLinkedList();
        Object result = instance.getLast();

    }

    /**
     * Test of peek method, of class MyLinkedList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testPeek1() {
        System.out.println("peek");
        MyLinkedList instance = new MyLinkedList();
        Object result = instance.peek();

    }

    /**
     * Test of toArray method, of class MyLinkedList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testToArray1() {
        System.out.println("toArray");
        MyLinkedList instance = new MyLinkedList();
        Object[] result = instance.toArray();

    }

    /**
     * Test of poll method, of class MyLinkedList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testPoll1() {
        System.out.println("poll");
        MyLinkedList instance = new MyLinkedList();
        Object result = instance.poll();

    }

    /**
     * Test of get method, of class MyLinkedList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testGet1() {
        System.out.println("get");
        int index = 0;
        MyLinkedList instance = new MyLinkedList();
        Object result = instance.get(index);

    }

    /**
     * Test of removeFirst method, of class MyLinkedList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testRemoveFirst1() {
        System.out.println("removeFirst");
        MyLinkedList instance = new MyLinkedList();
        Object result = instance.removeFirst();

    }

    /**
     * Test of removeLast method, of class MyLinkedList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testRemoveLast1() {
        System.out.println("removeLast");
        MyLinkedList instance = new MyLinkedList();
        Object result = instance.removeLast();

    }

    /**
     * Test of add method, of class MyLinkedList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testAdd_int_GenericType1() {
        System.out.println("add");
        int index = 0;
        Object c = null;
        MyLinkedList instance = new MyLinkedList();
        boolean result = instance.add(index, c);

    }

    /**
     * Test of addAll method, of class MyLinkedList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testAddAll_GenericType1() {
        System.out.println("addAll");
        Object[] c = null;
        MyLinkedList instance = new MyLinkedList();
        boolean result = instance.addAll(c);

    }

    /**
     * Test of addAll method, of class MyLinkedList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testAddAll_int_GenericType1() {
        System.out.println("addAll");
        int index = 0;
        Object[] c = null;
        MyLinkedList instance = new MyLinkedList();
        boolean expResult = false;
        boolean result = instance.addAll(index, c);
        
    }

    /**
     * Test of pop method, of class MyLinkedList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testPop1() {
        System.out.println("pop");
        MyLinkedList instance = new MyLinkedList();
        Object result = instance.pop();

    }
}
