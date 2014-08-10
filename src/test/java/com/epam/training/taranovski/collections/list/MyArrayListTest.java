/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.list;

import com.epam.training.taranovski.collections.exceptions.MyIndexOutOfBoundsException;
import com.epam.training.taranovski.collections.exceptions.MyIllegalArgumentException;
import java.util.Iterator;
import java.util.NoSuchElementException;
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
public class MyArrayListTest {

    public MyArrayListTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Test
    public void testDefaultConcstuctor() {
        MyArrayList<Integer> instance = new MyArrayList();
        assertTrue(instance.isEmpty());
    }

    /**
     *
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testGetFromEmptyList() {
        MyArrayList<Integer> instance = new MyArrayList();
        instance.get(0);
    }

    /**
     * Test of iterator method, of class MyArrayList.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        MyArrayList<String> instance = new MyArrayList();
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
     * Test of add method, of class MyArrayList.
     */
    @Test
    public void testAdd_GenericType() {
        System.out.println("add");
        String e = " nulle";
        MyArrayList<String> instance = new MyArrayList();
        instance.add("blah");
        instance.add("blah2");
        boolean result = instance.add(e);
        System.out.println(result);
        assertTrue(result);
        assertTrue(instance.get(0) == "blah");
        assertTrue(instance.get(2) == e);

    }

    /**
     * Test of add method, of class MyArrayList.
     */
    @Test
    public void testAdd_int_GenericType() {
        System.out.println("add");
        int index = 1;
        String e = " nulle";
        MyArrayList<String> instance = new MyArrayList();
        instance.add("blah");
        instance.add("blah2");
        boolean result = instance.add(index, e);
        assertTrue(result);
        assertTrue(instance.get(0) == "blah");
        assertTrue(instance.get(2) == "blah2");
        assertTrue(instance.get(index) == e);
    }

    /**
     * Test of addAll method, of class MyArrayList.
     */
    @Test
    public void testAddAll_GenericType() {
        System.out.println("addAll");
        MyArrayList<String> instance = new MyArrayList();
        String[] expResult = {"111", "2222", "sdafasdf"};

        instance.add("blah");

        boolean result = instance.addAll(expResult);
        assertTrue(result);
        assertTrue(instance.get(1) == "111");
        assertTrue(instance.get(2) == "2222");
        assertTrue(instance.get(3) == "sdafasdf");
        assertTrue(instance.size() == 4);

    }

    /**
     * Test of addAll method, of class MyArrayList.
     */
    @Test
    public void testAddAll_int_GenericType() {
        System.out.println("addAll");
        MyArrayList<String> instance = new MyArrayList();
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
        assertTrue(instance.get(0) == "blah1");
        assertTrue(instance.get(6) == "blah4");
    }

    /**
     * Test of get method, of class MyArrayList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        MyArrayList<String> instance = new MyArrayList();
        String expResult = "1null";
        instance.add(expResult);
        String result = instance.get(index);
        assertTrue(expResult == result);

    }

    /**
     * Test of remove method, of class MyArrayList.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        int index = 1;
        MyArrayList<String> instance = new MyArrayList();
        String expResult = "dfdhfnull";
        instance.add("111");
        instance.add(expResult);
        instance.add("122");

        assertTrue(instance.get(0) == "111");
        assertTrue(instance.get(2) == "122");
        assertTrue(instance.size() == 3);

        String result = instance.remove(index);
        assertTrue(expResult == result);

        assertTrue(instance.get(0) == "111");
        assertTrue(instance.get(1) == "122");
        assertTrue(instance.size() == 2);

    }

    /**
     * Test of clear method, of class MyArrayList.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        MyArrayList instance = new MyArrayList();
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
     * Test of isEmpty method, of class MyArrayList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        MyArrayList instance = new MyArrayList();
        assertTrue(instance.isEmpty());
        instance.add(new Object());
        assertTrue(!instance.isEmpty());
        instance.clear();
        assertTrue(instance.isEmpty());
        instance.add(new Object());
        instance.remove(0);
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of set method, of class MyArrayList.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int index = 1;
        String e = "null1";
        MyArrayList<String> instance = new MyArrayList();
        boolean expResult = true;

        instance.add("blah");
        instance.add("blahblah");
        instance.add("blahblahblah");

        boolean result = instance.set(index, e);
        assertTrue(result);
        assertTrue(instance.get(0) == "blah");
        assertTrue(instance.get(2) == "blahblahblah");
        assertTrue(instance.get(index) == e);

    }

    /**
     * Test of indexOf method, of class MyArrayList.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        String o = "null123";
        MyArrayList<String> instance = new MyArrayList();
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
     * Test of size method, of class MyArrayList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        MyArrayList<Integer> instance = new MyArrayList();
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
     * Test of toArray method, of class MyArrayList.
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        MyArrayList<String> instance = new MyArrayList();
        String[] expResult = {"111", "2222", "sdafasdf"};
        instance.addAll(expResult);

        String[] result = (String[]) instance.toArray();

        assertArrayEquals(expResult, result);

    }

    /**
     * Test of set method, of class MyArrayList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testSet1() {
        System.out.println("set");
        int index = 0;
        Object e = "nuldfsdfl";
        MyArrayList instance = new MyArrayList();

        boolean result = instance.set(index, e);
        assertTrue(result);

    }

    /**
     * Test of remove method, of class MyArrayList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testRemove1() {
        System.out.println("remove");
        int index = 0;
        MyArrayList instance = new MyArrayList();
        Object result = instance.remove(index);

    }

    /**
     * Test of toArray method, of class MyArrayList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testToArray1() {
        System.out.println("toArray");
        MyArrayList instance = new MyArrayList();
        Object[] result = instance.toArray();

    }

    /**
     * Test of get method, of class MyArrayList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testGet2() {
        System.out.println("get");
        int index = 0;
        MyArrayList instance = new MyArrayList();
        Object result = instance.get(index);

    }

    /**
     * Test of add method, of class MyArrayList.
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testAdd_int_GenericType1() {
        System.out.println("add");
        int index = 0;
        Object c = null;
        MyArrayList instance = new MyArrayList();
        boolean result = instance.add(index, c);

    }

    /**
     * Test of addAll method, of class MyArrayList.
     */
    @Test(expected = MyIllegalArgumentException.class)
    public void testAddAll_GenericType1() {
        System.out.println("addAll");
        Object[] c = null;
        MyArrayList instance = new MyArrayList();
        boolean result = instance.addAll(c);

    }

