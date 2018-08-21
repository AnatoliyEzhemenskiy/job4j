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

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] arr1 = new int[]{1,2,8,9,10};
        int[] arr2 = new int[]{4,5,6,7};
        int[] arr3 = merge.merge(arr1,arr2);

        for(int arr: arr3){
            System.out.println(arr);
        }
    }
}
