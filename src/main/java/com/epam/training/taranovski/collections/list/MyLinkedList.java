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
        } else if (start == end) {
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
        } else if (end == start) {
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
        size--;
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
        T item = end.getValue();
        if (end == start) {
            end = null;
            start = null;
        } else {
            end = end.getPrevious();
            end.setNext(null);
        }
        size--;
        return item;
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
                    if (start == end) {
                        start = null;
                        end = null;
                    } else {
                        start = start.getNext();
                        start.setPrevious(null);
                        currentMyNode = null;
                    }
                } else if (currentMyNode == end) {
                    end = end.getPrevious();
                    end.setNext(null);
                    currentMyNode = end;
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
        return new Iterator<T>() {

            MyNode<T> currentMyNode = start;

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
                currentMyNode = currentMyNode.getNext();
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
                    if (start == end) {
                        start = null;
                        end = null;
                    } else {
                        start = start.getNext();
                        start.setPrevious(null);
                        currentMyNode = start;
                    }
                } else if (currentMyNode == end) {
                    end = end.getPrevious();
                    end.setNext(null);
                    currentMyNode = null;
                } else {
                    MyNode prevMyNode = currentMyNode.getPrevious();
                    MyNode nextMyNode = currentMyNode.getNext();
                    prevMyNode.setNext(nextMyNode);
                    nextMyNode.setPrevious(prevMyNode);
                    currentMyNode = nextMyNode;
                }
                size--;
            }
        };
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean add(T e) {
        this.addLast(e);
        return e == end;
    }

    /**
     *
     * @param index
     * @param e
     * @return
     */
    @Override
    public boolean add(int index, T e) {
        if (index < 0 || index > size) {
            throw new MyIndexOutOfBoundsException();
        }
        MyNode<T> node;
        int i = 0;
        for (node = start; i < index; node = node.getNext()) {
            i++;
        }
        MyNode<T> prev = node.getPrevious();
        MyNode<T> insert = new MyNode<>(e, node, prev);
        prev.setNext(insert);
        node.setPrevious(insert);
        return this.get(index) == e;
    }

    /**
     *
     * @param c
     * @return
     */
    @Override
    public boolean addAll(T[] c) {
        boolean success = true;
        for (T item : c) {
            success = success & this.add(item);
        }
        return success;
    }

    /**
     *
     * @param index
     * @param c
     * @return
     */
    @Override
    public boolean addAll(int index, T[] c) {
        if (index < 0 || index > size) {
            throw new MyIndexOutOfBoundsException();
        }
        boolean success = true;
        MyNode<T> node;
        int i = 0;
        for (node = start; i < index; node = node.getNext()) {
            i++;
        }
        MyNode<T> prev = node.getPrevious();
        MyNode<T> tempEnd = end;
        
        end = prev;
        this.addAll(c);
        end.setNext(node);
        end = tempEnd;
        
        return success;
    }

    /**
     *
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new MyIndexOutOfBoundsException();
        }
        MyNode<T> node;
        int i = 0;
        for (node = start; i < index; node = node.getNext()) {
            i++;
        }
        return node.getValue();
    }

    /**
     *
     * @param index
     * @return
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new MyIndexOutOfBoundsException();
        }
        MyNode<T> node;
        int i = 0;
        for (node = start; i < index; node = node.getNext()) {
            i++;
        }
        MyNode<T> prev = node.getPrevious();
        MyNode<T> next = node.getNext();
        prev.setNext(next);
        next.setPrevious(prev);
        return node.getValue();
    }

    /**
     *
     */
    @Override
    public void clear() {
        start = null;
        end = null;
        size = 0;
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
     * @param index
     * @param e
     * @return
     */
    @Override
    public boolean set(int index, T e) {
        if (index < 0 || index > size) {
            throw new MyIndexOutOfBoundsException();
        }
        MyNode<T> node;
        int i = 0;
        for (node = start; i < index; node = node.getNext()) {
            i++;
        }
        node.setValue(e);
        return node.getValue() == e;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int indexOf(T o) {
        int index = 0;
        for (T item : this) {
            if (item.equals(o)) {
                return index;
            }
            index++;
        }
        return -1;
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
    public T[] toArray() {
        if (size == 0) {
            throw new MyIndexOutOfBoundsException();
        }
        T[] array = (T[]) java.lang.reflect.Array.newInstance(start.getValue().getClass(), size);
        int i = 0;
        for (T item : this) {
            array[i] = item;
            i++;
        }
        return array;
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean offer(T e) {
        return this.add(e);
    }

    /**
     *
     * @return
     */
    @Override
    public T peek() {
        return this.getFirst();
    }

    /**
     *
     * @return
     */
    @Override
    public T poll() {
        return this.removeFirst();
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean push(T e) {
        return this.add(e);
    }

    /**
     *
     * @return
     */
    @Override
    public T pop() {
        return this.removeLast();
    }

}
