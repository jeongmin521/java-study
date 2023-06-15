//DFS

public class Solution {
    
  public int solution(int n, int[][] computers) {
    int answer = 0;
    boolean[] visited = new boolean[n]; //모든 요소는 false

    for (int i = 0; i < n; i++) {
      if (!visited[i]) { //for문을 돌며 visited가 flase인 경우(미방문)
        dfs(computers, i, visited);
        answer++;
      }
    }

    return answer;
  }

  boolean[] dfs(int[][] computers, int i, boolean[] visited) {
    visited[i] = true; //방문처리

    for (int j = 0; j < computers.length; j++) {
      if (i != j && computers[i][j] == 1 && visited[j] == false) { 
        visited = dfs(computers, j, visited);
      }
    }
    return visited;
  }
}
    
/*
각 노드를 돌며 연결되어있는지 여부를 확인해야함
연결되어 있는 네트워크 count

자기 자신이 아니고, 연결되어있으며, 미방문인경우
*/

---------------------------------------------------------------------------------------------
//BFS  
    
    
import java.util.*;
class Solution {  
  
    boolean[] visited;  
    public int solution(int n, int[][] computers){  
        visited = new boolean[n];  
        int answer = 0;  
        for(int i = 0; i < computers.length; i++){  
            if(visited[i]){  
                continue;  
            }  
            bfs(i, computers);  
            answer++;  
        }  
        return answer;  
    }  
  
    private void bfs(int i, int[][] computers) {  
        Queue<Integer> queue = new LinkedList<>();  
        queue.add(i);  
        visited[i] = true;  
        while(!queue.isEmpty()){  
            int current = queue.poll();  
            for(int j = 0; j < computers.length; j++){  
                if(current == j || computers[current][j] == 0 || visited[j]){  
                    continue;  
                }  
                queue.add(j);  
                visited[j] = true;  
            }  
        }  
    }  
}
