package ADSPractice;

public class MaxProfit {
	public static int solution(int[] A) {
		int priceTracker = A[0];
		int profit = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] < priceTracker) {
				priceTracker = A[i];
			} else {
				profit = Math.max(A[i] - priceTracker, profit);
			}
		}
        return profit;
    } // O(n)

    public static void main(String[] args) {
        System.out.println(solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367}));
    }
}
