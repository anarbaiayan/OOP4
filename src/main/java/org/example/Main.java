package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        MyArrayList<Integer> myList = new MyArrayList<>();
        MyLinkedList<Integer> myList = new MyLinkedList<>();

        myList.add(1);
        myList.add(2);
        myList.add(3);
        printArray(myList);

        myList.set(1, 2);
        printArray(myList);

        myList.add(1, 0);
        printArray(myList);

        myList.addFirst(1);
        printArray(myList);

        myList.addLast(5);
        printArray(myList);


        System.out.println(myList.get(1));


        System.out.println(myList.getFirst());


        System.out.println(myList.getLast());


        myList.remove(1);
        printArray(myList);


        myList.removeFirst();
        printArray(myList);


        myList.removeLast();
        printArray(myList);


        myList.sort();
        printArray(myList);


        System.out.println(myList.indexOf(20));


        System.out.println(myList.lastIndexOf(20));


        System.out.println(myList.exists(20));


        myList.clear();
        printArray(myList);


        System.out.println(myList.size());
    }

    public static void printArray(Iterable<Integer> arr) {
        for (Object object : arr) {
            System.out.print(object + " ");
        }
        System.out.println();
    }
}