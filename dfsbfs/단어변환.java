class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length]; //false로 초기화

        dfs(begin, target, words, 0);
        return answer;
    }
    
    public static void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) { //최종 단어로 변환 끝
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
           if (visited[i]) { //이미 방문한 경우 
                continue;
            }
            

            int k = 0;    // 같은 스펠링 개수 세기
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) { //각 글자를 문자로 변환해서 알파벳 하나씩 비교
                    k++;
                }
            }

            if (k == begin.length() - 1) {  // 한글자 빼고 같은 경우
                visited[i] = true; //방문처리
                dfs(words[i], target, words, cnt + 1);
                //visited[i] = false; //모든 경우의 수 탐색을 위해 재설정 ??
            }
        }
    }
}

/*
한 글자 빼고 나머지가 같은 단어를 words에서 찾기

lot -> log -> dog -> cog
lot -> log -> cog
이렇게 두가지라고 생각하면
log의 방문기록은
이미 둘 중 한번
방문할때 처리가 되니까
다시 false로 해줘야함
*/
