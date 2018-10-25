package ru.job4j.coffeemachine;

import org.junit.Test;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

public class CoffeeMachineTest {
    @Test
    public void whenPrice33andValue50ThenCnange10And5And2() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] changes = coffeeMachine.changes(33, 50);
        int[] result = {10, 5, 2};
        assertThat(changes, is(result));
    }
}