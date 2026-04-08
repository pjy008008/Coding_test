import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int arr[];
	private static int inc[];
	private static int dec[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		inc = new int[n];
		dec = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			res = Math.max(res, lis(i) + lds(i) - 1);
		}
		System.out.println(res);
	}

	private static int lis(int idx) {
		if (inc[idx] != 0) {
			return inc[idx];
		}
		inc[idx] = 1;
		for (int i = 0; i < idx; i++) {
			if (arr[i] < arr[idx]) {
				inc[idx] = Math.max(inc[idx], lis(i) + 1);
			}
		}
		return inc[idx];
	}

	private static int lds(int idx) {
		if (dec[idx] != 0) {
			return dec[idx];
		}
		dec[idx] = 1;
		for (int i = n - 1; i > idx; i--) {
			if (arr[i] < arr[idx]) {
				dec[idx] = Math.max(dec[idx], lds(i) + 1);
			}
		}
		return dec[idx];
	}
}
