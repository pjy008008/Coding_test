import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = times[0];
        long right = (long)times[times.length-1] * n;

        while(left<=right){
            long mid = (left + right) / 2;
            if(find(mid, times) < n){
                left = mid + 1;
                continue;
            }else{
                right = mid - 1;
                continue;
            }
        }
        return left;
    }
    
    private static long find(long mid, int[] times){
        long num = 0L;
        for(int i=0;i<times.length;i++){
            num += mid / times[i];
        }
        return num;
    }
}