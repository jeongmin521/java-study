import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> Minpq = new PriorityQueue<>();
        PriorityQueue<Integer> Maxpq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (String operation : operations) {
            String[] splitOther = operation.split(" ");

            if (splitOther[0].equals("I")) {
                Maxpq.add(Integer.parseInt(splitOther[1]));
                Minpq.add(Integer.parseInt(splitOther[1]));
            }

            if (splitOther[0].equals("D")) {
                if (!Maxpq.isEmpty()) {
                    if (splitOther[1].equals("1")) {
                        int max = Maxpq.peek();
                        Maxpq.remove(max);
                        Minpq.remove(max);

                    } else {
                        int min = Minpq.peek();
                        Maxpq.remove(min);
                        Minpq.remove(min);
                    }
                }
            }

        }
        if (!Maxpq.isEmpty()) {
            answer[0] = Maxpq.peek();
            answer[1] = Minpq.peek();

        }
        return answer;
    }
}





----------------------------------------------------------------------------------------------------------------
테스트케이스 2,3 틀림 -> subString에서 문제?

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> minPq = new PriorityQueue<>(); //최솟값이 맨앞
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder()); //최댓값이 맨앞
        
        for(int i = 0; i < operations.length; i++){
            int x = Integer.valueOf(operations[i].substring(2));
            
            if(operations[i].substring(0,1).equals("I")){ //삽입
                minPq.add(x);
                maxPq.add(x);
            }
            else if(operations[i].substring(0,1).equals("D")){ //삭제
                if(maxPq.isEmpty() || minPq.isEmpty()){ //pq 비어있는 경우
                    continue;
                }
                if(operations[i].substring(2,3).equals("1")){ //최댓값 삭제
                    int maxX = maxPq.peek();
                    maxPq.poll();
                    minPq.remove(maxX);
                }
                else if (operations[i].substring(2,3).equals("-")){ //최솟값 삭제
                   int minX = maxPq.peek();
                    minPq.poll();
                    maxPq.remove(minX); 
                }
            }
        }
                          

        if(!maxPq.isEmpty()){
            answer[0] = maxPq.peek();
            answer[1] = minPq.peek();
        }
        
        
        return answer;
    }
}



/*
1.최대 최소 삭제 
    -> 큐는 맨 앞의 값을 삭제
    -> 최대/최소 힙 두개 만들기
2. string 을 subString으로 쪼개어 삽입/삭제 구분 or StringTokenizer 사용
https://jamesdreaming.tistory.com/81
https://koohee.tistory.com/14

operations[i].substring(0,1) == "I" 인식못함
-> == 대신 .equals 사용
*/
