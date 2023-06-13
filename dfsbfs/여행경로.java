import java.util.*;

class Solution {
    boolean[] visited; //방문여부체크
    ArrayList<String> allRoute; 
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, cnt); //시작은 ICN ,루트 시작도 ICN
        
        Collections.sort(allRoute); //알파벳순 정렬
        answer = allRoute.get(0).split(" ");
        
        return answer;
    }
    
    public void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            allRoute.add(route); //방문한곳
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){ //시작공항이start, 미방문
                visited[i] = true; //방문처리
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }
    
}


/*
조건 : 주어진 항공권 모두 사용 -> 모든 경우의 수

DFS함수에서 모든 티켓을 다 썼을 때, allRoute에 구현 경로를 add()

연결되어 있는 공항으로 꼬리물기를 하며 티켓의 시작공항이 start와 같고 방문하지 않은 경우 dfs()의 start 자리에 tickets[i][1]을 넣고 재탐색

모든 경로를 탐색하기 위해서 이때 visited[i] = false로 다시 바꿔줌

*/
