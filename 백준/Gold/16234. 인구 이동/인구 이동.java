import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };
	private static int[][] map;
	private static boolean[][] visited;
	private static boolean flag;
	private static int n, l, r;
	private static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		while (true) {
			flag = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						bfs(j, i);
					}
				}
			}
			if (!flag) {
				break;
			}
			visited = new boolean[n][n];
			cnt++;
		}
		System.out.println(cnt);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		int sum = 0;
		q.offer(new int[] { x, y });
		visited[y][x] = true;
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int cx = pos[0];
			int cy = pos[1];
			list.add(new int[] { cx, cy });
			sum += map[cy][cx];
			for (int dir = 0; dir < 4; dir++) {
				int nx = cx + dx[dir];
				int ny = cy + dy[dir];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (!visited[ny][nx]) {
						int diff = Math.abs(map[cy][cx] - map[ny][nx]);
						if (l <= diff && diff <= r) {
							flag = true;
							visited[ny][nx] = true;
							q.offer(new int[] { nx, ny });
						}
					}
				}
			}
		}
		sum /= list.size();
		for (int[] pos : list) {
			map[pos[1]][pos[0]] = sum;
		}
		list.clear();
	}
}
