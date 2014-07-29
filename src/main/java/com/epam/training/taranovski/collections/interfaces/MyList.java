/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.interfaces;

/**
 *
 * @author user
 * @param <T>
 */
public interface MyList<T> extends Iterable<T> {

    boolean add(T e);

    boolean add(int index, T e);

    boolean addAll(T[] c);

    boolean addAll(int index, T[] c);

    T get(int index);

    T remove(int index);

    void clear();

    boolean isEmpty();

    boolean set(int index, T e);

    int indexOf(T o);

    int size();

    T[] toArray();

}
