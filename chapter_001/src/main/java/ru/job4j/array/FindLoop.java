package ru.job4j.array;

/**
 *  Находжние индекса элемента в заданном массиве, с заданным значениемы
 */
public class FindLoop {
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