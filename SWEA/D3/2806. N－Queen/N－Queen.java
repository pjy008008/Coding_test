import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	private static boolean[] c;
	private static boolean[] dia1;
	private static boolean[] dia2;
	private static int n;
	private static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			n = Integer.parseInt(br.readLine());
			c = new boolean[n];
			dia1 = new boolean[2 * n];
			dia2 = new boolean[2 * n];
			cnt = 0;
			solve(0);
			sb.append("#").append(i).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void solve(int row) {
		if (row == n) {
			cnt++;
			return;
		}
		for (int col = 0; col < n; col++) {
			if (!c[col] && !dia1[row + col] && !dia2[row - col + n]) {
				c[col] = dia1[row + col] = dia2[row - col + n] = true;
				solve(row + 1);
				c[col] = dia1[row + col] = dia2[row - col + n] = false;
			}
		}
	}
}
