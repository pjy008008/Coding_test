import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int l, c;
    private static char[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        solve(0, 0);
        System.out.println(sb);
    }

    private static void solve(int start, int flag) {
        if (Integer.bitCount(flag) == l) {
            if (!check(flag)) {
                return;
            }
            for (int i = 0; i < c; i++) {
                if ((flag & (1 << i)) != 0) {
                    sb.append(arr[i]);
                }
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < c; i++) {
            if ((flag & (1 << i)) != 0) {
                continue;
            }
            solve(i + 1, flag | 1 << i);
        }
    }

    private static boolean check(int flag) {
        int consonants = 0;
        int vowels = 0;
        for (int i = 0; i < c; i++) {
            if ((flag & (1 << i)) != 0) {
                if (isVowel(arr[i])) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        return consonants >= 2 && vowels >= 1;
    }

    private static boolean isVowel(char c) {
        if ("aeiou".contains(String.valueOf(c))) {
            return true;
        }
        return false;
    }
}