package concepts;

import java.util.Arrays;

public class SortRunner {
	public static void main(String args[]){
		int[] arr = new int[] {6,2,5,3,1,0};
		Sort.quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
