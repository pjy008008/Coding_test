import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] map;
	private static boolean[][] visited;
	private static int n;
	private static int k;
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static int maxDepth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			maxDepth = 0;
			int max = 0;
			map = new int[n][n];
			visited = new boolean[n][n];
			List<int[]> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int l = 0; l < n; l++) {
					int x = Integer.parseInt(st.nextToken());
					if (x > max) {
						max = x;
						list.clear();
						list.add(new int[] { j, l });
					} else if (x == max) {
						list.add(new int[] { j, l });
					}
					map[j][l] = x;
				}
			}
			for (int[] pos : list) {
				int y = pos[0];
				int x = pos[1];
				dfs(x, y, 1, false);
			}
			sb.append("#").append(i).append(" ").append(maxDepth).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y, int depth, boolean cons) {
		if (depth > maxDepth) {
			maxDepth = depth;
		}
		visited[y][x] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (!visited[ny][nx]) {
					if (map[ny][nx] < map[y][x]) {
						// 작으면 그냥 진행
						dfs(nx, ny, depth + 1, cons);
					} else if (!cons && map[ny][nx] - k < map[y][x]) {
						// k만큼 깍았을 때 작아지고, 공사를 안했으면 공사 진행
						int origin = map[ny][nx];
						map[ny][nx] = map[y][x] - 1;
						dfs(nx, ny, depth + 1, true);
						map[ny][nx] = origin;
					}
				}
			}
		}
		visited[y][x] = false;
	}
}
