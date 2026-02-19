import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };
	private static int max;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			n = Integer.parseInt(br.readLine());
			max = 1;
			map = new int[n][n];
			visited = new boolean[n][n];
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			for (int j = 1; j <= 100; j++) {
				eat(j);
				int cnt = 0;
				for (int k = 0; k < n; k++) {
					for (int p = 0; p < n; p++) {
						if (bfs(k, p)) {
							cnt++;
						}
					}
				}
				max = Math.max(cnt, max);
				visited = new boolean[n][n];
			}
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean bfs(int x, int y) {
		if (visited[y][x]) {
			return false;
		}
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int cx = pos[0];
			int cy = pos[1];
			for (int dir = 0; dir < 4; dir++) {
				int nx = cx + dx[dir];
				int ny = cy + dy[dir];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (visited[ny][nx]) {
						continue;
					}
					visited[ny][nx] = true;
					q.offer(new int[] { nx, ny });
				}
			}
		}
		return true;
	}

	private static void eat(int day) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] <= day) {
					visited[i][j] = true;
				}
			}
		}
	}
}
