package preperation.leetcode.problemsolving.medium;

/*

    https://leetcode.com/problems/push-dominoes

    There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
    After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
    When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
    For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

    You are given a string dominoes representing the initial state where:
        dominoes[i] = 'L', if the ith domino has been pushed to the left,
        dominoes[i] = 'R', if the ith domino has been pushed to the right, and
        dominoes[i] = '.', if the ith domino has not been pushed.
    Return a string representing the final state.

    Example 1:
        Input: dominoes = "RR.L"
        Output: "RR.L"
        Explanation: The first domino expends no additional force on the second domino.

    Example 2:
        Input: dominoes = ".L.R...LR..L.."
        Output: "LL.RR.LLRRLL.."

 */
public class PushDominoes {

    public static String pushDominoes(String dominoes) {
        char[] dominoesCharArray = dominoes.toCharArray();
        int dominoesLength = dominoes.length();
        int[] forcesArray = new int[dominoesLength];
        int force = 0;

        for (int i = 0; i < dominoesLength; i++) {
            if (dominoesCharArray[i] == 'R') {
                force = dominoesLength;
            } else if (dominoesCharArray[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forcesArray[i] += force;
        }

        force = 0;
        for (int i = dominoesLength - 1; i >= 0; i--) {
            if (dominoesCharArray[i] == 'L') {
                force = dominoesLength;
            } else if (dominoesCharArray[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forcesArray[i] -= force;
        }

        StringBuilder result = new StringBuilder();

        for (Integer f : forcesArray) {
            if (f > 0) {
                result.append("R");
            } else if (f < 0) {
                result.append("L");
            } else {
                result.append(".");
            }
        }

        return result.toString();
    }

}
