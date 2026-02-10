import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			Deque<Integer> stackA = new ArrayDeque<>();
			Deque<Integer> stackB = new ArrayDeque<>();
			for (int j = 0; j < a.length(); j++) {
				stackA.addFirst(a.charAt(j) - '0');
			}
			for (int j = 0; j < b.length(); j++) {
				stackB.addFirst(b.charAt(j) - '0');
			}
			int maxLength = Math.max(a.length(), b.length());

			boolean up = false;
			Deque<Integer> result = new ArrayDeque<>();
			for (int j = 0; j < maxLength; j++) {
				int sum = 0;
				if (up)
					sum++;
				if (j < a.length()) {
					sum += stackA.removeFirst();
				}
				if (j < b.length()) {
					sum += stackB.removeFirst();
				}
				if (sum >= 10) {
					sum = sum % 10;
					up = true;
				} else {
					up = false;
				}
				result.addFirst(sum);
			}
			if (up) {
				result.addFirst(1);
			}
			sb.append("#").append(i).append(" ");
			while(!result.isEmpty()) {
				sb.append(result.removeFirst());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
