import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String line = br.readLine();
			if (line.length() == 1 && line.charAt(0) == '.') {
				break;
			}
			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '(') {
					stack.push('(');
				} else if (line.charAt(i) == '[') {
					stack.push('[');
				} else if (line.charAt(i) == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						flag = false;
						break;
					}
				} else if (line.charAt(i) == ']') {
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else {
						flag = false;
						break;
					}
				} else {
					continue;
				}
			}
			if (flag && stack.isEmpty()) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
		}
		System.out.println(sb);
	}
}
