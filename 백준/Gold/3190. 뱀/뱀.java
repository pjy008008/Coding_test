import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		// initialize apples
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			map[y][x] = 2;
		}

		// initialize snake moves
		int l = Integer.parseInt(br.readLine());
		PriorityQueue<Move> cmds = new PriorityQueue<>();
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			cmds.offer(new Move(t, c));
		}

		Queue<int[]> body = new LinkedList<>();
		body.offer(new int[] { 0, 0 });
		map[0][0] = 1;
		int cx = 0;
		int cy = 0;
		int dir = 0;
		int time = 0;
		while (true) {
			if (!cmds.isEmpty() && time == cmds.peek().time) {
				Move move = cmds.poll();
				if (move.cmd == 'L') {
					dir--;
					if (dir < 0) {
						dir += 4;
					}
				} else {
					dir++;
					dir %= 4;
				}
			}
			cx = cx + dx[dir];
			cy = cy + dy[dir];
			if (!(0 <= cx && cx < n && 0 <= cy && cy < n)) {
				break;
			}
			if (map[cy][cx] == 1) {
				break;
			}
			body.offer(new int[] { cx, cy });
			if (map[cy][cx] != 2) {
				int[] tail = body.poll();
				map[tail[1]][tail[0]] = 0;
			}
			map[cy][cx] = 1;
			time++;
		}
		System.out.println(time + 1);
	}

	private static void print(int[][] map, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	static class Apple {
		int x;
		int y;

		Apple(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Apple other = (Apple) obj;
			return x == other.x && y == other.y;
		}
	}

	static class Move implements Comparable<Move> {
		int time;
		char cmd;

		Move(int time, char cmd) {
			this.time = time;
			this.cmd = cmd;
		}

		@Override
		public int compareTo(Move o) {
			return this.time - o.time;
		}
	}
}
