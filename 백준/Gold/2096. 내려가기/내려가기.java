import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		// init map
		int[][] map = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// init min, max
		int[][] min = new int[n][3];
		int[][] max = new int[n][3];
		min[0][0] = max[0][0] = map[0][0];
		min[0][1] = max[0][1] = map[0][1];
		min[0][2] = max[0][2] = map[0][2];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					min[i][j] = map[i][j] + Math.min(min[i - 1][0], min[i - 1][1]);
					max[i][j] = map[i][j] + Math.max(max[i - 1][0], max[i - 1][1]);
				}
				if (j == 1) {
					min[i][j] = map[i][j] + Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2]));
					max[i][j] = map[i][j] + Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2]));
				}
				if (j == 2) {
					min[i][j] = map[i][j] + Math.min(min[i - 1][2], min[i - 1][1]);
					max[i][j] = map[i][j] + Math.max(max[i - 1][2], max[i - 1][1]);
				}
			}
		}
		int resMax = Integer.MIN_VALUE;
		int resMin = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (max[n - 1][i] > resMax) {
				resMax = max[n - 1][i];
			}
			if (min[n - 1][i] < resMin) {
				resMin = min[n - 1][i];
			}
		}
		System.out.println(resMax + " " + resMin);
	}
}
