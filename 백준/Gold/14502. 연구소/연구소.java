import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static int max;
	private static int[][] map;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };
	private static int[] selected;
	private static List<int[]> space;
	private static Queue<int[]> virus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // height
		m = Integer.parseInt(st.nextToken()); // width
		max = Integer.MIN_VALUE;
		map = new int[n][m];
		space = new ArrayList<>();
		virus = new LinkedList<>();
		selected = new int[3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 0) {
					// 벽을 세울 수 있는 곳
					space.add(new int[] { j, i }); // x,y 순으로 삽입
				}
				if (x == 2) {
					// 바이러스 위치
					virus.offer(new int[] { j, i }); // x,y 순으로 삽입
				}
				map[i][j] = x;
			}
		}
		comb(0, 0, 0);
		System.out.println(max);
	}

	private static void comb(int start, int cnt, int flag) {
		if (cnt == 3) {
			max = Math.max(max, bfs(selected));
			return;
		}
		for (int i = start; i < space.size(); i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}
			selected[cnt] = i;
			comb(i + 1, cnt + 1, flag | 1 << i);
		}
	}

	private static int bfs(int[] selected) {
		// 맵 복사
		int[][] tempMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		// 벽 세우기
		for (int i = 0; i < 3; i++) {
			int[] pos = space.get(selected[i]);
			int x = pos[0];
			int y = pos[1];
			tempMap[y][x] = 1;
		}

		// virus 복사
		Queue<int[]> q = new LinkedList<>(virus);
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int x = pos[0];
			int y = pos[1];
			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if (0 <= nx && nx < m && 0 <= ny && ny < n) {
					if (tempMap[ny][nx] == 0) {
						tempMap[ny][nx] = 2;
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tempMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
