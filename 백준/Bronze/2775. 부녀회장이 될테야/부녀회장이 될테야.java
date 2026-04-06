import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int[][] dp = new int[15][15];
		for (int i = 1; i <= 14; i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= 14; i++) {
			for (int j = 1; j <= 14; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[k][n]).append("\n");
		}
		System.out.println(sb);
	}
}
