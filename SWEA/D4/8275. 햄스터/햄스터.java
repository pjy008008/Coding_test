import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    private static int n;
    private static int x;
    private static int m;
    private static int[] l;
    private static int[] r;
    private static int[] s;
    private static int[] numbers;
    private static int[] best;
    private static int max;
    private static boolean[] included;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());  // 우리 개수
            x = Integer.parseInt(st.nextToken());  // 한 우리당 0~x
            m = Integer.parseInt(st.nextToken());  // 기록 개수
            numbers = new int[n];
            best = new int[n];
            included = new boolean[n];
            max = -1;
            l = new int[m];
            r = new int[m];
            s = new int[m];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                l[j] = Integer.parseInt(st.nextToken());
                r[j] = Integer.parseInt(st.nextToken());
                s[j] = Integer.parseInt(st.nextToken());
                for (int k = l[j] - 1; k < r[j]; k++) {
                    included[k] = true;
                }
            }
            perm(0);
            sb.append("#").append(i).append(" ");
            if (max >= 0) {
                for (int j = 0; j < n; j++) {
                    sb.append(best[j]).append(" ");
                }
            } else {
                sb.append(-1);
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if (cnt == n) {
            for (int i = 0; i < m; i++) {
                int sum = 0;
                for (int j = l[i] - 1; j < r[i]; j++) {
                    sum += numbers[j];
                }
                if (sum != s[i]) {
                    return;
                }
            }
            int cur = Arrays.stream(numbers).sum();
            if (cur > max) {
                max = cur;
                for (int i = 0; i < n; i++) {
                    best[i] = numbers[i];
                }
            }
            return;
        }
        if (!included[cnt]) {
            numbers[cnt] = x;
            perm(cnt + 1);
        } else {
            for (int i = 0; i <= x; i++) {
                numbers[cnt] = i;
                perm(cnt + 1);
            }
        }
    }
}
