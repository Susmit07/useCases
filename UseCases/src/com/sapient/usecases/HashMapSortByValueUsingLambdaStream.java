package com.sapient.usecases;

import java.util.*;
import java.util.stream.Stream;

public class HashMapSortByValueUsingLambdaStream {

	public static void main(String[] args) {

		Map<String, String> employeeMap = new HashMap<String, String>();
		employeeMap.put("1", "Susmit");
		employeeMap.put("2", "Panjvir");
		employeeMap.put("3", "Rahul");
		employeeMap.put("4", "Akash");
		employeeMap.put("5", "Aryan");

		System.out.println("Original Employee: \n"+employeeMap);

		Map<String, String> sortedEmployeeMap = new LinkedHashMap<String, String>();
		Stream<Map.Entry<String, String>> stream = employeeMap.entrySet().stream();
		stream.sorted(Map.Entry.<String, String>comparingByValue().reversed()).
		forEach(s ->sortedEmployeeMap.put(s.getKey(),s.getValue()));

		System.out.println("The Sorted Map in Descending Order of Values is: \n"+sortedEmployeeMap);

	}
}
