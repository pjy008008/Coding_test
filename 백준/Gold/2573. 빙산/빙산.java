import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static int[][] map;
	private static int[][] melt;
	private static boolean[][] visited;

	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		while (true) {
			// counting islands logic
			int res = countIslands();
			if (res >= 2) {
				break;
			} else if (res == 0) {
				ans = 0;
				break;
			}
			// get melt array
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!flag && map[i][j] != 0) {
						bfs(j, i);
						flag = true;
						break;
					}
				}
			}
			ans++;
		}
		System.out.println(ans);
	}

	private static void bfs(int x, int y) {
		visited = new boolean[n][m];
		melt = new int[n][m];

		Queue<int[]> q = new LinkedList<>();
		visited[y][x] = true;
		q.offer(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int cx = pos[0];
			int cy = pos[1];
			for (int dir = 0; dir < 4; dir++) {
				int nx = cx + dx[dir];
				int ny = cy + dy[dir];
				if (0 <= nx && nx < m && 0 <= ny && ny < n) {
					if (!visited[ny][nx] && map[ny][nx] != 0) {
						visited[ny][nx] = true;
						q.offer(new int[] { nx, ny });
					} else if (map[ny][nx] == 0) {
						visited[ny][nx] = true;
						melt[cy][cx]++;
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] -= melt[i][j];
				if (map[i][j] < 0) {
					map[i][j] = 0;
				}
			}
		}
	}

	private static int countIslands() {
		visited = new boolean[n][m];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					cnt++;
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] { j, i });
					visited[i][j] = true;
					while (!q.isEmpty()) {
						int[] pos = q.poll();
						int cx = pos[0];
						int cy = pos[1];
						for (int dir = 0; dir < 4; dir++) {
							int nx = cx + dx[dir];
							int ny = cy + dy[dir];
							if (0 <= nx && nx < m && 0 <= ny && ny < n) {
								if (!visited[ny][nx] && map[ny][nx] != 0) {
									visited[ny][nx] = true;
									q.offer(new int[] { nx, ny });
								}
							}
						}
					}
				}
			}
		}
		return cnt;
	}
}
