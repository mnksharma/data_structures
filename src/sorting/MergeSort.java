package sorting;

import java.util.ArrayList;
import static util.Util.*;
import java.util.stream.IntStream;

public class MergeSort {
	private static void merge(int[] array, int startIndex, int pivotIndex, int endIndex) {
		int numberOfElementsToSort = 1 + endIndex - startIndex; // Need to add 1 since this is a count rather than an index
		
		int leftStart = startIndex;
		int rightStart = pivotIndex+1;

		ArrayList<Integer> temp = new ArrayList<>(numberOfElementsToSort); // Temporary array to hold sorted sub-array
		
		while(leftStart <= pivotIndex && rightStart <= endIndex) {// While we have both left and right halves of the array
			if(array[leftStart] <= array[rightStart])
				temp.add(array[leftStart++]);
			else
				temp.add(array[rightStart++]);
		}
		
		while(leftStart <= pivotIndex) // While we only have left half
			temp.add(array[leftStart++]);
		
		while(rightStart <= endIndex) // While we only have right half
			temp.add(array[rightStart++]);
	
		// Copy back sorted sub-array back into the main array
		IntStream.range(0, temp.size())
				 .forEach(i -> array[startIndex + i] = temp.get(i));
	}

	public static void sort(int[] array, int startIndex, int endIndex) {
		if (endIndex <= startIndex) // Guarding against indexes overlapping which will result in infinite recursion
			return;

		int pivotIndex = (startIndex + endIndex) / 2; // Find the pivot index (mid-point of the array)
		sort(array, startIndex, pivotIndex); // Recursive sort left sub-array
		sort(array, pivotIndex + 1, endIndex); // Recursively sort right sub-array
		merge(array, startIndex, pivotIndex, endIndex); // Merge the two sorted sub-arrays
	}

	public static void main(String[] args) {
		int[] a = { 34, 65, 3, 36, 23, 4, 7, 234, 3, 435 };
		print(a);
		sort(a, 0, a.length - 1);
		print(a);
		System.out.println("Sorting complete");
	}
}
