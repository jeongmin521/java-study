import java.util.*;

class Solution {
    int cnt = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);

        return cnt;
    }

    public void dfs(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length){ //모든 숫자 탐색한 후
            if(target == sum) {
                cnt++; 
            }//계산결과가 target이면 count+1
        } 
        else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]); // 해당 노드의 값을 더하고 다음 숫자 탐색
            dfs(numbers, depth + 1, target, sum - numbers[depth]); // 해당 노드의 값을 빼고 다음 숫자 탐색
            
        }
    }
}


/*
주어진 숫자를 모두 이용해서 target 숫자를 만들기
+, - 를 사용
1. 모든 경우의 수를 만든 후 target number이 되는 경우를 count
 - 모든 경우의 수 만들기 dfs(깊이 우선 탐색) : https://codingnojam.tistory.com/44
 - 숫자 앞에 +, - 를 바꾸면서 계산
 
 해당 dfs함수에서 재귀함수를 호출하면 현재 진행하는 반복이 멈춘후 재귀함수를 먼저 진행
 
 https://scshim.tistory.com/241
 */
