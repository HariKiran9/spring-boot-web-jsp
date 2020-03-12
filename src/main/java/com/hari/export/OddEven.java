package com.hari.export;

import java.util.ArrayList;
import java.util.List;

public class OddEven {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}

		int[] even = new int[50];
		int[] odd = new int[50];
		int eCounter = 0;
		int oCounter = 0;
		for (int i = 1; i < 101; i++) {
			if (i % 2 == 0) {
				even[eCounter] = i;
				eCounter = eCounter + 1;
			} else {
				odd[oCounter] = i;
				oCounter = oCounter + 1;
			}
		} // for

		for (int i = 0; i < odd.length; i++) {
			System.out.println("even [" + i + "] : " + even[i] + "\t Odd [" + i + "] : " + odd[i]);
		}

	}

}
