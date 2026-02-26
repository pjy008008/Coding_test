import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static int[] trees;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		trees = new int[n];
		st = new StringTokenizer(br.readLine());
		int max = 1;
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			max = Math.max(max, x);
			trees[i] = x;
		}
		System.out.println(binarySearch(0, max));
	}

	private static int binarySearch(int start, int end) {
		if (start == end) {
			return start - 1;
		}
		int mid = (start + end) / 2;
		long sum = 0;
		for (int i = 0; i < n; i++) {
			int left = trees[i] - mid;
			if (left > 0) {
				sum += left;
			}
		}
		if (sum > m) {
			return binarySearch(mid + 1, end);
		} else if (sum < m) {
			return binarySearch(start, mid);
		} else {
			return mid;
		}
	}
}
