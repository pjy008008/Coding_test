import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map;
	private static int[] selected;
	private static int n, m;
	private static int hc, cc;
	private static int min;
	private static List<int[]> houses, chickens;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		selected = new int[m];
		min = Integer.MAX_VALUE;
		hc = cc = 0;
		houses = new ArrayList<>();
		chickens = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					houses.add(new int[] { j, i });
					hc++;
				}
				if (x == 2) {
					chickens.add(new int[] { j, i });
					cc++;
				}
				map[i][j] = x;
			}
		}
		comb(0, 0, 0);
		System.out.println(min);
	}

	private static void comb(int start, int cnt, int flag) {
		if (cnt == m) {
			calc(selected);
			return;
		}
		for (int i = start; i < cc; i++) {
			if ((flag & (1 << i)) != 0) {
				continue;
			}
			selected[cnt] = i;
			comb(i + 1, cnt + 1, flag | 1 << i);
		}
	}

	private static void calc(int[] nums) {
		int sum = 0;
		for (int[] house : houses) {
			int dis = Integer.MAX_VALUE;
			int hx = house[0];
			int hy = house[1];
			for (int i = 0; i < m; i++) {
				int[] chicken = chickens.get(nums[i]);
				int cx = chicken[0];
				int cy = chicken[1];
				dis = Math.min(dis, Math.abs(hx - cx) + Math.abs(hy - cy));
			}
			sum += dis;
		}
		min = Math.min(min, sum);
	}
}
