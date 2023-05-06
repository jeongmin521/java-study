import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++){
            if (phone_book[i + 1].startsWith(phone_book[i])){ //앞 번호가 뒷 번호의 접두어인지 확인
                return false;
            }
        }
        return true;
    }
}


------------------------------------------------------------------------------------------------------------
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        for (int i = 0; i < phone_book.length-1; i++){
            for(int j = i+1; j < phone_book.length; j++){
                if (phone_book[j].startsWith(phone_book[i])){ //앞 번호가 뒷 번호의 접두어인지 확인
                    return false;
                }
                else
                    continue;
            }
        }
        return true;
    }
}

/*
sort안하고 이중for문 썼을 때 오류가 나는 이유?
순서가 123 12 이면 false가 나와야하는데 앞의것을 기준으로 뒤에것을 비교하기 때문에 true가 나옴
*/


-----------------------------------------------------------------------------------------------------------
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Map<String, Integer> map = new HashMap<>(); //HashMap 선언

        for (int i = 0; i < phone_book.length; i++) 
            map.put(phone_book[i], i);
        
        for (int i = 0; i < phone_book.length; i++)
            for (int j = 0; j < phone_book[i].length(); j++){
                if (map.containsKey(phone_book[i].substring(0, j))){ //모든 전화번호의 substring이 HashMap에 존재하는지 확인
                    return false;
                }   
            }
        return true;
    }
}
