import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map.merge(s, 1, (oldV, newV) -> oldV + 1);
        }
        int max = 0;
        String ans = "";
        for (String s : map.keySet()) {
            if (map.get(s) > max) {
                max = map.get(s);
                ans = s;
            }
        }
        System.out.println(ans);
    }
}