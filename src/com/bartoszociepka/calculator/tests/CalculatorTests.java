package com.bartoszociepka.calculator.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bartoszociepka.calculator.Calculator;

public class CalculatorTests {

	@Test
	public void test() {
		Calculator calc = new Calculator();
		
		assertEquals("12 + 25","37", calc.calculate(12, 25, '+'));
		assertEquals("-30 + 100", "70", calc.calculate(-30, 100, '+'));
		assertEquals("100 - 30", "70", calc.calculate(100, 30, '-'));
		assertEquals("100 - -30", "130", calc.calculate(100, -30, '-'));
		assertEquals("-25 - 29", "-54", calc.calculate(-25, 29, '-'));
		assertEquals("-41 - -10", "-31", calc.calculate(-41, -10, '-'));
		assertEquals("9 * 3", "27", calc.calculate(9, 3, '*'));
		assertEquals("9 * -4", "-36", calc.calculate(9, -4, '*'));
		assertEquals("-4 * 8", "-32", calc.calculate(-4, 8, '*'));
		assertEquals("-12 * -9", "108", calc.calculate(-12, -9, '*'));
		assertEquals("100 / 2", "50", calc.calculate(100, 2, '/'));
		assertEquals("75 / -3", "-25", calc.calculate(75, -3, '/'));
		assertEquals("-75 / 3", "-25", calc.calculate(-75, 3, '/'));
		assertEquals("7 / 3", "Non-integral answer", calc.calculate(7, 3, '/'));
		assertEquals("0 / 0", "Not-defined", calc.calculate(0, 0, '/'));
		assertEquals("5 ^ 3", "125", calc.calculate(5, 3, '^'));
		assertEquals("-5 ^ 3", "-125", calc.calculate(-5, 3, '^'));
		assertEquals("-8 ^ 3", "-512", calc.calculate(-8, 3, '^'));
		assertEquals("-1 ^ 1", "-1", calc.calculate(-1, 1, '^'));
		assertEquals("1 ^ 1", "1", calc.calculate(1, 1, '^'));
		assertEquals("0 ^ 5", "0", calc.calculate(0, 5, '^'));
		assertEquals("5 ^ 0", "1", calc.calculate(5, 0, '^'));
		assertEquals("10 ^ -3", "Non-integral answer", calc.calculate(10, -3, '^'));
	}

}
