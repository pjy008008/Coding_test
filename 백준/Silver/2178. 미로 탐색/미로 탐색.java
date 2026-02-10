import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n,m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        bfs(0, 0);
        System.out.println(arr[n - 1][m - 1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            visited[x][y]=true;
            for (int k = 0; k < 4; k++) {
                int i = now[0] + dx[k];
                int j = now[1] + dy[k];
                if (i < n && i >= 0 && j >= 0 && j < m) {
                    if (arr[i][j] != 0 && !visited[i][j]) {
                        visited[i][j]=true;
                        arr[i][j]=arr[now[0]][now[1]]+1;
                        queue.add(new int[]{i, j});
                    }
                }
            }

        }

    }
}
