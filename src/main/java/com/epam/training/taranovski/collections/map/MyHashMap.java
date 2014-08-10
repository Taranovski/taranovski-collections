/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.map;

import com.epam.training.taranovski.collections.exceptions.MyNoSuchElementException;
import com.epam.training.taranovski.collections.interfaces.MyMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Oleksandr_Taranovsky
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K, V> implements MyMap<K, V> {

    private static final int DEFAULT_BUCKET_NUMBER = 16;
    private static final int MAX_BUCKET_NUMBER = 1 << 30;
    private static final double DEFAULT_CAPACITY_THRESHOLD = 0.75;
    private static final int BUCKET_SHIFT_FACTOR = 1;
    private static final int MAGIC_INT = 1117;
    private static final int KEY_NOT_FOUND = -1;

    private int size;
    private int bucketNumber;
    private double loadFactor;

    private List<List<MyHashMapEntry<K, V>>> buckets;

    /**
     *
     */
    private class MyHashMapEntry<K, V> implements MyEntry<K, V> {

        private final K key;
        private V value;

        /**
         *
         * @param key
         * @param value
         */
        public MyHashMapEntry(K key, V value) {
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

    }

    /**
     *
     */
    public MyHashMap() {
        bucketNumber = DEFAULT_BUCKET_NUMBER;
        size = 0;
        loadFactor = DEFAULT_CAPACITY_THRESHOLD;
        buckets = new ArrayList<>(bucketNumber);
        for (int i = 0; i < bucketNumber; i++) {
            buckets.add(null);
            buckets.set(i, new LinkedList<MyHashMapEntry<K, V>>());
        }

    }

    /**
     *
     * @param initialCapacity
     */
    public MyHashMap(int initialCapacity) {
        bucketNumber = DEFAULT_BUCKET_NUMBER;
        for (; bucketNumber <= MAX_BUCKET_NUMBER;) {
            if (initialCapacity < bucketNumber) {
                break;
            }
            bucketNumber = bucketNumber << BUCKET_SHIFT_FACTOR;
        }
        size = 0;
        loadFactor = DEFAULT_CAPACITY_THRESHOLD;

        buckets = new ArrayList<>(bucketNumber);
        for (int i = 0; i < bucketNumber; i++) {
            buckets.add(null);
            buckets.set(i, new LinkedList<MyHashMapEntry<K, V>>());
        }

    }

    /**
     *
     * @param initialCapacity
     * @param loadFactor
     */
    public MyHashMap(int initialCapacity, double loadFactor) {
        this(initialCapacity);
        this.loadFactor = loadFactor;
    }

    /**
     *
     */
    @Override
    public void clear() {
        for (int i = 0; i < bucketNumber; i++) {
            buckets.set(i, new LinkedList<MyHashMapEntry<K, V>>());
        }
        size = 0;
    }

    /**
     *
     * @param key
     * @return
     */
    private int getBucket(K key) {
        return Math.abs((key.hashCode() * MAGIC_INT) % bucketNumber);
    }

    /**
     *
     * @param key
     * @param bucket
     * @return
     */
    private int getKeyIndexInTheBucket(K key, int bucket) {
        List<MyHashMapEntry<K, V>> someBucket = buckets.get(bucket);
        int index = KEY_NOT_FOUND;
        for (int i = 0; i < someBucket.size(); i++) {
            if (key.equals(key)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(K key) {
        return getKeyIndexInTheBucket(key, getBucket(key)) != KEY_NOT_FOUND;
    }

    /**
     *
     * @param value
     * @return
     */
    @Override
    public boolean containsValue(V value) {
        Iterator<? extends MyEntry<K, V>> iterator = entryIterator();
        while (iterator.hasNext()) {
            if (value.equals(iterator.next().getValue())) {
                return true;
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
        int bucket = getBucket(key);
        if (containsKey(key)) {
            MyHashMapEntry<K, V> item = buckets.get(bucket).get(getKeyIndexInTheBucket(key, bucket));
            V value = item.getValue();
            return value;
        } else {
            throw new MyNoSuchElementException();
        }
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
     */
    private void ensureCapacity() {
        double currentFillRate = size / bucketNumber;
        if (currentFillRate > loadFactor & bucketNumber < MAX_BUCKET_NUMBER) {
            Iterator<? extends MyEntry<K, V>> iterator = this.entryIterator();

            bucketNumber = bucketNumber << BUCKET_SHIFT_FACTOR;
            buckets = new ArrayList<>(bucketNumber);
            for (int i = 0; i < bucketNumber; i++) {
                buckets.add(null);
                buckets.set(i, new LinkedList<MyHashMapEntry<K, V>>());
            }
            size = 0;
            MyEntry<K, V> entry = null;
            while (iterator.hasNext()) {
                entry = iterator.next();
                this.put(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public V put(K key, V value) {
        ensureCapacity();
        int bucket = getBucket(key);
        if (containsKey(key)) {
            MyHashMapEntry<K, V> item = buckets.get(bucket).get(getKeyIndexInTheBucket(key, bucket));
            V oldValue = item.setValue(value);
            return oldValue;
        } else {
            buckets.get(bucket).add(new MyHashMapEntry(key, value));
            size++;
            return null;
        }
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        int bucket = getBucket(key);
        if (containsKey(key)) {
            MyHashMapEntry<K, V> item = buckets.get(bucket).remove(getKeyIndexInTheBucket(key, bucket));
            V value = item.getValue();
            size--;
            return value;
        } else {
            throw new MyNoSuchElementException();
        }
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
        return new MyHashMapEntryIterator<K, V>(this);
    }

    /**
     *
     */
    private class MyHashMapEntryIterator<K, V> implements Iterator<MyHashMapEntry<K, V>> {

        private MyHashMap map;
        private List<MyHashMapEntry<K, V>> list = new LinkedList<>();
        private int index;

        /**
         *
         */
        public MyHashMapEntryIterator(MyHashMap<K, V> map) {
            this.map = map;
            for (List tempList : buckets) {
                list.addAll(tempList);
            }
            index = 0;
        }

        /**
         *
         * @return
         */
        @Override
        public boolean hasNext() {
            return index < list.size();
        }

        /**
         *
         * @return
         */
        @Override
        public MyHashMapEntry<K, V> next() {
            return list.get(index++);
        }

        /**
         *
         */
        @Override
        public void remove() {
            MyHashMapEntry<K, V> entry = list.remove(index);
            map.remove(entry.getKey());
        }
    }
}
