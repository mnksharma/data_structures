package sorting;
import static util.Util.*;

public class QuickSort {
	
	private static int partition(int[] array, int startIndex, int endIndex, int pivot) {
		while(startIndex <= endIndex) { // While start/end indexes have not overlapped
			
			while(array[startIndex] < pivot) // Move forward the startIndex until we find a value that is less than the pivot
				startIndex++;
			
			while(array[endIndex] > pivot) // Move backward the endIndex until we find a value greater than the pivot
				endIndex--;
			
			if(startIndex <= endIndex) { // If we found something and start/end indexes don't overlap then swap the values
				swap(array, startIndex, endIndex);
				startIndex++;
				endIndex--;
			}
		}
		return startIndex;
	}
	
	public static void sort(int[] array, int startIndex, int endIndex) {
		if (endIndex <= startIndex) // Guarding against indexes overlapping which will result in infinite recursion
			return;
		
		int pivot = array[(startIndex + endIndex) / 2]; // Find the pivot (middle value of the array)
	
		int partitionIndex = partition(array, startIndex, endIndex, pivot); // Find the partition (rough mid-point of the array)
		sort(array, startIndex, partitionIndex - 1); // Recursively sort the left sub-array
		sort(array, partitionIndex, endIndex); // Recursively sort the right sub-array
	}

	public static void main(String[] args) {
		int[] a = {1,1,2,1,3,3};
		print(a);
		sort(a, 0, a.length - 1);
		print(a);
		System.out.println("Quick sort complete");
	}
}
