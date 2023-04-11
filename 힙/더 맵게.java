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


/*
우선순위 큐
- 큐는 FIFO인데 우선순위큐는 우선순위가 높은 순서대로 나감
- 이진트리 힙으로 구성
- 데이터 삽입 시 우선순위의 최대,  최소를 구성하여 데이터가 빠지면 중간을 계속해서 채워넣음

-선언
PriorityQueue<타입> 변수명 = new PriorityQueue<>();

- 삽입
해당 큐 맨 뒤에 삽입하고 성공 시 true반환
add() - 큐가 꽉 찬 경우  IllegalStateException
offer() - 값 추가 실패 시 false

-삭제
큐 맨 앞에 있는 값 반환 후 삭제
remove() - 큐가 비어있는 경우 NoSuchElementException
poll() - 비어있는 경우 null 반환

-값 확인
큐의 맨 앞에 있는 값 반환
element() - 큐가 비어있는 경우 NoSuchElementException
peek() - 비어있는 경우 null 반환
*/
