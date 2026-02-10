import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>((a, b)->{
            int firstValue = Math.abs(a);
            int secondValue = Math.abs(b);
            if(firstValue==secondValue){
                return a>b?1:-1;
            }else{
                return firstValue -secondValue;
            }
        });
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x !=0) {
                priorityQueue.add(x);
            }
            else{
                if(priorityQueue.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(priorityQueue.poll());
                }
            }
        }
    }
}
