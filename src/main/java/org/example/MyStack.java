package org.example;

public class MyStack<T>  {

    private MyLinkedList<T> stack = new MyLinkedList<>();

    public MyStack() {
    }

    public T top() { // top element
        return (T) stack.getLast();
    }

    public T pop() { // gets top element and removes it
        T item = stack.getLast();
        stack.removeLast();
        return item;
    }

    public void push(T item) {// adds elements to the top of the stack
        stack.addLast(item);
    }

    public boolean isEmpty() {// checks if the stack is empty
        return stack.size() == 0;
    }

    public int size() {// size function
        return stack.size();
    }

    public void clear() {// clear function
        stack.clear();
    }

}