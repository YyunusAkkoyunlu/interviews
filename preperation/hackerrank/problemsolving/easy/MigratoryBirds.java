package preperation.hackerrank.problemsolving.easy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
    https://www.hackerrank.com/challenges/migratory-birds

 Given an array of bird sightings where every element represents a bird type id, determine the id of the most frequently sighted type.
 If more than 1 type has been spotted that maximum amount, return the smallest of their ids.

 Example
    arr = [1, 1, 2, 2, 3]

 There are two each of types 1 and 2, and one sighting of type 3. Pick the lower of the two types seen twice: type 1.


 Function Description
    Complete the migratoryBirds function in the editor below.

    migratoryBirds has the following parameter(s):
        int arr[n]: the types of birds sighted

 Returns
    int: the lowest type id of the most frequently sighted birds

 Input Format
     The first line contains an integer, n, the size of arr.
     The second line describes arr as n space-separated integers, each a type number of the bird sighted.

 Constraints
    It is guaranteed that each type is 1, 2, 3, 4, or 5.

 Sample Input 0
    6
    1 4 4 4 5 3

 Sample Output 0
    4

 Explanation 0
    The different types of birds occur in the following frequencies:

     Type 1 : 1 bird
     Type 2 : 0 birds
     Type 3 : 1 bird
     Type 4 : 3 birds
     Type 5 : 1 bird
     The type number that occurs at the highest frequency is type 4, so we print 4 as our answer.

 */
public class MigratoryBirds {

    public static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> birds = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            if (birds.containsKey(arr.get(i))) {
                birds.put(arr.get(i), birds.get(arr.get(i)) + 1);
            } else {
                birds.put(arr.get(i), 1);
            }
        }

        return Collections.max(birds.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static int migratoryBirdsV2(List<Integer> arr) {
        int[] birds = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            birds[arr.get(i)] += 1;
        }
        List <Integer> birdList = Arrays.stream(birds).boxed().collect(Collectors.toList()); // for using indexOf method

        return birdList.indexOf(Collections.max(birdList));
    }

}
