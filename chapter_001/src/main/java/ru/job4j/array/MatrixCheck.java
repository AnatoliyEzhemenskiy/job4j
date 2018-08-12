package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
		int last = data[0].length - 1;
        for (int i = 0; i < last; i++) {
			if (data[i][i] != data[i + 1][i + 1] || data[i][last - i] != data[i + 1][last - i - 1]) {
				result = false;
				break;				
			}
        }
        return result;
    }
}

