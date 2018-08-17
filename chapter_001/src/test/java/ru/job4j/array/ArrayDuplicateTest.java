package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate dupl = new ArrayDuplicate();
        String[] input = new String[] {"1", "1", "2", "3", "4", "4", "5", "5"};
        String[] result = new String[] {"1", "2", "3", "4", "5"};
		input = dupl.remove(input);
        assertThat(input, arrayContainingInAnyOrder(result));
    }
}