import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[] arr;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[101];
		Arrays.fill(dp, -1);

		for (int i = 0; i < n; i++) {
			int cur = arr[i];

			for (int prev = 1; prev <= 100; prev++) {
				if (dp[prev] != -1) {
					int diff = Math.abs(cur - prev);
					int score = dp[prev] + diff * diff;
					dp[cur] = Math.max(dp[cur], score);
				}
			}

			dp[cur] = Math.max(dp[cur], 0);
		}
		int res = 0;
		for (int i = 1; i <= 100; i++) {
			res = Math.max(res, dp[i]);
		}
		System.out.println(res);
	}
}
