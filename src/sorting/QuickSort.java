package sorting;
import static util.Util.*;

public class QuickSort {
	
	private static int partition(int[] array, int startIndex, int endIndex, int pivot) {
		while(startIndex <= endIndex) { // While start/end indexes have not overlapped

			while(array[startIndex] < pivot) // Move forward the startIndex until we find a value that is less than the pivot
				startIndex++;
			
			while(array[endIndex] > pivot) // Move backward the endIndex until we find a value greater than the pivot
				endIndex--;
			util.Util.print(array);

			if(startIndex <= endIndex) { // If we found something and start/end indexes don't overlap then swap the values
				swap(array, startIndex, endIndex);
				startIndex++;
				endIndex--;
			}
		}
		return startIndex;
	}
	
	public static void sort(int[] array, int startIndex, int endIndex) {
		if (endIndex <= startIndex) { // Guarding against indexes overlapping which will result in infinite recursion
			return;
		}
		
		int pivot = array[(startIndex + endIndex) / 2];
	
		int partitionIndex = partition(array, startIndex, endIndex, pivot);
		sort(array, startIndex, partitionIndex - 1);
		sort(array, partitionIndex, endIndex);
	}

	public static void main(String[] args) {
		int[] a = {1,1,2,1,3,3};
		print(a);
		sort(a, 0, a.length - 1);
		print(a);
		System.out.println("Quick sorting complete");
	}
}
