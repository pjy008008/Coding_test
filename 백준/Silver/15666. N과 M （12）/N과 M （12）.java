import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int[] arr;
    private static int[] numbers;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        numbers = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        comb(0, 0);
        System.out.println(sb);
    }

    private static void comb(int cnt, int start) {
        if (cnt == m) {
            for (int x : numbers) sb.append(x).append(" ");
            sb.append("\n");
            return;
        }

        int lastUsed = -1;
        for (int i = start; i < n; i++) {
            if (lastUsed == arr[i]) continue;

            lastUsed = arr[i];
            numbers[cnt] = arr[i];
            comb(cnt + 1, i);
        }
    }
}