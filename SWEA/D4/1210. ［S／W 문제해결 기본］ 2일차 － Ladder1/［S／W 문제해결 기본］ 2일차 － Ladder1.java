import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] map;
	private static boolean[][] isVisited;
	private static int end;
	private static int start;
	private static int[] dRow = new int[] { 0, 0, -1 };
	private static int[] dCol = new int[] { -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			int tc = Integer.parseInt(br.readLine());
			map = new int[100][100];
			isVisited = new boolean[100][100];
			for (int j = 0; j < 100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 100; k++) {
					int x = Integer.parseInt(st.nextToken());
					if (x == 2) {
						end = k;
					}
					map[j][k] = x;
				}
			}
			start = dfs(99, end);
			sb.append("#").append(tc).append(" ").append(start).append("\n");
		}
		System.out.println(sb);
	}

	private static int dfs(int row, int col) {
		if (row == 0) {
			return col;
		}
		isVisited[row][col] = true;
		for (int dir = 0; dir < 3; dir++) {
			int nr = row + dRow[dir];
			int nc = col + dCol[dir];
			if (0 <= nr && nr < 100 && 0 <= nc && nc < 100) {
				if (map[nr][nc] == 1 && !isVisited[nr][nc]) {
					return dfs(nr, nc);
				}
			}
		}
		return 0;
	}
}
