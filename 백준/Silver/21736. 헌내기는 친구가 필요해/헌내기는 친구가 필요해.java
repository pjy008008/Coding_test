import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] map = new char[n][m];
		boolean[][] visited = new boolean[n][m];
		int sx = 0;
		int sy = 0;
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				char c = line.charAt(j);
				if (c == 'I') {
					sx = j;
					sy = i;
				}
				map[i][j] = c;
			}
		}
		int cnt = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sx, sy });
		visited[sy][sx] = true;
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int cx = pos[0];
			int cy = pos[1];
			for (int dir = 0; dir < 4; dir++) {
				int nx = cx + dx[dir];
				int ny = cy + dy[dir];
				if (0 <= nx && nx < m && 0 <= ny && ny < n) {
					if (!visited[ny][nx] && map[ny][nx] != 'X') {
						if (map[ny][nx] == 'P') {
							cnt++;
						}
						visited[ny][nx] = true;
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}
		if(cnt==0) {
			System.out.println("TT");
		}else {
			System.out.println(cnt);
		}
	}
}
