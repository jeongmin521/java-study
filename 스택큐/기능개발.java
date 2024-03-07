import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>(); //남은 작업일수
        List<Integer> answerList = new ArrayList<>(); 

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i]; //완료까지 걸리는 시간
            int date = (int) Math.ceil(remain); //올림해서 날짜

            if (!q.isEmpty() && q.peek() < date) { //현재date가 q첫번째 숫자보다 크면 q에있는걸 먼저 배포
                answerList.add(q.size()); //현재 배포할수있는 기능 수를 answerList에 저장
                q.clear(); //q를 초기화해서 두번째 배포 준비
            }

            q.offer(date);//큐에 date객체 저장
        }

        answerList.add(q.size()); 

        int[] answer = new int[answerList.size()]; //크기 맞춰줌

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
-----------------------------------------------------------------------------------------------------------------------------
24.03.07
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>(); //정답을 저장할 리스트
        Queue<Integer> q = new <Integer> LinkedList(); //남은 일수를 저장
        //큐를 쓰는 이유 : 배열->값 추가 어려움, 리스트 -> 순서대로 값을 가져오기 어려움
        int cnt = 0; //완료된 작업의 개수
        
        for(int i = 0; i < progresses.length; i++){
            int k = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            q.add(k);
        }//q에 각 작업별로 완료까지 남은 일수를 저장
        
        int qlength = q.size();
        int frontqval = q.element();
        
        while(!q.isEmpty()) {
            int qval = q.element();
        	if(frontqval < qval && q.size() != qlength){ //i 작업의 남은 일수 < i+1 작업의 남은 일수 -> i까지 배포
                if(cnt != 0){
                    answer.add(cnt); //현재 완료된 작업까지 배포
                    cnt = 1; //완료된 작업 개수 초기화. 0아니고 1인 이유는 현재 i < i+1인 경우 다음 배포를 위해 하나 추가
                    }
                if(q.size() == 1){
                    answer.add(cnt);
                }
                frontqval = (frontqval > qval) ? frontqval : qval; // 그 뒤에 오는 작업과 일수를 비교 위해
                q.remove();
        	    } 
            else { //q[i] < q[i+1]일 때까지 q값 뽑아내서 비교 후 만족 시 answer에 cnt추가
                    cnt++;
                    if(q.size() == 1){
                        answer.add(cnt);
                    } 
                     frontqval = (frontqval > qval) ? frontqval : qval;
                    q.remove();
                }
        }
        
        //리스트를 배열로 변환
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }
           
        return result;
    }
}

/*
작업 진도가 100이 되어야 배포 가능
배포된 작업의 갯수를 count
progresses의 순서대로 
(100 - progresses[i]) / speeds[i]
q = 7,4,9
q[i] >= q[i+1] 이면 둘이 함께 배포 
q[i] <= q[i+1] i까지 배포가 됨
q에서 peek 할 때 마다 cnt++ 해줘서 q[i] >= q[i+1] 일 경우 cnt의 개수만큼 배포하는것
*/
