import java.util.*;
 
class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); //처리시간 순서대로
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); //시작시간 순서대로 
        
        int sum = 0;
        int current = 0; //현재 시간
        int i = 0;
        while(i < jobs.length || !pq.isEmpty()) {
            while(i < jobs.length && jobs[i][0] <= current) {
                pq.add(new int[] {jobs[i][0], jobs[i][1]});
                i++;
            }
            
            if(pq.isEmpty()) { //큐가 비어있음 -> 현재 실행가능한 작업X
                current = jobs[i][0]; //다음 작업의 시작시간으로 이동
            } else {
                int[] temp = pq.poll();
                sum += current + temp[1] - temp[0]; //요청 ~ 종료시간 
                current += temp[1];
            }
        }
        return sum / jobs.length;
        
    }
}



/*1. 요청부터 종료까지 시간을 구한다
   ->순서를 어떻게 해야 평균이 가장 작을까?
        -첫번째는 가장 시작시간이 빠른 것부터
        -그다음 작업이 끝난 상태보다 시작시간이 빠른것 선택
          ->이게 여러개일 경우
               => 수행시간이 더 짧은 작업 선택
  2. 이들의 평균을 구함 */
