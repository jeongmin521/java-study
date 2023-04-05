import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] result = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            result[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(result,(s1,s2)->(s2+s1).compareTo(s1+s2));
        if(result[0].equals("0")) return "0";
        for(String s : result){
            answer+=s;
        }

        return answer;
    }
}

