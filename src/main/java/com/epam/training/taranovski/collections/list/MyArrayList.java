/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.list;

import com.epam.training.taranovski.collections.exceptions.MyIndexOutOfBoundsException;
import com.epam.training.taranovski.collections.interfaces.MyList;
import com.epam.training.taranovski.collections.interfaces.MyRandomAccess;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author user
 * @param <T>
 */
public class MyArrayList<T> implements MyList<T>, MyRandomAccess {

    private final int DEFAULT_CAPACITY = 16;
    private final double CAPACITY_INCREASE_FACTOR = 0.5;
    private int capacity;
    private int size;
    private Object[] array;

    /**
     * default constructor
     */
    public MyArrayList() {
        capacity = DEFAULT_CAPACITY;
        size = 0;
        array = new Object[capacity];
    }

    /**
     * constructor from another my list
     *
     * @param c a list of values to create from
     */
    public MyArrayList(MyList<T> c) {
        size = c.size();
        capacity = (int) (size + size * CAPACITY_INCREASE_FACTOR);
        array = new Object[capacity];
        for (T item : c) {
            this.add(item);
        }
    }

    /**
     * constructor with initian capacity
     *
     * @param initialCapacity initial capacity
     */
    public MyArrayList(int initialCapacity) {
        capacity = initialCapacity;
        size = 0;
        array = new Object[capacity];

    }

    /**
     * ensures a given capacity
     *
     * @param minCapacity capacity to ensure
     */
    public void ensureCapacity(int minCapacity) {
        if (capacity < minCapacity) {
            capacity = minCapacity;
            Object[] temp = array;
            array = new Object[capacity];

            System.arraycopy(temp, 0, array, 0, temp.length);
        }
    }

    /**
     *
     */
    public void trimToSize() {
        if (capacity > size) {
            capacity = size;
            Object[] temp = array;
            array = new Object[capacity];

            System.arraycopy(temp, 0, array, 0, capacity);
        }

    }

    /**
     * add an element to list
     * @param e element to add
     * @return if add operation was successfull
     */
    @Override
    public boolean add(T e) {
        if (size == capacity) {
            capacity = (int) (size + size * CAPACITY_INCREASE_FACTOR);
            Object[] temp = array;
            array = new Object[capacity];

            System.arraycopy(temp, 0, array, 0, temp.length);
        }
        array[size] = e;
        size++;
        return array[size - 1] == e;
    }

    /**
     *
     * @param index
     * @param e
     * @return
     */
    @Override
    public boolean add(int index, T e) {
        if (index < 0 || index > size || size == 0) {
            throw new MyIndexOutOfBoundsException();
        }
        
    }

    /**
     *
     * @param c
     * @return
     */
    @Override
    public boolean addAll(T[] c) {
        
    }

    /**
     *
     * @param index
     * @param c
     * @return
     */
    @Override
    public boolean addAll(int index, T[] c) {
        
    }

    /**
     * get an item by index
     * @param index index if item to get
     * @return item
     */
    @Override
    public T get(int index) {
        if (index < 0 || index > size || size == 0) {
            throw new MyIndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    /**
     * remove item from list
     * @param index index of item to remove
     * @return item
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index > size || size == 0) {
            throw new MyIndexOutOfBoundsException();
        }
        
    }

    /**
     * clear the list
     */
    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    /**
     * check if the list is empty
     * @return if the list is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @param index
     * @param e
     * @return
     */
    @Override
    public boolean set(int index, T e) {
        if (index < 0 || index > size || size == 0) {
            throw new MyIndexOutOfBoundsException();
        }
        array[index] = e;
        return array[index] == e;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int indexOf(T o) {
        
    }

    /**
     * size of the list
     * @return list size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @return
     */
    @Override
    public T[] toArray() {
        if (size == 0) {
            throw new MyIndexOutOfBoundsException();
        }
        return (T[]) Arrays.copyOf(array, size);
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){

            @Override
            public boolean hasNext() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public T next() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        };
    }

}
