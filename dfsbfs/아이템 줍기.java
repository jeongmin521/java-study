import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int start_x = characterX * 2;
        int start_y = characterY * 2;
        int end_x = itemX * 2;
        int end_y = itemY * 2; // 시작, 끝 좌표를 다 두배로 늘려줌
        
        boolean[][] map = new boolean[103][103]; //늘려줌
        
        for(int i = 0; i < rectangle.length; i++){
            int[] data = rectangle[i]; // = for(int[] data:rectangle) 확장된 for문
            
            for(int j = data[1] * 2; j <= data[3] * 2; j++){ // y축
              for(int k = data[0] * 2; k <= data[2] * 2; k++){// x축
                    map[j][k] = true; //테두리 포함해서 직사각형 모두 true
              }  
            }
        }
        
        for(int[] data:rectangle){
            for(int i = data[1] * 2 + 1; i < data[3] * 2; i++){
              for(int j = data[0] * 2 + 1;j < data[2] * 2; j++){
                    map[i][j] = false; //테두리 제외해서 직사각형 내부 모두 false
              }  
            }
        }
    
        Stack<Player> stack = new Stack<>(); //bfs를 위해 player라는 스택 생성
        
        Player p = new Player(start_x,start_y); //시작점(현위치)
        stack.add(p);//스택에 추가
        
        List<Integer> result = new ArrayList<>(); //결과를 저장할 리스트
        int cnt = 0;
        
        while(true){       
            if(stack.isEmpty()){ //스택이 비어있으면(= 더 이상 움직일 수 x = 한 바퀴를 다 돎 => 전체 길이)
                result.add(cnt); //전체 길이를 result에 추가
                break; 
            }
            
            Player temp = stack.pop(); //스택이 비어있지 않으면(=이동이 가능하면) 꺼내서
            int x = temp.x;
            int y = temp.y; //스택에 있던 좌표로 위치를 변경해줌
           
            if(x == end_x && y == end_y){ //아이템 위치에 도착한 경우
                result.add(cnt); //움직인 만큼을 결과에 추가
            }
                       
            map[y][x] = false; //지난자리 false    
            
            if(map[y+1][x] == true) stack.add(new Player(x, y + 1)); //이동이 가능한 경우 찾기
            if(map[y][x+1] == true) stack.add(new Player(x + 1, y));
            if(map[y-1][x] == true) stack.add(new Player(x, y - 1));
            if(map[y][x-1] == true) stack.add(new Player(x - 1, y));
            
            cnt++; //이동 횟수 ++
        }
        
        answer = Math.min(result.get(0)/2, result.get(1)/2-result.get(0)/2); //반대 방향으로 출발했을 때 최솟값 
        //캐릭터위치~아이템거리, 전체 테두리길이 - 캐릭터위치~아이템거리 
        return answer;
    }
    
    class Player{
        int x;
        int y;
        
        public Player(int x, int y){
            this.x = x;
            this.y = y;   
        }
    }
}


/*
확장된 for문
for (요소타입 변수명: 반복대상) {
	실행영역;
}


캐릭터의 위치 (characterX, characterY)에서 아이템의 위치(itemX, itemY)

(3,5) -> (3,6) 으로 바로 갈 수 없음
    => 좌표를 두배로 늘려줘서 이 길이 이어져있는지 아닌지 구분

테두리만 이동가능 -> 테두리와 내부를 구분해야함 
    => 좌표를 두배로 늘려준 후 내부를 false
    
BFS 를 이용하여 최단거리 구함

*/
