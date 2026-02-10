import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int max = Integer.MIN_VALUE;
            int day = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x > max) {
                    max = x;
                }
                list.add(x);
            }
            int[] remain = new int[3];
            for (int j = 0; j < n; j++) {
                int x = max - list.get(j);
                if (x > 0) {
                    remain[2] += x / 2;
                    if (x % 2 != 0) {
                        remain[1]++;
                    }
                }
            }
            // 1,2 가 같은 양만큼 남은 경우
            if (remain[1] == remain[2]) {
                day += remain[1] * 2;
            }
            // 1이 더 많이 남은 경우
            else if (remain[1] > remain[2]) {
                day += remain[2] * 2;
                remain[1] -= remain[2];
                day += (remain[1] - 1) * 2 + 1;
            }
            // 2가 더 많이 남은 경우
            else {
                day += remain[1] * 2;
                remain[2] -= remain[1];
                day += 4 * (remain[2] / 3);
                if (remain[2] % 3 == 1) {
                    day += 2;
                }
                if (remain[2] % 3 == 2) {
                    day += 3;
                }
            }
            System.out.println("#" + i + " " + day);
        }
    }
}
