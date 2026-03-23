import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int len1 = s1.length();
		int len2 = s2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int lcsLen = dp[len1][len2];
		System.out.println(lcsLen);
		if (lcsLen > 0) {
			StringBuilder sb = new StringBuilder();
			int p1 = len1;
			int p2 = len2;
			while (p1 > 0 && p2 > 0) {
				if (s1.charAt(p1 - 1) == s2.charAt(p2 - 1)) {
					sb.append(s1.charAt(p1 - 1));
					p1--;
					p2--;
				} else if (dp[p1 - 1][p2] >= dp[p1][p2 - 1]) {
					p1--;
				} else {
					p2--;
				}
			}
			System.out.println(sb.reverse().toString());
		}
	}
}
