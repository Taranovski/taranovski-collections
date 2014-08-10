/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.util;

import com.epam.training.taranovski.collections.exceptions.MyIllegalArgumentException;
import com.epam.training.taranovski.collections.interfaces.MyList;
import com.epam.training.taranovski.collections.interfaces.MyRandomAccess;
import com.epam.training.taranovski.collections.list.MyArrayList;
import com.epam.training.taranovski.collections.list.MyArrayList;
import com.epam.training.taranovski.collections.list.MyLinkedList;
import com.epam.training.taranovski.collections.list.MyLinkedList;
import com.epam.training.taranovski.collections.util.MyCollections;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alyx
 */
public class MyCollectionsTest {

    public MyCollectionsTest() {
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
     * Test of sort method, of class MyCollections.
     */
    @Test
    public void testSort_MyList() {
        System.out.println("sort");
        MyList<Integer> list = new MyLinkedList();
        list.add(1);
        list.add(10);
        list.add(9);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(8);
        list.add(1);
        list.add(7);
        list.add(1);

        assertTrue(list.size() == 10);

        MyCollections.sort(list);
        System.out.println(Arrays.toString(list.toArray()));

        assertTrue(list.get(0) == 1);
        assertTrue(list.get(1) == 1);
        assertTrue(list.get(2) == 1);
        assertTrue(list.get(3) == 1);
        assertTrue(list.get(4) == 1);
        assertTrue(list.get(5) == 2);
        assertTrue(list.get(6) == 7);
        assertTrue(list.get(7) == 8);
        assertTrue(list.get(8) == 9);
        assertTrue(list.get(9) == 10);

    }

    /**
     * Test of sort method, of class MyCollections.
     */
    @Test
    public void testSort_MyList1() {
        System.out.println("sort");
        MyList<Integer> list = new MyArrayList();
        list.add(1);
        list.add(10);
        list.add(9);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(8);
        list.add(1);
        list.add(7);
        list.add(1);

        assertTrue(list.size() == 10);

        MyCollections.sort(list);

        assertTrue(list.get(0) == 1);
        assertTrue(list.get(1) == 1);
        assertTrue(list.get(2) == 1);
        assertTrue(list.get(3) == 1);
        assertTrue(list.get(4) == 1);
        assertTrue(list.get(5) == 2);
        assertTrue(list.get(6) == 7);
        assertTrue(list.get(7) == 8);
        assertTrue(list.get(8) == 9);
        assertTrue(list.get(9) == 10);

    }

    /**
     *
     */
    class MyObject {

        private int ob;

        /**
         *
         * @param number
         */
        MyObject(int number) {
            ob = number;
        }

        /**
         * @return the ob
         */
        public int getOb() {
            return ob;
        }

        /**
         * @param ob the ob to set
         */
        public void setOb(int ob) {
            this.ob = ob;
        }
    }

    /**
     *
     */
    class MyComparator implements Comparator<MyObject> {

        /**
         *
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(MyObject o1, MyObject o2) {
            return o1.getOb() - o2.getOb();
        }

    }

    /**
     * Test of sort method, of class MyCollections.
     */
    @Test
    public void testSort_MyList_Comparator() {
        System.out.println("sort");

        MyList<MyObject> list = new MyLinkedList<>();
        Comparator<MyObject> c = new MyComparator();

        list.add(new MyObject(1));
        list.add(new MyObject(10));
        list.add(new MyObject(9));
        list.add(new MyObject(1));
        list.add(new MyObject(2));
        list.add(new MyObject(1));
        list.add(new MyObject(8));
        list.add(new MyObject(1));
        list.add(new MyObject(7));
        list.add(new MyObject(1));

        assertTrue(list.size() == 10);

        MyCollections.sort(list, c);

        assertTrue(list.get(0).getOb() == 1);
        assertTrue(list.get(1).getOb() == 1);
        assertTrue(list.get(2).getOb() == 1);
        assertTrue(list.get(3).getOb() == 1);
        assertTrue(list.get(4).getOb() == 1);
        assertTrue(list.get(5).getOb() == 2);
        assertTrue(list.get(6).getOb() == 7);
        assertTrue(list.get(7).getOb() == 8);
        assertTrue(list.get(8).getOb() == 9);
        assertTrue(list.get(9).getOb() == 10);

    }

    /**
     * Test of sort method, of class MyCollections.
     */
    @Test
    public void testSort_MyList_Comparator1() {
        System.out.println("sort");

        MyList<MyObject> list = new MyArrayList<>();
        Comparator<MyObject> c = new MyComparator();

        list.add(new MyObject(1));
        list.add(new MyObject(10));
        list.add(new MyObject(9));
        list.add(new MyObject(1));
        list.add(new MyObject(2));
        list.add(new MyObject(1));
        list.add(new MyObject(8));
        list.add(new MyObject(1));
        list.add(new MyObject(7));
        list.add(new MyObject(1));

        assertTrue(list.size() == 10);

        System.out.println("1");
        MyCollections.sort(list, c);
        System.out.println("2");

        assertTrue(list.get(0).getOb() == 1);
        assertTrue(list.get(1).getOb() == 1);
        assertTrue(list.get(2).getOb() == 1);
        assertTrue(list.get(3).getOb() == 1);
        assertTrue(list.get(4).getOb() == 1);
        assertTrue(list.get(5).getOb() == 2);
        assertTrue(list.get(6).getOb() == 7);
        assertTrue(list.get(7).getOb() == 8);
        assertTrue(list.get(8).getOb() == 9);
        assertTrue(list.get(9).getOb() == 10);

    }

    /**
     * Test of swap method, of class MyCollections.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        MyList<String> list = new MyLinkedList<>();

        String[] array = new String[]{"scr1", "sdadf", "gfvcbgkg", "435435"};
        int size = array.length;
        list.addAll(array);

        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i) == array[i]);
        }

        int i = 0;
        int j = 2;
        MyCollections.swap(list, i, j);

        assertTrue(list.get(0) == array[2]);
        assertTrue(list.get(1) == array[1]);
        assertTrue(list.get(2) == array[0]);
        assertTrue(list.get(3) == array[3]);

    }

    /**
     * Test of swap method, of class MyCollections.
     */
    @Test(expected = MyIllegalArgumentException.class)
    public void testSwap1() {
        System.out.println("swap");
        MyList list = null;
        int i = 0;
        int j = 0;
        MyCollections.swap(list, i, j);

    }

    /**
     * Test of copy method, of class MyCollections.
     */
    @Test
    public void testCopy() {
        System.out.println("copy");
        MyList<String> dest = new MyArrayList();
        MyList<String> src = new MyLinkedList<>();

        src.addAll(new String[]{"scr1", "sdadf", "gfvcbgkg", "435435"});

        MyCollections.copy(dest, src);

        for (int i = 0; i < src.size(); i++) {
            assertTrue(src.get(i) == dest.get(i));
        }

    }

    /**
     * Test of copy method, of class MyCollections.
     */
    @Test(expected = MyIllegalArgumentException.class)
    public void testCopy1() {
        System.out.println("copy");
        MyList dest = null;
        MyList src = null;
        MyCollections.copy(dest, src);

    }

    /**
     * Test of reverse method, of class MyCollections.
     */
    @Test
    public void testReverse() {
        System.out.println("reverse");
        MyList<String> list = new MyLinkedList<>();

        String[] array = new String[]{"scr1", "sdadf", "gfvcbgkg", "435435"};
        int size = array.length;
        list.addAll(array);

        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i) == array[i]);
        }

