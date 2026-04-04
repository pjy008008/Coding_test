import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        int x = (int) Math.round(n * 0.15);
        int sum = 0;
        for (int i = x; i < n - x; i++) {
            sum += list.get(i);
        }
        int amount = n - 2 * x;
        int res = Math.round((float) sum / amount);
        System.out.println(res);
    }
}