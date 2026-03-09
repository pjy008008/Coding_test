import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	private static char[][] map;
	private static int[] dx = { -1, 0, 1, 0, -1, -1, 1, 1 };
	private static int[] dy = { 0, 1, 0, -1, -1, 1, 1, -1 };
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			for (int j = 0; j < n; j++) {
				map[j] = br.readLine().toCharArray();
			}
			int count = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (map[j][k] == '.' && countMine(k, j) == 0) {
						bfs(k, j);
						count++;
					}
				}
			}
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (map[j][k] == '.') {
						count++;
					}
				}
			}
			sb.append("#").append(i).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		map[y][x] = '0';
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			if(map[cy][cx]=='0') {
				for (int dir = 0; dir < 8; dir++) {
					int nx = cx + dx[dir];
					int ny = cy + dy[dir];
					if (0 <= nx && nx < n && 0 <= ny && ny < n) {
						if (map[ny][nx] == '.') {
							map[ny][nx] = (char) ('0' + countMine(nx, ny));
							q.offer(new int[] { nx, ny });
						}
					}
				}
			}
		}
	}

	private static int countMine(int x, int y) {
		int cnt = 0;
		for (int dir = 0; dir < 8; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (map[ny][nx] == '*') {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
