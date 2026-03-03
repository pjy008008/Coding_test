import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[][] map;
	private static int[] cnt;

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
		cnt = new int[3];
		dfs(0, 0, n);
		for (int i = 0; i < 3; i++) {
			System.out.println(cnt[i]);
		}
	}

	private static void dfs(int x, int y, int size) {
		if (size == 1) {
			cnt[map[y][x] + 1]++;
			return;
		}
		int value = map[y][x];
		for (int i = y; i < size + y; i++) {
			for (int j = x; j < size + x; j++) {
				if (map[i][j] != value) {
					int nextSize = size / 3;
					dfs(x, y, nextSize);
					dfs(x, y + nextSize, nextSize);
					dfs(x, y + 2 * nextSize, nextSize);

					dfs(x + nextSize, y, nextSize);
					dfs(x + nextSize, y + nextSize, nextSize);
					dfs(x + nextSize, y + 2 * nextSize, nextSize);

					dfs(x + 2 * nextSize, y, nextSize);
					dfs(x + 2 * nextSize, y + nextSize, nextSize);
					dfs(x + 2 * nextSize, y + 2 * nextSize, nextSize);
					return;
				}
			}
		}
		cnt[value + 1]++;
		return;
	}
}
