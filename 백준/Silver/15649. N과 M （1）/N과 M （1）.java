import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int[] numbers;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[m];
        perm(0, 0);
        System.out.println(sb);
    }

    private static void perm(int cnt, int flag) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if ((flag & 1 << i) != 0) {
                continue;
            }
            numbers[cnt] = i + 1;
            perm(cnt + 1, flag | 1 << i);
        }
    }
}