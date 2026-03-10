import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	private static int n;
	private static int min;
	private static int cx, cy, hx, hy;
	private static ArrayList<int[]> customers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			n = Integer.parseInt(br.readLine());
			customers = new ArrayList<>();
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			cx = Integer.parseInt(st.nextToken());
			cy = Integer.parseInt(st.nextToken());
			hx = Integer.parseInt(st.nextToken());
			hy = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				customers.add(new int[] { x, y });
			}
			dfs(0, 0, 0, new int[] { cx, cy });
			sb.append("#").append(i).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int depth, int dis, int flag, int[] pos) {
		if (dis > min) {
			return;
		}
		if (depth == n) {
			min = Math.min(min, dis + getDis(pos, new int[] { hx, hy }));
		}
		for (int i = 0; i < n; i++) {
			if ((flag & (1 << i)) != 0) {
				continue;
			}
			int d = getDis(pos, customers.get(i));
			dfs(depth + 1, dis + d, flag | 1 << i, customers.get(i));
		}
	}

	private static int getDis(int[] pos1, int[] pos2) {
		return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
	}
}
