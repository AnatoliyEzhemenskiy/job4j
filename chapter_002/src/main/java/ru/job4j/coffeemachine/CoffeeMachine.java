package ru.job4j.coffeemachine;

import java.util.Arrays;

public class CoffeeMachine {
    private final int[] NOMINAL = {1, 2, 5, 10};

    public final int[] changes(int price, int value) {
        int residue = value - price;
        int[] result = new int[residue];
        int i = 0;
        int index = NOMINAL.length - 1;
        while (residue != 0) {
            while (residue - NOMINAL[index] < 0) {
                index--;
            }
            residue -= NOMINAL[index];
            result[i++] = NOMINAL[index];
        }
        return Arrays.copyOf(result, i);
    }
}