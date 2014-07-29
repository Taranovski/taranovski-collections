/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.list;

/**
 *
 * @author user
 */
public interface MyList<T> extends Iterable {

    void add(T e);

    void add(int index, T e);

    void addAll(T[] c);

    void addAll(int index, T[] c);

    T get(int index);

    T remove(int index);

    void clear();

    boolean isEmpty();

    void set(int index, T e);

    int indexOf(T o);

    int size();

    T[] toArray();

}
