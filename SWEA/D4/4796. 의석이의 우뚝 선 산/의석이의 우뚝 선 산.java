import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		StringBuilder sb = new StringBuilder();
		st.nextToken();
		int t = (int) st.nval;
		for (int i = 1; i <= t; i++) {
			st.nextToken();
			int n = (int) st.nval;
			List<Integer> list = new ArrayList<>();
			int sum = 0;
			boolean isIncrease = false;
			st.nextToken();
			int temp = (int) st.nval;
			for (int j = 1; j < n; j++) {
				st.nextToken();
				int x = (int) st.nval;
				if (!isIncrease) {
					if (x > temp) {
						list.add(j - 1);
						isIncrease = true;
					}
				} else {
					if (x < temp) {
						list.add(j - 1);
						isIncrease = false;
					}
				}
				if (j == n - 1) {
					if (!isIncrease) {
						list.add(j);
					}
				}
				temp = x;
			}
			for (int j = 0; j < list.size() - 2; j += 2) {
				int left = list.get(j + 1) - list.get(j);
				int right = list.get(j + 2) - list.get(j + 1);
				sum += left * right;
			}
			sb.append("#").append(i).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
