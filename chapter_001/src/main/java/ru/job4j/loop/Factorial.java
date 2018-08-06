package ru.job4j.loop;

public class Factorial {
	public int calc(int n) {
    /**
     * Метод вычисления факториала числа.
     *
     * @param n - число для вычисления факториала
     */
		int result = 1;
		for (int i = 1; i <= n; i++) {
				result *= i;
		}
		return result;
	}
			
}