import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		int cnt = 0;
		int res = 0;
		for (int i = 1; i < m - 1; i++) {
			if (arr[i - 1] == 'I' && arr[i] == 'O' && arr[i + 1] == 'I') {
				cnt++;
				if (cnt >= n) {
					res++;
				}
				i++;
			} else {
				cnt = 0;
			}
		}
		System.out.println(res);
	}
}
