import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int max_x = 0;
        int max_y=0;
        for(int i = 0;i < sizes.length; i++){
            int x = Math.max(sizes[i][0],sizes[i][1]); //가로가 더 긴 쪽으로 가게 회전
            int y = Math.min(sizes[i][0],sizes[i][1]); //세로가 더 짧은 쪽으로 가게 회전
            max_x = Math.max(max_x, x);
            max_y = Math.max(max_y, y);
        }
        return max_x * max_y;
    }
}

/* 최소크기를 구하는 방법
회전이 가능하다!
-> 더 긴 부분을 가로, 짧은 부분을 세로로 설정한 후 그중 최댓값의 크기로 만들면 됨
*/
