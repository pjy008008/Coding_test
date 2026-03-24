import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<operations.length;i++){
            st = new StringTokenizer(operations[i]);
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(cmd.equals("I")){
                // insert
                if(!map.containsKey(num)){
                    map.put(num,1);
                }else{
                    int count = map.get(num);
                    map.put(num,count+1);
                }
            }
            if(cmd.equals("D")){
                // delete
                if(map.isEmpty()){
                    continue;
                }
                if(num==1){
                    int key = map.lastKey();
                    int count = map.get(key);
                    count--;
                    if(count>1){
                        map.put(key,count);
                    }else{
                        map.remove(key);
                    }
                }
                if(num==-1){
                    int key = map.firstKey();
                    int count = map.get(key);
                    count--;
                    if(count>1){
                        map.put(key,count);
                    }else{
                        map.remove(key);
                    }
                }         
            }
        }
        if(map.isEmpty()){
            return new int[]{0,0};
        }
        return new int[]{map.lastKey(),map.firstKey()};
    }
}