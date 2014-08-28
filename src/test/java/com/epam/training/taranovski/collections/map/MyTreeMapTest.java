/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.map;

import com.epam.training.taranovski.collections.exceptions.MyIllegalArgumentException;
import com.epam.training.taranovski.collections.interfaces.MyMap;
import com.epam.training.taranovski.collections.interfaces.MyMap.MyEntry;
import com.epam.training.taranovski.collections.map.MyTreeMap.MyTreeMapEntry;
import java.util.Comparator;
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

        for (int i = 0; i < 2000; i++) {
            instance.put(i, "myvalue" + i);
        }

        for (int i = 0; i < 2000; i++) {
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

        for (int i = 0; i < 2000; i++) {
            instance.put(i, ("myvalue" + i));
        }

        for (int i = 0; i < 2000; i++) {
            assertTrue(instance.containsValue("myvalue" + i));

        }

    }

    /**
     * Test of get method, of class MyTreeMap.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        String key = "blah";
        Integer value = 100500;
        MyTreeMap<String, Integer> instance = new MyTreeMap<>();
        instance.put(key, value);
        int expResult = 100500;
        int result = instance.get(key);
        assertEquals(expResult, result);

    }

    /**
     * Test of isEmpty method, of class MyTreeMap.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        MyTreeMap instance = new MyTreeMap();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);

    }

    /**
     * Test of put method, of class MyTreeMap.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        String key = "blah";
        Integer value = 100501;
        MyTreeMap<String, Integer> instance = new MyTreeMap<>();
        instance.put(key, value);
        int expResult = 100501;
        int result = instance.get(key);
        assertEquals(expResult, result);

    }

    /**
     * Test of remove method, of class MyTreeMap.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        String key = "blah";
        Integer value = 100501;
        MyTreeMap<String, Integer> instance = new MyTreeMap<>();
        assertTrue(instance.isEmpty());
        instance.put(key, value);
        assertFalse(instance.isEmpty());
        int expResult = 100501;
        int result = instance.remove(key);
        assertEquals(expResult, result);
        assertTrue(instance.isEmpty());

    }

    /**
     * Test of size method, of class MyTreeMap.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        MyTreeMap instance = new MyTreeMap();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        instance.put(1, 2);
        expResult = 1;
        result = instance.size();
        assertEquals(expResult, result);

    }

    /**
     * Test of entryIterator method, of class MyTreeMap.
     */
    @Test
    public void testEntryIterator() {
        System.out.println("entryIterator");
        MyTreeMap<Integer, String> instance = new MyTreeMap<>();
        for (int i = 0; i < 2000; i++) {
            instance.put(i, ("myvalue" + i));
        }

        Iterator<? extends MyMap.MyEntry<Integer, String>> iterator = instance.entryIterator();
        int c = 0;
        while (iterator.hasNext()) {
            MyMap.MyEntry<Integer, String> entry = iterator.next();
            assertTrue(entry.getKey() == c);
            assertTrue(("myvalue" + c).equals(entry.getValue()));
            c++;
        }
        assertTrue(instance.size() == 2000);
    }

    /**
     * Test of entryIterator method, of class MyTreeMap.
     */
    @Test
    public void testEntryIterator1() {
        System.out.println("entryIterator");
        MyTreeMap<Integer, String> instance = new MyTreeMap<>();
        for (int i = 0; i < 2000; i++) {
            instance.put(i, ("myvalue" + i));
        }

        Iterator<? extends MyMap.MyEntry<Integer, String>> iterator = instance.entryIterator();
        int c = 0;
        while (iterator.hasNext()) {
            MyMap.MyEntry<Integer, String> entry = iterator.next();
            assertTrue(entry.getKey() == c);
            assertTrue(("myvalue" + c).equals(entry.getValue()));
            iterator.remove();
            c++;
        }
        assertTrue(instance.size() == 0);
    }

    /**
     *
     */
    @Test
    public void testConstructorWithComparator() {
        System.out.println("testConstructorWithComparator");
        MyTreeMap<Integer, String> instance = new MyTreeMap<>(new Comparator<Integer>() {
            /**
             *
             * @param o1
             * @param o2
             * @return
             */
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

        });
        for (int i = 0; i < 2000; i++) {
            instance.put(i, ("myvalue" + i));
        }

        Iterator<? extends MyMap.MyEntry<Integer, String>> iterator = instance.entryIterator();
        int c = 1999;
        while (iterator.hasNext()) {
            MyMap.MyEntry<Integer, String> entry = iterator.next();
            assertTrue(entry.getKey() == c);
            assertTrue(("myvalue" + c).equals(entry.getValue()));
            iterator.remove();
            c--;
        }
        assertTrue(instance.size() == 0);

    }

    /**
     *
     */
    @Test
    public void testPutWithComparator() {
        System.out.println("testPutWithComparator");
        MyTreeMap<Integer, String> instance = new MyTreeMap<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

        });
        for (int i = 0; i < 2000; i++) {
            instance.put(i, ("myvalue" + i));
        }

        for (int i = 0; i < 2000; i++) {
            assertTrue(instance.containsValue("myvalue" + i));
            assertTrue(instance.containsKey(i));
            assertTrue(("myvalue" + i).equals(instance.get(i)));
        }
    }

    /**
     *
     */
    @Test
    public void testPutNullWithComparator() {
        System.out.println("testPutNullWithComparator");
        MyTreeMap<Integer, String> instance = new MyTreeMap<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

        });
        for (int i = 2000; i > -2000; i--) {
            instance.put(i, null);
        }

        for (int i = 0; i <= 2000; i++) {
            assertTrue(instance.containsValue(null));
            assertTrue(instance.containsKey(i));
            assertTrue(instance.get(i) == null);
        }
    }

    /**
     *
     */
    @Test
    public void testPutNullValueWithoutComparator() {
        System.out.println("testPutNullValueWithoutComparator");
        MyTreeMap<Integer, String> instance = new MyTreeMap<>();
        for (int i = 2000; i > -2000; i--) {
            instance.put(i, null);
        }

        for (int i = 0; i <= 2000; i++) {
            assertTrue(instance.containsValue(null));
            assertTrue(instance.containsKey(i));
            assertTrue(instance.get(i) == null);
        }
    }

    /**
     *
     */
    @Test(expected = MyIllegalArgumentException.class)
    public void testPutNullKeyWithoutComparator() {
        System.out.println("testPutNullKeyWithoutComparator");
        MyTreeMap<Integer, String> instance = new MyTreeMap<>();

        instance.put(null, null);
    }
    
    /**
     *
     */
    @Test(expected = MyIllegalArgumentException.class)
    public void testGetNullKeyWithoutComparator() {
        System.out.println("testPutNullKeyWithoutComparator");
        MyTreeMap<Integer, String> instance = new MyTreeMap<>();

        instance.get(null);
    }
    
    /**
     *
     */
    @Test
    public void testRemoveItems() {
        System.out.println("testRemoveItems");
        MyTreeMap<Integer, String> instance = new MyTreeMap<>();
        for (int i = 2000; i >= -2000; i--) {
            instance.put(i, ("myValue" + i));
        }

        for (int i = -2000; i <= 2000; i++) {
            assertTrue(instance.containsValue(("myValue" + i)));
            assertTrue(instance.containsKey(i));
            assertTrue(("myValue" + i).equals(instance.remove(i)));
        }
    }
}
