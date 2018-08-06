package ru.job4j.loop;

public class Factorial {
	/**
	* Метод вычисления факториала числа.
	*
	* @param n - число для вычисления факториала
	*/
	public int calc(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}	
			
}