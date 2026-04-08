import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int r, c, t;
	private static List<int[]> fresh;
	private static int[][] map;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		fresh = new ArrayList<>();
		// initialize map
		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				int x = Integer.parseInt(st.nextToken());
				if (x == -1) {
					fresh.add(new int[] { j, i });
				}
				map[i][j] = x;
			}
		}

		for (int i = 0; i < t; i++) {
			move();
		}
		int res = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] > 0) {
					res += map[i][j];
				}
			}
		}
		System.out.println(res);
	}

	private static void move() {
		int[][] clone = new int[r][c];
//		for (int i = 0; i < r; i++) {
//			clone[i] = map[i].clone();
//		}

		// 확산 알고리즘
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] != 0) {
					int cnt = 0;
					int amount = map[i][j] / 5;
					// 움직일 수 있는지 확인
					for (int dir = 0; dir < 4; dir++) {
						int nx = j + dx[dir];
						int ny = i + dy[dir];
						if (check(nx, ny)) {
							clone[ny][nx] += amount;
							cnt++;
						}
					}
					clone[i][j] += (map[i][j] - cnt * amount);
				}
			}
		}
		map = clone;
		clean();
	}

	private static void clean() {
		// clean top area
		int topY = fresh.get(0)[1];
		for (int i = topY; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		map[topY][0] = 0;
		for (int i = 0; i < c - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		for (int i = 0; i < topY; i++) {
			map[i][c - 1] = map[i + 1][c - 1];
		}
		for (int i = c - 1; i > 0; i--) {
			map[topY][i] = map[topY][i - 1];
		}

		// clean bottom area
		int bottomY = fresh.get(1)[1];
		for (int i = bottomY; i < r - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		map[bottomY][0] = 0;
		for (int i = 0; i < c - 1; i++) {
			map[r - 1][i] = map[r - 1][i + 1];
		}
		for (int i = r - 1; i >= bottomY; i--) {
			map[i][c - 1] = map[i - 1][c - 1];
		}
		for (int i = c - 1; i > 0; i--) {
			map[bottomY][i] = map[bottomY][i - 1];
		}
	}

	private static boolean check(int x, int y) {
		for (int[] pos : fresh) {
			if (pos[0] == x && pos[1] == y) {
				return false;
			}
		}
		if (!(0 <= x && x < c && 0 <= y && y < r)) {
			return false;
		}
		return true;
	}
}
