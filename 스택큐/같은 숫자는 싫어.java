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

-------------------------------------------------------------------------------------------------------------------------------
    import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> answer = new ArrayList<Integer>();
//         Queue<Integer> q = new LinkedList<>(); //정수형 큐 선언
        
//         int qvalue = -1; //arr의 원소가 될 수 없는 값으로 초기값 설정
        
//         for(int x : arr){
//             q.add(x);
//         } //큐에 arr에 있는 숫자들 넣기
        
//         for(int i = 0; i < arr.length; i++){
//             int qelement = q.element();
//             if(qvalue == qelement){ //숫자 중복 여부 확인
//                 q.remove(); //중복 값일 경우 삭제
//                 continue;
//             }
//             else{
//                 qvalue = q.poll();
//                 answer.add(qvalue);//answer에 중복되지 않은 숫자 넣기
//             }
//         }
        
        int qvalue = -1; //arr의 원소가 될 수 없는 값으로 초기값 설정
        
        for(int value : arr){
            if(qvalue == value){ //숫자 중복 여부 확인
                continue;
            }
            else{
                answer.add(value);//answer에 중복되지 않은 숫자 넣기
                qvalue = value;
            }
        }

        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
}

/*
중복된 숫자는 빼고 입력 순서 그대로 다시 출력해야 함 -> FIF0. 큐 사용하기
큐의 값을 하나씩 빼면서 그 값과 그 다음으로 나올 값을 비교해 같을 경우 삭제
peek을 하고 성공하면 true/false를 반환함. 형 변환 필요
 ->peek() 대신 element, poll 사용
테케 다 통과했는데 효율성검사에서 시간초과가 뜸..
굳이 큐를 쓰지 않아도 가능
*/
