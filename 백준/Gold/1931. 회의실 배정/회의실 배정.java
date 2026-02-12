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
		int n = Integer.parseInt(br.readLine());
		int cnt = 1;
		List<Meeting> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new Meeting(s, e));
		}
		Collections.sort(list);
		int e = list.get(0).e;
		for (int i = 1; i < n; i++) {
			if (list.get(i).s >= e) {
				e = list.get(i).e;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static class Meeting implements Comparable<Meeting> {
		int s;
		int e;

		Meeting(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Meeting o) {
			if (this.e != o.e) {
				return this.e - o.e;
			} else {
				return this.s - o.s;
			}
		}
	}
}
