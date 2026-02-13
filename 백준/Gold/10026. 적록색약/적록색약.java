import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static char[][] map;
	private static boolean[][] visited;
	private static int normal;
	private static int blind;
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		normal = 0;
		blind = 0;
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bfsForNormal(j, i, map[i][j]);
			}
		}
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bfsForBlind(j, i, map[i][j]);
			}
		}
		sb.append(normal).append(" ").append(blind);
		System.out.println(sb);
	}

	private static void bfsForNormal(int x, int y, char c) {
		if (!visited[y][x]) {
			normal++;
		} else {
			return;
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
					if (!visited[ny][nx] && map[ny][nx] == c) {
						visited[ny][nx] = true;
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}
	}

	private static void bfsForBlind(int x, int y, char c) {
		if (!visited[y][x]) {
			blind++;
		} else {
			return;
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
					if (!visited[ny][nx]) {
						if (c == 'R' || c == 'G') {
							if (map[ny][nx] == 'R' || map[ny][nx] == 'G') {
								visited[ny][nx] = true;
								q.offer(new int[] { nx, ny });
							}
						} else {
							if (map[ny][nx] == 'B') {
								visited[ny][nx] = true;
								q.offer(new int[] { nx, ny });
							}
						}
					}
				}
			}
		}
	}
}
