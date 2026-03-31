import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		List<Integer> list = new ArrayList<>();
		int idx = 0;
		int sum = 0;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				continue;
			}
			if (c == '+') {
				sum += Integer.parseInt(s.substring(idx, i));
				idx = i + 1;
			}
			if (c == '-') {
				sum += Integer.parseInt(s.substring(idx, i));
				idx = i + 1;
				list.add(sum);
				sum = 0;
			}
		}
		sum += Integer.parseInt(s.substring(idx, s.length()));
		list.add(sum);
		int res = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			res -= list.get(i);
		}
		System.out.println(res);
	}
}
