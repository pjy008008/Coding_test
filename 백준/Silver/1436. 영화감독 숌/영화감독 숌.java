import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int number = 666;
		while (true) {
			String s = String.valueOf(number);
			if (s.contains("666")) {
				cnt++;
			}
			if (cnt == n) {
				break;
			}
			number++;
		}
		System.out.println(number);
	}
}
