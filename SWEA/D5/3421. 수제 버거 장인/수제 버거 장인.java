import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int n;
	private static int m;
	private static int cnt;
	private static int[] conditions;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			cnt = 0;
			conditions = new int[m];
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int a = 1 << (Integer.parseInt(st.nextToken()) - 1);
				int b = 1 << (Integer.parseInt(st.nextToken()) - 1);
				int c = a | b;
				conditions[j] = c;
			}
			for (int j = 0; j < (1 << n); j++) {
				boolean isGood = true;
				for (int k = 0; k < m; k++) {
					if (Integer.bitCount(j & conditions[k]) == 2) {
						isGood = false;
						break;
					}
				}
				if (isGood) {
					cnt++;
				}
			}
			sb.append("#").append(i).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
