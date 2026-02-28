import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] map;
    private static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        count = new int[2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, n);
        for(int ans: count){
            System.out.println(ans);
        }
    }

    private static void dfs(int x, int y, int size) {
        if (size == 1) {
            count[map[y][x]]++;
            return;
        }
        int mid = size / 2;
        int data = map[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] != data) {
                    dfs(x, y, mid);
                    dfs(x + mid, y, mid);
                    dfs(x, y + mid, mid);
                    dfs(x + mid, y + mid, mid);
                    return;
                }
            }
        }
        count[data]++;
    }
}