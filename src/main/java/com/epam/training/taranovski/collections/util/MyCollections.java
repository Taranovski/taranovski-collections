/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.util;

import com.epam.training.taranovski.collections.interfaces.MyList;
import com.epam.training.taranovski.collections.interfaces.MyRandomAccess;
import java.util.Comparator;

/**
 *
 * @author user
 */
public abstract class MyCollections {
public static void sort(MyList list);
public static void sort(MyList list, Comparator c);
public static void swap(MyList list, int i, int j);
public static void copy(MyList dest, MyList src);
public static void reverse(MyList list);
public static int binarySearch(MyRandomAccess list,Object key);

}
