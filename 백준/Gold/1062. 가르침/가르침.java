import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, k;
    private static int[] words;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (k <= 4) {
            System.out.println(0);
        } else {
            words = new int[n];
            max = Integer.MIN_VALUE;
            int flag = 1 | (1 << 2) | (1 << 8) | (1 << 13) | (1 << 19);
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                int word = 0;
                for (int j = 0; j < str.length(); j++) {
                    int pos = str.charAt(j) - 'a';
                    word = word | (1 << pos);
                }
                words[i] = word;
            }
            comb(0, flag, 5);
            System.out.println(max);
        }
    }

    private static void comb(int idx, int flag, int size) {
        if (size == k) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if ((flag & words[i]) == words[i]) {
                    cnt++;
                }
            }
            if (cnt > max) {
                max = cnt;
            }
            return;
        }
        for (int i = idx; i < 26; i++) {
            if ((flag & (1 << i)) != 0) {
                continue;
            }
            comb(i + 1, flag | 1 << i, size + 1);
        }
    }
}