import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			res = Math.min(res, find(i));
		}
		System.out.println(res);
	}

	private static int find(int start) {
		int[][] dp = new int[n][3];
		for (int i = 0; i < 3; i++) {
			if (i == start) {
				dp[0][i] = map[0][i];
			} else {
				dp[0][i] = 1000000000;
			}
		}
		for (int i = 1; i < n; i++) {
			dp[i][0] = map[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = map[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = map[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (i != start) {
				min = Math.min(min, dp[n - 1][i]);
			}
		}
		return min;
	}
}
