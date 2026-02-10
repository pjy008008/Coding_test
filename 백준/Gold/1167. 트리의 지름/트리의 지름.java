import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Node>[] arr;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        arr = new ArrayList[v + 1];
        visited = new boolean[v + 1];
        distance = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            arr[i] = new ArrayList<Node>();
        }
        for (int i = 0; i < v; i++) {
            int vertex = sc.nextInt();
            while (true) {
                int e = sc.nextInt();
                if (e == -1) {
                    break;
                }
                int w = sc.nextInt();
                arr[vertex].add(new Node(e, w));
            }
        }
        int max=1;
        bfs(1);
        for (int i = 2; i <= v; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }
        distance = new int[v + 1];
        visited = new boolean[v + 1];
        bfs(max);
        Arrays.sort(distance);
        System.out.println(distance[v]);
    }
    public static void bfs(int vertex) {
        visited[vertex] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (Node node : arr[x]) {
                if (!visited[node.vertex]) {
                    visited[node.vertex]=true;
                    queue.add(node.vertex);
                    distance[node.vertex] = distance[x] + node.weight;
                }
            }
        }
    }
}
class Node {
    int vertex;
    int weight;
    Node(int vertex,int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
}
