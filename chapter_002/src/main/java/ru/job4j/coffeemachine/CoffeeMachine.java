package ru.job4j.coffeemachine;

import java.util.Arrays;

public class CoffeeMachine{
    private int[] NOMINAL = {1,2,5,10};

    public int[] changes(int price, int value) {
        int residue = value - price;
        if (residue < 0) {
            throw new NoMoneyException("Not enough money");
        }
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
        result = Arrays.copyOf(result,i);
        return result;
    }

    public void printChange(int[] changes) {
        for (int i = 0; i < changes.length;i++) {
            System.out.println(changes[i]);
        }
    }

    public static void main(String[] args) {
       CoffeeMachine coffeeMachine = new CoffeeMachine();
       Coffee coffee = new Coffee(32,30);
       try {
           int[] changes = coffeeMachine.changes(coffee.getPrice(), coffee.getValue());
           coffeeMachine.printChange(changes);
       } catch (NoMoneyException nme) {
           System.out.println("Sorry, not enough money");
       }
    }
}
