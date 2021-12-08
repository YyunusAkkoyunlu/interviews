package preperation.hackerrank.problemsolving.easy;

import java.util.Arrays;
import java.util.List;

public class BillDivision {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);

        bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 12);
//        bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 7);
    }

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        // k anna's doesn't eat meal
        // b..?

        int actual = 0;
        for (int i = 0; i < bill.size(); i ++) {
            if (i != k) {
                actual += bill.get(i);
            }
        }
//         actual /=  2;

        String result = actual / 2 == b ? "Bon Appetit" : String.valueOf(Math.abs(actual/ 2 - b));
        System.out.println(result);
    }

}
