import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n, cnt;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { 1, 1, 0 };
	private static int[] dy = { 0, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		cnt = 0;
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// prev = 가로:0, 대각선:1, 세로:2
		dfs(1, 0, 0);
		System.out.println(cnt);
	}

	private static void dfs(int x, int y, int prev) {
		if (visited[y][x]) {
			return;
		}
		if (x + 1 == n && y + 1 == n) {
			cnt++;
			return;
		}
		visited[y][x] = true;
		int start = 0;
		int end = 0;
		if (prev == 0) {
			// 가로인 경우
			start = 0;
			end = 2;
		}
		if (prev == 1) {
			// 대각선인 경우
			start = 0;
			end = 3;
		}
		if (prev == 2) {
			// 세로인 경우
			start = 1;
			end = 3;
		}
		for (int dir = start; dir < end; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (dir == 1) {
					// 대각선인 경우
					if (ny - 1 >= 0 && nx - 1 >= 0) {
						if (map[ny][nx] != 1 && map[ny - 1][nx] != 1 && map[ny][nx - 1] != 1) {
							dfs(nx, ny, dir);
						}
					}
				} else {
					// 가로, 세로인 경우
					if (map[ny][nx] != 1) {
						dfs(nx, ny, dir);
					}
				}
			}
		}
		visited[y][x] = false;
	}
}
