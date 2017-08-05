package sorting;
import static util.Util.*;

public class HeapSort {

	private static int getParentIndex(int index) {
		if(index % 2 == 0)
			return (int)(index / 2) - 1;
		return index / 2;
	}
	
	private static void heapifyDown(int[] array, int parentIndex, int endIndex) {
		int maxChildIndex = getMaxChildIndex(array, parentIndex, endIndex);
		while(maxChildIndex > 0 && parentIndex < endIndex && array[parentIndex] < array[maxChildIndex]) {
			swap(array, parentIndex, maxChildIndex);
			parentIndex = maxChildIndex;
		}
	}
	
	private static int getMaxChildIndex(int[] array, int parentIndex, int endIndex) {
		int leftChildIndex  = 2 * parentIndex + 1;
		int rightChildIndex = 2 * parentIndex + 2;
		if(leftChildIndex <= endIndex) {
			if(rightChildIndex <= endIndex && array[rightChildIndex] > array[leftChildIndex])
				return rightChildIndex;

			return leftChildIndex;
		}
		return -1;
	}
	
	private static void makeMaxHeap(int[] array, int startIndex, int endIndex) {
		for(int parentIndex = getParentIndex(endIndex); parentIndex >= startIndex; --parentIndex) {
			int maxChildIndex = getMaxChildIndex(array, parentIndex, endIndex);
			if(array[parentIndex] < array[maxChildIndex]) {
				swap(array, parentIndex, maxChildIndex);
				heapifyDown(array, maxChildIndex, endIndex);
				
			}
		}
	}
	
	public static void sort(int[] array, int startIndex, int endIndex) {
		
		if(endIndex <= startIndex) {
			return;
		}
		
		makeMaxHeap(array, startIndex, endIndex);
		swap(array, startIndex, endIndex);
		sort(array, startIndex, endIndex - 1);
	}

	public static void main(String[] args) {
		int[] a = {5,3,3,6,8,9,4,2,6,34,2,24,6,7,2,4,5,5,53,4};
		util.Util.print(a);
		sort(a, 0, a.length - 1);
		util.Util.print(a);
		System.out.println("Heap sort complete");
	}
}
