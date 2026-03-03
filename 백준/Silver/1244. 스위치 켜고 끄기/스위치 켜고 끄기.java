import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int[] led = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            led[i] = x;
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                // man
                int pos = num;
                int w = 2;
                while (pos <= n) {
                    if (led[pos] == 1) {
                        led[pos] = 0;
                    } else {
                        led[pos] = 1;
                    }
                    pos = num * w;
                    w++;
                }
            } else {
                // woman
                int pos1 = num - 1;
                int pos2 = num + 1;
                while (range(pos1) && range(pos2) && led[pos1] == led[pos2]) {
                    pos1--;
                    pos2++;
                }
                for (int j = pos1 + 1; j < pos2; j++) {
                    if (led[j] == 1) {
                        led[j] = 0;
                    } else {
                        led[j] = 1;
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            sb.append(led[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean range(int x) {
        if (1 <= x && x <= n) {
            return true;
        }
        return false;
    }
}