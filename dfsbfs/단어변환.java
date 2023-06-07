import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);
        return answer;
    }
    
    public static void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int k = 0;    // 같은 스펠링 개수 세기
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }

            if (k == begin.length() - 1) {  // 한글자 빼고 같은 경우
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}

/*
한 글자 빼고 나머지가 같은 단어를 words에서 찾기
찾은 단어를 visited = true
cnt++ 하면서 dfs 재귀 호출
visited = false로 재설정(모든 경우의 수 탐색 위함)
begin == target 이면 answer = cnt
*/
