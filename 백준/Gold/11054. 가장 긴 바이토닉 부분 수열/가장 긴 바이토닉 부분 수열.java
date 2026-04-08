import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] increase = new int[n];
		int[] decrease = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// LIS
		for (int i = 0; i < n; i++) {
			increase[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					increase[i] = Math.max(increase[i], increase[j] + 1);
				}
			}
		}

		// LDS
		for (int i = n - 1; i >= 0; i--) {
			decrease[i] = 1;
			for (int j = n - 1; j > i; j--) {
				if (arr[j] < arr[i]) {
					decrease[i] = Math.max(decrease[i], decrease[j] + 1);
				}
			}
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			res = Math.max(res, increase[i] + decrease[i] - 1);
		}
		System.out.println(res);
	}
}
