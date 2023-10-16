import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
            int answer = n - lost.length;
 
        //본인이 도난당함
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = reserve[j] = -1;
                    break;
                }
            }
        }
 
        //앞뒷번 친구에게 빌려줌
        for (int lostPerson : lost) {
            for (int i = 0; i < reserve.length; i++) {
                if (reserve[i] == lostPerson + 1 || reserve[i] == lostPerson - 1) {
                    answer++;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}

/*
그리디 알고리즘
 -> 매 선택에서 현재 당장 최적인 답을 선택해 전체 적합한 결과 도출
 
cnt = 0
만약에 문제가 해결된(빌리기 완료)경우에 cnt++ 해서 마지막에 return  n - (lost - cnt);

경우의 수
1. 도난당한 학생이 여벌의 옷을 가지고 있는 경우 -> 아무에게도 빌려줄 수x, 도난 전과 같은 상황
2. 도난당한 학생의 앞번호 학생이 여벌 가지고 있는 경우 -> 해결~!, lost에서 지움
3. 도난당한 학생의 뒷번호 학생이 여벌 가지고 있는 경우 -> 해결~!, lost에서 지움

2, 3이 겹칠 경우?
최대한 많은 학생들이 빌릴 수 있는 방법?


return n(전체 학생의 수) - lost.length

*/
