import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[][] map;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[n][1 << n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		// 0(flag 1)에서 시작
		System.out.println(dfs(0, 1));
	}

	private static int dfs(int prev, int flag) {
		if (flag == (1 << n) - 1) {
			if (map[prev][0] == 0) {
				return 17_000_000;
			}
			return map[prev][0];
		}
		if (dp[prev][flag] != -1) {
			return dp[prev][flag];
		}

		dp[prev][flag] = 17_000_000;

		for (int i = 1; i < n; i++) {
			if ((flag & (1 << i)) != 0 || map[prev][i] == 0) {
				continue;
			}
			dp[prev][flag] = Math.min(dp[prev][flag], dfs(i, flag | 1 << i) + map[prev][i]);
		}
		return dp[prev][flag];
	}
}
