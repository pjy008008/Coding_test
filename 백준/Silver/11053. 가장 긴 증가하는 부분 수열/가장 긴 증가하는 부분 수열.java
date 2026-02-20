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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		list.add(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			int last = list.get(list.size() - 1);
			if (x > last) {
				list.add(x);
			} else {
				int idx = binarySearch(list, 0, list.size(), x);
				list.remove(idx);
				list.add(idx, x);
			}
		}
		System.out.println(list.size());
	}

	private static int binarySearch(ArrayList<Integer> list, int start, int end, int key) {
		if (start == end) {
			return start;
		}
		int mid = (start + end) / 2;
		int index = list.get(mid);
		if (key == index) {
			return mid;
		} else if (key > index) {
			return binarySearch(list, mid + 1, end, key);
		} else {
			return binarySearch(list, start, mid, key);
		}
	}
}
