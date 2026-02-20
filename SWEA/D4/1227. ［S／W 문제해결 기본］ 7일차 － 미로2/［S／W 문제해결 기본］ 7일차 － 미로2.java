import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] map;
	private static boolean[][] visited;
	private static int sx, sy, ex, ey;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 1; i <= 10; i++) {
			br.readLine();
			map = new int[100][100];
			visited = new boolean[100][100];
			for (int j = 0; j < 100; j++) {
				String line = br.readLine();
				for (int k = 0; k < 100; k++) {
					int x = line.charAt(k) - '0';
					if (x == 2) {
						sy = j;
						sx = k;
					}
					if (x == 3) {
						ey = j;
						ex = k;
					}
					map[j][k] = x;
				}
			}

			sb.append("#").append(i).append(" ");
			if (bfs(sx, sy)) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visited[y][x] = true;
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int cx = pos[0];
			int cy = pos[1];
			for (int dir = 0; dir < 4; dir++) {
				int nx = cx + dx[dir];
				int ny = cy + dy[dir];
				if (0 <= nx && nx < 100 && 0 <= ny && ny < 100) {
					if (nx == ex && ny == ey) {
						return true;
					}
					if (!visited[ny][nx] && map[ny][nx] == 0) {
						visited[ny][nx] = true;
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}
		return false;
	}
}
