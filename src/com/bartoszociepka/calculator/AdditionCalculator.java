package com.bartoszociepka.calculator;
/**
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reddit Challenge #331 - Easy
 * 
 * Link: https://www.reddit.com/r/dailyprogrammer/comments/6ze9z0/20170911_challenge_331_easy_the_adding_calculator/
 * 
 * Calculator based on addition only capable of adding, subtracting, multiplying, dividing and expotent
 * 
 * @author Bartosz Ociepka
 *
 */
public class AdditionCalculator {
	private int firstNumber;
	private int secondNumber;
	private Action action;
	
	public enum Action {
		ADD('+'), SUBTRACT('-'), MULTIPLY('*'), DIVIDE('/'), EXPOTENT('^');
		private char value;
		private Action(char value) {
			this.value = value;
			}
		public static Action fromChar(char character) throws Exception {
			switch(character) {
			case '+':return ADD;
			case '-':return SUBTRACT;
			case '*':return MULTIPLY;
			case '/':return DIVIDE;
			case '^':return EXPOTENT;
			default: throw new Exception("Incorrect action");
			}
		}
		public String toString() {
			return Character.toString(this.value);
		}
		}
	BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	/**
	 * Starts the calculator
	 */
	public void start() {
		AskForNumbers();
		AskForAction();
		try {
			System.out.println(firstNumber + " " + action + " " + secondNumber + " = " + calculate(firstNumber, secondNumber, action));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}
	/**
	 * Asks user for numbers to make an equation and assigns them to firstNumber and secondNumber variables
	 */
	private void AskForNumbers() {
		System.out.print("Give me first number: ");
		try {
			firstNumber = Integer.parseInt(buffer.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Only integers are possible");
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("Give me second number: ");
		try {
			secondNumber = Integer.parseInt(buffer.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Only integers are possible");
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Asks user for action and stores it in action variable
	 */
	public void AskForAction() {
		System.out.print("Give me action ");
		try {
			action = Action.fromChar(buffer.readLine().charAt(0));
		}  catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}
	
	/**
	 * Calculates the equation
	 * @param firstNumber first number
	 * @param secondNumber second number
	 * @param action type of equation
	 * @return result of equation
	 * @throws Exception 
	 */
	public String calculate(int firstNumber, int secondNumber, Action action) throws Exception {
		switch(action) {
			case ADD: return add(firstNumber, secondNumber);
			case SUBTRACT: return subtract(firstNumber, secondNumber);
			case MULTIPLY: return multiply(firstNumber, secondNumber);
			case DIVIDE: return divide(firstNumber, secondNumber);
			case EXPOTENT: return expotent(firstNumber, secondNumber);
		}
		throw new Exception("Non-existent action");
	}
	/**
	 * Changes the sign of a number using only addition
	 * @param a number to change
	 * @return modified number
	 */
	public int changeSign(int a) {
		int helper = -500;
		
		while(helper + a != 0) {
			helper++;
		}
		
		return helper;
		
	}
	
	/**
	 * Adds 2 numbers
	 * @param a first number to add
	 * @param b second number to add
	 * @return result of addition
	 */
	public String add(int a, int b) {
		return Integer.toString(a + b);
	}
	
	/**
	 * Subtracts 2 numbers using addition
	 * @param a number to subtract from
	 * @param b subtracted number
	 * @return result of subtraction
	 */
	public String subtract(int a, int b) {
		int helper = changeSign(b);
		
		return Integer.toString(a + helper);
	}
	
	/**
	 * Multiplies 2 numbers using addition
	 * @param a first number
	 * @param b second number
	 * @return result of multiplication
	 */
	public String multiply(int a, int b) {
		int result = 0;
		int sign = 1;
		
		if(a < 0) {
			sign = changeSign(sign);
			a = changeSign(a);
		}
		
		if(b < 0) {
			sign = changeSign(sign);
			b = changeSign(b);
		}
		
		while(a != 0) {
			a = Integer.parseInt(subtract(a, 1));
			result += b;
			
		}
		if(sign == 1) return Integer.toString(result);
		else return Integer.toString(changeSign(result));
	}
	/**
	 * Divides numbers using addition
	 * @param a number to divide from
	 * @param b divisor
	 * @return result of division
	 * @throws Exception 
	 */
	public String divide(int a, int b) {
		int sign = 1;
		int result = 0;
		
		if(b == 0) return "Not-defined";
		
		if(a < 0) {
			a = changeSign(a);
			sign = changeSign(sign);
		}
		
		if(b < 0) {
			b = changeSign(b);
			sign = changeSign(sign);
		}
		
		while(a > 0) {
			a = Integer.parseInt(subtract(a, b));
			result++;
		}
		
		if(a < 0) return "Non-integral answer";
 		else return multiply(result, sign);
	}
	/**
	 * Calculates expotent using addition
	 * @param a number
	 * @param b power
	 * @return result of equation
	 * @throws Exception 
	 */
	public String expotent(int a, int b) {
		int result = 1;
		if(b >= 0) {
			while(b > 0) {
				result = Integer.parseInt(multiply(result, a));
				b = Integer.parseInt(subtract(b, 1));
			}
			return Integer.toString(result);
		}
		else {
			while(b < 0) {
				try {
					result = Integer.parseInt(divide(result, a));
				}
				catch (NumberFormatException ex) {
					return divide(result, a);
				}
				b++;
			}
			return Integer.toString(result);
		}
	}
}
