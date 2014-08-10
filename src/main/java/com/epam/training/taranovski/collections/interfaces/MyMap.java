/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.interfaces;

import java.util.Iterator;

/**
 *
 * @author Oleksandr_Taranovsky
 * @param <K>
 * @param <V>
 */
public interface MyMap<K, V> {

    void clear();

    boolean containsKey(K key);

    boolean containsValue(V value);

    V get(K key);

    boolean isEmpty();

    V put(K key, V value);

    V remove(K key);

    int size();

    Iterator<? extends MyEntry<K, V>> entryIterator();

    interface MyEntry<K, V> {

        @Override
        boolean equals(Object o);

        K getKey();

        V getValue();

        @Override
        int hashCode();

        V setValue(V value);
    }

}
