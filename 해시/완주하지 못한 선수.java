import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);  //배열 정렬

        int i = 0;
        for(i=0;i<completion.length;i++)
            if(!participant[i].equals(completion[i]))
                break; //두 배열을 비교해서 다른 것을 찾음
      
        return participant[i];
    }
}


---------------------------------------------------------------------------------------

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String player : participant) //참가자
            map.put(player, map.getOrDefault(player, 0) + 1);
        
        for (String player : completion) //완주자
            map.put(player, map.get(player) - 1);

            Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            if (entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}


/*
HashMap : Key-Value의 Pair를 관리하는 클래스
HashMap<String, Integer>
    -> Key는 String , Value는 Integer
    
getOrDefault
-  찾는 키 존재 시 찾는 키 값을 반환. 없다면 기본 값 반환
getOrDefault(Object key, V DefaultValue)

ex)
String [] alphabet = { "A", "B", "C" ,"A"};
HashMap<String, Integer> map = new HashMap<>();
for(String key : alphabet){
    map.put(key, map.getOrDefault(key, 0) + 1);
}

-> map : {A=2, B=1, C=1}

*/
