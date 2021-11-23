package preperation.crackingTheCodingInterview.chapterOneArraysAndStrings;

public class IsPermutationOfPalindrome {

    public static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);

        return checkMaxOneOdd(table);
    }

    public static boolean isPermutationOfPalindromeV2(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z')
                - Character.getNumericValue('a') + 1];

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }

        return countOdd <= 1;
    }

    public static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z')
                - Character.getNumericValue('a') + 1];

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }

        return table;
    }

    public static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int value = Character.getNumericValue(c);

        if (a <= value && value <= z) {
            return z - value;
        }

        return -1;
    }

}