        MyCollections.reverse(list);

        assertTrue(list.get(0) == array[3]);
        assertTrue(list.get(1) == array[2]);
        assertTrue(list.get(2) == array[1]);
        assertTrue(list.get(3) == array[0]);

    }

    /**
     * Test of reverse method, of class MyCollections.
     */
    @Test(expected = MyIllegalArgumentException.class)
    public void testReverse1() {
        System.out.println("reverse");
        MyList list = null;
        MyCollections.reverse(list);

    }

    /**
     * Test of binarySearch method, of class MyCollections.
     */
    @Test
    public void testBinarySearch() {
        System.out.println("binarySearch");
        MyList<Integer> list = new MyArrayList();

        for (int i = 0; i < 32; i++) {
            list.add(i);
        }

        Integer key = 27;
        int expResult = 27;
        int result = MyCollections.binarySearch(list, key);
        
        assertEquals(expResult, result);
        
        key = 32;
        expResult = -33;
        result = MyCollections.binarySearch(list, key);
        assertEquals(expResult, result);
        
        key = -1;
        expResult = -1;
        result = MyCollections.binarySearch(list, key);
        assertEquals(expResult, result);
        
        key = 15;
        expResult = 15;
        result = MyCollections.binarySearch(list, key);
        assertEquals(expResult, result);
        
        list.remove(15);
        
        key = 15;
        expResult = -16;
        result = MyCollections.binarySearch(list, key);
        assertEquals(expResult, result);

    }

    /**
     * Test of binarySearch method, of class MyCollections.
     */
    @Test(expected = MyIllegalArgumentException.class)
    public void testBinarySearch1() {
        System.out.println("binarySearch");
        MyList list = null;
        Comparable key = null;
        int expResult = 0;
        int result = MyCollections.binarySearch(list, key);
        assertEquals(expResult, result);

    }

}
