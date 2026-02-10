import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String cmd = br.readLine();
			int cmdL = cmd.length();
			int size = Integer.parseInt(br.readLine());
			boolean errorFlag = false;
			boolean reverseFlag = false;
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), "[],");
			Deque<Integer> deque = new ArrayDeque<>();
			for (int j = 0; j < size; j++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			for (int j = 0; j < cmdL; j++) {
				if (cmd.charAt(j) == 'R') {
					if (reverseFlag) {
						reverseFlag = false;
					} else {
						reverseFlag = true;
					}
				}
				if (cmd.charAt(j) == 'D') {
					if (deque.size() != 0) {
						if (reverseFlag) {
							deque.removeLast();
						} else {
							deque.removeFirst();
						}
					} else {
						errorFlag = true;
					}
				}
			}
			if (errorFlag) {
				sb.append("error\n");
			} else {
				sb.append("[");
				size = deque.size();
				for (int j = 0; j < size; j++) {
					if(reverseFlag) {
						sb.append(deque.pollLast());
					}else {
						sb.append(deque.pollFirst());
					}
					if (j != size - 1) {
						sb.append(",");
					}
				}
				sb.append("]\n");
			}
		}
		System.out.println(sb);
	}
}
