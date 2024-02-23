import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }
}

--------------------------------------------------------------------------------------------------
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int x = citations.length; //x = 5
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            if(x - i <= citations[i] && citations[i] != 0){
                answer = (x - i);
                break;
            }
        }
        return answer;
    }
}

/*
citation을 정렬해서 citation의 값보다 남은 인덱스의 값이 커질때를 잡아야함
x - i >= citations[i] 
h이상 인용된 논문

01356 citations[i]
01234 i
3 <= 3

0135678
1234567
4 <= 5
남은 인덱스 수 < citation[i]의 값

013456
012345
3 <= 4

x-1을 하는 이유
인용된 횟수가 0인 경우를 제외해야 하기 때문
*/
