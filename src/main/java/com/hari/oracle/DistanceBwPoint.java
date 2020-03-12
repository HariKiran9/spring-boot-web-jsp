package com.hari.oracle;

public class DistanceBwPoint {

	public static void main(String[] args) {

		char graph2[][] = new char[][] { { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'M' },
				{ 'O', 'V', 'O', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'O', 'V', 'O', 'O', 'O', 'V', 'O' },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
				{ 'O', 'O', 'O', 'O', 'V', 'O', 'O', 'O' } };

		char graph3[][] = new char[8][8];
		// let's loop through array to populate board
		for (int row = 0; row < graph2.length; row++) {
			for (int col = 0; col < graph2[row].length; col++) {
//				System.out.print("graph2 : " + graph2[row][col] + "\t");
				graph3[row][col] = graph2[row][col];
			}
//			System.out.println();
		}
		int destX1 = 0;
		int destY1 = 0;
		int sourceX2 = 0;
		int sourceY2 = 0;

		int[] dist = new int[4];
		int count = 0;

		// let's loop through array to print each row and column
		for (int row = 0; row < graph2.length; row++) {
			for (int col = 0; col < graph2[row].length; col++) {
				graph3[row][col] = graph2[row][col];
//				System.out.print("graph3 : " + graph3[row][col] + "\t");
				if (' ' != graph2[row][col]) {
					sourceX2 = row;
					sourceY2 = col;
					if (graph3[row][col] == 'M') {
						destX1 = row;
						destY1 = col;
					}

					if (sourceX2 != destX1 && sourceY2 != destY1) {
//					System.out.print(destX1 + "" + destY1 + "" + sourceX2 + "" + sourceY2);
						if (graph3[row][col] == 'V') {
							double distance = calDis(destX1, destY1, sourceX2, sourceY2);
							dist[count] = (int) distance;
							count = count + 1;
						}
					}
				} // if
			} // for..column
//			System.out.println();
		} // for..row

		for (int i = 0; i < dist.length; i++) {
//			System.out.println(dist[i]);
		}

		int minDistance = getMinValue(dist);
		System.out.println("Min Distance : " + minDistance);

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
