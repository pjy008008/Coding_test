import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int n;
	private static int[][] map;
	private static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			min = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0, 0, 0);
			sb.append("#").append(i).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static void comb(int cnt, int start, int flag) {
		if (cnt == n / 2) {
			calc(flag);
		}
		for (int i = start; i < n; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}
			comb(cnt + 1, i + 1, flag | 1 << i);
		}
	}

	private static void calc(int flag) {
		int a = 0;
		int b = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((flag & (1 << i)) != 0 && (flag & (1 << j)) != 0) {
					a += map[i][j];
				}
				if ((flag & (1 << i)) == 0 && (flag & (1 << j)) == 0) {
					b += map[i][j];
				}
			}
		}
		min = Math.min(min, Math.abs(a - b));
	}
}
