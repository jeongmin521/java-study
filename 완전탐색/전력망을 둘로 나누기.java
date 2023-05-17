import java.util.*

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 0;
        int[] cnt = new int[];
        for(int i = 0; i < wires.length; i++){
            cnt[wires[i][0]] += 1;
            cnt[wires[0][i]] += 1;
        }
        return answer;
    }
}


/*트리형태
answer이 최소가 되도록
vn중에 가장 많은 전선이 연결된 것을 끊어본다 
 -> 연결된 것 중에 어떤 걸 끊지??
vn을 구하는 법 -> 2차원 배열을 돌면서 vn이 나올 때 마다 숫자를 카운트
카운트 수가 같은 경우 하나씩 끊어보고 answer의 최솟값을 구한다
*/
