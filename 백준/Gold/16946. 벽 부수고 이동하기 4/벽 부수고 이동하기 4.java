import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static Map<Integer, Integer> cnt;
	private static int[][] map;
	private static int[][] islandId;
	private static int id;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		islandId = new int[n][m];
		cnt = new HashMap<>();
		id = 1;
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0 && islandId[i][j] == 0) {
					bfs(j, i);
					id++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					Set<Integer> set = new HashSet<>();
					for (int dir = 0; dir < 4; dir++) {
						int nx = j + dx[dir];
						int ny = i + dy[dir];
						if (0 <= nx && nx < m && 0 <= ny && ny < n) {
							if (map[ny][nx] == 0 && islandId[ny][nx] > 0) {
								set.add(islandId[ny][nx]);
							}
						}
					}
					int sum = 1;
					for (int x : set) {
						sum += cnt.get(x);
					}
					sb.append(sum % 10);
				}else {
					sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		islandId[y][x] = id;
		int localCnt = 1;
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int cx = pos[0];
			int cy = pos[1];
			for (int dir = 0; dir < 4; dir++) {
				int nx = cx + dx[dir];
				int ny = cy + dy[dir];
				if (0 <= nx && nx < m && 0 <= ny && ny < n) {
					if (map[ny][nx] == 0 && islandId[ny][nx] == 0) {
						islandId[ny][nx] = id;
						localCnt++;
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}
		cnt.put(id, localCnt);
	}
}
