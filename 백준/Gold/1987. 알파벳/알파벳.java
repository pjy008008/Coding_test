import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static char[][] map;
	private static boolean[][] visited;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };
	private static int n, m;
	private static int max;
	private static Set<Character> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // height
		m = Integer.parseInt(st.nextToken()); // width
		max = Integer.MIN_VALUE;
		set = new HashSet<>();

		map = new char[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}
		dfs(0, 0, 1);
		System.out.println(max);
	}

	private static void dfs(int curX, int curY, int depth) {
		if (set.contains(map[curY][curX])) {
			return;
		}
		if (depth > max) {
			max = depth;
		}
		set.add(map[curY][curX]);
		visited[curY][curX] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nx = curX + dx[dir];
			int ny = curY + dy[dir];
			if (0 <= nx && nx < m && 0 <= ny && ny < n) {
				if (!visited[ny][nx]) {
					dfs(nx, ny, depth + 1);
				}
			}
		}
		set.remove(map[curY][curX]);
		visited[curY][curX] = false;
	}
}
