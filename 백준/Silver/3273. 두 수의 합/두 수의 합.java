import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int x = Integer.parseInt(br.readLine());

        int s = 0;
        int e = list.size() - 1;
        int res = 0;
        while (s < e) {
            int cur = list.get(s) + list.get(e);
            if (cur == x) {
                res++;
                s++;
            } else if (cur < x) {
                s++;
            }else{
                e--;
            }
        }
        System.out.println(res);
    }
}