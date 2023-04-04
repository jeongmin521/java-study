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
