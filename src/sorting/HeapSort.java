package sorting;
import static util.Util.*;

public class HeapSort {

	// Find the parent index of the given child index
	private static int getParentIndex(int index) {
		if(index % 2 == 0) // If the index is an even number we need to divide by 2 and subtract 1 else just divide by 2
			return (int)(index / 2) - 1;
		else
			return index / 2;
	}
	
	private static void heapifyDown(int[] array, int parentIndex, int endIndex) {
		int maxChildIndex = getMaxChildIndex(array, parentIndex, endIndex); // Get the index of the maximum child of the parent
		while(maxChildIndex > 0 && parentIndex < endIndex && array[parentIndex] < array[maxChildIndex]) { // While parent is less than child, swap the parent with child and repeat the process with child
			swap(array, parentIndex, maxChildIndex);
			parentIndex = maxChildIndex;
		}
	}
	
	private static int getMaxChildIndex(int[] array, int parentIndex, int endIndex) {
		int leftChildIndex  = 2 * parentIndex + 1; // Left child index of the parent index
		int rightChildIndex = 2 * parentIndex + 2; // Right child index of the parent index
		if(leftChildIndex <= endIndex) { // If we have left child
			if(rightChildIndex <= endIndex && array[rightChildIndex] > array[leftChildIndex]) // If we have right child also and right child is greater than left
				return rightChildIndex;
			else
				return leftChildIndex;
		}
		return -1; // Ideally this should not happen
	}
	
	private static void makeMaxHeap(int[] array, int startIndex, int endIndex) {
		for(int parentIndex = getParentIndex(endIndex); parentIndex >= startIndex; --parentIndex) { // Working backwards from the last 'parent' node
			int maxChildIndex = getMaxChildIndex(array, parentIndex, endIndex); // Find the maximum child of the current parent
			if(array[parentIndex] < array[maxChildIndex]) { // If maximum child is less than the parent then swap parent and child and trickle the changes down the heap
				swap(array, parentIndex, maxChildIndex);
				heapifyDown(array, maxChildIndex, endIndex);
			}
		}
	}
	
	public static void sort(int[] array, int startIndex, int endIndex) {
		if (endIndex <= startIndex) // Guarding against indexes overlapping which will result in infinite recursion
			return;
		
		makeMaxHeap(array, startIndex, endIndex); // Make max-heap of the array
		swap(array, startIndex, endIndex); // Swap the first element (being the max value) with the last element
		sort(array, startIndex, endIndex - 1); // Recursively sort sub-array from 0 to N-1 elements
	}

	public static void main(String[] args) {
		int[] a = {5,3,3,6,8,9,4,2,6,34,2,24,6,7,2,4,5,5,53,4};
		util.Util.print(a);
		sort(a, 0, a.length - 1);
		util.Util.print(a);
		System.out.println("Heap sort complete");
	}
}
