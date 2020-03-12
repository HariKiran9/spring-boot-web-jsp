package com.hari.datastructures;

public class RemoveAnagramEx3 {
	// function to calculate minimum numbers of characters to be removed to make two
	// strings anagram
	static int remAnagram(String str1, String str2) {
		// make hash array for both string and calculate frequency of each character
		int count1[] = new int[26];
		int count2[] = new int[26];

		// count frequency of each character in first string
		for (int i = 0; i < str1.length(); i++) {
			count1[str1.charAt(i) - 'a']++;
//			System.out.println("A : " + str1.charAt(i) + " : " + (str1.charAt(i) - 'a'));
		}

		// count frequency of each character in second string
		for (int i = 0; i < str2.length(); i++) {
			count2[str2.charAt(i) - 'a']++;
		}

		// traverse count arrays to find number of characters to be removed
		int result = 0;
		int counter = 0;
		for (int i = 0; i < 26; i++) {
//			System.out.println(" Before Result : " + result);
			result += Math.abs(count1[i] - count2[i]);
//			System.out.println(" Before After : " + result);
			counter++;
		}
		System.out.println(" Counter : " + counter);
		return result;
	}

	// Driver program to run the case
	public static void main(String[] args) {
		String str1 = "bcadeh", str2 = "hea";
		System.out.println(remAnagram(str1, str2));
	}

}
