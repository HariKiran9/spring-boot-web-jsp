package com.hari.datastructures;

public class StairCaseEx1 {

	public static void main(String[] args) {
		staircase(6);
	}

	static void staircase(int n) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; i++)
			builder.append(" ");
		int j = 0;

		for (int i = 1; i <= n; i++) {
			builder.replace(builder.length() - i, builder.length() - j, "#");
			System.out.println(builder);
			j++;
		}
	}// for

}
