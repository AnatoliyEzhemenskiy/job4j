package ru.job4j.array;

import static org.hamcrest.core.Is.is;
import org.junit.Test;
import static org.junit.Assert.assertThat;

public class MergeTest {
    @Test
    public void whenTwoMergedSortedArraysThenOneBigSortedArray() {
        Merge merge = new Merge();
        int[] array1 = {1, 2, 4, 8, 10};
        int[] array2 = {3, 5, 6, 7, 9};
        int[] result = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(merge.merge(array1, array2), is(result));
    }
}