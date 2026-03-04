import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0, };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		while (true) {
			boolean flag = true;
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visited = new boolean[n][m];
			int[][] count = new int[n][m];
			q.offer(new int[] { 0, 0 });
			visited[0][0] = true;
			while (!q.isEmpty()) {
				int[] pos = q.poll();
				int x = pos[0];
				int y = pos[1];
				for (int dir = 0; dir < 4; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					if (0 <= nx && nx < m && 0 <= ny && ny < n) {
						if (map[ny][nx] == 0 && !visited[ny][nx]) {
							visited[ny][nx] = true;
							q.offer(new int[] { nx, ny });
						} else if (map[ny][nx] == 1) {
							count[ny][nx]++;
						}
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (count[i][j] >= 2) {
						map[i][j] = 0;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1) {
						flag = false;
					}
				}
			}
			cnt++;
			if (flag) {
				break;
			}
		}
		System.out.println(cnt);
	}
}
