/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.map;

import com.epam.training.taranovski.collections.exceptions.MyIllegalArgumentException;
import com.epam.training.taranovski.collections.exceptions.MyNoSuchElementException;
import com.epam.training.taranovski.collections.interfaces.MyMap;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author Oleksandr_Taranovsky
 * @param <K>
 * @param <V>
 */
public class MyTreeMap<K extends Comparable, V> implements MyMap<K, V> {

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private int size;
    private MyTreeMapEntry<K, V> head;
    private Comparator<K> comparator;

    /**
     *
     * @param <K>
     * @param <V>
     */
    public class MyTreeMapEntry<K extends Comparable, V> implements MyEntry<K, V> {

        private K key;
        private V value;
        private boolean color = BLACK;
        private MyTreeMapEntry<K, V> right;
        private MyTreeMapEntry<K, V> left;
        private MyTreeMapEntry<K, V> parent;

        /**
         *
         * @param key
         * @param value
         */
        public MyTreeMapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         *
         * @return
         */
        @Override
        public K getKey() {
            return key;
        }

        /**
         *
         * @return
         */
        @Override
        public V getValue() {
            return value;
        }

        /**
         *
         * @param value
         * @return
         */
        @Override
        public V setValue(V value) {
            V tempValue = this.value;
            this.value = value;
            return tempValue;
        }

        /**
         * @return the right
         */
        private MyTreeMapEntry<K, V> getRight() {
            return right;
        }

        /**
         * @param right the right to set
         */
        private void setRight(MyTreeMapEntry<K, V> right) {
            this.right = right;
        }

        /**
         * @return the left
         */
        private MyTreeMapEntry<K, V> getLeft() {
            return left;
        }

        /**
         * @param left the left to set
         */
        private void setLeft(MyTreeMapEntry<K, V> left) {
            this.left = left;
        }

        /**
         * @return the color
         */
        private boolean isColor() {
            return color;
        }

        /**
         * @param color the color to set
         */
        private void setColor(boolean color) {
            this.color = color;
        }

        /**
         * @return the parent
         */
        private MyTreeMapEntry<K, V> getParent() {
            return parent;
        }

        /**
         * @param parent the parent to set
         */
        private void setParent(MyTreeMapEntry<K, V> parent) {
            this.parent = parent;
        }

        /**
         *
         * @param key
         */
        private void setKey(K key) {
            this.key = key;
        }

        /**
         *
         * @return
         */
        @Override
        public String toString() {
            String colorStr = (color ? "black" : "red");
            return this.hashCode() + "\ncolor: " + colorStr
                    + "\nkey: " + key
                    + "\nvalue: " + value
                    + "\nparent: " + (parent == null ? null : parent.hashCode())
                    + "\nleft: " + (left == null ? null : left.hashCode())
                    + "\nright: " + (right == null ? null : right.hashCode());
        }

    }

    /**
     *
     */
    public MyTreeMap() {
        size = 0;
        head = null;
        comparator = null;
    }

    /**
     *
     * @param comparator
     */
    public MyTreeMap(Comparator<K> comparator) {
        size = 0;
        head = null;
        this.comparator = comparator;
    }

