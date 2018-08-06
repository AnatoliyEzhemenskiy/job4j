package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
	@Test
	public void whenFactorialThreeThanSix() {
		Factorial fact = new Factorial();
		int result = fact.calc(3);
		assertThat(result, is(6));
	}
	@Test
	public void whenFactorialFourThanTwentyFour() {
		Factorial fact = new Factorial();
		int result = fact.calc(4);
		assertThat(result, is(24));
	}
}