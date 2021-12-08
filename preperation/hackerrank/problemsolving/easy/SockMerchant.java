package preperation.hackerrank.problemsolving.easy;

import java.util.*;

/**
    https://www.hackerrank.com/challenges/sock-merchant/problem

 There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

 Example
    n = 7
    ar = [1, 2, 1, 2, 1, 3, 2]


 There is one pair of color 1 and one of color 2. There are three odd socks left, one of each color. The number of pairs is 2.

 Function Description

     Complete the sockMerchant function in the editor below.

     sockMerchant has the following parameter(s):
         int n: the number of socks in the pile
         int ar[n]: the colors of each sock

     Returns
        int: the number of pairs

     Input Format

     The first line contains an integer , the number of socks represented in ar.
     The second line contains n space-separated integers, ar[i], the colors of the socks in the pile.

     Constraints
        1 <=n <= 100
        1 <= ar[i] <= 100 where 0 <= i < n

     Sample Input
         STDIN                       Function
         -----                       --------
         9                           n = 9
         10 20 20 10 10 30 50 10 20  ar = [10, 20, 20, 10, 10, 30, 50, 10, 20]

     Sample Output
        3

 */
public class SockMerchant {

    public static int sockMerchant(int n, List<Integer> ar) {
        Collections.sort(ar);

        int countOfSameColor = 0, pairOfColor = 0;
        for (int i = 0; i < n; i++) {
            countOfSameColor ++;

            if (i + 1 >= n || ar.get(i) != ar.get(i + 1)) {
                pairOfColor += countOfSameColor / 2;
                countOfSameColor = 0;
            }
        }

        return pairOfColor;
    }

    public static int sockMerchantV2(int n, List<Integer> ar) {
        Set<Integer> colors = new HashSet<>();
        int pairs = 0;

        for (int i = 0; i < n; i++) {
            if (!colors.contains(ar.get(i))) {
                colors.add(i);
            } else {
                pairs ++;
                colors.remove(ar.get(i));
            }
        }

        return pairs;
    }

}
