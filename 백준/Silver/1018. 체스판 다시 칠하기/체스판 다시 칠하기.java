import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n - 7; i++) {
			for (int j = 0; j < m - 7; j++) {
				res = Math.min(res, getMin(j, i));
			}
		}
		System.out.println(res);
	}

	private static int getMin(int x, int y) {
		int cntA = 0;
		int cntB = 0;
		boolean isWhite = true;
		for (int i = y; i < y + 8; i++) {
			for (int j = x; j < x + 8; j++) {
				if (isWhite && map[i][j] == 'B') {
					cntA++;
				}
				if (!isWhite && map[i][j] == 'W') {
					cntA++;
				}
				if (j != x + 7) {
					if (isWhite) {
						isWhite = false;
					} else {
						isWhite = true;
					}
				}
			}
		}

		isWhite = false;
		for (int i = y; i < y + 8; i++) {
			for (int j = x; j < x + 8; j++) {
				if (isWhite && map[i][j] == 'B') {
					cntB++;
				}
				if (!isWhite && map[i][j] == 'W') {
					cntB++;
				}
				if (j != x + 7) {
					if (isWhite) {
						isWhite = false;
					} else {
						isWhite = true;
					}
				}
			}
		}
		return Math.min(cntA, cntB);
	}
}
