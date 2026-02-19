import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int n;
	private static boolean[] lC;
	private static boolean[] rC;
	private static boolean[] c;
	private static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cnt = 0;
		lC = new boolean[2 * n];
		rC = new boolean[2 * n];
		c = new boolean[n];
		dfs(0);
		System.out.println(cnt);
	}

	private static void dfs(int row) {
		if (row == n) {
			cnt++;
			return;
		}
		for (int col = 0; col < n; col++) {
			if (!c[col] && !lC[row + col] && !rC[row - col + n]) {
				c[col] = lC[row + col] = rC[row - col + n] = true;
				dfs(row + 1);
				c[col] = lC[row + col] = rC[row - col + n] = false;
			}

		}
	}
}
