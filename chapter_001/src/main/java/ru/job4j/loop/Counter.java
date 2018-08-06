package ru.job4j.loop;

public class Counter {
	/**
	 * Метод вычисления суммы чётных чисел.
	 *
	 * @param start начальное число
	 * @param finish конечное число
	 */
	public int add(int start, int finish) {
		int result = 0;
		for (int i = start; i <= finish; i++) {
			if (i % 2 == 0) {
				result += i;
			}
		}
		return result;
	}
}