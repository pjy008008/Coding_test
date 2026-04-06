import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static int[] price;
	private static int[] plan;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			// initialize price
			price = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				price[j] = Integer.parseInt(st.nextToken());
			}

			// initialize plan
			st = new StringTokenizer(br.readLine());
			plan = new int[12];
			for (int j = 0; j < 12; j++) {
				plan[j] = Integer.parseInt(st.nextToken());
			}

			// initialize dp
			dp = new int[12];
			Arrays.fill(dp, -1);
			
			int res = solve(0);
			res = Math.min(res, price[3]);
			sb.append("#").append(i).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	private static int solve(int idx) {
		if (idx >= 12) {
			return 0;
		}
		if (dp[idx] != -1) {
			return dp[idx];
		}
		int day = plan[idx];

		if (day == 0) {
			dp[idx] = solve(idx + 1);
		} else {
			dp[idx] = Math.min(solve(idx + 1) + price[0] * day, solve(idx + 1) + price[1]);
			dp[idx] = Math.min(dp[idx], solve(idx + 3) + price[2]);
		}

		return dp[idx];
	}
}
