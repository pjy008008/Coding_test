import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n, k;
	private static int[][] dp;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[n][k + 1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(solve(0, k));
	}

	private static int solve(int idx, int x) {
		if (x == 0) {
			return 1;
		} else if (x < 0) {
			return 0;
		}

		if (dp[idx][x] != -1) {
			return dp[idx][x];
		}
		dp[idx][x] = 0;

		for (int i = idx; i < n; i++) {
			dp[idx][x] += solve(i, x - arr[i]);
		}

		return dp[idx][x];
	}
}
