/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.map;

import com.epam.training.taranovski.collections.exceptions.MyNoSuchElementException;
import com.epam.training.taranovski.collections.interfaces.MyMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;

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

    @Test
    public void testConstructorWithCapacity() {
        MyHashMap<String, Integer> instance = new MyHashMap<>(100500);
    }

    @Test
    public void testEnsureCapacity() {
        MyHashMap<String, Integer> instance = new MyHashMap<>();
        instance.put("blah", 1005);
        for (int i = 0; i < 200; i++) {
            instance.put("" + i, i);
        }

        assertTrue(instance.containsKey("blah"));
        System.out.println("blah get: " + instance.get("blah"));

        for (int i = 0; i < 200; i++) {
            System.out.println("get number: " + i + "" + instance.get("" + i));
        }

        assertTrue(instance.containsValue(100500));
        assertTrue(instance.get("blah") == 100500);

    }
}
