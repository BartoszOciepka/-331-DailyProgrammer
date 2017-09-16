package com.bartoszociepka.calculator;
/**
 * 
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reddit Challenge #331
 * 
 * Link: https://www.reddit.com/r/dailyprogrammer/comments/6ze9z0/20170911_challenge_331_easy_the_adding_calculator/
 * 
 * @author Bartosz Ociepka
 *
 */
public class Calculator {
	private int firstNumber;
	private int secondNumber;
	private char action;
	BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	/**
	 * Starts the calculator
	 */
	public void start() {
		AskForNumbers();
		AskForAction();
		System.out.println(calculate(firstNumber, secondNumber, action));
	}
	
	private void AskForNumbers() {
		System.out.print("Give me first number: ");
		try {
			firstNumber = Integer.parseInt(buffer.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("Give me second number: ");
		try {
			secondNumber = Integer.parseInt(buffer.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void AskForAction() {
		System.out.print("Give me action ");
		try {
			action = buffer.readLine().charAt(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String calculate(int firstNumber, int secondNumber, char action) {
		switch(action) {
			case '+': return add(firstNumber, secondNumber);
			case '-': return subtract(firstNumber, secondNumber);
			case '*': return multiply(firstNumber, secondNumber);
			case '/': return divide(firstNumber, secondNumber);
			case '^': return expotent(firstNumber, secondNumber);
		}
		return "Non-existent action";
	}
	
	public int changeSign(int a) {
		int helper = Integer.MAX_VALUE;
		
		while(helper + a != 0) {
			helper++;
		}
		
		return helper;
		
	}
	
	public String add(int a, int b) {
		return Integer.toString(a + b);
	}
	
	public String subtract(int a, int b) {
		int helper = changeSign(b);
		
		return Integer.toString(a + helper);
	}
	
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
		
		return multiply(result, sign);
	}
	
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
