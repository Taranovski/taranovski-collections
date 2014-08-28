/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.map;

import com.epam.training.taranovski.collections.exceptions.MyNoSuchElementException;
import com.epam.training.taranovski.collections.interfaces.MyMap;
import com.epam.training.taranovski.collections.interfaces.MyMap.MyEntry;
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
        MyHashMap<String, Integer> instance = new MyHashMap<>();

        assertTrue(instance.size() == 0);

        instance.put("hello", 1);

        assertTrue(instance.size() == 1);
        assertTrue(instance.containsKey("hello"));
        assertTrue(instance.containsValue(1));
        assertTrue(instance.get("hello") == 1);

        instance.clear();
        assertTrue(instance.size() == 0);
        assertFalse(instance.containsKey("hello"));
        assertFalse(instance.containsValue(1));

    }

    /**
     * Test of containsKey method, of class MyHashMap.
     */
    @Test
    public void testContainsKey() {
        System.out.println("containsKey");
        String key = "hello";
        MyHashMap<String, Integer> instance = new MyHashMap<>();

        instance.put("hello", 1);

        boolean expResult = true;
        boolean result = instance.containsKey(key);
        assertEquals(expResult, result);

        expResult = false;
        result = instance.containsKey("key");
        assertEquals(expResult, result);

    }

    /**
     * Test of containsValue method, of class MyHashMap.
     */
    @Test
    public void testContainsValue() {
        System.out.println("containsValue");
        Integer value = 12345;
        MyHashMap<String, Integer> instance = new MyHashMap<>();

        instance.put("hello", 12345);

        boolean expResult = true;
        boolean result = instance.containsValue(value);
        assertEquals(expResult, result);

        expResult = false;
        result = instance.containsValue(1);
        assertEquals(expResult, result);

    }

    /**
     * Test of get method, of class MyHashMap.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        String key = "nulel";
        MyHashMap<String, Integer> instance = new MyHashMap<>();
        instance.put(key, 1);
        Integer expResult = 1;
        Integer result = instance.get(key);
        assertEquals(expResult, result);

    }

    /**
     * Test of get method, of class MyHashMap.
     */
    @Test(expected = MyNoSuchElementException.class)
    public void testGetNoElement() {
        System.out.println("get");
        String key = "nulel";
        MyHashMap<String, Integer> instance = new MyHashMap<>();

        Integer result = instance.get(key);

    }

    /**
     * Test of isEmpty method, of class MyHashMap.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        MyHashMap instance = new MyHashMap();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);

    }

    /**
     * Test of put method, of class MyHashMap.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        String key = "blah";
        Integer value = 1;
        MyHashMap<String, Integer> instance = new MyHashMap<>();
        Integer expResult = null;
        Integer result = instance.put(key, value);
        assertEquals(expResult, result);

        expResult = value;
        result = instance.put(key, 2);
        assertEquals(expResult, result);

        expResult = 2;
        result = instance.put(key, 3);
        assertEquals(expResult, result);

    }

    /**
     * Test of remove method, of class MyHashMap.
     */
    @Test(expected = MyNoSuchElementException.class)
    public void testRemove() {
        System.out.println("remove");
        String key = "null1";
        MyHashMap instance = new MyHashMap();

        Object result = instance.remove(key);

    }

    /**
     * Test of size method, of class MyHashMap.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        MyHashMap<String, Integer> instance = new MyHashMap();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);

        instance.put("blah", 1);
        expResult = 1;
        result = instance.size();
        assertEquals(expResult, result);

        instance.put("blah1", 2);
        expResult = 2;
        result = instance.size();
        assertEquals(expResult, result);

        expResult = 1;
        result = instance.remove("blah");
        assertEquals(expResult, result);

        expResult = 1;
        result = instance.size();
        assertEquals(expResult, result);

    }

    /**
     * Test of entryIterator method, of class MyHashMap.
     */
    @Test
    public void testEntryIterator() {
        System.out.println("entryIterator");
        MyHashMap<String, Integer> instance = new MyHashMap<>();

        instance.put("1", 1);
        instance.put("2", 2);
        instance.put("3", 3);
        instance.put("4", 4);
        instance.put("5", 5);
        instance.put("6", 6);

        assertTrue(instance.size() == 6);

        Iterator<? extends MyMap.MyEntry<String, Integer>> iterator = instance.entryIterator();
        while (iterator.hasNext()) {
            iterator.remove();
        }

        assertTrue(instance.size() == 0);
    }

    /**
     *
     */
    @Test
    public void testConstructorWithCapacity() {
        System.out.println("testConstructorWithCapacity");
        MyHashMap<String, Integer> instance = new MyHashMap<>(100500);
        
        for (int i = 0; i < 10000; i++) {
            instance.put("blah" + i, i);
        }

        for (int i = 0; i < 10000; i++) {
            assertTrue(instance.get("blah" + i) == i);
        }
    }

    /**
     *
     */
    @Test
    public void testEnsureCapacity() {
        System.out.println("testEnsureCapacity");
        MyHashMap<String, Integer> instance = new MyHashMap<>();
        instance.put("blah", 100500);

        assertTrue(instance.containsKey("blah"));

        for (int i = 0; i < 200; i++) {
            instance.put("" + i, i);
        }

        assertTrue(instance.containsKey("blah"));

        assertTrue(instance.containsValue(100500));
        assertTrue(instance.get("blah") == 100500);

    }

    /**
     *
     */
    @Test(expected = MyNoSuchElementException.class)
    public void testNextFromIteratorOutOfMap() {
        System.out.println("testNextFromIteratorOutOfMap");
        MyHashMap<String, Integer> instance = new MyHashMap<>();
        Iterator<? extends MyEntry<String, Integer>> iterator = instance.entryIterator();
        iterator.next();
    }

    /**
     *
     */
    @Test(expected = MyNoSuchElementException.class)
    public void testRemoveFromIteratorOutOfMap() {
        System.out.println("testRemoveFromIteratorOutOfMap");
        MyHashMap<String, Integer> instance = new MyHashMap<>();
        Iterator<? extends MyEntry<String, Integer>> iterator = instance.entryIterator();
        iterator.remove();
    }

    /**
     *
     */
    @Test
    public void testConstructorWithLoadFactor() {
        System.out.println("testConstructorWithLoadFactor");
        int initialCapacity = 10;
        double loadFactor = 0.5;
        MyHashMap<String, Integer> instance = new MyHashMap<>(initialCapacity, loadFactor);

        for (int i = 0; i < 10000; i++) {
            instance.put("blah" + i, i);
        }

        for (int i = 0; i < 10000; i++) {
            assertTrue(instance.get("blah" + i) == i);
        }
    }
}
