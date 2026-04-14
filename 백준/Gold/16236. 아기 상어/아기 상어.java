import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int x, y, sum, size;
	private static int res;
	private static int[][] map;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		x = 0;
		y = 0;
		sum = 0;
		size = 2;
		res = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 9) {
					x = j;
					y = i;
					continue;
				}
				map[i][j] = temp;
			}
		}
		while (true) {
			if (!bfs()) {
				break;
			}
		}
		System.out.println(res);
	}

	private static boolean bfs() {
		Queue<int[]> q = new LinkedList<>();
		int[][] visited = new int[n][n];
		q.offer(new int[] { x, y });
		visited[y][x] = 1;
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int cx = pos[0];
			int cy = pos[1];
			for (int dir = 0; dir < 4; dir++) {
				int nx = cx + dx[dir];
				int ny = cy + dy[dir];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (visited[ny][nx] == 0 && map[ny][nx] <= size) {
						visited[ny][nx] = visited[cy][cx] + 1;
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] > 0 && 0 < map[i][j] && map[i][j] < size) {
					min = Math.min(min, visited[i][j]);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == min && 0 < map[i][j] && map[i][j] < size) {
					res += visited[i][j] - 1;
					x = j;
					y = i;
					map[i][j] = 0;
					sum++;
					if (sum == size) {
						size++;
						sum = 0;
					}
					return true;
				}
			}
		}
		return false;
	}
}
