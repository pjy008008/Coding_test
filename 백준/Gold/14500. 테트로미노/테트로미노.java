import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static int max;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()) + 6;
		m = Integer.parseInt(st.nextToken()) + 6;
		map = new int[n][m];
		for (int i = 3; i < n - 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 3; j < m - 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		max = Integer.MIN_VALUE;
		block1();
		block2();
		block3();
		block4();
		block5();
		System.out.println(max);
	}

	private static void block1() {
		for (int i = 0; i < n - 3; i++) {
			for (int j = 0; j < m - 3; j++) {
				max = Math.max(max, map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3]);
				max = Math.max(max, map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j]);
			}
		}
	}

	private static void block2() {
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 1; j++) {
				max = Math.max(max, map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i + 1][j + 1]);
			}
		}
	}

	private static void block3() {
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 2; j++) {
				max = Math.max(max, map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i][j + 1]);
				max = Math.max(max, map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2]);
				max = Math.max(max, map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1] + map[i + 2][j]);
				max = Math.max(max, map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 2]);

				max = Math.max(max, map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1]);
				max = Math.max(max, map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2] + map[i][j + 2]);
				max = Math.max(max, map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1]);
				max = Math.max(max, map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i][j + 2]);
			}
		}
	}

	private static void block4() {
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 2; j++) {
				max = Math.max(max, map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1]);
				max = Math.max(max, map[i][j + 1] + map[i][j + 2] + map[i + 1][j] + map[i + 1][j + 1]);
				max = Math.max(max, map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j]);
				max = Math.max(max, map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2]);
			}
		}
	}

	private static void block5() {
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 2; j++) {
				max = Math.max(max, map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2] + map[i][j + 1]);
				max = Math.max(max, map[i + 1][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1]);
				max = Math.max(max, map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 1]);
				max = Math.max(max, map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j + 1]);
			}
		}
	}
}
