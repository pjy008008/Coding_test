import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	private static int n;
	private static int[][] map;
	private static boolean[][] visited;
	private static List<int[]> list;
	private static int maxCore;
	private static int minDis;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			n = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			map = new int[n][n];
			visited = new boolean[n][n];
			maxCore = 0;
			minDis = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					int x = Integer.parseInt(st.nextToken());
					if (x == 1) {
						visited[j][k] = true;
						if (j == 0 || j == n - 1 || k == 0 || k == n - 1) {
							continue;
						}
						list.add(new int[] { j, k }); // Y X 순으로 저장
					}
					map[j][k] = x;
				}
			}
			dfs(0, 0, 0);
			sb.append("#").append(i).append(" ").append(minDis).append("\n");
		}
		System.out.println(sb);
	}

	// idx는 list의 몇번째 요소 탐색할건지
	// cnt는 core 연결 개수
	private static void dfs(int idx, int cnt, int distance) {
		if (idx == list.size()) {
			// cnt가 기존의 maxCore보다 크면 갱신
			if (cnt > maxCore) {
				maxCore = cnt;
				minDis = distance;
			}
			// maxCore가 같은데 distance가 더 작다면 갱신
			else if (maxCore == cnt && distance < minDis) {
				minDis = distance;
			}
			return;
		}
		// 4방향에서
		for (int i = 0; i < 4; i++) {
			int y = list.get(idx)[0];
			int x = list.get(idx)[1];
			int[] dir = new int[] { dx[i], dy[i] };
			if (check(x, y, dir)) {
				// dfs 에서 cnt+1(연결)하는 경우 => if 연결가능, visit => dfs => unVisit
				setVisit(x, y, dir, true);
				dfs(idx + 1, cnt + 1, distance + getDistance(x, y, i));
				setVisit(x, y, dir, false);
			}
		}
		// 탐색이 되는 경로에만 탐색하고, 선택하지 않을 경우도 고려
		dfs(idx + 1, cnt, distance);
	}

	// 연결할 수 있는 지 check
	private static boolean check(int x, int y, int[] dir) {
		int weight = 1;
		while (true) {
			int nx = x + dir[0] * weight;
			int ny = y + dir[1] * weight;
			if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) {
				return true;
			}
			if (visited[ny][nx]) {
				return false;
			}
			weight++;
		}
	}

	// visited 배열 수정 함수
	private static void setVisit(int x, int y, int[] dir, boolean value) {
		int weight = 1;
		while (true) {
			int nx = x + dir[0] * weight;
			int ny = y + dir[1] * weight;
			if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) {
				return;
			}
			visited[ny][nx] = value;
			weight++;
		}
	}

	private static int getDistance(int x, int y, int dir) {
		// 좌우상하
		if (dir == 0) {
			return x;
		} else if (dir == 1) {
			return n - 1 - x;
		} else if (dir == 2) {
			return n - 1 - y;
		} else {
			return y;
		}
	}
}
