/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.map;

import com.epam.training.taranovski.collections.exceptions.MyIllegalArgumentException;
import com.epam.training.taranovski.collections.interfaces.MyMap;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Oleksandr_Taranovsky
 * @param <K>
 * @param <V>
 */
public class MyTreeMap<K extends Comparable, V> implements MyMap<K, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private int size;
    private MyTreeMapEntry<K, V> head;
    private Comparator<K> comparator;

    /**
     *
     */
    private class MyTreeMapEntry<K, V> implements MyEntry<K, V> {

        private final K key;
        private V value;
        private boolean color;
        private MyTreeMapEntry<K, V> right;
        private MyTreeMapEntry<K, V> left;
        private MyTreeMapEntry<K, V> parent;

        /**
         *
         * @param key
         * @param value
         */
        public MyTreeMapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         *
         * @return
         */
        @Override
        public K getKey() {
            return key;
        }

        /**
         *
         * @return
         */
        @Override
        public V getValue() {
            return value;
        }

        /**
         *
         * @param value
         * @return
         */
        @Override
        public V setValue(V value) {
            V tempValue = this.value;
            this.value = value;
            return tempValue;
        }

        /**
         * @return the right
         */
        public MyTreeMapEntry<K, V> getRight() {
            return right;
        }

        /**
         * @param right the right to set
         */
        public void setRight(MyTreeMapEntry<K, V> right) {
            this.right = right;
        }

        /**
         * @return the left
         */
        public MyTreeMapEntry<K, V> getLeft() {
            return left;
        }

        /**
         * @param left the left to set
         */
        public void setLeft(MyTreeMapEntry<K, V> left) {
            this.left = left;
        }

        /**
         * @return the color
         */
        public boolean isColor() {
            return color;
        }

        /**
         * @param color the color to set
         */
        public void setColor(boolean color) {
            this.color = color;
        }

        /**
         * @return the parent
         */
        public MyTreeMapEntry<K, V> getParent() {
            return parent;
        }

        /**
         * @param parent the parent to set
         */
        public void setParent(MyTreeMapEntry<K, V> parent) {
            this.parent = parent;
        }

    }

    /**
     *
     */
    MyTreeMap() {
        size = 0;
        head = null;
        comparator = null;
    }

    /**
     *
     * @param comparator
     */
    MyTreeMap(Comparator<K> comparator) {
        size = 0;
        head = null;
        this.comparator = comparator;
    }

    /**
     *
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     *
     * @param key
     * @return
     */
    private V getEntryUsingComparator(K key) {
        if (key == null) {
            throw new MyIllegalArgumentException();
        }
        MyTreeMapEntry<K, V> p = head;
        while (p != null) {
            int cmp = comparator.compare(key, p.getKey());
            if (cmp < 0) {
                p = p.getLeft();
            } else if (cmp > 0) {
                p = p.getRight();
            } else {
                return p.getValue();
            }
        }
        return null;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /**
     *
     * @param value
     * @return
     */
    @Override
    public boolean containsValue(V value) {
        Iterator<? extends MyEntry<K, V>> i = entryIterator();
        if (value == null) {
            while (i.hasNext()) {
                MyEntry<K, V> e = i.next();
                if (e.getValue() == null) {
                    return true;
                }
            }
        } else {
            while (i.hasNext()) {
                MyEntry<K, V> e = i.next();
                if (value.equals(e.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        if (comparator != null) {
            return getEntryUsingComparator(key);
        }
        if (key == null) {
            throw new MyIllegalArgumentException();
        }
        Comparable k = key;
        MyTreeMapEntry<K, V> p = head;
        while (p != null) {
            int cmp = k.compareTo(p.getKey());
            if (cmp < 0) {
                p = p.getLeft();
            } else if (cmp > 0) {
                p = p.getRight();
            } else {
                return p.getValue();
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public V put(K key, V value) {
        if (head == null) {
            head = new MyTreeMapEntry<>(key, value);
            head.setColor(BLACK);
            return null;
        }
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
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
    public Iterator<? extends MyEntry<K, V>> entryIterator() {
        return new MyTreeMapEntryIterator<>();
    }

    /**
     *
     */
    private class MyTreeMapEntryIterator<K, V> implements Iterator<MyTreeMapEntry<K, V>> {

        private MyHashMap map;
        private List<MyTreeMapEntry<K, V>> list = new LinkedList<>();
        private int index;

        /**
         *
         */
        public MyTreeMapEntryIterator() {

        }

        /**
         *
         * @return
         */
        @Override
        public boolean hasNext() {
            return index < size;
        }

        /**
         *
         * @return
         */
        @Override
        public MyTreeMapEntry<K, V> next() {
            return list.get(index++);
        }

        /**
         *
         */
        @Override
        public void remove() {
            MyTreeMapEntry<K, V> entry = list.remove(index);
            map.remove(entry.getKey());
        }
    }

}
