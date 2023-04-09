import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
         PriorityQueue<Integer> pq = new PriorityQueue<>(); //숫자가 낮은게 우선
        
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        //=for (int i : scoville) pq.add(i);
        
        int cnt = 0; //새로운 음식 만드는 횟수
        
        while (pq.peek() < K) {
            if (pq.peek() >= K) break;
            if (pq.size() == 1) return - 1; //모두 k 이상으로 만들 수 없는 경우
            pq.add(pq.poll() + (pq.poll() * 2));
            cnt++;
        }
        
        return cnt;
    }
}
