/**
 * 
 */
package com.hari.oracle;

import java.util.Scanner;

/**
 * @author bc887d
 *
 */
public class ShortestPath {

	/**
	 * @param args
	 */
	static final int V = 8;

	int minDistance(int dist[], Boolean sptSet[]) {
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

	// A utility function to print the constructed distance array
	void printSolution(int dist[], int n) {
		System.out.println("Vertex   Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i + " tt " + dist[i]);
	}

	// Function that implements Dijkstra's single source shortest path
	// algorithm for a graph represented using adjacency matrix
	// representation
	void dijkstra(char graph[][], int src) {
		int dist[] = new int[V]; // The output array. dist[i] will hold
		// the shortest distance from src to i

		// sptSet[i] will true if vertex i is included in shortest
		// path tree or shortest distance from src to i is finalized
		Boolean sptSet[] = new Boolean[V];

		// Initialize all distances as INFINITE and stpSet[] as false
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		// Distance of source vertex from itself is always 0
		dist[src] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < V - 1; count++) {
			// Pick the minimum distance vertex from the set of vertices
			// not yet processed. u is always equal to src in first
			// iteration.
			int u = minDistance(dist, sptSet);

			// Mark the picked vertex as processed
			sptSet[u] = true;

			// Update dist value of the adjacent vertices of the
			// picked vertex.
			for (int v = 0; v < V; v++)

				// Update dist[v] only if is not in sptSet, there is an
				// edge from u to v, and total weight of path from src to
				// v through u is smaller than current value of dist[v]
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

		// print the constructed distance array
		printSolution(dist, V);
	}

	private void input() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("n : " + n);

		String inputDataEven[] = new String[n];
		String inputDataOdd[] = new String[n];
		String inputData[] = new String[n * 2];
		for (int i = 0; i < inputData.length; i++) {
			inputData[i] = sc.next();
			System.out.println("inputData[" + i + "] : " + inputData[i]);
			if (i == 0) {
				inputDataOdd[i] = sc.next();
			} else if (i % 2 == 0) {
				inputDataEven[i] = sc.next();
			} else {
				inputDataOdd[i] = sc.next();
			}
		}

		String graphRow[][] = new String[n][n];
		for (int row = 0; row < graphRow.length; row++) {
//			graphRow[row] = inputData[row];
		} // row

		String graph3[][] = new String[n][n];
		for (int row = 0; row < graphRow.length; row++) {

		} // row
	}

	// Driver method
	public static void main(String[] args) {
		/* Let us create the example graph discussed above */
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		char graph2[][] = new char[][] { { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'M' },
				{ 'O', 'V', 'O', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'O', 'V', 'O', 'O', 'O', 'V', 'O' },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
				{ 'O', 'O', 'O', 'O', 'V', 'O', 'O', 'O' } };

//		ShortestPath t = new ShortestPath();
//		t.dijkstra(graph2, 0);

		int destX1 = 0;
		int destY1 = 0;
		int sourceX2 = 0;
		int sourceY2 = 0;

		int[] dist = new int[4];
		int count = 0;

		// let's loop through array to print each row and column
		for (int row = 0; row < graph2.length; row++) {
			for (int col = 0; col < graph2[row].length; col++) {
				graph2[row][col] = graph2[row][col];
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
			} // for..column
		} // for..row

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
