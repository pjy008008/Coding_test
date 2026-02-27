import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Character> deque = new ArrayDeque<>();
		String line = br.readLine();
		for (int i = 0; i < line.length(); i++) {
			char cur = line.charAt(i);
			if ('A' <= cur && cur <= 'Z') {
				sb.append(cur);
			} else if (cur == '(') {
				deque.addFirst(cur);
			} else if (cur == ')') {
				while (!deque.isEmpty() && deque.peekFirst() != '(') {
					sb.append(deque.removeFirst());
				}
				deque.removeFirst();
			} else {
				while (!deque.isEmpty() && priority(deque.peekFirst()) >= priority(cur))
					sb.append(deque.removeFirst());
				deque.addFirst(cur);
			}
		}
		while (!deque.isEmpty()) {
			char c = deque.removeFirst();
			if (c == '(') {
				continue;
			}
			sb.append(c);
		}
		System.out.println(sb);
	}

	private static int priority(char op) {
		if (op == '(')
			return 1;
		if (op == '+' || op == '-')
			return 2;
		if (op == '*' || op == '/')
			return 3;
		return 0;
	}
}
