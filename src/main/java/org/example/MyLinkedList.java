package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {
    class MyNode<E> {
        E element; // The data of the node
        MyNode next; // The reference to the next node
        MyNode prev;  // The reference to the previous node

        public MyNode(E element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        } // Constructor with one parameter (element)

        public MyNode(E element, MyNode next, MyNode prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        } // Constructor with three parameters (element, next, prev)

        public MyNode() {
            this.element = null;
            this.next = null;
            this.prev = null;
        } // Constructor with no parameter
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private void check(int index) {
        if(index < 0|| index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    } // Checks if the given index is in the range of the list.

    @Override
    public void add(T item) {
        MyNode node = new MyNode(item);
        if (head == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    } // Add new element to the end of the list

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error: Index out of bound");
        }
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.element = item;
    } // Replace new element on the specified index with another

    @Override
    public void add(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error: Index out of bound");
        }
        MyNode node = new MyNode(item);
        if(index == 0){
            node.next = head;
            head.prev = node;
            head = node;
        }else if(index == size){
            tail.next = node;
            node.prev = tail;
            tail = node;
        }else{
            MyNode current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            node.next = current.next;
            node.prev = current;
            current.next.prev = node;
            current.next = node;
        }
        size++;

    } // Add new element to the specified index

    @Override
    public void addFirst(T item) {
        add(0, item);
    } // Add new element on the beginning of this list

    @Override
    public void addLast(T item) {
        add(item);
    } // Add new element on the end of this list

    @Override
    public T get(int index) {
        check(index);
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (T) current.element;
    }// Gets element on specified index

    @Override
    public T getFirst() {
        return (T) head.element;
    } // Gets first element of the list

    @Override
    public T getLast() {
        return (T) tail.element;
    } // Gets last element of the list

    @Override
    public void remove(int index) {
        check(index);
        if (index == 0) {
            head = head.next;
            head.prev = null;
        }
        else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            MyNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    } // Removes element from the list on specified index

    @Override
    public void removeFirst() {
        remove(0);
    } // Removes first element from the list

    @Override
    public void removeLast() {
        remove(size - 1);
    } // Removes last element from the list

    @Override
    public void sort() {
        for (MyNode i = head; i != null; i = i.next) {
            for (MyNode j = i.next; j != null; j = j.next) {
                if (((Comparable)j.element).compareTo(i.element) < 0) {
                    Object current = i.element;
                    i.element = j.element;
                    j.element = current;
                }
            }
        }
    } // Sort the list in asc order

    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(object)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    } // Returns index of specified element

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.element.equals(object)) {
                return i;
            }
            current = current.prev;
        }
        return -1;
    } // Returns index of the last element in the list

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    } // Checks for existing of specified element

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            arr[i] = current.element;
            current = current.next;
        }
        return arr;
    } // Returns an array

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    } // Deletes all elements from the list

    @Override
    public int size() {
        return size;
    } // Returns number of element in list

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    public class MyIterator implements Iterator<T> {
        private MyNode current = head;
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (hasNext() != true) {
                throw new NoSuchElementException();
            }
            T element = (T) current.element;
            current = current.next;
            index++;
            return element;
        }
    }

}
