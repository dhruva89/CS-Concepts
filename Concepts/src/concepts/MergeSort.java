package concepts;

import java.util.Arrays;

public class MergeSort {
	public static void main(String args[]) {
		int[] input = { 6, 7, 2, 8, 3, 2 };

		mergeSort(input, 0, input.length - 1, new int[input.length]);
		System.out.println(Arrays.toString(input));
	}

	private static void mergeSort(int[] input, int start, int end, int[] helperArray) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(input, start, mid, helperArray);
			mergeSort(input, mid + 1, end, helperArray);
			merge(input, helperArray, start, mid, end);
		}
	}

	private static void merge(int[] input, int[] helperArray, int start, int mid, int end) {
		for (int i = start; i <= end; i++) {
			helperArray[i] = input[i];
		}
		int i = start;
		int j = mid + 1;
		int cur = start;

		while (i <= mid && j <= end) {
			if (helperArray[i] <= helperArray[j]) {
				input[cur] = helperArray[i];
				i++;
			} else {
				input[cur] = helperArray[j];
				j++;
			}
			cur++;
		}

		while (i <= mid) {
			input[cur] = helperArray[i];
			i++;
			cur++;
		}
	}
}
