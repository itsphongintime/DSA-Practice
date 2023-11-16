package ADSPractice;

public class MaxSumViaDeletion {
    public static int solution(int[] A) {
        boolean isEven = true;
        int result = 0;
        int prevVal = A[0];
        
        for (int i = 1; i < A.length; ++i) {
        	if (isEven) {
        		if (prevVal > A[i]) {
        			result += (prevVal % 1000000000);
        			isEven = false;
        			prevVal = A[i];
        		} else {
        			prevVal = A[i];
        			isEven = true;
        		}
        	} else {
        		if (prevVal < A[i]) {
        			result -= (prevVal % 1000000000);
        			isEven = true;
        			prevVal = A[i];
        		} else {
        			prevVal = A[i];
        			isEven = false;
        		}
        	}
        	if (isEven && i == (A.length - 1)) {
				result += A[A.length - 1];
			}
        }
        return result % 1000000000;
    } // O(n)

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 1, 2, 3}));
        System.out.println(solution(new int[]{1, 2, 3, 2, 1, 5}));
        System.out.println(solution(new int[]{1000000000, 1, 2, 2, 1000000000, 1, 1000000000}));
    }
}
