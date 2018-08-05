package ru.job4j.max;

/**
 * Максимальное из двух чисел
 */
public class Max {
    /**
     * Максимальное из двух чисел.
     * @param first первое число.
	 * @param second второе число.
     * @return наибольшее из двух чисел.
	 */
	
	public int max(int first, int second) {
	    return first > second ? first : second;
	}
}