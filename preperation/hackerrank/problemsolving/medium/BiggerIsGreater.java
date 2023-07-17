package preperation.hackerrank.problemsolving.medium;

import java.util.Arrays;

/**

 https://www.hackerrank.com/challenges/bigger-is-greater/


 Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.

 Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:
     It must be greater than the original word
     It must be the smallest word that meets the first condition

 Example
    abcd

 The next largest word is adbc.

 Complete the function biggerIsGreater below to create and return the new string meeting the criteria. If it is not possible, return no answer.

 */
public class BiggerIsGreater {

    public static String biggerIsGreater(String str) {
        char[] charArray = str.toCharArray();
        int lenght = charArray.length;
        int endIndex = 0;

        for (endIndex = lenght - 1; endIndex > 0; endIndex--) {
            if (charArray[endIndex] > charArray[endIndex - 1]) {
                break;
            }
        }

        if (endIndex == 0) {
            return "no answer";
        } else {
            int firstSmallCharacter = charArray[endIndex], nextSmallCharacter = endIndex;

            for (int startIndex = endIndex + 1; startIndex < lenght; startIndex++) {
                if (charArray[startIndex] > firstSmallCharacter && charArray[startIndex] < charArray[nextSmallCharacter]) {
                    nextSmallCharacter = startIndex;
                }
            }

            swap(charArray, endIndex - 1, nextSmallCharacter);

            Arrays.sort(charArray, endIndex, lenght);
        }

        return new String(charArray);
    }

    private static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

}
