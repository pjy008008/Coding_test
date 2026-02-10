import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	private static int n;
	private static int l;
	private static List<Ingredient> list;

	private static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			max = -1;
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int kcal = Integer.parseInt(st.nextToken());
				list.add(new Ingredient(score, kcal));
			}
			subSet();
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	private static void subSet() {
		for (int i = 0; i < (1 << n); i++) {
			int scoreS = 0;
			int kcalS = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					scoreS += list.get(j).score;
					kcalS += list.get(j).kcal;
				}
			}
			if (kcalS > l) {
				continue;
			}
			max = Math.max(max, scoreS);
		}
		
	}

	static class Ingredient {
		int score;
		int kcal;

		Ingredient(int score, int kcal) {
			this.score = score;
			this.kcal = kcal;
		}
	}
}
