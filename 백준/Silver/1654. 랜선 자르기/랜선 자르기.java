import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int k, n;
	private static long max;
	private static int[] line;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		max = Long.MIN_VALUE;
		line = new int[k];
		for (int i = 0; i < k; i++) {
			int x = Integer.parseInt(br.readLine());
			line[i] = x;
			if (x > max) {
				max = x;
			}
		}
		long start = 1;
		long end = max;
		long res = 0;
		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			for (int i = 0; i < k; i++) {
				sum += line[i] / mid;
			}
			if (sum >= n) {
				res = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(res);
	}
}
