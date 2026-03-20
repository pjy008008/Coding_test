import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		// init prefix a
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		// init prefix b
		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		List<Long> listA = new ArrayList<>();
		List<Long> listB = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			long sum = 0;
			for (int j = i; j < n; j++) {
				sum += a[j];
				listA.add(sum);
			}
		}
		for (int i = 0; i < m; i++) {
			long sum = 0;
			for (int j = i; j < m; j++) {
				sum += b[j];
				listB.add(sum);
			}
		}
		Collections.sort(listA);
		Collections.sort(listB);
		int s = 0;
		int e = listB.size() - 1;
		long res = 0;
		while (s < listA.size() && 0 <= e) {
			long sum = listA.get(s) + listB.get(e);
			if (sum == t) {
				long curA = listA.get(s);
				long cntA = 0;
				while (s < listA.size() && curA == listA.get(s)) {
					s++;
					cntA++;
				}

				long curB = listB.get(e);
				long cntB = 0;
				while (0 <= e && curB == listB.get(e)) {
					e--;
					cntB++;
				}
				res += cntA * cntB;
			} else if (sum > t) {
				e--;
			} else {
				s++;
			}
		}
		System.out.println(res);
	}
}
