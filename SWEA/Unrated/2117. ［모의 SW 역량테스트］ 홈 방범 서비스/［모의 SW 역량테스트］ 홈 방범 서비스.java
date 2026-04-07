import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	private static int m, n;
	private static int max;
	private static int[][] map;
	private static List<int[]> house;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			map = new int[n][n];
			house = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					int x = Integer.parseInt(st.nextToken());
					if (x == 1) {
						house.add(new int[] { k, j });
					}
					map[j][k] = x;
				}
			}
			for (int k = 1; k <= n + 1; k++) {
				solve(k);
			}
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	private static void solve(int k) {
		int cost = k * k + (k - 1) * (k - 1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int[] pos : house) {
					if (Math.abs(j - pos[0]) + Math.abs(i - pos[1]) < k) {
						cnt++;
					}
				}
				if (cnt * m - cost >= 0 && cnt > max) {
					max = cnt;
				}
			}
		}
	}
}
