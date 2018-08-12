package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void when5319then1359() {
        int[] arr = new int[]{5, 3, 1, 9};
        int[] expect = new int[]{1, 3, 5, 9};
		BubbleSort bsort = new BubbleSort();
        arr = bsort.sort(arr);
        assertThat(arr, is(expect));
    }
}