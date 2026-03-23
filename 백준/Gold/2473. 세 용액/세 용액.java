import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		boolean flag = false;
		long[] res = new long[3];
		long min = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			long find = -arr[i];
			int s = 0;
			int e = n - 1;
			while (s < n && e >= 0) {
				if (s == i) {
					s++;
					continue;
				}
				if (e == i) {
					e--;
					continue;
				}
				if (s == e) {
					break;
				}
				long sum = arr[s] + arr[e];
				if (sum == find) {
					flag = true;
					res[0] = -find;
					res[1] = arr[s];
					res[2] = arr[e];
					break;
				} else {
					long tmp = find - sum;
					if (Math.abs(tmp) < min) {
						min = Math.abs(tmp);
						res[0] = -find;
						res[1] = arr[s];
						res[2] = arr[e];
					}
					if (sum > find) {
						e--;
					} else {
						s++;
					}
				}
			}
			if (flag) {
				break;
			}
		}
		Arrays.sort(res);
		System.out.println(res[0] + " " + res[1] + " " + res[2]);
	}
}
