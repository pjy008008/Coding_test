import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();

        for(int i=0;i<phone_book.length;i++){
            set.add(phone_book[i]);
        }
        for(int i=0;i<phone_book.length;i++){
            String s = phone_book[i];
            for(int j=1;j<s.length();j++){
                String sub = s.substring(0,j);
                if(set.contains(sub)){
                    return false;
                }
            }
        }
        return true;
    }
}