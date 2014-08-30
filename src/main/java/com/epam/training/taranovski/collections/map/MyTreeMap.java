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
public class MyTreeMap<K, V> implements MyMap<K, V> {

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private int size;
    private MyTreeMapEntry<K, V> head;
    private final Comparator<K> comparator;

    /**
     *
     * @param <K>
     * @param <V>
     */
    public static class MyTreeMapEntry<K, V> implements MyEntry<K, V> {

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
         * @param parent
         */
        public MyTreeMapEntry(K key, V value, MyTreeMapEntry<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
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
     * @param <K>
     * @param <V>
     * @param p
     * @return
     */
    private static <K, V> boolean colorOf(MyTreeMapEntry<K, V> p) {
        return (p == null) ? BLACK : p.color;
    }

    /**
     *
     * @param <K>
     * @param <V>
     * @param p
     * @return
     */
    private static <K, V> MyTreeMapEntry<K, V> parentOf(MyTreeMapEntry<K, V> p) {
        return (p == null) ? null : p.parent;
    }

    /**
     *
     * @param <K>
     * @param <V>
     * @param p
     * @param c
     */
    private static <K, V> void setColor(MyTreeMapEntry<K, V> p, boolean c) {
        if (p != null) {
            p.color = c;
        }
    }

    /**
     *
     * @param <K>
     * @param <V>
     * @param p
     * @return
     */
    private static <K, V> MyTreeMapEntry<K, V> leftOf(MyTreeMapEntry<K, V> p) {
        return (p == null) ? null : p.left;
    }

    /**
     *
     * @param <K>
     * @param <V>
     * @param p
     * @return
     */
    private static <K, V> MyTreeMapEntry<K, V> rightOf(MyTreeMapEntry<K, V> p) {
        return (p == null) ? null : p.right;
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
                p = p.left;
            } else if (cmp > 0) {
                p = p.right;
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
            int cmp = ((Comparable) key).compareTo(node.getKey());
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
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
        MyTreeMapEntry<K, V> node = null;
        if (comparator != null) {
            node = getEntryUsingComparator(key);
        } else {
            node = getEntry(key);
        }
        return node != null || get(key) != null;
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
        if (key == null) {
            throw new MyIllegalArgumentException();
        }
        MyTreeMapEntry<K, V> t = head;

        if (t == null) {

            head = new MyTreeMapEntry<>(key, value, null);
            size = 1;
            return null;
        }
        int cmp;
        MyTreeMapEntry<K, V> parent;
        // split comparator and comparable paths
        Comparator<? super K> cpr = comparator;
        if (cpr != null) {
            do {
                parent = t;
                cmp = cpr.compare(key, t.key);
                if (cmp < 0) {
                    t = t.left;
                } else if (cmp > 0) {
                    t = t.right;
                } else {
                    return t.setValue(value);
                }
            } while (t != null);
        } else {
            if (key == null) {
                throw new NullPointerException();
            }
            Comparable<? super K> k = (Comparable<? super K>) key;
            do {
                parent = t;
                cmp = k.compareTo(t.key);
                if (cmp < 0) {
                    t = t.left;
                } else if (cmp > 0) {
                    t = t.right;
                } else {
                    return t.setValue(value);
                }
            } while (t != null);
        }
        MyTreeMapEntry<K, V> e = new MyTreeMapEntry<>(key, value, parent);
        if (cmp < 0) {
            parent.left = e;
        } else {
            parent.right = e;
        }
        fixAfterInsertion(e);
        size++;
        return null;
    }

    /**
     *
     * @param p
     */
    private void rotateLeft(MyTreeMapEntry<K, V> p) {
        if (p != null) {
            MyTreeMapEntry<K, V> r = p.right;
            p.right = r.left;
            if (r.left != null) {
                r.left.parent = p;
            }
            r.parent = p.parent;
            if (p.parent == null) {
                head = r;
            } else if (p.parent.left == p) {
                p.parent.left = r;
            } else {
                p.parent.right = r;
            }
            r.left = p;
            p.parent = r;
        }
    }

    /**
     *
     * @param p
     */
    private void rotateRight(MyTreeMapEntry<K, V> p) {
        if (p != null) {
            MyTreeMapEntry<K, V> l = p.left;
            p.left = l.right;
            if (l.right != null) {
                l.right.parent = p;
            }
            l.parent = p.parent;
            if (p.parent == null) {
                head = l;
            } else if (p.parent.right == p) {
                p.parent.right = l;
            } else {
                p.parent.left = l;
            }
            l.right = p;
            p.parent = l;
        }
    }

    /**
     *
     * @param x1
     */
    private void fixAfterInsertion(MyTreeMapEntry<K, V> x1) {
        MyTreeMapEntry<K, V> x = x1;
        x.color = RED;

        while (x != null && x != head && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                MyTreeMapEntry<K, V> y = rightOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateRight(parentOf(parentOf(x)));
                }
            } else {
                MyTreeMapEntry<K, V> y = leftOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        head.color = BLACK;
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
     * @param t
     * @return
     */
    private MyTreeMapEntry<K, V> successor(MyTreeMapEntry<K, V> t) {
        if (t == null) {
            return null;
        } else if (t.right != null) {
            MyTreeMapEntry<K, V> p = t.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            MyTreeMapEntry<K, V> p = t.parent;
            MyTreeMapEntry<K, V> ch = t;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    /**
     *
     * @param p1
     */
    private void deleteEntry(MyTreeMapEntry<K, V> p1) {
        MyTreeMapEntry<K, V> p = p1;
        size--;

        // If strictly internal, copy successor's element to p and then make p
        // point to successor.
        if (p.left != null && p.right != null) {
            MyTreeMapEntry<K, V> s = successor(p);
            p.key = s.key;
            p.value = s.value;
            p = s;
        }
        // p has 2 children

        // Start fixup at replacement node, if it exists.
        MyTreeMapEntry<K, V> replacement = (p.left != null) ? p.left : p.right;

        if (replacement != null) {
            // Link replacement to parent
            replacement.parent = p.parent;
            if (p.parent == null) {
                head = replacement;
            } else if (p == p.parent.left) {
                p.parent.left = replacement;
            } else {
                p.parent.right = replacement;
            }

            // Null out links so they are OK to use by fixAfterDeletion.
            p.left = p.right = p.parent = null;

            // Fix replacement
            if (p.color == BLACK) {
                fixAfterDeletion(replacement);
            }
        } else if (p.parent == null) { 
            // return if we are the only node.
            head = null;
        } else { 
            //  No children. Use self as phantom replacement and unlink.
            if (p.color == BLACK) {
                fixAfterDeletion(p);
            }

            if (p.parent != null) {
                if (p == p.parent.left) {
                    p.parent.left = null;
                } else if (p == p.parent.right) {
                    p.parent.right = null;
                }
                p.parent = null;
            }
        }
    }

    /**
     *
     * @param x1
     */
    private void fixAfterDeletion(MyTreeMapEntry<K, V> x1) {
        MyTreeMapEntry<K, V> x = x1;
        while (x != head && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {
                MyTreeMapEntry<K, V> sib = rightOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateLeft(parentOf(x));
                    sib = rightOf(parentOf(x));
                }

                if (colorOf(leftOf(sib)) == BLACK
                        && colorOf(rightOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(rightOf(sib)) == BLACK) {
                        setColor(leftOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateRight(sib);
                        sib = rightOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(sib), BLACK);
                    rotateLeft(parentOf(x));
                    x = head;
                }
            } else {
            // symmetric
                MyTreeMapEntry<K, V> sib = leftOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateRight(parentOf(x));
                    sib = leftOf(parentOf(x));
                }

                if (colorOf(rightOf(sib)) == BLACK
                        && colorOf(leftOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(sib)) == BLACK) {
                        setColor(rightOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateLeft(sib);
                        sib = leftOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(sib), BLACK);
                    rotateRight(parentOf(x));
                    x = head;
                }
            }
        }

        setColor(x, BLACK);
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
    public Iterator<MyEntry<K, V>> entryIterator() {
        return new MyTreeMapEntryIterator();
    }

    /**
     *
     * @return
     */
    private MyTreeMapEntry<K, V> getFirstEntry() {
        MyTreeMapEntry<K, V> node = head;
        if (node != null) {
            while (node.left != null) {
                node = node.left;
            }
        }
        return node;
    }

    /**
     *
     */
    private class MyTreeMapEntryIterator implements Iterator<MyEntry<K, V>> {

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
        public MyEntry<K, V> next() {
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
            if (lastReturnedForIterator.left != null && lastReturnedForIterator.right != null) {
                nextForIterator = lastReturnedForIterator;
            }
            deleteEntry(lastReturnedForIterator);
            lastReturnedForIterator = null;
        }
    }

}
