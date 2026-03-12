import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0, end = 0;
		long sum = 0;
		int min = Integer.MAX_VALUE;
		while (end != n) {
			if (start == end) {
				sum += arr[end];
				end++;
				continue;
			}
			if (sum >= s) {
				min = Math.min(min, end - start);
				sum -= arr[start];
				start++;
			} else {
				sum += arr[end];
				end++;
			}
		}
		while (sum >= s) {
			min = Math.min(min, end - start);
			sum -= arr[start];
			start++;
		}
		if (min == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(min);
		}
	}
}
