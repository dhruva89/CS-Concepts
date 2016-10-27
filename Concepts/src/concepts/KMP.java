package concepts;

import java.util.ArrayList;
import java.util.Arrays;

public class KMP {
	public static void main(String args[]) {
		
		String text = "This is ababac some text that will be looked into for matching. abcthe ababay ababac";
		System.out.println(text.length());
		String pattern = "ababac";

		ArrayList<Integer> matches = new ArrayList<Integer>();

		int[] f = computeFailureFunction(pattern);

		int i = 0;
		int j = 0;
		while (i < text.length()) {
			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
				if (j == pattern.length()) {
					matches.add((i - pattern.length()));
					j=0;
				}
			} else if (j > 0) {
				j = f[j];
			} else {
				i++;
			}
		}

		System.out.println(Arrays.toString(matches.toArray()));
	}

	private static int[] computeFailureFunction(String pattern) {
		int[] f = new int[pattern.length() + 1];
		f[0] = 0;
		f[1] = 0;
		for (int i = 2; i < f.length; i++) {
			int j = f[i - 1];
			for (;;) {
				if (pattern.charAt(j) == pattern.charAt(i - 1)) {
					f[i] = j + 1;
					break;
				}
				if (j == 0) {
					f[i] = 0;
					break;
				}
				j = f[j];
			}
		}
		return f;
	}
}
