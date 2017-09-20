package com.bartoszociepka.calculator.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bartoszociepka.calculator.AdditionCalculator;
import com.bartoszociepka.calculator.AdditionCalculator.Action;

public class CalculatorTests {

	AdditionCalculator calc;
	
	public CalculatorTests() {
		calc = new AdditionCalculator();
	}
	
	@Test
	public void addition() throws Exception {
		assertEquals("12 + 25","37", calc.calculate(12, 25, Action.ADD));
		assertEquals("-30 + 100", "70", calc.calculate(-30, 100, Action.ADD));
	}
	
	@Test
	public void subtraction() throws Exception {
		assertEquals("100 - 30", "70", calc.calculate(100, 30, Action.SUBTRACT)); //OK
		assertEquals("100 - -30", "130", calc.calculate(100, -30, Action.SUBTRACT));
		assertEquals("-25 - 29", "-54", calc.calculate(-25, 29, Action.SUBTRACT));
		assertEquals("-41 - -10", "-31", calc.calculate(-41, -10, Action.SUBTRACT));
	}
	
	@Test
	public void multiplication() throws Exception {
		assertEquals("9 * 3", "27", calc.calculate(9, 3, Action.MULTIPLY));
		assertEquals("9 * -4", "-36", calc.calculate(9, -4, Action.MULTIPLY));
		assertEquals("-4 * 8", "-32", calc.calculate(-4, 8, Action.MULTIPLY));
		assertEquals("-12 * -9", "108", calc.calculate(-12, -9, Action.MULTIPLY));
	}
	
	@Test
	public void division() throws Exception {
		assertEquals("100 / 2", "50", calc.calculate(100, 2, Action.DIVIDE));
		assertEquals("75 / -3", "-25", calc.calculate(75, -3, Action.DIVIDE));
		assertEquals("-75 / 3", "-25", calc.calculate(-75, 3, Action.DIVIDE));
		assertEquals("7 / 3", "Non-integral answer", calc.calculate(7, 3, Action.DIVIDE));
		assertEquals("0 / 0", "Not-defined", calc.calculate(0, 0, Action.DIVIDE));
	}
	
	@Test
	public void expotent() throws Exception {
		assertEquals("5 ^ 3", "125", calc.calculate(5, 3, Action.EXPOTENT));
		assertEquals("-5 ^ 3", "-125", calc.calculate(-5, 3, Action.EXPOTENT));
		assertEquals("-8 ^ 3", "-512", calc.calculate(-8, 3, Action.EXPOTENT));
		assertEquals("-1 ^ 1", "-1", calc.calculate(-1, 1, Action.EXPOTENT));
		assertEquals("1 ^ 1", "1", calc.calculate(1, 1, Action.EXPOTENT));
		assertEquals("0 ^ 5", "0", calc.calculate(0, 5, Action.EXPOTENT));
		assertEquals("5 ^ 0", "1", calc.calculate(5, 0, Action.EXPOTENT));
		assertEquals("10 ^ -3", "Non-integral answer", calc.calculate(10, -3, Action.EXPOTENT));
	}
}
