import java.util.*;  
  
class Solution {  
  
    boolean solution(String s) {  
        Stack<Character> stack = new Stack<>();  
        for (int i = 0; i < s.length(); i++) {  
            if (s.charAt(i) == '(') { //CharAt : string으로 저장된 것 중 하나만 char형으로 변환
                stack.push('(');  
            } else if (s.charAt(i) == ')') {  
                if (stack.isEmpty()) {  
                    return false;  
                }  
                stack.pop(); //짝을 찾으면 stack에서 '('를 뺌
            }  
        }  
        return stack.isEmpty(); //stack이 비어있으면 true
    }  
}                                                                                                                                     
