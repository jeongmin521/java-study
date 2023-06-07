//DFS

import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        int length = computers.length;

        int [] visited = new int[length];

        for(int i = 0; i < length; i++){
            if (visited[i] == 0) {
                dfs(i, computers, visited);
                answer++;
            }
        }

        return answer;
    }
    public void dfs(int node, int[][]computers, int[]visited) {

        visited[node] = 1;

        for(int i = 0 ; i < computers.length; i++) {
            if (visited[i] == 0 && computers[node][i] == 1) {
                dfs(i,computers, visited);
            }
        }
        return;
    }
}



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
