/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.list;

import com.epam.training.taranovski.collections.exceptions.MyIndexOutOfBoundsException;
import com.epam.training.taranovski.collections.exceptions.MyIllegalArgumentException;
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
     * constructor with initial capacity
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
            capacity = (int) (minCapacity + minCapacity * CAPACITY_INCREASE_FACTOR);
            Object[] temp = array;
            array = new Object[capacity];

            System.arraycopy(temp, 0, array, 0, temp.length);
        }
    }

    /**
     * sets a real size of a list to its size
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
     *
     * @param e element to add
     * @return if add operation have succeed
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
     * add an element to the list to a given position
     *
     * @param index position to add to
     * @param e item
     * @return if an add operation have succeed
     */
    @Override
    public boolean add(int index, T e) {
        if (index < 0 || index > size || size == 0) {
            throw new MyIndexOutOfBoundsException();
        }
        if (size < capacity) {
            System.arraycopy(array, index, array, index + 1, size - index);
        } else {
            capacity = (int) (size + size * CAPACITY_INCREASE_FACTOR);
            Object[] temp = array;
            array = new Object[capacity];

            System.arraycopy(temp, 0, array, 0, index);
            System.arraycopy(temp, index, array, index + 1, temp.length - index);
        }
        array[index] = e;
        size++;
        return array[index] == e;
    }

    /**
     *
     * @param c
     * @return
     */
    @Override
    public boolean addAll(T[] c) {
        if (c == null) {
            throw new MyIllegalArgumentException();
        }
        if ((size + c.length) >= capacity) {
            this.ensureCapacity(size + c.length);
        }

        System.arraycopy(c, 0, array, size, c.length);
        int tempsize = size;
        size += c.length;
        boolean success = true;

        for (int i = 0; i < c.length; i++) {
            success = success & c[i] == array[i + tempsize];
        }

        return success;
    }

    /**
     *
     * @param index
     * @param c
     * @return
     */
    @Override
    public boolean addAll(int index, T[] c) {
        if (c == null) {
            throw new MyIllegalArgumentException();
        }
        if ((size + c.length) >= capacity) {
            this.ensureCapacity(size + c.length);
        }

        System.arraycopy(array, index, array, index + c.length, size - index);
        System.arraycopy(c, 0, array, index, c.length);
        int tempsize = index;
        size += c.length;
        boolean success = true;

        for (int i = 0; i < c.length; i++) {
            success = success & c[i] == array[i + tempsize];
        }

        return success;
    }

    /**
     * get an item by index
     *
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
     *
     * @param index index of item to remove
     * @return item
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index > size || size == 0) {
            throw new MyIndexOutOfBoundsException();
        }
        T e = (T) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);

        size--;
        return e;
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
     *
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
     * get an index of an item
     *
     * @param o item to find
     * @return index of a given item in the list or -1 if no item found
     */
    @Override
    public int indexOf(T o) {
        int index = 0;
        for (T item : this) {
            if (item.equals(o)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    /**
     * size of the list
     *
     * @return list size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * presents a list as an array
     *
     * @return an array which consists of all the elements of the list
     */
    @Override
    public T[] toArray() {
        if (size == 0) {
            throw new MyIndexOutOfBoundsException();
        }

        T[] newArray = (T[]) java.lang.reflect.Array.newInstance(array[0].getClass(), size);

        T item = null;
        for (int i = 0; i < size; i++) {
            newArray[i] = (T) array[i];
        }
        return newArray;
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = 0;

            /**
             *
             * @return
             */
            @Override
            public boolean hasNext() {
                return i < size;
            }

            /**
             *
             * @return
             */
            @Override
            public T next() {
                return (T) array[i++];
            }

            /**
             *
             */
            @Override
            public void remove() {
                System.arraycopy(array, i + 1, array, i, size - i);
                size--;
            }

        };
    }

}
