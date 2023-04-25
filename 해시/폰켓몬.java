import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
          set.add(num);
        }
        int nums2 = nums.length/2;
        
        if(nums2 <= set.size()){
            return nums2;
        }
        else{
            return set.size();
        }
    }
}


/*가장 많은 종류의 폰켓몬을 가지는 방법
 -> 같은 번호를 가진 폰켓몬을 뽑는 것을 최소화
 1. 배열의 중복을 제거한다
 https://hianna.tistory.com/554
 hash set : https://crazykim2.tistory.com/474
 2. 중복이 제거된 배열의 크기가 N/2보다 크면 N/2 리턴
    작으면 중복이 제거된 배열의 크기를 리턴
*/
