import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n * 2 - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                map[i][j] = ' ';
            }
        }
        solve(n - 1, 0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void solve(int x, int y, int h) {
        if (h == 3) {
            map[y][x] = '*';
            map[y + 1][x - 1] = '*';
            map[y + 1][x + 1] = '*';
            for (int i = -2; i <= 2; i++) {
                map[y + 2][x + i] = '*';
            }
            return;
        }
        // top
        solve(x, y, h / 2);
        // left-bottom
        solve(x - h / 2, y + h / 2, h / 2);
        // right-bottom
        solve(x + h / 2, y + h / 2, h / 2);
    }
}