import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] dx = { 1, -1, 0, 0, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1, 0, 0 };
	private static int[] dz = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[][][] map = new int[h][n][m];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					int x = Integer.parseInt(st.nextToken());
					if (x == 1) {
						q.offer(new int[] { k, j, i });
					}
					map[i][j][k] = x;
				}
			}
		}
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int z = cur[2];
			for (int dir = 0; dir < 6; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				int nz = z + dz[dir];
				if (0 <= nx && nx < m && 0 <= ny && ny < n && 0 <= nz && nz < h) {
					if (map[nz][ny][nx] == 0) {
						map[nz][ny][nx] = map[z][y][x] + 1;
						q.offer(new int[] { nx, ny, nz });
					}
				}
			}
		}
		boolean impossible = false;
		int max = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[i][j][k] == 0) {
						impossible = true;
					}
					if (map[i][j][k] > max) {
						max = map[i][j][k];
					}
				}
			}
		}
		max = max - 1;
		if (!impossible) {
			System.out.println(max);
		} else {
			System.out.println(-1);
		}
	}
}
