import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	private static int[][] map;
	private static boolean[][] isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			int t = Integer.parseInt(br.readLine());
			int sx=1, sy=1;
			int dx=13,dy=13;
			map = new int[16][16];
			isVisit = new boolean[16][16];
			for (int j = 0; j < 16; j++) {
				String line = br.readLine();
				for (int k = 0; k < 16; k++) {
					int x = line.charAt(k) - '0';
					if(x==2) {
						sx=j;
						sy=k;
					}
					if(x==3) {
						dx=j;
						dy=k;
					}
					map[j][k] = x;
				}
			}
			dfs(sx, sy);
			sb.append("#").append(i).append(" ");
			if(isVisit[dx][dy]) {
				sb.append(1);
			}else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y) {
		if (map[x][y] == 1 || isVisit[x][y]) {
			return;
		}
		isVisit[x][y] = true;
		int[] dx = new int[] { -1, 0, 0, 1 };
		int[] dy = new int[] { 0, 1, -1, 0 };

		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (0 <= nx && nx < 16 && 0 <= ny && ny < 16) {
				dfs(nx, ny);
			}
		}
	}
}
