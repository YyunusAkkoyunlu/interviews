package preperation.hackerrank.problemsolving.easy;

import java.util.ArrayList;
import java.util.List;

/**

 https://www.hackerrank.com/challenges/permutation-equation

 */
public class PermutationEquation {

    public static List<Integer> permutationEquation(List<Integer> p) {
        List result = new ArrayList();

        for (int i = 0; i < p.size(); i++) {
            int index = p.indexOf(i + 1) + 1;
            result.add(p.indexOf(index) + 1);
        }

        return result;
    }

}
