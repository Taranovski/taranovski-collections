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
     * node class
     *
     * @param <T>
     */
    private static class MyNode<T> {

        /**
         * constructor
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
     * default constructor
     */
    public MyLinkedList() {
        start = null;
        end = null;
        size = 0;
    }

    /**
     * constructor from another my list
     *
     * @param c a list of values to create from
     */
    public MyLinkedList(MyList<T> c) {
        for (T item : c) {
            this.addLast(item);
        }
    }

    /**
     * adds an element to the start of the list
     *
     * @param e item to add
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
     * adds an element to the end of the list
     *
     * @param e item to add
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
     * get a first item in the list
     *
     * @return first item in the list
     */
    public T getFirst() {
        if (start == null) {
            throw new MyIndexOutOfBoundsException();
        }
        return start.getValue();
    }

    /**
     * get a last item in the list
     *
     * @return last item in the list
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
                    }
                    currentMyNode = null;
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
                if (currentMyNode == end) {
                    if (start == end) {
                        start = null;
                        end = null;
                    } else {
                        end = end.getPrevious();
                        end.setNext(null);
                    }
                    currentMyNode = null;
                } else if (currentMyNode == start) {
                    start = start.getNext();
                    start.setPrevious(null);
                    currentMyNode = start;
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
        return e == end.getValue();
    }

    /**
     *
     * @param index
     * @param e
     * @return
     */
    @Override
    public boolean add(int index, T e) {
        if (index < 0 || index > size || size == 0) {
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
        if (c == null) {
            throw new MyIndexOutOfBoundsException();
        }
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
        if (index < 0 || index > size || size == 0) {
            throw new MyIndexOutOfBoundsException();
        }
        if (c == null) {
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
        if (index < 0 || index > size || size == 0) {
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
        if (index < 0 || index > size || size == 0) {
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
        size--;
        return node.getValue();
    }

    /**
     * clears the list
     */
    @Override
    public void clear() {
        start = null;
        end = null;
        size = 0;
    }

    /**
     * checks if the list is empty
     *
     * @return if the list is empty
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
        if (index < 0 || index > size || size == 0) {
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
     * get an index of an item
     *
     * @param o item to find
     * @return index of a given item in the list or -1 if no item found
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
     * gets a size of the list
     *
     * @return size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * presents a list as an array
     *
     * @return an array which consists of all the elements of the list
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
     * adds an item to the end of the queue (end of the list)
     *
     * @param e item to add
     * @return if the item successfully added
     */
    @Override
    public boolean offer(T e) {
        return this.add(e);
    }

    /**
     * get an element of queue without delete (start of the list)
     *
     * @return an element from queue
     */
    @Override
    public T peek() {
        return this.getFirst();
    }

    /**
     * get an element of queue with delete (start of the list)
     *
     * @return an element from queue
     */
    @Override
    public T poll() {
        return this.removeFirst();
    }

    /**
     * add an element to stack (end of the list)
     *
     * @param e element to add
     * @return if the element is successfully added
     */
    @Override
    public boolean push(T e) {
        return this.add(e);
    }

    /**
     * get an element from stack (end of the list)
     *
     * @return an element
     */
    @Override
    public T pop() {
        return this.removeLast();
    }

}
