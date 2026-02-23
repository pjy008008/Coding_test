import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeSet<String> set = new TreeSet<>((o1, o2) -> {
            if (o1.length() == o2.length()) {
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) < o2.charAt(i)) {
                        return -1;
                    } else if (o1.charAt(i) > o2.charAt(i)) {
                        return 1;
                    }
                }
                return 0;
            } else {
                return o1.length() - o2.length();
            }
        });
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            set.add(s);
        }
        for (String s : set) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}