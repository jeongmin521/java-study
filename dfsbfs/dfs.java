/*DFS(Depth First Search, 깊이우선탐색)
 - 한 노드에서 다음 분기로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방식
 - 스택, 재귀함수 이용
 */
 
 
class Graph {
	private int V;
	private LinkedList<Integer> adj[]; // 링크드리스트의 배열
	
	//생성자
	Graph (int v) {
		V = v;
		adj = new LinkedList[v];
		// v개의 LinkedList 선언 및 생성
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList(); 
		}
	}
	void addEdge (int v, int w) { // v번째 LinkedList 에 w를 삽입
		adj[v].add(w); 
	}
  
	// DFS 함수
	void DFS(int v) { // v를 시작노드로
		boolean visited[] = new boolean[V]; // 각 노드 방문
		DFSUtil(v, visited);
	}
	// DFS에서 호출되는 함수
	void DFSUtil(int v, boolean visited[])  {
		// 현재 노드 방문
		visited[v] = true;
		System.out.println(v + " ");
		
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
