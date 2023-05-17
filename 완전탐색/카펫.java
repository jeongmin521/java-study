import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = yellow + brown;
        
        for(int row = 3; row < sum; row++){
            int col = sum / row;
            if(sum % row == 0 && row >= col && (row - 2) * (col - 2) == yellow){
                answer[0] = row;
                answer[1] = col;
            }
        }
        return answer;
    }
}



/*
구해야 할것 : [가로길이, 세로길이]

1. 총 쓸수있는 길이를 구함 yellow + brown
2. yellow + brown 의 공약수 구함
 -> 이때 row >= col
 ex) 테케1번
    (12,1), (6,2), (4,3)...(가로,세로)
3. 이중에서 yellow가 가운데로 가고 brown이 감싸도록 하려면
    - 최소 가로 길이는 3
    - (가로 - 2) * (세로 - 2) = yellow
*/
