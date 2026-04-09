import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static char[][] map;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = ' ';
            }
        }
        solve(0, 0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void solve(int x, int y, int size) {
        if (size == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    map[y + i][x + j] = '*';
                }
            }
            return;
        }
        int temp = size / 3;

        // top three
        solve(x, y, temp);
        solve(x + temp, y, temp);
        solve(x + 2 * temp, y, temp);

        // medium
        solve(x, y + temp, temp);
        solve(x + 2 * temp, y + temp, temp);

        // bottom
        solve(x, y + 2 * temp, temp);
        solve(x + temp, y + 2 * temp, temp);
        solve(x + 2 * temp, y + 2 * temp, temp);
    }
}