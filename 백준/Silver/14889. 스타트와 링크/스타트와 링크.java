import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int min;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(1, 0, 1);
		System.out.println(min);
	}

	private static void comb(int cnt, int start, int flag) {
		if (cnt == n / 2) {
			calc(flag);
		}
		for (int i = start; i < n; i++) {
			if ((flag & (1 << i)) != 0) {
				continue;
			}
			comb(cnt + 1, i, flag | 1 << i);
		}
	}

	private static void calc(int flag) {
		int a = 0;
		int b = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((flag & 1 << i) != 0 && (flag & 1 << j) != 0) {
					a += map[i][j];
				}
				if ((flag & 1 << i) == 0 && (flag & 1 << j) == 0) {
					b += map[i][j];
				}
			}
		}
		min = Math.min(min, Math.abs(a - b));
	}
}
