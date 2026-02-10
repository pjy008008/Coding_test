import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static int[][] map;
    private static int[] numbers;
    private static int n;
    private static int m;
    private static int c;
    private static int max = 0;
    private static int maxProfit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            numbers = new int[2];
            map = new int[n][n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            comb(0, 0);
            sb.append("#").append(i).append(" ").append(max).append("\n");
            max = 0;

        }
        System.out.println(sb);
    }

    private static void comb(int cnt, int start) {
        if (cnt == 2) {
            int aX = numbers[0] % n;
            int aY = numbers[0] / n;
            int bX = numbers[1] % n;
            int bY = numbers[1] / n;
            if (aY == bY && Math.abs(aX - bX) < m) {
                // 너무 붙어 있는 경우
                return;
            }
            int honey1 = getHoney(aX, aY);
            int honey2 = getHoney(bX, bY);
            max = Math.max(max, honey1 + honey2);
        } else {
            for (int i = start; i < n * n; i++) {
                if (i % n > n - m)
                    continue;
                numbers[cnt] = i;
                comb(cnt + 1, i + 1);
            }
        }
    }

    private static int getHoney(int x, int y) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = map[y][x + i];
        }
        maxProfit = 0;
        findMaxProfit(0, 0, 0, arr);
        return maxProfit;
    }

    private static void findMaxProfit(int idx, int sum, int powSum, int[] arr) {
        if (sum > c) return;

        if (idx == m) {
            maxProfit = Math.max(maxProfit, powSum);
            return;
        }

        findMaxProfit(idx + 1, sum + arr[idx], powSum + (arr[idx] * arr[idx]), arr);
        findMaxProfit(idx + 1, sum, powSum, arr);
    }
}
