package com.sapient.usecases;

public class FibonacciSeriesIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		printFibonacciSeries(n);
	}
	private static void printFibonacciSeries(int n)
	{
		int a=0,b=1,sum=0;
		for(int i=2;i<=n;i++)
		{
			sum=a+b;
			System.out.println(sum);
			a=b;
			b=sum;
		}
	}
}
