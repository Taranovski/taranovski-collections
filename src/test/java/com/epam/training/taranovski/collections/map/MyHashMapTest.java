/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.training.taranovski.collections.map;

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
public class MyHashMapTest {
    
    public MyHashMapTest() {
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
     * Test of clear method, of class MyHashMap.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        MyHashMap instance = new MyHashMap();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of containsKey method, of class MyHashMap.
     */
    @Test
    public void testContainsKey() {
        System.out.println("containsKey");
        Object key = null;
        MyHashMap instance = new MyHashMap();
        boolean expResult = false;
        boolean result = instance.containsKey(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of containsValue method, of class MyHashMap.
     */
    @Test
    public void testContainsValue() {
        System.out.println("containsValue");
        Object value = null;
        MyHashMap instance = new MyHashMap();
        boolean expResult = false;
        boolean result = instance.containsValue(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class MyHashMap.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Object key = null;
        MyHashMap instance = new MyHashMap();
        Object expResult = null;
        Object result = instance.get(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class MyHashMap.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        MyHashMap instance = new MyHashMap();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of put method, of class MyHashMap.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        Object key = null;
        Object value = null;
        MyHashMap instance = new MyHashMap();
        Object expResult = null;
        Object result = instance.put(key, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class MyHashMap.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object key = null;
        MyHashMap instance = new MyHashMap();
        Object expResult = null;
        Object result = instance.remove(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class MyHashMap.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        MyHashMap instance = new MyHashMap();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of entryIterator method, of class MyHashMap.
     */
    @Test
    public void testEntryIterator() {
        System.out.println("entryIterator");
        MyHashMap instance = new MyHashMap();
        //Iterator<? extends MyMap.MyEntry<K, V>> expResult = null;
        //Iterator<? extends MyMap.MyEntry<K, V>> result = instance.entryIterator();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
