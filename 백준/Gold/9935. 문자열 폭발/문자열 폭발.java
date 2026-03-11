import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String a = br.readLine();
		String b = br.readLine();
		for (int i = 0; i < a.length(); i++) {
			sb.append(a.charAt(i));
			if (sb.length() >= b.length()) {
				boolean flag = true;
				int idx = sb.length() - b.length();
				for (int j = 0; j < b.length(); j++) {
					if (sb.charAt(idx + j) != b.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					sb.delete(idx, idx + b.length());
				}
			}
		}
		if (sb.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb);
		}
	}
}
