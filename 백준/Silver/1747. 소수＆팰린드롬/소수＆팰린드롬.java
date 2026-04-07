import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final int MAX_VALUE = 10_000_001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[MAX_VALUE];
		for (int i = 2; i < MAX_VALUE; i++) {
			arr[i] = i;
		}

		for (int i = 2; i < Math.sqrt(MAX_VALUE); i++) {
			if (arr[i] == 0) {
				continue;
			}
			for (int j = i + i; j < MAX_VALUE; j = j + i) {
				arr[j] = 0;
			}
		}

		for (int i = n; i <= MAX_VALUE; i++) {
			if (arr[i] != 0) {
				if (check(i)) {
					System.out.println(i);
					break;
				}
			}
		}
	}

	private static boolean check(int value) {
		char[] charArr = String.valueOf(value).toCharArray();
		int s = 0;
		int e = charArr.length - 1;
		while (s < e) {
			if (charArr[s] == charArr[e]) {
				s++;
				e--;
			} else {
				return false;
			}
		}
		return true;
	}
}
