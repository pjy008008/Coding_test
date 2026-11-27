import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] isPossible = new boolean[n + 1];
        Arrays.fill(isPossible, true);

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPossible[i]) {
                primes.add(i);
                int cur = i;
                int x = i;
                int cnt = 1;
                while (cur <= n) {
                    isPossible[cur] = false;
                    cur = cnt * x;
                    cnt++;
                }
            }
        }

        if (n == 1) {
            System.out.println(0);
        } else {
            int sum = primes.get(0);
            int s = 0, e = 1;
            int res = 0;
            while (e < primes.size()) {
                if (sum == n) {
                    res++;
                    sum -= primes.get(s);
                    s++;
                } else if (sum > n) {
                    sum -= primes.get(s);
                    s++;
                } else {
                    sum += primes.get(e);
                    e++;
                }
            }

            if (sum == n) {
                res++;
            } else if (sum > n) {
                while (s < e) {
                    sum -= primes.get(s);
                    s++;
                    if (sum == n) {
                        res++;
                        break;
                    }
                }
            }
            System.out.println(res);
        }
    }
}