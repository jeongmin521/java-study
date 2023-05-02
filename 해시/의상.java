---------------------------------------------------------------------------------
import java.util.HashMap;
class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();

        // type별로 옷 종류가 몇개인지 세기
        for(int i = 0; i < clothes.length; i++){
            String cloth_type = clothes[i][1];
            hash.put(cloth_type, hash.getOrDefault(cloth_type, 1) + 1);
        }
        
        for (String key : hash.keySet()) {
            answer *= hash.get(key);
        }

        return answer-1;
    }
}

/*
getOrDefault(Object key, V DefaultValue)
찾는 key 존재 시 해당 key에 매핑되어 있는 값 반환, 없으면 디폴트 값 반환
ex)
	public static void main(String arg[]) {
		String [] alphabet = { "A", "B", "C" ,"A"};
		HashMap<String, Integer> hm = new HashMap<>();
		for(String key : alphabet) hm.put(key, hm.getOrDefault(key, 0) + 1);
		System.out.println("결과 : " + hm);
        	// 결과 : {A=2, B=1, C=1}
	}
*/
