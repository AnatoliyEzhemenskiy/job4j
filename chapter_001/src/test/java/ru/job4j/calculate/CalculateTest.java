package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Anatoliy Ezhemenskiy (mailto:a.ezhem@gmail.com)
* @version $Id$
* @since 0.1
*/
public class CalculateTest {

	/**
	* Test echo.
	*/	
	@Test
	public void whenTakeNameThenThreeEchoPlusName() {
		String input = "Vasya Pupkin";
		String expect = "Echo, echo, echo : Vasya Pupkin";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}