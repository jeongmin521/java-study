import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0; // 총 이동 횟수
        int index;
        int cnt = name.length() - 1;
        
        for(int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            //상하이동. 첫 번째 알파벳이 A부터 혹은 Z부터 이동하는 것 중 더 적은 횟수만큼 +
            //첫 번째 글자
            
            index = i + 1; //좌우이동, 두번째 이상 문자
            
            while(index < name.length() && name.charAt(index) == 'A') {
                index++; //좌우 이동 후 상하 이동이 필요 없는경우 (A 연속)
            }
            //좌우 이동 후 상하 이동이 필요한 경우
            cnt = Math.min(cnt, i * 2 + name.length() - index); //상하이동 두 방향중 빠른 것 선택
            cnt = Math.min(cnt, (name.length() - index) *2 + i); //처음부터 뒷부분을 입력하는게 더 빠른 경우
        }
        return answer + cnt;
    }
}

/*
횟수의 최솟값
1. 위, 아래로 각각 알파벳이 매칭될 때 까지 이동해 더 적은 횟수를 저장
2. 좌우로 이동한 후 마찬가지로 어느 방향이 더 빠른지?


3. 연속된 A의 앞쪽보다 뒷쪽이 짧은 경우, 뒷쪽부터 조작하는 것이 더 적게 이동
*/
