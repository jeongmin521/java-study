import java.util.*;

class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        // 답으로 제출될 answer 배열은 commands.length와 길이가 같다.
        int[] answer = new int[commands.length];
        // commands배열의 이중배열의 길이만큼 반복
        for (int i = 0; i < commands.length; i++) {
            // 이중배열의 값은 각각 I, J ,K로 저장되고 I부터 J까지 배열을 생성한후 정렬하고 그 배열의 K번쨰 원소를 저장한다.
            for (int j = 0; j < commands[i].length; j++) {
                // I, J ,K는 index형식이 아니라서 -1
                int I = commands[i][0] - 1;
                int J = commands[i][1] - 1;
                int K = commands[i][2] - 1;
                // I부터 J까지 짤린 배열 생성
                int[] tmpArr = new int[J - I + 1]; //길이
                for (int k = 0; k < J - I + 1; k++) {
                    tmpArr[k] = array[I + k];
                } 
                // 정렬
                Arrays.sort(tmpArr);
                answer[i] = tmpArr[K];
            }
        }
        return answer;
    }
}
