import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int b;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					map[i][j] = 0;
				} else {
					map[i][j] = 1000000000;
				}

			}
		}
		for (int i = 0; i < b; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			if (w < map[s][e])
				map[s][e] = w;
		}
		floyd();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1000000000) {
		            sb.append(0).append(" ");
		        } else {
		            sb.append(map[i][j]).append(" ");
		        }
			}
			sb.append("\n");
		}
		System.out.println(sb);
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
