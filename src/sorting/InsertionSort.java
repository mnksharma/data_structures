package sorting;
import static util.Util.*;

public class InsertionSort {

	public static void sort(int[] array, int startIndex, int endIndex) {
		for(int i = startIndex + 1; i <= endIndex; ++i) {
			for(int j = i; j > 0 && array[j] < array[j-1]; --j) {
				swap(array, j, j-1);
			}
		}
	}

	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,4,3,2,1};
		util.Util.print(a);
		sort(a, 0, a.length - 1);
		util.Util.print(a);
		System.out.println("Quick sorting complete");
	}
}
