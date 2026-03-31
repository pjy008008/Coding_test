import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		// initialize map
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int min = Integer.MAX_VALUE;
		int resH = 0;
		for (int height = 256; height >= 0; height--) {
			int left = 0;
			int over = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (height - map[i][j] > 0) {
						left += height - map[i][j];
					}
					if (map[i][j] - height > 0) {
						over += map[i][j] - height;
					}
				}
			}
			if (left <= over + b) {
				int res = left + over * 2;
				if (res < min) {
					min = res;
					resH = height;
				}
			}
		}
		System.out.println(min + " " + resH);
	}
}
