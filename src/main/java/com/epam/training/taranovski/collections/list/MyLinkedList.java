/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.list;

import com.epam.training.taranovski.collections.exceptions.MyIndexOutOfBoundsException;
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
        for (T item : c) {
            this.addLast(item);
        }
    }

    /**
     *
     * @param e
     */
    public void addFirst(T e) {
        if (start == null) {
            start = new MyNode<>(e, null, null);
            end = start;
        }
        if (start == end) {
            start = new MyNode<>(e, end, null);
            end.setPrevious(start);
        } else {
            MyNode<T> temp = start;
            start = new MyNode<>(e, temp, null);
            temp.setPrevious(start);
        }
        size++;
    }

    /**
     *
     * @param e
     */
    public void addLast(T e) {
        if (end == null) {
            end = new MyNode<>(e, null, null);
            start = end;
        }
        if (end == start) {
            end = new MyNode<>(e, null, start);
            start.setNext(end);
        } else {
            MyNode<T> temp = end;
            end = new MyNode<>(e, null, temp);
            temp.setNext(end);
        }
        size++;
    }

    /**
     * final version
     *
     * @return
     */
    public T getFirst() {
        if (start == null) {
            throw new MyIndexOutOfBoundsException();
        }
        return start.getValue();
    }

    /**
     * final version
     *
     * @return
     */
    public T getLast() {
        if (end == null) {
            throw new MyIndexOutOfBoundsException();
        }
        return end.getValue();
    }

    /**
     *
     * @return
     */
    public T removeFirst() {
        if (start == null) {
            throw new MyIndexOutOfBoundsException();
        }
        T item = start.getValue();
        if (start == end) {
            start = null;
            end = null;
        } else {
            start = start.getNext();
            start.setPrevious(null);
        }
        return item;
    }

    /**
     *
     * @return
     */
    public T removeLast() {
        if (end == null) {
            throw new MyIndexOutOfBoundsException();
        }
        
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
                if (currentMyNode == null) {
                    throw new MyIndexOutOfBoundsException();
                }
                T value = currentMyNode.getValue();
                currentMyNode = currentMyNode.getPrevious();
                return value;
            }

            /**
             *
             */
            @Override
            public void remove() {
                if (currentMyNode == null) {
                    throw new MyIndexOutOfBoundsException();
                }
                if (currentMyNode == start) {
                    
                }
                if (currentMyNode == end) {
                    
                } else {
                    MyNode prevMyNode = currentMyNode.getPrevious();
                    MyNode nextMyNode = currentMyNode.getNext();
                    prevMyNode.setNext(nextMyNode);
                    nextMyNode.setPrevious(prevMyNode);
                    currentMyNode = prevMyNode;
                }
                size--;
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
