import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < arr.length; i++){
            if(stack.size() == 0 || arr[i] != stack.peek()) // peek : Stack의 맨 위에 저장된 객체를 반환 Stack에서 꺼내지는 않음. 비었을 때 null 반환
                stack.push(arr[i]); //스택에 마지막으로 들어간 숫자가 이전에 들어간 숫자와 같지 않으면 arr에 쌓음
        }
        
        int[] answer = new int[stack.size()];
        
        for(int i = stack.size()-1; i >= 0; i--){
            answer[i] = stack.pop(); //스택은 LIFO라서 뒤에서부터 다시 쌓음
        }
        return answer;
    }
}
