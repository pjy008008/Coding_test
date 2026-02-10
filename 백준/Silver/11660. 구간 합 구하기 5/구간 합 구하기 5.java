import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] a = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int x = scanner.nextInt();
                a[i][j]=x;
                s[i][j] = s[i][j-1] +s[i-1][j] + a[i][j] - s[i-1][j-1];
            }
        }
        for (int i = 0; i < m; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            System.out.println(s[x2][y2] - s[x1-1][y2] - s[x2][y1-1] + s[x1-1][y1-1]);

        }
    }
}