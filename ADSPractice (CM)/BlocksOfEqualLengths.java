package ADSPractice;

import java.util.HashMap;

public class BlocksOfEqualLengths {
	public static int solution(String S) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        char currLetter = S.charAt(0);
        int currBlockLength = 1;
        int mapIndex = 0;
        int maxLength = 1;
        
        for (int i = 1; i < S.length(); i++) {
        	if (currLetter != S.charAt(i)) {
        		map.put(mapIndex, currBlockLength);
        		mapIndex++;
        		
        		currLetter = S.charAt(i);
        		
        		maxLength = Math.max(maxLength, currBlockLength);
        		currBlockLength = 1;
        	} else {
        		currBlockLength++;
        		currLetter = S.charAt(i);
        	}
        }
        map.put(mapIndex, currBlockLength);
        maxLength = Math.max(maxLength, currBlockLength);
        
        int result = 0;
        for (int value : map.values()) {
        	result += maxLength - value;
        }
        
        return result;
    } // O(n), 19phut36giay

    public static void main(String[] args) {
        System.out.println(solution("babaa"));
        System.out.println(solution("bbbab"));
        System.out.println(solution("bbbaaabbb"));
    }
}
