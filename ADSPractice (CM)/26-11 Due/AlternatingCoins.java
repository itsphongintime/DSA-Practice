package ADSPractice;

public class AlternatingCoins {
	public static int solution(int[] A) {
		int result = 0;
		if (A[0] == A[1]) {
			result--;
		}
		
		if (A[A.length - 2] == A[A.length - 1]) {
			result--;
		}
		
		int sameCoinCount = 1;
		int currCoin = A[0];
		
		for (int i = 1; i < A.length; i++) {
			if (currCoin == A[i]) {
				sameCoinCount++;
				currCoin = A[i];
			} else {
				result += sameCoinCount / 2;
				if (sameCoinCount % 2 == 0) {
					result++;
				}
				sameCoinCount = 1;
				currCoin = A[i];
			}
		}
		result += sameCoinCount / 2;
		if (sameCoinCount % 2 == 0) {
			result++;
		}
        return result;	
    } //O(n)

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,0,1,0,1,1}));
        System.out.println(solution(new int[]{1,1,0,1,1}));
        System.out.println(solution(new int[]{0,1,0}));
        System.out.println(solution(new int[]{0,1,1,0}));
    }
}
