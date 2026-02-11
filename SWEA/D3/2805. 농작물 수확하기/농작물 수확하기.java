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
			int n = Integer.parseInt(br.readLine());
			int sum = 0;
			int mid = n / 2;
			for (int j = 0; j < n; j++) {
				String line = br.readLine();
				int center = Math.abs(mid - j);
				for (int k = center; k < n - center; k++) {
					sum += line.charAt(k) - '0';
				}
			}
			sb.append("#").append(i).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
