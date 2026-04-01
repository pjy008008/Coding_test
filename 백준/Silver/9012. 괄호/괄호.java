import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			boolean flag = true;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '(') {
					stack.push('(');
				} else {
					if (stack.isEmpty()) {
						flag = false;
						break;
					} else {
						stack.pop();
					}
				}
			}
			if (!stack.isEmpty()) {
				flag = false;
			}
			if (flag) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}
}
