package com.sapient.usecases;

import java.util.Scanner;

public class FibonacciSeriesUsingRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Please Enter Number : ");
		int input = sc.nextInt();
		if (input < 2)
			System.out.println("Please put a valid number ");
		else
			System.out.println("The value is: "+printFibonacciSeries(input));
		sc.close();
	}

	private static int printFibonacciSeries(int input) {
		if (input == 0) {

			return 0;
		} else if (input == 1) {

			return 1;
		} else {

			return printFibonacciSeries(input - 1) + printFibonacciSeries(input - 2);
		}
	}
}