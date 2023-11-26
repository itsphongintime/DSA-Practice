package ADSPractice;

import java.util.Arrays;

public class BalancedString {
    public static int solution(String S) {
        int[] lowerCaseCount = new int[26];
        int[] upperCaseCount = new int[26];
        int minLength = Integer.MAX_VALUE;

        for (int start = 0; start < S.length(); start++) {
            Arrays.fill(lowerCaseCount, 0);
            Arrays.fill(upperCaseCount, 0);

            for (int end = start; end < S.length(); end++) {
                char c = S.charAt(end);
                if (Character.isLowerCase(c)) {
                    lowerCaseCount[c - 'a']++;
                } else {
                    upperCaseCount[c - 'A']++;
                }

                if (isBalanced(lowerCaseCount, upperCaseCount)) {
                    minLength = Math.min(minLength, end - start + 1);
                    break;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    } // O(n^2)

    public static boolean isBalanced(int[] lowerCaseCount, int[] upperCaseCount) {
        for (int i = 0; i < 26; i++) {
            if ((lowerCaseCount[i] > 0 && upperCaseCount[i] == 0) || (upperCaseCount[i] > 0 && lowerCaseCount[i] == 0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("azABaabza"));
        System.out.println(solution("TacoCat"));
        System.out.println(solution("AcZCbaBz"));
        System.out.println(solution("abcdefghijklmnopqrstuvwxyz"));
    }
}
