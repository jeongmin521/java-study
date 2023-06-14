import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int start_x = characterX * 2;
        int start_y = characterY * 2;
        int end_x = itemX * 2;
        int end_y = itemY * 2;
        
        boolean[][] map = new boolean[103][103];
        int ted = 0;
        
        for(int[] data:rectangle){
            //테두리 포함해서 직사각형 모두 true
            for(int i = data[1]*2; i <= data[3]*2; i++){
              for(int j = data[0]*2; j <= data[2]*2; j++){
                    map[i][j] = true;
              }  
            }
        }
        
        for(int[] data:rectangle){
            //테두리 제외해서 직사각형 내부 모두 false
            for(int i = data[1] * 2+1; i < data[3] * 2; i++){
              for(int j = data[0] * 2+1;j < data[2] * 2; j++){
                    map[i][j] = false;
              }  
            }
        }
    
        //bfs
        Stack<Player> stack = new Stack<>();
        
        //시작점
        Player p = new Player(start_x,start_y);
        stack.add(p);
        
        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        
        while(true){       
            if(stack.isEmpty()){
                result.add(cnt);
                break;
            }
            Player temp = stack.pop();
            int x = temp.x;
            int y = temp.y; 
           
            //도착하면 갯수 저장
            if(x == end_x && y == end_y){
                result.add(cnt);         
            }
            
            //지난자리 false               
            map[y][x] = false;
            
            if(map[y+1][x] == true) stack.add(new Player(x, y+1));
            if(map[y][x+1] == true) stack.add(new Player(x+1, y));
            if(map[y-1][x] == true) stack.add(new Player(x, y-1));
            if(map[y][x-1] == true) stack.add(new Player(x-1, y));
            
            cnt++;
            
        }
        
        answer = Math.min(result.get(0)/2, result.get(1)/2-result.get(0)/2); //가장 최솟값을 구함     
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
최단거리 -> BFS
캐릭터의 위치 (characterX, characterY)에서 아이템의 위치(itemX, itemY)
테두리만 이동가능 -> 테두리와 내부를 구분해야함 
    => 좌표를 두배로 늘려줌
테두리 포함해 직사각형을 map[][]에다 True, 테두리 제외해 직사각형을 map[][] 에다 False 할당 -> 테두리만 남은 True 길이

*/
