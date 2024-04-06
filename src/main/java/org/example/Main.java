package org.example;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
//        task8();
//        task9();
//        task10();

    }

    public static void task1(int arr[], int n, int min) { // complexity O(n)
        if (n == 0) {
            System.out.println(min);
        } else if (min > arr[n - 1]) {
            min = arr[n - 1];
            n -= 1;
            task1(arr, n, min);
        } else {
            n -= 1;
            task1(arr, n, min);
        }
    }

    public static void task1() { // complexity O(n)
        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int min = arr[n - 1];
        if (n == 1) {
            System.out.println(arr[0]);
        } else {
            task1(arr, n, min);
        }
    }


    public static void task2() { // complexity O(n)
        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int i = 0;
        float sum = 0;
        task2(arr, n, i, sum);
    }

    public static void task2(int arr[], int n, int i, float sum) { // complexity O(n)
        if (n == i) {
            System.out.println(sum / n);
            return;
        }
        sum += arr[i];
        i += 1;
        task2(arr, n, i, sum);
    }


    private static boolean task3(int n, int limit, int i) { // complexity O(sqrt(n))
        if (n == 1) {
            return false;
        }

        if (i > limit) {
            return true;
        }

        if (n % i == 0) {
            return false;
        }

        return task3(n, limit, i + 1);

    }

    public static String task3(int n) { // complexity O(n)
        if (n == 1) {
            return "Composite";
        }

        return task3(n, (int) Math.sqrt(n), 2) ? "Prime" : "Composite";
    }

    public static void task3() {
        int n = scan.nextInt();
        System.out.println(task3(n));
    }

    public static void task4() {
        int n = scan.nextInt();
        int sum = 1;
        task4(n, sum);
    }

    public static void task4(int n, int sum) { //complexity O(n)
        if (n == 1) {
            System.out.println(sum);
            return;
        }

        sum *= n;
        task4(n - 1, sum);
    }

    public static void task5() {
        int n = scan.nextInt();
        System.out.println(task5(n));
    }

    public static int task5(int n) { //complexity O(2^n)
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return task5(n - 2) + task5(n - 1);
    }

    public static void task6() {
        int a = scan.nextInt();
        int n = scan.nextInt();
        int sum = 1;
        task6(n, a, sum);
    }

    public static void task6(int n, int a, int sum) { //complexity O(n)
        if (n == 0) {
            System.out.println(sum);
            return;
        }
        sum *= a;
        n -= 1;
        task6(n, a, sum);
    }

    public static void task7() {
        String s = scan.next();
        task7(s);
    }

    public static String task7(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    private static void task7(String s, int i) { //complexity O(n!)
        if (i == s.length()) {
            System.out.println(s);
            return;
        }

        for (int j = i; j < s.length(); j++) {
            s = task7(s, i, j);
            task7(s, i + 1);
            s = task7(s, i, j);
        }

    }

    public static void task7(String s) { //complexity O(n!)
        task7(s, 0);
    }

    private static void task8(){
        String s = scan.next();
        int n = 0;
        if(task8(s, n)){
            System.out.println("Yes");
        }else
            System.out.println("No");

    }

    private static boolean task8(String s, int n){
        if(n == s.length()){
            return true;
        }

        if(s.charAt(n) < '0' || s.charAt(n) > '9'){
            return false;
        }

        return task8(s, n+1);

    }

    public static void task9() {
        int n = scan.nextInt();
        int k = scan.nextInt();
        System.out.println(task9(n, k));
    }

    public static int task9(int n ,  int k) { //complexity O(n)
        if(k == 0 || k == n){
            return 1;
        }

        return task9(n-1, k-1) + task9(n-1, k);
    }

    public static void task10() {
        int n = scan.nextInt();
        int m = scan.nextInt();
        System.out.println(task10(n, m));
    }

    public static int task10(int n , int m) { //complexity O(log(n))
        if(m == 0){
            return n;
        }

        return task10(m, n % m);
    }

}