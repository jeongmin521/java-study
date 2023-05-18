import java.util.*;

class Solution {
    static boolean[] visited; //false로 초기화
	static int answer = 0;
    
	public static int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		
		return solve(dungeons,k,visited,0);
	}
	
	private static int solve(int[][] dungeons, int k, boolean[] visited, int count){
		for(int i = 0; i < dungeons.length; i++){
			if(k >= dungeons[i][0] && visited[i] == false){ //조건을 만족하는 던전 방문
				visited[i] = true;
				solve(dungeons,k - dungeons[i][1], visited, count + 1); 
				visited[i] = false;
			}
		} //재귀를 이용한 완전탐색
		answer = Math.max(answer, count); //여러 경우의 수 중에서 가장 방문횟수가 높은 것 리턴
		
		return answer;
	}
}
/*
현재 피로도 k
dungeons = 던전별 [최소 필요 피로도, 소모 피로도]
던전 순서 바꿔가며 최대 던전 수 찾기 
    - 소모피로도가 작은 것 우선
    - 최소 필요 피로도가 큰 것 우선
    -> 두개가 섞여있을 경우?
        -> 모든 경우의 수를 시도해봐야함
        
모든 경우의 수를 시도하는 방법
미방문, 최소 필요 피로도 <= k 일 경우 방문
    k -= 소모피로도;
    boolean visited = true;
    count++;
    
완전탐색
https://hongjw1938.tistory.com/78
*/
