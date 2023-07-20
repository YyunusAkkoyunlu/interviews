package preperation.hackerrank.problemsolving.easy;

import java.util.HashSet;
import java.util.Set;

/**

 https://www.hackerrank.com/challenges/happy-ladybugs

 Happy Ladybugs is a board game having the following properties:
    The board is represented by a string, b, of length n. The ith character of the string,b[i] , denotes ith the cell of the board.
         If b[i] is an underscore (i.e., _), it means the ith cell of the board is empty.
         If b[i] is an uppercase English alphabetic letter (ascii[A-Z]), it means the ith cell contains a ladybug of color b[i].
         String b will not contain any other characters.

     A ladybug is happy only when its left or right adjacent cell (i.e.,b[i+1] ) is occupied by another ladybug having the same color.
     In a single move, you can move a ladybug from its current position to any empty cell.

 Given the values of n and b for games of Happy Ladybugs, determine if it’s possible to make all the ladybugs happy. For each game, print YES on a new line if all the ladybugs can be made happy through some number of moves. Otherwise, print NO.

 As an example,b=[YYR_B_BR] . You can move the rightmost B and R to make b=[YYRRBB_] and all the ladybugs are happy.

 */
public class HappyLadybugs {

    public static String happyLadybugs(String bugs) {
        Set<Character> uniqueCharacterSet = new HashSet<>();
        for (char ch : bugs.toCharArray()) {
            if (ch != '_' && bugs.chars().filter(c -> c == ch).count() == 1) {
                return "NO";
            }
            uniqueCharacterSet.add(ch);
        }

        if (!uniqueCharacterSet.contains('_')) {
            for (int i = 1; i < bugs.length() - 1; i++) {
                if (bugs.charAt(i - 1) != bugs.charAt(i) && bugs.charAt(i + 1) != bugs.charAt(i)) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

}
