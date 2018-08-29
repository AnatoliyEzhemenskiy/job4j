package ru.job4j.array;

/**
 *  FindLoop
 *
 *   * @author - AnatoliyEzhemenskiy
 */
public class FindLoop {
    /**
     *
     * @param data - массив чисел
     * @param item - искомое число
     * @return - индекс искомого числа
     */
    public int indexOf(int[] data, int item) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == item) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}