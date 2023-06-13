import java.util.*;

class Solution {
    
    int[] dx = {0, 1, -1, 0}; //x축(상,하 이동)
    int[] dy = {1, 0, 0, -1}; //y축(좌,우 이동)
    
    public int solution(int[][] maps) {
        
        int answer = 0;

        int[][] visited = new int[maps.length][maps[0].length];//방문여부

        bfs(maps, visited);
        answer = visited[maps.length - 1][maps[0].length - 1]; //최종 목적지 좌표

        if (answer == 0) { //최종 도달하지 못한 경우
            answer = -1;
        }

        return answer;
    }
    
    public void bfs(int[][] maps, int[][] visited) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0}); // Queue에 시작 정점 추가
        visited[0][0] = 1; //처음 위치 방문처리

        while (!q.isEmpty()) { // 더 나아갈 정점이 없을 때까지 반복

            int[] current = q.poll(); // 정점 하나 꺼내기
            int X = current[0];
            int Y = current[1];

            for (int i = 0; i < 4; i++) {
                int nX = X + dx[i];
                int nY = Y + dy[i];

                // 좌표가 maps에서 벗어날 경우
                if (nX < 0 || nX > maps.length - 1 || nY < 0 || nY > maps[0].length - 1) {
                    continue;
                }

                // 미방문, 이동가능인 경우
                if (visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    visited[nX][nY] = visited[X][Y] + 1;
                    q.add(new int[]{nX, nY});
                }
            }
        }
    }
}


/*
1. 경로를 담을 Queue를 생성
2. 시작 위치인 (0, 0)을 담고 방문 체크
3. Queue에 담긴 경로인 정점 하나를 꺼내고 각각 X좌표와 Y좌표 담기 (nX, nY는 상하좌우로 나아갈 수 있는 좌표)
4. 좌표가 maps에서 벗어날 경우에는 다음 반복으로 넘어감
5. 미방문, 이동가능일 경우 경우의 수 +1.
6. Queue에 새로운 좌표 넣음
*/
