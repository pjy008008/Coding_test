import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[0][0] = 0;
		pq.offer(new Node(0, 0, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (dist[cur.y][cur.x] < cur.w) {
				continue;
			}
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if (0 <= nx && nx < m && 0 <= ny && ny < n) {
					if (dist[ny][nx] > dist[cur.y][cur.x] + map[ny][nx]) {
						dist[ny][nx] = dist[cur.y][cur.x] + map[ny][nx];
						pq.offer(new Node(nx, ny, dist[ny][nx]));
					}
				}
			}
		}
		System.out.println(dist[n - 1][m - 1]);
	}

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int w;

		Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
}