    /**
     *
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     *
     * @param key
     * @return
     */
    private MyTreeMapEntry<K, V> getEntryUsingComparator(K key) {
        if (key == null) {
            throw new MyIllegalArgumentException();
        }
        MyTreeMapEntry<K, V> p = head;
        while (p != null) {
            int cmp = comparator.compare(key, p.getKey());
            if (cmp < 0) {
                p = p.getLeft();
            } else if (cmp > 0) {
                p = p.getRight();
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     *
     * @param key
     * @return
     */
    private MyTreeMapEntry<K, V> getEntry(K key) {
        if (key == null) {
            throw new MyIllegalArgumentException();
        }
        MyTreeMapEntry<K, V> node = head;
        while (node != null) {
            int cmp = key.compareTo(node.getKey());
            if (cmp < 0) {
                node = node.getLeft();
            } else if (cmp > 0) {
                node = node.getRight();
            } else {
                return node;
            }
        }
        return null;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /**
     *
     * @param value
     * @return
     */
    @Override
    public boolean containsValue(V value) {
        Iterator<? extends MyEntry<K, V>> i = entryIterator();
        if (value == null) {
            while (i.hasNext()) {
                MyEntry<K, V> e = i.next();
                if (e.getValue() == null) {
                    return true;
                }
            }
        } else {
            while (i.hasNext()) {
                MyEntry<K, V> e = i.next();
                if (value.equals(e.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        MyTreeMapEntry<K, V> node = null;
        if (comparator != null) {
            node = getEntryUsingComparator(key);
        } else {
            node = getEntry(key);
        }
        return node == null ? null : node.getValue();
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
     * @param key
     * @param value
     * @return
     */
    @Override
    public V put(K key, V value) {
        MyTreeMapEntry<K, V> t = head;

        if (t == null) {
            head = new MyTreeMapEntry<>(key, value);
            size = 1;
            return null;
        }

        int keyCompareResult;
        MyTreeMapEntry<K, V> parent = null;
        if (comparator != null) {
            do {
                parent = t;
                keyCompareResult = comparator.compare(key, t.getKey());
                if (keyCompareResult < 0) {
                    t = t.getLeft();
                } else if (keyCompareResult > 0) {
                    t = t.getRight();
                } else {
                    return t.setValue(value);
                }
            } while (t != null);
        } else {
            do {
                parent = t;
                keyCompareResult = key.compareTo(t.getKey());
                if (keyCompareResult < 0) {
                    t = t.getLeft();
                } else if (keyCompareResult > 0) {
                    t = t.getRight();
                } else {
                    return t.setValue(value);
                }
            } while (t != null);
        }
        //System.out.println(parent.getKey() + ": " + parent.getValue());
        MyTreeMapEntry<K, V> insertionNode = new MyTreeMapEntry<>(key, value);
        insertionNode.setParent(parent);
        if (keyCompareResult < 0) {
            parent.setLeft(insertionNode);
        } else {
            parent.setRight(insertionNode);
        }

        fixAfterInsertion(insertionNode);

        System.out.println("parent: " + parent);
        System.out.println("insertionNode: " + insertionNode);
        size++;
        return null;
    }

    /**
     *
     * @param treeNodeToRotateLeft
     */
    private void rotateLeft(MyTreeMapEntry<K, V> treeNodeToRotateLeft) {
        if (treeNodeToRotateLeft != null) {
            MyTreeMapEntry<K, V> rightNode = treeNodeToRotateLeft.getRight();
            treeNodeToRotateLeft.setRight(rightNode.getLeft());
            if (rightNode.getLeft() != null) {
                rightNode.getLeft().setParent(treeNodeToRotateLeft);
            }
            rightNode.setParent(treeNodeToRotateLeft.getParent());
            if (treeNodeToRotateLeft.getParent() == null) {
                head = rightNode;
            } else if (treeNodeToRotateLeft.getParent().getLeft() == treeNodeToRotateLeft) {
                treeNodeToRotateLeft.getParent().setLeft(rightNode);
            } else {
                treeNodeToRotateLeft.getParent().setRight(rightNode);
            }
            rightNode.setLeft(treeNodeToRotateLeft);
            treeNodeToRotateLeft.setParent(rightNode);
        }
    }

    /**
     *
     * @param treeNodeToRotateRight
     */
    private void rotateRight(MyTreeMapEntry<K, V> treeNodeToRotateRight) {
        if (treeNodeToRotateRight != null) {
            MyTreeMapEntry<K, V> leftNode = treeNodeToRotateRight.getLeft();
            treeNodeToRotateRight.setLeft(leftNode.getRight());
            if (leftNode.getRight() != null) {
                leftNode.getRight().setParent(treeNodeToRotateRight);
            }
            leftNode.setParent(treeNodeToRotateRight.getParent());
            if (treeNodeToRotateRight.getParent() == null) {
                head = leftNode;
            } else if (treeNodeToRotateRight.getParent().getRight() == treeNodeToRotateRight) {
                treeNodeToRotateRight.getParent().setRight(leftNode);
            } else {
                treeNodeToRotateRight.getParent().setLeft(leftNode);
            }
            leftNode.setRight(treeNodeToRotateRight);
            treeNodeToRotateRight.setParent(leftNode);
        }
    }

    /**
     *
     * @param x
     */
    private void fixAfterInsertion(MyTreeMapEntry<K, V> x) {
        x.setColor(RED);

        while (x != null
                && x != head
                && x.getParent().isColor() == RED) {
            if (x.getParent() == x.getParent().getParent().getLeft()) {
                MyTreeMapEntry<K, V> y = x.getParent().getParent().getRight();
                if (y.isColor() == RED) {
                    x.getParent().setColor(BLACK);
                    y.setColor(BLACK);
                    x.getParent().getParent().setColor(RED);
                    x = x.getParent().getParent();
                } else {
                    if (x == x.getParent().getRight()) {
                        x = x.getParent();
                        rotateLeft(x);
                    }
                    x.getParent().setColor(BLACK);
                    x.getParent().getParent().setColor(RED);
                    rotateRight(x.getParent().getParent());
                }
            } else {
                MyTreeMapEntry<K, V> someLeftNode = x.getParent().getParent().getLeft();

                if (someLeftNode.isColor() == RED) {
                    x.getParent().setColor(BLACK);
                    someLeftNode.setColor(BLACK);
                    x.getParent().getParent().setColor(RED);

                    x = x.getParent().getParent();
                } else {
                    if (x == x.getParent().getLeft()) {
                        x = x.getParent();
                        rotateRight(x);
                    }
                    x.getParent().setColor(BLACK);
                    x.getParent().getParent().setColor(RED);

                    rotateLeft(x.getParent().getParent());
                }
            }
        }
        head.setColor(BLACK);
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        MyTreeMapEntry<K, V> node = null;
        if (comparator != null) {
            node = getEntryUsingComparator(key);
        } else {
            node = getEntry(key);
        }
        if (node == null) {
            return null;
        }

        V oldValue = node.value;
        deleteEntry(node);
        return oldValue;
    }

    /**
     *
     * @param myTreeMapNodeToFindSuccessor
     * @return
     */
    private MyTreeMapEntry<K, V> successor(MyTreeMapEntry<K, V> myTreeMapNodeToFindSuccessor) {
        if (myTreeMapNodeToFindSuccessor == null) {
            return null;
        } else if (myTreeMapNodeToFindSuccessor.getRight() != null) {
            MyTreeMapEntry<K, V> someRightNode = myTreeMapNodeToFindSuccessor.getRight();
            while (someRightNode.getLeft() != null) {
                someRightNode = someRightNode.getLeft();
            }
            return someRightNode;
        } else {
            MyTreeMapEntry<K, V> someParentNode = myTreeMapNodeToFindSuccessor.getParent();
            MyTreeMapEntry<K, V> someChoise = myTreeMapNodeToFindSuccessor;
            while (someParentNode != null && someChoise == someParentNode.getRight()) {
                someChoise = someParentNode;
                someParentNode = someParentNode.getParent();
            }
            return someParentNode;
        }
    }

    /**
     *
     * @param myTreeMapNodeToDelete
     */
    private void deleteEntry(MyTreeMapEntry<K, V> myTreeMapNodeToDelete) {
        size--;

        // If strictly internal, copy successor's element to p and then make p
        // point to successor.
        if (myTreeMapNodeToDelete.getLeft() != null && myTreeMapNodeToDelete.getRight() != null) {
            MyTreeMapEntry<K, V> successor = successor(myTreeMapNodeToDelete);
            myTreeMapNodeToDelete.setKey(successor.getKey());
            myTreeMapNodeToDelete.setValue(successor.getValue());
            myTreeMapNodeToDelete = successor;
        } // p has 2 children

        // Start fixup at replacement node, if it exists.
        MyTreeMapEntry<K, V> replacement = (myTreeMapNodeToDelete.getLeft() != null ? myTreeMapNodeToDelete.getLeft() : myTreeMapNodeToDelete.getRight());

        if (replacement != null) {
            // Link replacement to parent
            replacement.setParent(myTreeMapNodeToDelete.getParent());
            if (myTreeMapNodeToDelete.getParent() == null) {
                head = replacement;
            } else if (myTreeMapNodeToDelete == myTreeMapNodeToDelete.getParent().getLeft()) {
                myTreeMapNodeToDelete.getParent().setLeft(replacement);
            } else {
                myTreeMapNodeToDelete.getParent().setRight(replacement);
            }

            // Null out links so they are OK to use by fixAfterDeletion.
            myTreeMapNodeToDelete.setParent(null);
            myTreeMapNodeToDelete.setLeft(null);
            myTreeMapNodeToDelete.setRight(null);

            // Fix replacement
            if (myTreeMapNodeToDelete.isColor() == BLACK) {
                fixAfterDeletion(replacement);
            }
        } else if (myTreeMapNodeToDelete.getParent() == null) { // return if we are the only node.
            head = null;
        } else { //  No children. Use self as phantom replacement and unlink.
            if (myTreeMapNodeToDelete.isColor() == BLACK) {
                fixAfterDeletion(myTreeMapNodeToDelete);
            }

            if (myTreeMapNodeToDelete.getParent() != null) {
                if (myTreeMapNodeToDelete == myTreeMapNodeToDelete.getParent().getLeft()) {
                    myTreeMapNodeToDelete.getParent().setLeft(null);
                } else if (myTreeMapNodeToDelete == myTreeMapNodeToDelete.getParent().getRight()) {
                    myTreeMapNodeToDelete.getParent().setRight(null);
                }
                myTreeMapNodeToDelete.setParent(null);
            }
        }
    }

    /**
     *
     * @param treeMapNodeToFix
     */
    private void fixAfterDeletion(MyTreeMapEntry<K, V> treeMapNodeToFix) {
        MyTreeMapEntry<K, V> sibling = null;
        while (treeMapNodeToFix != head && treeMapNodeToFix.isColor() == BLACK) {
            if (treeMapNodeToFix == treeMapNodeToFix.getParent().getLeft()) {
                sibling = treeMapNodeToFix.getParent().getRight();

                if (sibling.isColor() == RED) {
                    sibling.setColor(BLACK);
                    treeMapNodeToFix.getParent().setColor(RED);
                    rotateLeft(treeMapNodeToFix.getParent());
                    sibling = treeMapNodeToFix.getParent().getRight();
                }

                if (sibling.getLeft().isColor() == BLACK
                        && sibling.getRight().isColor() == BLACK) {
                    sibling.setColor(RED);
                    treeMapNodeToFix = treeMapNodeToFix.getParent();
                } else {
                    if (sibling.getRight().isColor() == BLACK) {
                        sibling.getLeft().setColor(BLACK);
                        sibling.setColor(RED);
                        rotateRight(sibling);
                        sibling = treeMapNodeToFix.getParent().getRight();
                    }
                    sibling.setColor(treeMapNodeToFix.getParent().isColor());
                    treeMapNodeToFix.getParent().setColor(BLACK);
                    sibling.getRight().setColor(BLACK);
                    rotateLeft(treeMapNodeToFix.getParent());
                    treeMapNodeToFix = head;
                }
            } else { // symmetric
                sibling = treeMapNodeToFix.getParent().getLeft();

                if (sibling.isColor() == RED) {
                    sibling.setColor(BLACK);
                    treeMapNodeToFix.getParent().setColor(RED);
                    rotateRight(treeMapNodeToFix.getParent());
                    sibling = treeMapNodeToFix.getParent().getLeft();
                }

                if (sibling.getRight().isColor() == BLACK
                        && sibling.getLeft().isColor() == BLACK) {
                    sibling.setColor(RED);
                    treeMapNodeToFix = treeMapNodeToFix.getParent();
                } else {
                    if (sibling.getLeft().isColor() == BLACK) {
                        sibling.getRight().setColor(BLACK);
                        sibling.setColor(RED);
                        rotateLeft(sibling);
                        sibling = treeMapNodeToFix.getParent().getLeft();
                    }
                    sibling.setColor(treeMapNodeToFix.getParent().isColor());
                    treeMapNodeToFix.getParent().setColor(BLACK);
                    sibling.getLeft().setColor(BLACK);

                    rotateRight(treeMapNodeToFix.getParent());
                    treeMapNodeToFix = head;
                }
            }
        }
        treeMapNodeToFix.setColor(BLACK);
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
    public Iterator<? extends MyEntry<K, V>> entryIterator() {
        return new MyTreeMapEntryIterator<>();
    }

    /**
     *
     * @return
     */
    private MyTreeMapEntry<K, V> getFirstEntry() {
        MyTreeMapEntry<K, V> node = head;
        if (node != null) {
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
        }
        return node;
    }

    /**
     *
     */
    private class MyTreeMapEntryIterator<T extends MyTreeMapEntry<K, V>> implements Iterator<MyTreeMapEntry<K, V>> {

        private MyTreeMapEntry<K, V> nextForIterator;
        private MyTreeMapEntry<K, V> lastReturnedForIterator;
        private MyTreeMapEntry<K, V> tempNodeForIterator;

        /**
         *
         */
        public MyTreeMapEntryIterator() {
            lastReturnedForIterator = null;
            nextForIterator = getFirstEntry();
        }

        /**
         *
         * @return
         */
        @Override
        public boolean hasNext() {
            return nextForIterator != null;
        }

        /**
         *
         * @return
         */
        @Override
        public MyTreeMapEntry<K, V> next() {
            tempNodeForIterator = nextForIterator;
            if (tempNodeForIterator == null) {
                throw new MyNoSuchElementException();
            }

            nextForIterator = successor(tempNodeForIterator);
            lastReturnedForIterator = tempNodeForIterator;
            return tempNodeForIterator;
        }

        /**
         *
         */
        @Override
        public void remove() {

            if (lastReturnedForIterator == null) {
                throw new MyNoSuchElementException();
            }

            // deleted entries are replaced by their successors
            if (lastReturnedForIterator.getLeft() != null && lastReturnedForIterator.getRight() != null) {
                nextForIterator = lastReturnedForIterator;
            }
            deleteEntry(lastReturnedForIterator);
            lastReturnedForIterator = null;
        }
    }

}
