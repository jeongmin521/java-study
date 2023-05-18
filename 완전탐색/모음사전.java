import java.util.*;

class Solution {
    static String[] arr;
    static List<String> list;
    public int solution(String word) {
        int answer = 0;
        
        list = new ArrayList<>();
        arr = new String[]{"A", "E", "I", "O", "U"};
        // 완전탐색 메서드 호출
        recursion(word, "", 0);
        
        // 선형 탐색
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    // 완전탐색 메서드
    static void recursion(String word, String str, int depth) {
        list.add(str);
        
        if(depth == 5) {
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            recursion(word, str + arr[i], depth + 1);
        }
    }
}


-----------------------------------------------------------------------------------------------
    
import java.util.*;

class Solution {
    static char[] vowel = {'A','E','I','O','U'};
    static ArrayList<String> list;
    
    public int solution(String word) {
        list = new ArrayList<>(); //새로운 리스트 생성
        int answer = 0;
        
        combination(0, "");
        Collections.sort(list); //정렬
        answer = list.indexOf(word) + 1;
        
        return answer;
    }
    
    public void combination(int index, String str){
        
        if(index >= 5) {
            return;
        }
        for(int i = 0; i < vowel.length; i++){
            list.add(str + vowel[i]);
            combination(index + 1, str + vowel[i]);
        }
    }
}


/*
컬렉션 : https://crazykim2.tistory.com/557
indexOf() : 특정 문자나 문자열이 앞에서부터 처음 발견되는 인덱스 반환. 찾지 못했을 경우 -1 반환
*/
