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
