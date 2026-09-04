import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        for(int i=progresses.length-1;i>=0;i--){
            stack.push(progresses[i]);
        }
        List<Integer> res = new ArrayList<>();
        int day = 0;
        int cnt = 0;
        int temp = 0;
        while(!stack.isEmpty()){
            day += 1;
            int peek = stack.peek();
            if(peek+(day*speeds[cnt])>=100){
                stack.pop();
                day -= 1;
                cnt += 1;
                temp += 1;
                continue;
            }else{
                if(temp!=0){
                    res.add(temp);    
                }
                temp=0;
            }
        }
        res.add(temp);
        int size = res.size();
        int[] ans = new int[size];
        for(int i=0;i<size;i++){
            ans[i] = res.get(i);
        }
        
        return ans;
    }
}