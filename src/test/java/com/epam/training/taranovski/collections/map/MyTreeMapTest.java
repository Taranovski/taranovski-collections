/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.map;

import com.epam.training.taranovski.collections.interfaces.MyMap;
import com.epam.training.taranovski.collections.interfaces.MyMap.MyEntry;
import com.epam.training.taranovski.collections.map.MyTreeMap.MyTreeMapEntry;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Alyx
 */
public class MyTreeMapTest {

    public MyTreeMapTest() {
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
     * Test of clear method, of class MyTreeMap.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        MyTreeMap<String, Integer> instance = new MyTreeMap<>();
        assertTrue(instance.size() == 0);
        assertTrue(instance.isEmpty());
        instance.put("new string", 1);
        assertTrue(instance.size() == 1);
        assertTrue(!instance.isEmpty());
        instance.clear();
        assertTrue(instance.size() == 0);
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of containsKey method, of class MyTreeMap.
     */
    @Test
    public void testContainsKey() {
        System.out.println("containsKey");
        Integer key = 1;
        String val = " my value";
        MyTreeMap<Integer, String> instance = new MyTreeMap<>();
        instance.put(key, val);

        boolean expResult = true;
        boolean result = instance.containsKey(key);
        assertEquals(expResult, result);

        for (int i = 0; i < 20; i++) {
            Iterator<? extends MyEntry<Integer, String>> iterator = instance.entryIterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            System.out.println(i);
            instance.put(i, "myvalue" + i);
        }

        for (int i = 0;
                i < 20; i++) {
            assertTrue(instance.containsKey(i));
        }
    }

    /**
     * Test of containsValue method, of class MyTreeMap.
     */
    @Test
    public void testContainsValue() {
        System.out.println("containsValue");
        Integer key = 1;
        String value = " my value";
        MyTreeMap<Integer, String> instance = new MyTreeMap<>();
        instance.put(key, value);

        boolean expResult = true;
        boolean result = instance.containsValue(value);
        assertEquals(expResult, result);

        for (int i = 0; i < 20; i++) {
            System.out.println(i);
            System.out.println(instance.put(i, ("myvalue" + i)));
        }

        for (int i = 0; i < 20; i++) {
            assertTrue(instance.containsValue("myvalue" + i));

        }

    }

    /**
     * Test of get method, of class MyTreeMap.
     */
//    @Test
//    public void testGet() {
//        System.out.println("get");
//        Object key = null;
//        MyTreeMap instance = new MyTreeMap();
//        Object expResult = null;
//        Object result = instance.get(key);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of isEmpty method, of class MyTreeMap.
//     */
//    @Test
//    public void testIsEmpty() {
//        System.out.println("isEmpty");
//        MyTreeMap instance = new MyTreeMap();
//        boolean expResult = false;
//        boolean result = instance.isEmpty();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of put method, of class MyTreeMap.
//     */
//    @Test
//    public void testPut() {
//        System.out.println("put");
//        Object key = null;
//        Object value = null;
//        MyTreeMap instance = new MyTreeMap();
//        Object expResult = null;
//        Object result = instance.put(key, value);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of remove method, of class MyTreeMap.
//     */
//    @Test
//    public void testRemove() {
//        System.out.println("remove");
//        Object key = null;
//        MyTreeMap instance = new MyTreeMap();
//        Object expResult = null;
//        Object result = instance.remove(key);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of size method, of class MyTreeMap.
//     */
//    @Test
//    public void testSize() {
//        System.out.println("size");
//        MyTreeMap instance = new MyTreeMap();
//        int expResult = 0;
//        int result = instance.size();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of entryIterator method, of class MyTreeMap.
//     */
//    @Test
//    public void testEntryIterator() {
//        System.out.println("entryIterator");
//        MyTreeMap instance = new MyTreeMap();
//        Iterator<? extends MyMap.MyEntry<K, V>> expResult = null;
//        Iterator<? extends MyMap.MyEntry<K, V>> result = instance.entryIterator();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
