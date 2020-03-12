package com.hari.datastructures;

public class BubbleSortEx1 {

	/*https://www.geeksforgeeks.org/bubble-sort/
	Other Sorting Algorithms on GeeksforGeeks/GeeksQuiz:
	    Selection Sort
	    Insertion Sort
	    Merge Sort
	    Heap Sort
	    QuickSort
	    Radix Sort
	    Counting Sort
	    Bucket Sort
	    ShellSort
	*/
	
	private void bubbleSort(int arr[]) {
		int n = arr.length;
		int counter = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap temp and arr[i]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					counter++;
				} //if
			} // for
		} // for
		System.out.println("Counter : " + counter);
	}

	/* Prints the array */
	private void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// Driver method to test above
	public static void main(String args[]) {
		BubbleSortEx1 ob = new BubbleSortEx1();
		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		ob.bubbleSort(arr);
		System.out.println("Sorted array");
		ob.printArray(arr);
	}

}
