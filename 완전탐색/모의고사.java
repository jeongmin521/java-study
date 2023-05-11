import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1,2,3,4,5}; 
        int[] second = {2,1,2,3,2,4,2,5}; 
        int[] third = {3,3,1,1,2,2,4,4,5,5}; 
        int[] score = {0,0,0}; //점수
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == first[i % 5]) score[0]++;
            if(answers[i] == second[i % 8]) score[1]++;
            if(answers[i] == third[i % 10]) score[2]++;
        } //각 수포자들 점수
        
        int max = Math.max(score[0], Math.max(score[1], score[2])); //최대점수
        
        List<Integer> goodGrade = new ArrayList<Integer>();
        for(int i=0; i<score.length; i++) if(max == score[i]) goodGrade.add(i+1); //최대 점수를 가진 수포자 리스트
        
        int[] answer = new int[goodGrade.size()];
        for(int i=0; i<goodGrade.size(); i++){
            answer[i] = goodGrade.get(i);
        }

        return answer;
    }
}

/*
점수를 계산해야함
answe[i] == 수포자 찍은 답[i]
반복되는 패턴을 배열에 저장해 점수를 계산
최대점수를 구해 같은 점수인 수포자가 있으면 같이 출력
*/
