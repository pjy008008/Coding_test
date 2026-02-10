import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			int n = Integer.parseInt(br.readLine());
			boolean[][] gears = new boolean[4][8];
			for (int j = 0; j < 4; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 8; k++) {
					if (st.nextToken().equals("1"))
						gears[j][k] = true;
				}
			}
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int gearNum = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				gears = move(gears, gearNum, dir);
			}
			int score = 0;
			int weight = 1;
			for (int j = 0; j < 4; j++) {
				if (gears[j][0]) {
					score += weight;
				}
				weight *= 2;
			}
			sb.append("#").append(i).append(" ").append(score).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean[][] move(boolean[][] gears, int gearNum, int dir) {
		boolean[] adjact = getAdjact(gears);
		boolean[] canMove = new boolean[4];
		canMove[gearNum] = true;
		int left = gearNum - 1;
		int right = gearNum;
		while (left >= 0) {
			if (adjact[left]) {
				canMove[left] = true;
				left--;
			} else {
				break;
			}
		}
		while (right < 3) {
			if (adjact[right]) {
				canMove[right + 1] = true;
				right++;
			} else {
				break;
			}
		}
		for (int i = 0; i < 4; i++) {
			if (canMove[i]) {
				int rotateDir;
				if ((Math.abs(gearNum - i) % 2) == 0) {
					rotateDir = dir;
				} else {
					rotateDir = -dir;
				}
				gears[i] = rotate(gears[i], rotateDir);
			}
		}
		return gears;
	}

	private static boolean[] rotate(boolean[] gear, int dir) {
		if (dir == 1) {
			boolean tmp = gear[7];
			for (int i = 7; i > 0; i--) {
				gear[i] = gear[i - 1];
			}
			gear[0] = tmp;
		} else {
			boolean tmp = gear[0];
			for (int i = 0; i < 7; i++) {
				gear[i] = gear[i + 1];
			}
			gear[7] = tmp;
		}
		return gear;
	}

	private static boolean[] getAdjact(boolean[][] gears) {
		boolean[] result = new boolean[3];
		for (int i = 0; i < 3; i++) {
			if (gears[i][2] != gears[i + 1][6]) {
				result[i] = true;
			}
		}
		return result;
	}
}
