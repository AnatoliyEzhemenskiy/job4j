package ru.job4j.array;

public class Merge {
    public int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int z = result.length;
        int i = array1.length - 1;
        int j = array2.length - 1;
        while (z > 0)
            result[--z] = (j < 0)||(array1[i] > array2[j]) ? array1[i--] : array2[j--];
        return result;
    }
}
