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
		
		System.out.println("You gave me " + firstNumber + " and " + secondNumber);
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
			case '+': return Integer.toString(firstNumber + secondNumber);
			case '-': return Integer.toString(firstNumber + (-secondNumber));
		}
		return "Non-existent action";
	}
}
