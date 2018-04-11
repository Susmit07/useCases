package com.sapient.usecases;

import java.util.Arrays;

// [7] Find nth largest element of an Unsorted array.
public class NLargestElementInUnsortedArray {

	public static void main(String[] args) {

		Integer arr[] = new Integer[]{12, 3, 5, 7, 19};
		int k = 2;
		System.out.print( "N'th largest element is "+nthLargest(arr, k) );   
	}

	private static int nthLargest(Integer[] arr, int k) {
		Arrays.sort(arr);
		int length = arr.length;
		return arr[length-k];
	}
}
