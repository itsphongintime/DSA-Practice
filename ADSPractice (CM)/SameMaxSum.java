package ADSPractice;

import java.util.HashMap;
import java.util.ArrayList;

public class SameMaxSum {
	public static int solution(int A[], int N) {
		HashMap <Integer, ArrayList<Integer>> digitSumMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int currNum = A[i];
			int currSum = 0;
			while (currNum != 0) {
				currSum += currNum%10;
				currNum = currNum/10;
			}
			if (digitSumMap.containsKey(currSum) == false) {
				ArrayList<Integer> tempList = new ArrayList<>();
				tempList.add(i);
			    digitSumMap.put(currSum, tempList);
			} else {
				ArrayList<Integer> tempList = digitSumMap.get(currSum);
				tempList.add(i);
				digitSumMap.put(currSum, tempList);
			}
		}
		
		int result = 0;
		for (ArrayList<Integer> value : digitSumMap.values()) {
			if (value.size() <= 1) {
				continue;
			} else {
				int largestVal = A[value.get(0)];
				int secondLargestVal = 0;
				int largestValIndex = 0;
				for (int j = 1; j < value.size(); j++) {
					if (A[value.get(j)] >= largestVal) {
						largestVal = A[value.get(j)];
						largestValIndex = j;
					}
				}
				for (int j = 0; j < value.size(); j++) {
					if (j == largestValIndex) {
						continue;
					}
					secondLargestVal = Math.max(secondLargestVal, A[value.get(j)]);
				}
				result = Math.max(largestVal + secondLargestVal, result);
			}
		}
		
		if (result == 0) {
			return -1;
		} else {
			return result;
		}
    } // O(n^2), tam 47 phut :))

    public static void main(String[] args) {
    	System.out.println(solution(new int[]{51, 71, 17, 42}, 4));
        System.out.println(solution(new int[]{42, 33, 60}, 3));
        System.out.println(solution(new int[]{51, 32, 43}, 3));
    }
}
