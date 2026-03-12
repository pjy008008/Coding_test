import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	private static HashSet<Integer> set;
	private static int[][] map;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			map = new int[4][4];
			set = new HashSet<>();
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					dfs(k, j, 1, map[j][k]);
				}
			}
			sb.append("#").append(i).append(" ").append(set.size()).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y, int depth, int value) {
		if (depth == 7) {
			set.add(value);
			return;
		}
		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (0 <= nx && nx < 4 && 0 <= ny && ny < 4) {
				dfs(nx, ny, depth + 1, value * 10 + map[ny][nx]);
			}
		}
	}
}
