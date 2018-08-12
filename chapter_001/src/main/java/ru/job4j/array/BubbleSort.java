package ru.job4j.array;

/**
Сортировка массива пузырьковым методом
*/
public class BubbleSort {
	public int[] sort(int[] array) {
		int element;
		int j = array.length - 1;
		while (j > 0) {
			for (int i = 0; i < j; i++) {
				if (array[i] > array[i + 1]) {
					element = array[i];
					array[i] = array[i + 1];
					array[i + 1] = element;
				}
			}
			j--;
		}
		return array;
	}
}