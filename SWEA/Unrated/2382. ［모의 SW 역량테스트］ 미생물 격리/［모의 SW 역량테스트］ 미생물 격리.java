import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	private static int n;
	private static int m;
	private static int k;
	private static int[][] map;
	private static List<Group> list;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 셀 개수
			m = Integer.parseInt(st.nextToken()); // 격리 시간
			k = Integer.parseInt(st.nextToken()); // 미생물 군집
			map = new int[n][n];
			list = new ArrayList<>();
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int amount = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				list.add(new Group(y, x, amount, dir));
			}
			for (int j = 0; j < m; j++) {
				move();
			}
			sb.append("#").append(i).append(" ").append(getResult()).append("\n");
		}
		System.out.println(sb);
	}

	private static void move() {
		List<Group> newGroup = new ArrayList<>();
		Set<int[]> set = new HashSet<>();
		for (Group group : list) {
			group.x += dx[group.dir];
			group.y += dy[group.dir];
			if (group.x == 0 || group.y == 0 || group.x == n - 1 || group.y == n - 1) {
				// amount/2, dir을 반대로(+2한 후 %4 연산)
				group.amount /= 2;
				group.dir = reverseDir(group.dir);

			}
			if (group.amount == 0) {
				continue;
			}
			set.add(new int[] { group.y, group.x });
			map[group.y][group.x] += group.amount;

		}
		for (int[] pos : set) {
			int y = pos[0];
			int x = pos[1];
			int max = 0;
			int maxDir = -1;
			for (Group group : list) {
				if (group.x == x && group.y == y) {
					if (group.amount > max) {
						max = group.amount;
						maxDir = group.dir;
					}
				}
			}
			newGroup.add(new Group(y, x, map[y][x], maxDir));
			map[y][x] = 0;
		}
		list.clear();
		list.addAll(newGroup);
	}

	private static int reverseDir(int dir) {
		if (dir == 0) {
			return 1;
		} else if (dir == 1) {
			return 0;
		} else if (dir == 2) {
			return 3;
		} else {
			return 2;
		}
	}

	private static int getResult() {
		int sum = 0;
		for (Group group : list) {
			sum += group.amount;
		}
		return sum;
	}

	static class Group {
		int y;
		int x;
		int amount;
		int dir;

		Group(int y, int x, int amount, int dir) {
			this.y = y;
			this.x = x;
			this.amount = amount;
			this.dir = dir;
		}
	}
}
