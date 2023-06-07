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
