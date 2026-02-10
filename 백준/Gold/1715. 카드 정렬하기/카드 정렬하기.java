import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x,y)->{
            return -(y - x);
        });
        int n = sc.nextInt();
        int sum=0;
        for (int i = 0; i < n; i++) {
            priorityQueue.offer(sc.nextInt());
        }

        while(priorityQueue.size()!=1){
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            sum+=a+b;
            priorityQueue.add(a + b);
        }
        System.out.println(sum);
    }
}
