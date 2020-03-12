package com.hari.oracle;

import java.util.Scanner;

public class CandidateCode {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		String finalString[] = new String[n];
		String inputDataEven[] = new String[n];
		String inputDataOdd[] = new String[n];
		String inputData[] = new String[n * 2];
		int oddCount = 0;
		int evenCount = 0;
		for (int i = 0; i < inputData.length; i++) {
			inputData[i] = sc.next();
			if (inputData[i] != null && !inputData[i].equals("")) {
				if (i == 0) {
					inputDataOdd[oddCount] = inputData[i];
					oddCount = oddCount + 1;
				} else if (i == 1) {
					inputDataEven[evenCount] = inputData[i];
					evenCount = evenCount + 1;
				} else if (i % 2 == 0) {
					inputDataEven[evenCount] = inputData[i];
					evenCount = evenCount + 1;
				} else {
					inputDataOdd[oddCount] = inputData[i];
					oddCount = oddCount + 1;
				}
			} // if..null

		} // for

		char graph2[][] = new char[n][n];
		for (int i = 0; i < finalString.length; i++) {
			if (inputDataEven[i] != null) {
				finalString[i] = inputDataOdd[i] + inputDataEven[i];
				char columns[] = finalString[i].toCharArray();
				for (int column = 0; column < columns.length; column++) {
					graph2[i][column] = columns[column];
				}
			}
		} // for

		int destX1 = 0, destY1 = 0, sourceX2 = 0, sourceY2 = 0;
		int[] dist = new int[4];
		int count = 0;

		// let's loop through array to print each row and column
		for (int row = 0; row < graph2.length; row++) {
			for (int col = 0; col < graph2[row].length; col++) {
				if (' ' != graph2[row][col]) {
					sourceX2 = row;
					sourceY2 = col;
					if (graph2[row][col] == 'M') {
						destX1 = row;
						destY1 = col;
					}

					if (sourceX2 != destX1 && sourceY2 != destY1) {
						if (graph2[row][col] == 'V') {
							double distance = calDis(destX1, destY1, sourceX2, sourceY2);
							dist[count] = (int) distance;
							count = count + 1;
						}
					}
				} // if

			} // for..column
		} // for..row

		int minDistance = getMinValue(dist);
		System.out.print(minDistance);
	}

	public static double calDis(int x1, int y1, int x2, int y2) {
		return (Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)));
	}

	public static int getMinValue(int[] numbers) {
		int minValue = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < minValue) {
				minValue = numbers[i];
			}
		}
		return minValue;
	}
}
