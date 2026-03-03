import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					map[i][j] = true;
				}
			}
		}
		floyd();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j]) {
					System.out.print(1 + " ");
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
	}

	private static void floyd() {
		for (int m = 0; m < n; m++) {
			for (int s = 0; s < n; s++) {
				for (int e = 0; e < n; e++) {
					if (map[s][m] && map[m][e]) {
						map[s][e] = true;
					}
				}
			}
		}
	}
}
