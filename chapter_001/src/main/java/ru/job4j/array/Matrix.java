package ru.job4j.array;
/**
 * Matrix
 *
 * @author - AnatoliyEzhemenskiy
 *
*/
public class Matrix {
	/**
	 * Генерируется таблица умножения
	 * @param size - размерность таблицы
	 * @return маасив таблицы умножения
	 */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				table[i][j] = (i + 1) * (j + 1);
			}
		}
        return table;
    }
}