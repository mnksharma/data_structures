package util;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Util {
	public static void print(int[] a) {
		String arrayCSV = Arrays.stream(a)
				 				.mapToObj(Integer::toString)
				 				.collect(Collectors.joining(", "));
		System.out.println(arrayCSV);
	}
	
	public static void swap(int[] array, int sourceIndex, int targetIndex) {
		int temp = array[sourceIndex];
		array[sourceIndex] = array[targetIndex];
		array[targetIndex] = temp;
	}
}
