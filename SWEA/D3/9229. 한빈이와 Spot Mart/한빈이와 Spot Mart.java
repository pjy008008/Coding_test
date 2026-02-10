import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			List<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = 0, e = n - 1, max = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(list);
			while (true) {
				if (s == e)
					break;
				int sum = list.get(s) + list.get(e);
				if (sum > m) {
					e--;
				}
				if (sum <= m) {
					if (sum > max) {
						max = sum;
					}
					s++;
				}
			}
			if (max == 0) {
				max = -1;
			}
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
