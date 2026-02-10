import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int h;
	private static int w;
	private static int hT;
	private static int wT;
	private static char[][] map;
	private static int cmdL;
	private static String cmd;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			for (int j = 0; j < h; j++) {
				String line = br.readLine();
				for (int k = 0; k < w; k++) {
					char c = line.charAt(k);
					if (c == '^' || c == 'v' || c == '<' || c == '>') {
						hT = j;
						wT = k;
					}
					map[j][k] = c;
				}
			}
			cmdL = Integer.parseInt(br.readLine());
			cmd = br.readLine();
			play();
			sb.append("#").append(i).append(" ");
			for (int j = 0; j < h; j++) {
				for (int k = 0; k < w; k++) {
					sb.append(map[j][k]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void play() {
		for (int j = 0; j < cmdL; j++) {
			if (cmd.charAt(j) == 'U') {
				map[hT][wT] = '^';
				if (isOutOfMap(hT - 1, wT) || canNotMove(map[hT - 1][wT])) {
					continue;
				}
				map[hT][wT] = '.';
				hT--;
				map[hT][wT] = '^';
			}
			if (cmd.charAt(j) == 'D') {
				map[hT][wT] = 'v';
				if (isOutOfMap(hT + 1, wT) || canNotMove(map[hT + 1][wT])) {
					continue;
				}
				map[hT][wT] = '.';
				hT++;
				map[hT][wT] = 'v';

			}
			if (cmd.charAt(j) == 'L') {
				map[hT][wT] = '<';
				if (isOutOfMap(hT, wT - 1) || canNotMove(map[hT][wT - 1])) {
					continue;
				}
				map[hT][wT] = '.';
				wT--;
				map[hT][wT] = '<';
			}
			if (cmd.charAt(j) == 'R') {
				map[hT][wT] = '>';
				if (isOutOfMap(hT, wT + 1) || canNotMove(map[hT][wT + 1])) {
					continue;
				}
				map[hT][wT] = '.';
				wT++;
				map[hT][wT] = '>';
			}
			if (cmd.charAt(j) == 'S') {
				if (map[hT][wT] == '<') {
					shoot(new int[] { -1, 0 }, hT, wT);
				}
				if (map[hT][wT] == '^') {
					shoot(new int[] { 0, -1 }, hT, wT);
				}
				if (map[hT][wT] == '>') {
					shoot(new int[] { 1, 0 }, hT, wT);
				}
				if (map[hT][wT] == 'v') {
					shoot(new int[] { 0, 1 }, hT, wT);
				}
			}
		}
	}

	private static boolean canNotMove(char c) {
		if (c == '#' || c == '*' || c == '-') {
			return true;
		}
		return false;
	}

	private static boolean isOutOfMap(int y, int x) {
		if (0 <= x && x < w && 0 <= y && y < h) {
			return false;
		}
		return true;
	}

	private static void shoot(int[] dir, int y, int x) {
		int cnt = 1;
		while (true) {
			int nx = x + dir[0] * cnt;
			int ny = y + dir[1] * cnt;
			if (isOutOfMap(ny, nx)) {
				return;
			}
			if (map[ny][nx] == '#') {
				return;
			}
			if (map[ny][nx] == '*') {
				map[ny][nx] = '.';
				return;
			}
			cnt++;
		}
	}
}
