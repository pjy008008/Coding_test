import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int s = 0;
		int e = n - 1;
		int min = Integer.MAX_VALUE;
		int[] res = new int[2];
		while (s < e) {
			int sum = arr[s] + arr[e];
			if (sum == 0) {
				res[0] = arr[s];
				res[1] = arr[e];
				break;
			} else {
				if (Math.abs(sum) < min) {
					min = Math.abs(sum);
					res[0] = arr[s];
					res[1] = arr[e];
				}
				if (sum > 0) {
					e--;
				} else {
					s++;
				}
			}
		}
		System.out.println(res[0] + " " + res[1]);
	}
}
