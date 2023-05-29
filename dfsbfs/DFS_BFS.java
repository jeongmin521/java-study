/*DFS(Depth First Search, 깊이우선탐색)
 - 한 노드에서 다음 분기로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방식
 - 스택, 재귀함수 이용
 - 모든 노드를 방문할 때 사용
 - 어떤 노드의 방문 여부 반드시 확인!(무한루프에 빠지는 것 방지)
 
 BFS(Bread First Search, 너비우선탐색)
  - 한 노드에서 시작해 인접한 노드를 반복적으로 큐에 넣고, 가까운 노드부터 탐색하는 방식
  - 방문한 노드를 차례로 저장한 후 꺼내는 큐 사용(FIFO)
  - 두 노드 사이의 최단경로 or 임의의 경로를 찾을 때 사용
 
 DFS는 한 드라마의 전 회차가 끝나고 몰아서 보는것
 BFS는 여러 드라마를 한 회차씩 보는것
 */

/*DFS 재귀
1) 탐색하려는 노드의 방문 여부 확인
2) 탐색하려는 노드의 자식노드들 확인
3) 자식노드 존재 X -> 탐색종료
4) 자식노드 존재 o -> 자식노드를 같은 방식으로 탐색
*/

void DFS(int v) { // v를 시작노드로
	boolean visited[] = new boolean[V]; // 각 노드 방문여부
	DFSUtil(v, visited);
	}

// DFS에서 호출되는 함수
void DFSUtil(int v, boolean visited[])  {
	// 현재 노드 방문
	visited[v] = true;
		
	// 방문한 노드와 인접한 모든 노드를 가지고 온다
	Iterator<Integer> it = adj[v].listIterator();
	while (it.hasNext()) {
		int n = it.next();
		// 방문하지 않은 노드면 해당 노드를 다시 시작 노드로하여 DFSUtil을 호출
		if (!visited[n])
		DFSUtil(n, visited); // 재귀호출
		}
	}
}

//자바 Iterator https://wakestand.tistory.com/247
---------------------------------------------------------------------------------------------------------------------------------------
/*
BFS
1. 탐색 시작 노드를 큐에 삽입하고 방문 처리
2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리
3. 위의 1~2 반복
*/

	public static void bfs(int node, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.offer(node);
        
        while(!queue.isEmpty()) {
            node = queue.poll();
            
            if(visited[node]) continue;
            
            visited[node] = true;
            
            for(int nextNode:nodeList[node]) {
                queue.add(nextNode);
            }
        }
    }




import java.util.*;

public class BFS {
    public static void main(String[] args){
        //각 노드가 연결된 정보를 2차원 배열 자료형으로 표현
        int [][]graph = {{},
            {2, 3, 8},
            {1, 7},
            {1, 4, 5},
            {3, 5},
            {3, 4},
            {7},
            {2, 6, 8},
            {1, 7}};
        
        //각 노드가 방문된 정보를 1차원 배열 자료형으로 표현
        boolean [] visited = {false, false, false ,false ,false ,false ,false ,false, false};
        
        int start = 1; // 시작 노드
        // 큐 구현
        Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            
            // 현재 노드를 방문 처리
            visited[start] = true;
            
            // 큐가 빌때까지 반복
            while(!queue.isEmpty()){
                // 큐에서 하나의 원소를 뽑아 출력
                int v = queue.poll();
                System.out.println(v + " ");
                
                // 인접한 노드 중 아직 방문하지 않은 원소들을 큐에 삽입
                for (int i : graph[v]){
                    if (visited[i] == false){
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
            }
            }
