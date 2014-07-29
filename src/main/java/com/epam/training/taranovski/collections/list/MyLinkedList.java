/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.list;

import com.epam.training.taranovski.collections.interfaces.MyList;
import com.epam.training.taranovski.collections.interfaces.MyQueue;
import com.epam.training.taranovski.collections.interfaces.MyStack;
import java.util.Iterator;

/**
 *
 * @author user
 * @param <T>
 */
public class MyLinkedList<T> implements MyList<T>, MyQueue<T>, MyStack<T> {

    /**
     *
     * @param <T>
     */
    private static class MyNode<T> {

        /**
         *
         * @param value
         * @param next
         * @param previous
         */
        public MyNode(T value, MyNode<T> next, MyNode<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        private T value;

        private MyNode<T> next;
        private MyNode<T> previous;

        /**
         * @return the value
         */
        public T getValue() {
            return value;
        }

        /**
         * @param value the value to set
         */
        public void setValue(T value) {
            this.value = value;
        }

        /**
         * @return the next
         */
        public MyNode<T> getNext() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(MyNode<T> next) {
            this.next = next;
        }

        /**
         * @return the previous
         */
        public MyNode<T> getPrevious() {
            return previous;
        }

        /**
         * @param previous the previous to set
         */
        public void setPrevious(MyNode<T> previous) {
            this.previous = previous;
        }

    }

    private int size;
    private MyNode<T> start;
    private MyNode<T> end;

    /**
     *
     */
    public MyLinkedList() {
        start = null;
        end = null;
        size = 0;
    }

    /**
     *
     * @param c
     */
    public MyLinkedList(MyList<T> c) {

    }

    /**
     *
     * @param e
     */
    public void addFirst(T e) {
    }

    /**
     *
     * @param e
     */
    public void addLast(T e) {
    }

    /**
     * final version
     *
     * @return
     */
    public T getFirst() {
        return start == null ? null : start.getValue();
    }

    /**
     * final version
     *
     * @return
     */
    public T getLast() {
        return end == null ? null : end.getValue();
    }

    /**
     *
     * @return
     */
    public T removeFirst() {
        return null;
    }

    /**
     *
     * @return
     */
    public T removeLast() {
        return null;
    }

    /**
     *
     * @return
     */
    public Iterator<T> descendingIterator() {
        return new Iterator<T>() {

            MyNode<T> currentMyNode = end;

            /**
             * final version
             *
             * @return
             */
            @Override
            public boolean hasNext() {
                return currentMyNode != null;
            }

            /**
             *
             * @return
             */
            @Override
            public T next() {
                T value = currentMyNode.getValue();
                currentMyNode = currentMyNode.getPrevious();
                return value;
            }

            /**
             *
             */
            @Override
            public void remove() {
                MyNode prevMyNode = currentMyNode.getPrevious();
                MyNode nextMyNode = currentMyNode.getNext();
                prevMyNode.setNext(nextMyNode);
                nextMyNode.setPrevious(prevMyNode);
                currentMyNode = prevMyNode;
            }

        };
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean add(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param index
     * @param e
     * @return
     */
    @Override
    public boolean add(int index, Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param c
     * @return
     */
    @Override
    public boolean addAll(Object[] c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param index
     * @param c
     * @return
     */
    @Override
    public boolean addAll(int index, Object[] c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param index
     * @return
     */
    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param index
     * @param e
     * @return
     */
    @Override
    public boolean set(int index, Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public T[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean offer(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public T peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public T poll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean push(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public T pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
