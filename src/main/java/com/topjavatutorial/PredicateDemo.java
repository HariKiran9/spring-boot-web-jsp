package com.topjavatutorial;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {

		Predicate<Integer> negative = n -> (n < 0);

		List<Integer> numbers = Arrays.asList(10, 20, 30, -10, -20, -30);
		long negativeCount = numbers.stream().filter(negative).count();
		System.out.println("Count of negative numbers in list numbers = " + negativeCount);

		List<Integer> moreNumbers = Arrays.asList(-100, -200, -50, 0, 30, -10, -20, -30);
		long negativeCount2 = moreNumbers.stream().filter(negative).count();
		System.out.println("Count of negative numbers in list moreNumbers = " + negativeCount2);

	}

}
