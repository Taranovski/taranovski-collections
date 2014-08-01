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
        if (list == null || list.isEmpty() || !(list.get(0) instanceof Comparable)) {
            throw new MyInvalidArgumentException();
        }

    }

    public static void sort(MyList list, Comparator c) {
        if (list == null || list.isEmpty() || c == null) {
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
        dest.clear();
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

    private void quicksortComparable(MyList list, int low, int high) {
        int i = low;
        int j = high;
        // Get the pivot element from the middle of the list
        Object pivot = list.get(low + (high - low) / 2);

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (((Comparable) list.get(i)).compareTo(pivot) < 0) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (((Comparable) list.get(j)).compareTo(pivot) > 0) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                swap(list, i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j) {
            quicksortComparable(list, low, j);
        }
        if (i < high) {
            quicksortComparable(list, i, high);
        }
    }

}
