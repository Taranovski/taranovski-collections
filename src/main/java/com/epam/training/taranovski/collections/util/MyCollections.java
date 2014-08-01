/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.util;

import com.epam.training.taranovski.collections.exceptions.MyInvalidArgumentException;
import com.epam.training.taranovski.collections.interfaces.MyList;
import com.epam.training.taranovski.collections.interfaces.MyRandomAccess;
import java.util.Comparator;

/**
 *
 * @author user
 */
public class MyCollections {

    public static void sort(MyList list) {
        if (list == null) {
            throw new MyInvalidArgumentException();
        }

    }

    public static void sort(MyList list, Comparator c) {
        if (list == null || c == null) {
            throw new MyInvalidArgumentException();
        }

    }

    /**
     *
     * @param list
     * @param i
     * @param j
     */
    public static void swap(MyList list, int i, int j) {
        if (list == null) {
            throw new MyInvalidArgumentException();
        }
        Object temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     *
     * @param dest
     * @param src
     */
    public static void copy(MyList dest, MyList src) {
        if (dest == null || src == null) {
            throw new MyInvalidArgumentException();
        }
        dest.addAll(src.toArray());
    }

    /**
     *
     * @param list
     */
    public static void reverse(MyList list) {
        if (list == null) {
            throw new MyInvalidArgumentException();
        }

        int size = list.size();
        int half = size / 2;
        for (int i = 0; i <= half; i++) {
            swap(list, i, size - i);
        }
    }

    public static int binarySearch(MyRandomAccess list, Object key) {
        if (list == null) {
            throw new MyInvalidArgumentException();
        }
        
        return 0;
    }

}
