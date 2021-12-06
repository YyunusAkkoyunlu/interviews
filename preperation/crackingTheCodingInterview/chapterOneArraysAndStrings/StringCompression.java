package preperation.crackingTheCodingInterview.chapterOneArraysAndStrings;

public class StringCompression {

    private static String compressed(String str) {
        String compressedString = "";
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive ++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedString += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }

        return str.length() > compressedString.length() ? compressedString : str;
    }

}
