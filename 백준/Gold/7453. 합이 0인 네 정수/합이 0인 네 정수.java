import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int[] d = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}

		int[] ab = new int[n * n];
		int[] cd = new int[n * n];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ab[idx] = a[i] + b[j];
				cd[idx] = c[i] + d[j];
				idx++;
			}
		}
		Arrays.sort(ab);
		Arrays.sort(cd);
		System.out.println(count(ab, cd, 0));
	}

	private static long count(int[] a, int[] b, int findNum) {
		int s = 0;
		int e = n * n - 1;
		long cnt = 0;
		while (0 <= e && s < n * n) {
			int sum = a[s] + b[e];
			if (sum == findNum) {
				int curA = a[s];
				long cntA = 0;
				while (s < n * n && a[s] == curA) {
					cntA++;
					s++;
				}

				int curB = b[e];
				long cntB = 0;
				while (0 <= e && b[e] == curB) {
					cntB++;
					e--;
				}
				cnt += cntA * cntB;
			} else if (sum > findNum) {
				e--;
			} else {
				s++;
			}
		}
		return cnt;
	}
}
