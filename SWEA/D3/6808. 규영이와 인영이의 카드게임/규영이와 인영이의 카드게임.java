import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	private static int win;
	private static int lose;
	private static int[] numbers;
	private static boolean[] isSelected;
	private static List<Integer> listA;
	private static List<Integer> listB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			win = 0;
			lose = 0;
			listA = new ArrayList<>();
			listB = new ArrayList<>();
			isSelected = new boolean[9];
			numbers = new int[9];
			for (int j = 0; j < 9; j++) {
				listA.add(Integer.parseInt(st.nextToken()));
			}
			for (int j = 1; j <= 18; j++) {
				if (!listA.contains(j)) {
					listB.add(j);
				}
			}
			permutation(0);
			sb.append("#").append(i).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}

	private static void permutation(int cnt) {
		if (cnt == 9) {
			int sumA = 0, sumB = 0;
			for (int i = 0; i < 9; i++) {
				int a = numbers[i];
				int b = listB.get(i);
				if (a > b) {
					sumA += a + b;
				}
				if (b > a) {
					sumB += a + b;
				}
			}
			if (sumA > sumB)
				win++;
			if (sumB > sumA) {
				lose++;
			}
		} else {
			for (int i = 0; i < 9; i++) {
				if (isSelected[i])
					continue;
				numbers[cnt] = listA.get(i);
				isSelected[i] = true;
				permutation(cnt + 1);
				isSelected[i] = false;
			}
		}
	}
}
