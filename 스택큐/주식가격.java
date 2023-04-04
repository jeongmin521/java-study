import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length]; //정답이 들어갈 배열
        int time;
        
        for(int i = 0; i < prices.length; i++){
            time = 0; //배열 다음 인덱스를 비교할때마다 time초기화
            for(int j = i+1; j < prices.length; j++){
                if(prices[i] <= prices[j]){
                    time++;
                } //뒤에 오는 가격이 더 떨어지지 않을 경우 time++
                else{
                    time++;
                    break;
                }//가격이 떨어진 경우
            }
            answer[i] = time;
        }
    return answer;
     } 
}


--------------------------------------------------------------------------------------------
큐를 이용한 풀이
import java.util.*; 

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < prices.length; i++){
            queue.offer(prices[i]);
        }
        int idx = 0, time = 0;
        while(!queue.isEmpty()){
            time = 0;
            for(int i = idx+1; i < prices.length; i++){
                if(queue.peek() <= prices[i]){
                    time++;
                }
                else{
                    time++;
                    break;
                }
            }
            queue.poll();
            answer[idx] = time;
            idx++;
        }
        return answer;
    }
}

//add는 예외상황에서 throw,offer은 null 이나 false반환
