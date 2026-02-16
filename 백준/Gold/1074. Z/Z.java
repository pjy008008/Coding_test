import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, r, c;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        solve(0, 0, 1 << n);
    }

    private static void solve(int row, int col, int size) {
        if (size == 1) {
            System.out.println(ans);
            return;
        }

        int mid = size / 2;
        if (r < mid + row && c < mid + col) {  // Second Quadrant
            solve(row, col, mid);
        }
        if (r < mid + row && c >= mid + col) { // First Quadrant
            ans += mid * mid;
            solve(row, col + mid, mid);
        }
        if (r >= mid + row && c < mid + col) { // Third Quadrant
            ans += mid * mid * 2;
            solve(row + mid, col, mid);
        }
        if (r >= mid + row && c >= mid + col) { // Fourth Quadrant
            ans += mid * mid * 3;
            solve(row + mid, col + mid, mid);
        }
    }
}