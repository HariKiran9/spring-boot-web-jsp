package com.hari.concurrency.fibonacci;

public class FibanocciTest {

	public static void main(String[] args) {
		printEvenFibonacci(1, 1, 10);
	}

	public static void printEvenFibonacci(int a, int b, int n) {
		int n3 = 0, n1 = a, n2 = b;
		for (int i = 2; i < n; i++) {
			n3 = n1 + n2;
			if (n3 % 2 == 0) {
				System.out.println("n3 : " + n3);
			}
			n1 = n2;
			n2 = n3;
		} // for

	}

}
