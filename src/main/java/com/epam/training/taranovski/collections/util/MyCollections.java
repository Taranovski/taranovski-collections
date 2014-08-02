/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.util;

import com.epam.training.taranovski.collections.exceptions.MyIllegalArgumentException;
import com.epam.training.taranovski.collections.interfaces.MyList;
import com.epam.training.taranovski.collections.interfaces.MyRandomAccess;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author user
 */
public class MyCollections {

    /**
     *
     * @param list
     */
    public static void sort(MyList list) {
        if (list == null || list.isEmpty() || !(list.get(0) instanceof Comparable)) {
            throw new MyIllegalArgumentException();
        }
        if (list instanceof MyRandomAccess) {
            quicksortComparable(list, 0, list.size() - 1);
        } else {
            mySortComparable(list, 0, list.size() - 1);
        }

    }

    /**
     *
     * @param list
     * @param c
     */
    public static void sort(MyList list, Comparator c) {
        if (list == null || list.isEmpty() || c == null) {
            throw new MyIllegalArgumentException();
        }
        if (list instanceof MyRandomAccess) {
            quicksortComparator(list, c, 0, list.size() - 1);
        } else {
            mySortComparator(list, c, 0, list.size() - 1);
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
            throw new MyIllegalArgumentException();
        }
        if (i == j) {
            return;
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
            throw new MyIllegalArgumentException();
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
            throw new MyIllegalArgumentException();
        }

        int size = list.size();
        int half = size / 2;
        for (int i = 0; i < half; i++) {
            swap(list, i, size - i - 1);
        }
    }

    public static int binarySearch(MyList list, Comparable key) {
        if (list == null || key == null || !(list instanceof MyRandomAccess)) {
            throw new MyIllegalArgumentException();
        }

        return bisectionSearch(list, key, 0, list.size() - 1);
    }

    /**
     *
     * @param list
     * @param key
     * @param start
     * @param end
     * @return
     */
    private static int bisectionSearch(MyList list, Comparable key, int start, int end) {
        System.out.println("start " + start + " end " + end);
        if (key.compareTo(list.get(end)) > 0) {
            return -1 - end - 1;
        }
        if (key.compareTo(list.get(start)) < 0) {
            return -1;
        }
        
        if (end - start <= 1) {
            if (key.equals(list.get(end))) {
                return end;
            } else {
                return -1 - end;
            }
        }

        int middle = start + (end - start) / 2;
        if (key.compareTo((Comparable) list.get(middle)) > 0) {
            return bisectionSearch(list, key, middle, end);
        } else if (key.compareTo((Comparable) list.get(middle)) < 0) {
            return bisectionSearch(list, key, start, middle);
        } else {
            return key.equals(list.get(middle)) ? middle : -1 - middle;
        }

    }

    /**
     *
     * @param list
     * @param low
     * @param high
     */
    private static void quicksortComparable(MyList list, int low, int high) {
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

    /**
     *
     * @param list
     * @param low
     * @param high
     */
    private static void mySortComparable(MyList list, int low, int high) {
        int lowBound = low;
        int highBound = high;

        int min = lowBound;
        int max = highBound;

//        System.out.println(Arrays.toString(list.toArray()));
//        System.out.println("lower " + lowBound + " higher " + highBound);
        while (highBound - lowBound > 0) {

            for (int i = lowBound; i <= highBound; i++) {
                if (((Comparable) list.get(i)).compareTo(list.get(max)) > 0) {
                    max = i;
                }
                if (((Comparable) list.get(i)).compareTo(list.get(min)) < 0) {
                    min = i;
                }
            }
//            System.out.println("lower " + lowBound + " higher " + highBound);
//            System.out.println("min " + min + " max " + max);
//            System.out.println(Arrays.toString(list.toArray()));

            if (max == lowBound) {
                swap(list, highBound, max);
            } else if (min == highBound) {
                swap(list, lowBound, min);
            } else if (max == min || (max == lowBound & min == highBound)) {
                swap(list, lowBound, highBound);
            } else {
                swap(list, lowBound, min);
                swap(list, highBound, max);
            }
//            System.out.println(Arrays.toString(list.toArray()));

            lowBound++;
            highBound--;

            min = lowBound;
            max = highBound;
        }

    }

    /**
     *
     * @param list
     * @param low
     * @param high
     */
    private static void quicksortComparator(MyList list, Comparator c, int low, int high) {
        int i = low;
        int j = high;

        //Class clazz = list.get(i).getClass();
        // Get the pivot element from the middle of the list
        Object pivot = list.get(low + (high - low) / 2);

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (c.compare(list.get(i), pivot) < 0) {

                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (c.compare(list.get(j), pivot) > 0) {
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

            System.out.println("asdfasdf");
        }
        // Recursion
        if (low < j) {
            quicksortComparator(list, c, low, j);
        }
        if (i < high) {
            quicksortComparator(list, c, i, high);
        }
    }

    /**
     *
     * @param list
     * @param low
     * @param high
     */
    private static void mySortComparator(MyList list, Comparator c, int low, int high) {
        int lowBound = low;
        int highBound = high;

        int min = lowBound;
        int max = highBound;

//        System.out.println(Arrays.toString(list.toArray()));
//        System.out.println("lower " + lowBound + " higher " + highBound);
        while (highBound - lowBound > 0) {

            for (int i = lowBound; i <= highBound; i++) {
                if (c.compare(list.get(i), list.get(max)) > 0) {
                    max = i;
                }
                if (c.compare(list.get(i), list.get(min)) < 0) {
                    min = i;
                }
            }
//            System.out.println("lower " + lowBound + " higher " + highBound);
//            System.out.println("min " + min + " max " + max);
//            System.out.println(Arrays.toString(list.toArray()));

            if (max == lowBound) {
                swap(list, highBound, max);
            } else if (min == highBound) {
                swap(list, lowBound, min);
            } else if (max == min || (max == lowBound & min == highBound)) {
                swap(list, lowBound, highBound);
            } else {
                swap(list, lowBound, min);
                swap(list, highBound, max);
            }
//            System.out.println(Arrays.toString(list.toArray()));

            lowBound++;
            highBound--;

            min = lowBound;
            max = highBound;
        }

    }
}
