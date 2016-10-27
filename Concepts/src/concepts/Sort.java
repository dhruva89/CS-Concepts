package concepts;

public class Sort {
	public static void bubbleSort(int[] inputArr) {
		for (int i = 0; i < inputArr.length - 1; i++) {
			for (int j = 0; j < inputArr.length - 1 - i; j++) {
				if (inputArr[j] > inputArr[j + 1]) {
					inputArr[j] = inputArr[j] + inputArr[j + 1];
					inputArr[j + 1] = inputArr[j] - inputArr[j + 1];
					inputArr[j] = inputArr[j] - inputArr[j + 1];
				}
			}
		}
	}

	public static void selectionSort(int[] inputArr) {
		for (int i = 0; i < inputArr.length - 1; i++) {
			for (int j = i + 1; j < inputArr.length; j++) {
				if (inputArr[j] < inputArr[i]) {
					inputArr[j] = inputArr[j] + inputArr[i];
					inputArr[i] = inputArr[j] - inputArr[i];
					inputArr[j] = inputArr[j] - inputArr[i];
				}
			}
		}
	}

	public static int[] mergeSort(int[] inputArr) {
		if (inputArr.length == 1) {
			return inputArr;
		}

		int mid = inputArr.length / 2;
		int[] leftArr = new int[mid];
		int[] rightArr = new int[inputArr.length - mid];
		for (int i = 0; i < mid; i++) {
			leftArr[i] = inputArr[i];
			rightArr[i] = inputArr[mid + i];
		}
		if (inputArr.length % 2 != 0) {
			rightArr[mid] = inputArr[inputArr.length - 1];
		}
		leftArr = mergeSort(leftArr);
		rightArr = mergeSort(rightArr);
		inputArr = merge(leftArr, rightArr);
		return inputArr;
	}

	private static int[] merge(int[] leftArr, int[] rightArr) {
		int i = 0;
		int j = 0;
		int k = 0;
		int[] out = new int[leftArr.length + rightArr.length];
		while (i != leftArr.length && j != rightArr.length) {
			if (leftArr[i] < rightArr[j]) {
				out[k] = leftArr[i];
				i++;
			} else {
				out[k] = rightArr[j];
				j++;
			}
			k++;
		}
		int[] arrayWithElementsRemaining;
		int index;
		if (i != leftArr.length) {
			arrayWithElementsRemaining = leftArr;
			index = i;
		} else {
			arrayWithElementsRemaining = rightArr;
			index = j;
		}
		while (index != arrayWithElementsRemaining.length) {
			out[k] = arrayWithElementsRemaining[index];
			k++;
			index++;
		}
		return out;
	}

	public static void quickSort(int arr[]) {
		if (arr.length > 0) {
			quickSort(arr, 0, arr.length - 1);
		}
	}

	private static void quickSort(int[] arr, int start, int end) {
		if (start <= end) {
			int pIndex = partition(arr, start, end);
			quickSort(arr, start, pIndex - 1);
			quickSort(arr, pIndex + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[start];
		int i = start;
		for (int j = start + 1; j <= end; j++) {
			if (arr[j] < pivot) {
				int temp = arr[j];
				arr[j] = arr[i+1];
				arr[i+1] = temp;
				i++;
			}
		}
		int temp = arr[i];
		arr[i] = pivot;
		arr[start] = temp;
		return i;
	}
}
