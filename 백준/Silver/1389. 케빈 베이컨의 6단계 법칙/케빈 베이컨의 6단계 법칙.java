import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			map[s][e] = 1;
			map[e][s] = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 1) {
					map[i][j] = 100000000;
				}
			}
		}
		floyd();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				if (map[i][j] != 100000000) {
					sum += map[i][j];
				}
			}
			min = Math.min(min, sum);
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				if (map[i][j] != 100000000) {
					sum += map[i][j];
				}
			}
			if (sum == min) {
				res = i + 1;
				break;
			}
		}
		System.out.println(res);
	}

	private static void floyd() {
		for (int m = 0; m < n; m++) {
			for (int s = 0; s < n; s++) {
				for (int e = 0; e < n; e++) {
					if (map[s][e] > map[s][m] + map[m][e]) {
						map[s][e] = map[s][m] + map[m][e];
					}
				}
			}
		}
	}
}
