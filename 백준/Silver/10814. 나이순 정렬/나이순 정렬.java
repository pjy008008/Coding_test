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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<User> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new User(age, name));
        }
        Collections.sort(list);
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i).age).append(" ").append(list.get(i).name).append("\n");
        }
        System.out.println(sb);
    }

    static class User implements Comparable<User> {
        int age;
        String name;

        User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            if (this.age == o.age) {
                this.name.compareTo(o.name);
            }
            return this.age - o.age;
        }
    }

}