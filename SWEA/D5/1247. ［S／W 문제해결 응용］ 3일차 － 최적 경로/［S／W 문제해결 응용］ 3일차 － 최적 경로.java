import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static int n;
	private static int min;
	private static int[] selected;
	private static ArrayList<int[]> customers;
	private static int cx, cy, hx, hy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			n = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			selected = new int[n];
			customers = new ArrayList<>();

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
			perm(0, 0);
			sb.append("#").append(i).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static void perm(int cnt, int flag) {
		if (cnt == n) {
			min = Math.min(min, calc(selected));
			return;
		}
		for (int i = 0; i < n; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}
			selected[cnt] = i;
			perm(cnt + 1, flag | 1 << i);
		}
	}

	private static int calc(int[] order) {
		int dis = 0;
		int[] first = customers.get(order[0]);
		int[] last = customers.get(order[n - 1]);
		dis += Math.abs(first[0] - cx) + Math.abs(first[1] - cy);
		for (int i = 1; i < n; i++) {
			int[] prev = customers.get(order[i - 1]);
			int[] cur = customers.get(order[i]);
			dis += Math.abs(prev[0] - cur[0]) + Math.abs(prev[1] - cur[1]);
		}
		dis += Math.abs(last[0] - hx) + Math.abs(last[1] - hy);
		return dis;
	}
}
