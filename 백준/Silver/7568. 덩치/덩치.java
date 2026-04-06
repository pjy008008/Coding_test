import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Person[] people = new Person[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			people[i] = new Person(w, h);
		}
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			int cnt = 1;
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				Person me = people[i];
				Person other = people[j];
				if (me.height < other.height && me.weigth < other.weigth) {
					cnt++;
				}
			}
			res[i] = cnt;
		}
		for(int x: res) {
			sb.append(x).append(" ");
		}
		System.out.println(sb);
	}

	static class Person {
		int weigth;
		int height;

		Person(int w, int h) {
			this.weigth = w;
			this.height = h;
		}
	}
}
