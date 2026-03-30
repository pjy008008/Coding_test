import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] idx = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		idx[0] = 0;
		for (int i = 1; i < n; i++) {
			int cur = arr[i];
			int last = list.get(list.size() - 1);
			if (cur > last) {
				list.add(cur);
				idx[i] = list.size() - 1;
			} else {
				int pos = Collections.binarySearch(list, cur);
				if (pos < 0) {
					pos = -(pos + 1);
				}
				list.set(pos, cur);
				idx[i] = pos;
			}
		}
		sb.append(list.size()).append("\n");
		ArrayList<Integer> res = new ArrayList<>();
		int find = list.size() - 1;
		for (int i = n - 1; i >= 0; i--) {
			if (idx[i] == find) {
				res.add(arr[i]);
				find--;
			}
			if (find == -1) {
				break;
			}
		}
		Collections.reverse(res);
		for(int x: res) {
			sb.append(x).append(" ");
		}
		System.out.println(sb);
	}
}
