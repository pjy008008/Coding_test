import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			arr[i] = x;
		}
		Arrays.sort(arr);
		int res = binarySearch(1, arr[n - 1] - arr[0] + 1);
		System.out.println(res - 1);
	}

	private static int binarySearch(int start, int end) {
		if (start == end) {
			return start;
		}

		int mid = (start + end) / 2;
		if (possible(mid)) {
			return binarySearch(mid + 1, end);
		} else {
			return binarySearch(start, mid);
		}
	}

	private static boolean possible(int value) {
		int cnt = 0;
		int dis = 0;
		// m-2개 설치
		for (int i = 1; i < n; i++) {
			dis += arr[i] - arr[i - 1];
			if (dis >= value) {
				cnt++;
				dis = 0;
			}
			if (cnt >= m - 1) {
				return true;
			}
		}
		return false;
	}
}
