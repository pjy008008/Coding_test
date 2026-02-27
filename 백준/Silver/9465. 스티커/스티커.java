import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[2][n];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				dp[0][j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				dp[1][j] = Integer.parseInt(st.nextToken());
			}
			if (n == 1) {
				sb.append(Math.max(dp[0][0], dp[1][0])).append("\n");
			} else if (n == 2) {
				sb.append(Math.max(dp[0][0] + dp[1][1], dp[0][1] + dp[1][0])).append("\n");
			} else {
				dp[0][1] += dp[1][0];
				dp[1][1] += dp[0][0];
				for (int j = 2; j < n; j++) {
					dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + dp[0][j];
					dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + dp[1][j];
				}
				sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
			}
		}
		System.out.println(sb);
	}
}
