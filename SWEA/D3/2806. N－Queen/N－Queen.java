import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	private static boolean[][] impossible;
	private static int cnt;
	private static int n;
	private static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	private static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			n = Integer.parseInt(br.readLine());
			cnt = 0;
			impossible = new boolean[n][n];
			for (int j = 0; j < n; j++) {
				dfs(0, j, 1);
			}
			sb.append("#").append(i).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y, int depth) {
		if (depth == n) {
			cnt++;
			return;
		}
		List<int[]> changed = new ArrayList<>();
		setPossible(x, y, changed);

		for (int i = x + 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!impossible[i][j]) {
					dfs(i, j, depth + 1);
				}
			}
		}
		for (int[] pos : changed) {
			impossible[pos[0]][pos[1]] = false;
		}
	}

	private static void setPossible(int x, int y, List<int[]> changed) {
		if (!impossible[x][y]) {
			impossible[x][y] = true;
			changed.add(new int[] { x, y });
		}
		for (int j = 1; j < n; j++) {
			for (int i = 0; i < 8; i++) {
				int nx = x + j * dx[i];
				int ny = y + j * dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (!impossible[nx][ny]) {
						impossible[nx][ny] = true;
						changed.add(new int[] { nx, ny });
					}
				}
			}
		}
	}
}
