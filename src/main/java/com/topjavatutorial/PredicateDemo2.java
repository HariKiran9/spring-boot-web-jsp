package com.topjavatutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo2 {

	public static void main(String[] args) {
		List<String> employees = new ArrayList<String>();
		employees.add("John");
		employees.add("Bob");
		employees.add("Jane");
		print(employees, emp -> emp.startsWith("J"));
	}

	private static void print(List<String> employees, Predicate<String> empPredicate) {
		for (String emp : employees) {
			if (empPredicate.test(emp))
				System.out.println(emp);
		}
	}

}
