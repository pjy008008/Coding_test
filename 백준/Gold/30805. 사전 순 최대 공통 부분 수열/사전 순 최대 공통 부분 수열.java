import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] count = new int[101];
		int[] countA = new int[101];
		int[] countB = new int[101];
		Set<Integer> set = new TreeSet<>();
		List<Integer> listA = new ArrayList<>();
		List<Integer> listB = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			listA.add(x);
			countA[x]++;
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(st.nextToken());
			listB.add(x);
			countB[x]++;
		}
		for (int i = 1; i <= 100; i++) {
			count[i] = Math.min(countA[i], countB[i]);
		}

		int idxA = 0;
		int idxB = 0;
		boolean flagA, flagB;
		int cnt = 0;
		List<Integer> result = new ArrayList<>();

		for (int i = 100; i > 0; i--) {
			if (count[i] >= 1) {
				flagA = flagB = false;
				int tempA = 0, tempB = 0;
				for (int j = idxA; j < n; j++) {
					if (listA.get(j) == i) {
						tempA = j;
						flagA = true;
						break;
					}
				}
				for (int j = idxB; j < m; j++) {
					if (listB.get(j) == i) {
						tempB = j;
						flagB = true;
						break;
					}
				}
				if (flagA && flagB) {
					idxA = tempA + 1;
					idxB = tempB + 1;
					cnt++;
					result.add(i);
					count[i]--;
					i++;
				}
			}
		}
		sb.append(cnt).append("\n");
		for (int x : result) {
			sb.append(x).append(" ");
		}
		System.out.println(sb);
	}
}
