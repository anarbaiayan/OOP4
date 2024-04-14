package org.example;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    class MyNode<E> {
        E element;
        MyNode next;
        MyNode prev;

        public MyNode(E element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }

        public MyNode(E element, MyNode next, MyNode prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

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
    }

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
    }

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
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error: Index out of bound");
        }
        MyNode newNode = new MyNode(item);
        if(index == 0){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }else if(index == size){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }else{
            MyNode current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        size++;

    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        check(index);
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (T) current.element;
    }

    @Override
    public T getFirst() {
        return (T) head.element;
    }

    @Override
    public T getLast() {
        return (T) tail.element;
    }

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
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
