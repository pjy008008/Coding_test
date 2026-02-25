import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // number of point
			int m = Integer.parseInt(st.nextToken()); // number of road
			int w = Integer.parseInt(st.nextToken()); // number of hole
			map = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (j == k) {
						map[j][k] = 0;
					} else {
						map[j][k] = 100000000;
					}
				}
			}
			for (int j = 0; j < m; j++) { // read roads
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken()) - 1;
				int end = Integer.parseInt(st.nextToken()) - 1;
				int weight = Integer.parseInt(st.nextToken());
				if (weight < map[start][end]) {
					map[start][end] = weight;
				}
				if (weight < map[end][start]) {
					map[end][start] = weight;
				}

			}
			for (int j = 0; j < w; j++) { // read holes
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken()) - 1;
				int end = Integer.parseInt(st.nextToken()) - 1;
				int weight = Integer.parseInt(st.nextToken());
				map[start][end] = -weight;
			}
			floyd();
			boolean flag = false;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (j == k && map[j][k] < 0) {
						flag = true;
					}
				}
			}
			if (flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
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
