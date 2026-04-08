import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int n;
	private static int[] arr;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		System.out.println(solve(1, 0, n - 1));
	}

	private static int solve(int cnt, int left, int right) {
		if (cnt == n + 1) {
			return 0;
		}
		if (dp[left][right] != -1) {
			return dp[left][right];
		}

		int l = solve(cnt + 1, left + 1, right) + arr[left] * cnt;
		int r = solve(cnt + 1, left, right - 1) + arr[right] * cnt;

		dp[left][right] = Math.max(l, r);
		return dp[left][right];
	}
}
