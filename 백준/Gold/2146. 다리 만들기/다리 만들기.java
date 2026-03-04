import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;

		// init map
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n][n];
		int island = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (bfs(j, i, island)) {
					island++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bfs2(j, i);
			}
		}
		System.out.println(min);
	}

	private static boolean bfs(int x, int y, int island) {
		if (visited[y][x] || map[y][x] == 0) {
			return false;
		}
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visited[y][x] = true;
		map[y][x] = island;
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int cx = pos[0];
			int cy = pos[1];
			for (int dir = 0; dir < 4; dir++) {
				int nx = cx + dx[dir];
				int ny = cy + dy[dir];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (!visited[ny][nx] && map[ny][nx] == 1) {
						visited[ny][nx] = true;
						map[ny][nx] = island;
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}

		return true;
	}

	private static void bfs2(int x, int y) {
		if (map[y][x] == 0) {
			return;
		}
		visited = new boolean[n][n];
		int num = map[y][x];
		int[][] count = new int[n][n];
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
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (!visited[ny][nx] && map[ny][nx] == 0) {
						visited[ny][nx] = true;
						count[ny][nx] = count[cy][cx] + 1;
						q.offer(new int[] { nx, ny });
					} else if (map[ny][nx] != num && map[ny][nx] != 0) {
						min = Math.min(min, count[cy][cx]);
					}
				}
			}
		}
	}
}
