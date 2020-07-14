package ru.job4j.lambda;

public class Reduce {
    public static int summation(int to) {
        int rsl = 0;
        for (int index = 0; index <= to; index++) {
            rsl += index;
        }
        return rsl;
    }

    public static int multiplication(int to) {
        int rsl = 1;
        for (int index = 1; index <= to; index++) {
            rsl *= index;
        }
        return rsl;
    }

    public static void main(String[] args) {
        System.out.println(summation(3));
        System.out.println(multiplication(3));
    }
}
