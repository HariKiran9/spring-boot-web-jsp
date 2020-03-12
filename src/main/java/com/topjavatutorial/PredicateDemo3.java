package com.topjavatutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo3 {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(15);
		numbers.add(20);
		numbers.add(25);

		System.out.println("Original List : " + numbers);
//		numbers.removeIf(num -> num % 2 == 0);
		System.out.println("Odd numbers : " + numbers);
		
		mutipleof2Or3(numbers);
	}

	private static void mutipleof2Or3(List<Integer> numbers) {
		Predicate<Integer> multipleOf2 = num -> num % 2 == 0;
		Predicate<Integer> multipleOf3 = num -> num % 3 == 0;
		System.out.println("Multiples of 2 or 3 in numbers list are : ");
		for (Integer num : numbers) {
			if ((multipleOf2.or(multipleOf3)).test(num))
				System.out.println(num);
		}
	}

}