    /**
     * Test of addAll method, of class MyArrayList.
     */
    @Test(expected = MyIllegalArgumentException.class)
    public void testAddAll_int_GenericType1() {
        System.out.println("addAll");
        int index = 0;
        Object[] c = null;
        MyArrayList instance = new MyArrayList();
        boolean expResult = false;
        boolean result = instance.addAll(index, c);

    }

    @Test
    public void testAddMuch() {
        System.out.println("addMuch");
        Integer[] array = new Integer[32];
        for (int i = 0; i < 32; i++) {
            array[i] = i;
        }
        MyArrayList<Integer> instance = new MyArrayList();
        for (Integer i : array) {
            instance.add(i);
        }
        assertTrue(instance.size() == 32);
        for (Integer i : array) {
            assertTrue(instance.get(i) == i);
        }

        Iterator<Integer> iterator = instance.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            assertTrue(iterator.next() == i);
            i++;
        }

        iterator = instance.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
        }
        assertTrue(instance.isEmpty());

    }

    @Test
    public void testConstructorWithCollection() {
        MyArrayList<String> instance = new MyArrayList();
        String[] array1 = {"1", "22", "333", "4444"};
        instance.addAll(array1);
        MyArrayList<String> instance1 = new MyArrayList(instance);

        assertTrue(instance1.size() == 4);
        assertTrue(array1[0] == instance1.get(0));
        assertTrue(array1[1] == instance1.get(1));
        assertTrue(array1[2] == instance1.get(2));
        assertTrue(array1[3] == instance1.get(3));

    }

    @Test
    public void testConstructorWithInitialSize() {
        MyArrayList<String> instance = new MyArrayList(4);
        String[] array1 = {"1", "22", "333", "4444"};
        instance.addAll(array1);
        //MyArrayList<String> instance1 = new MyArrayList(instance);

        assertTrue(instance.size() == 4);
        assertTrue(array1[0] == instance.get(0));
        assertTrue(array1[1] == instance.get(1));
        assertTrue(array1[2] == instance.get(2));
        assertTrue(array1[3] == instance.get(3));

    }

    @Test(expected = MyIllegalArgumentException.class)
    public void testConstructorWithInitialSize1() {
        MyArrayList<String> instance = new MyArrayList(-4);
    }

    @Test
    public void testEnsureCapacity() {
        MyArrayList<String> instance = new MyArrayList(4);
        String[] array1 = {"1", "22", "333", "4444"};
        instance.addAll(array1);
        //MyArrayList<String> instance1 = new MyArrayList(instance);

        assertTrue(instance.size() == 4);
        assertTrue(array1[0] == instance.get(0));
        assertTrue(array1[1] == instance.get(1));
        assertTrue(array1[2] == instance.get(2));
        assertTrue(array1[3] == instance.get(3));
        instance.ensureCapacity(10500);
        assertTrue(instance.size() == 4);
    }

    @Test
    public void testTrimToSize() {
        MyArrayList<String> instance = new MyArrayList(4);
        String[] array1 = {"1", "22", "333", "4444"};
        instance.addAll(array1);
        //MyArrayList<String> instance1 = new MyArrayList(instance);

        assertTrue(instance.size() == 4);
        assertTrue(array1[0] == instance.get(0));
        assertTrue(array1[1] == instance.get(1));
        assertTrue(array1[2] == instance.get(2));
        assertTrue(array1[3] == instance.get(3));
        instance.ensureCapacity(10500);
        assertTrue(instance.size() == 4);
        instance.trimToSize();
        assertTrue(instance.size() == 4);
        instance.add("5");
        assertTrue(instance.get(4) == "5");
    }

    @Test
    public void testInternalResizeArray() {
        MyArrayList<Integer> instance = new MyArrayList();
        for (int i = 0; i < 15; i++) {
            instance.add(i);
        }
        instance.add(5, 135);
        instance.add(7, 145);
        assertTrue(instance.get(5) == 135);
        assertTrue(instance.get(6) == 5);
        assertTrue(instance.get(7) == 145);
        assertTrue(instance.get(8) == 6);
    }

    @Test
    public void testInternalResizeArray1() {
        MyArrayList<Integer> instance = new MyArrayList();
        for (int i = 0; i < 15; i++) {
            instance.add(i);
        }

        Integer[] array = new Integer[]{1, 2, 3};

        instance.addAll(6, array);

        assertTrue(instance.get(5) == 5);
        assertTrue(instance.get(6) == 1);
        assertTrue(instance.get(7) == 2);
        assertTrue(instance.get(8) == 3);
        assertTrue(instance.get(9) == 6);
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNextFromEmptyList() {
        MyArrayList<String> instance = new MyArrayList();
        Iterator<String> iterator = instance.iterator();
        iterator.next();
    }

}
