package ru.job4j.array;

public class Turn {
    public int[] turn(int[] array) {
		int element;
        for (int i = 0; i < array.length / 2; i++) {
			element = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = element;			
        }
        return array;
    }
}