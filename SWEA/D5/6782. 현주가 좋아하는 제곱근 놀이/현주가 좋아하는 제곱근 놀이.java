import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			long n = Long.parseLong(br.readLine());
			long cnt = 0;
			while (true) {
				if (n == 2) {
					break;
				}
				long x = (long) Math.sqrt((double) n);
				if (x * x == n) {
					n = x;
					cnt++;
				} else {
					long goal = (x + 1) * (x + 1);
					cnt += goal - n;
					n = goal;
				}
			}
			sb.append("#").append(i).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
