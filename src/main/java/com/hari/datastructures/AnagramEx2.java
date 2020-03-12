package com.hari.datastructures;

import java.util.Arrays;

public class AnagramEx2 {

	static int NO_OF_CHARS = 256;

	/*
	 * method to check whether two strings are anagram of each other
	 */
	static boolean areAnagram(char char1[], char char2[]) {

		// If both strings are of different length.
		// Removing this condition will make the program fail for strings like "aaca"
		// and "aca"
		if (char1.length != char2.length) {
			return false;
		}

		// Create 2 count arrays and initialize all values as 0
		int count1[] = new int[NO_OF_CHARS];
		Arrays.fill(count1, 0);

		int count2[] = new int[NO_OF_CHARS];
		Arrays.fill(count2, 0);

		int i;

		// For each character in input strings, increment count in the corresponding
		// count array
		for (i = 0; i < char1.length && i < char2.length; i++) {
			count1[char1[i]]++;
			count2[char2[i]]++;
		}

		// Compare count arrays
		for (i = 0; i < NO_OF_CHARS; i++) {
			if (count1[i] != count2[i]) {
				return false;
			} // if
		} // for
		return true;
	}

	/* Driver program to test to print printDups */
	public static void main(String args[]) {
		char char1[] = ("geeksforgeeks").toCharArray();
		char char2[] = ("forgeeksgeeks").toCharArray();

		if (areAnagram(char1, char2))
			System.out.println("The two strings are anagram of each other");
		else
			System.out.println("The two strings are not anagram of each other");
	}

}
