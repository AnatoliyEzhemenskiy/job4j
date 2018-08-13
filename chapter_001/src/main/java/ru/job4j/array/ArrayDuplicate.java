package ru.job4j.array;

import java.util.Arrays;
/**
 Удаление дубликатов в массиве
*/
public class ArrayDuplicate {
    String[] remove(String[] array) {
        //кол-во одинаковых записей
        int countDubl = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - countDubl; j++) {
                //нашли совпадение, сдвигаем влево (цикл для многократных совпадений)
                while (array[i].equals(array[j]) && j < array.length - countDubl) {
                    for (int z = j; z < array.length - countDubl - 1; z++) {
                        array[z] = array[z + 1];
                    }
                    countDubl++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - countDubl);
    }
}