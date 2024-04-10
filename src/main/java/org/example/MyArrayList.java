package org.example;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] arr;
    private int length = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        arr = new Object[initialCapacity];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    private void increaseCapacity() {
        Object[] temp = new Object[arr.length * 2];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
    }

    @Override
    public void add(T item) {
        if(length == arr.length){
            increaseCapacity();
        }
        arr[length++] = item;
    }

    @Override
    public void set(int index, T item) {
        if(index < 0 || index > length){
            throw new IndexOutOfBoundsException("Error: Index out of bound");
        }
        arr[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if(index < 0 || index > length){
            throw new IndexOutOfBoundsException("Error: Index out of bound");
        }
        if(length == arr.length){
            increaseCapacity();
        }
        System.arraycopy(arr, index, arr, index + 1, length - index);
        arr[index] = item;
        length++;
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
        if(index < 0 || index > length){
            throw new IndexOutOfBoundsException("Error: Index out of bound");
        }
        return (T) arr[index];
    }

    @Override
    public T getFirst() {
        if(length == 0){
            throw new IndexOutOfBoundsException("Array is empty");
        }
        return (T) arr[0];
    }

    @Override
    public T getLast() {
        if(length == 0){
            throw new IndexOutOfBoundsException("Array is empty");
        }
        return (T) arr[length-1];
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index > length){
            throw new IndexOutOfBoundsException("Error: Index out of bound");
        }
        int num = length - index - 1;
        if (num > 0) {
            System.arraycopy(arr, index + 1, arr, index, num);
        }
        arr[--length] = null;
    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

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
