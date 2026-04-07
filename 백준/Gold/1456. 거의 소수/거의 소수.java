import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		long[] arr = new long[10_000_001];
		for (int i = 2; i < arr.length; i++) {
			arr[i] = i;
		}

		for (int i = 2; i <= Math.sqrt(arr.length); i++) {
			if (arr[i] == 0) {
				continue;
			}
			for (int j = i + i; j < arr.length; j = j + i) {
				arr[j] = 0;
			}
		}

		int cnt = 0;
		for (int i = 2; i <= Math.sqrt(b); i++) {
			if (arr[i] != 0) {
				long temp = (long) i * i;
				while (temp <= b) {
					if (temp >= a) {
						cnt++;
					}
					if (temp > b / i) {
						break;
					}
					temp *= i;
				}
			}
		}
		System.out.println(cnt);
	}
}
