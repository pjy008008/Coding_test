import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int length;
    private static int[] arr;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        length = st.countTokens() - 1;
        // initialize input
        arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // initialize dp Arr
        dp = new int[5][5][length];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        System.out.println(solve(0, 0, 0));
    }

    private static int solve(int left, int right, int idx) {
        if (idx == length) {
            return 0;
        }
        if (dp[left][right][idx] != -1) {
            return dp[left][right][idx];
        }

        int disL = solve(arr[idx], right, idx + 1) + calcEnergy(left, arr[idx]);
        int disR = solve(left, arr[idx], idx + 1) + calcEnergy(right, arr[idx]);
        dp[left][right][idx] = Math.min(disL, disR);
        return dp[left][right][idx];
    }

    private static int calcEnergy(int prev, int next) {
        int diff = Math.abs(prev - next);
        if (prev == 0) {
            return 2;
        } else if (diff == 0) {
            return 1;
        } else if (diff == 2) {
            return 4;
        } else {
            return 3;
        }
    }
}