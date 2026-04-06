import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[5001];
		boolean[] possible = new boolean[5001];
		dp[3] = 1;
		dp[5] = 1;
		possible[3] = true;
		possible[5] = true;
		for (int i = 6; i <= n; i++) {
			if (possible[i - 5]) {
				dp[i] = dp[i - 5] + 1;
				possible[i] = true;
			} else if (possible[i - 3]) {
				dp[i] = dp[i - 3] + 1;
				possible[i] = true;
			}
		}
		if(possible[n]) {
			System.out.println(dp[n]);
		}else {
			System.out.println(-1);
		}
	}
}
