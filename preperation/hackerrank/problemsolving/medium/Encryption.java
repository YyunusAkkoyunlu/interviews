package preperation.hackerrank.problemsolving.medium;

/**

 https://www.hackerrank.com/challenges/encryption


 An English text needs to be encrypted using the following encryption scheme.
 First, the spaces are removed from the text. Let L be the length of this text.
 Then, characters are written into a grid, whose rows and columns have the following constraints:

 Example
    s = if man was meant to stay on the ground god would have given us roots

    After removing spaces, the string is 54 characters long. SQRTT is between 7 and 8, so it is written in the form of a grid with 7 rows and 8 columns.

    ifmanwas
    meanttos
    tayonthe
    groundgo
    dwouldha
    vegivenu
    sroots

 */
public class Encryption {

    public static String encryption(String str) {
        String strWithoutSpace = str.replaceAll(" ","");

        int strWithoutSpaceLengthOfSquarePlusOne = (int) Math.ceil(Math.sqrt(strWithoutSpace.length()));
        StringBuilder[] stringBuilder = new StringBuilder[strWithoutSpaceLengthOfSquarePlusOne];
        for (int i = 0; i < stringBuilder.length; i++) {
            stringBuilder[i] = new StringBuilder();
        }

        int count = 0, i = 0;
        while (count < strWithoutSpace.length()) {
            stringBuilder[i].append(strWithoutSpace.charAt(count));
            i++;
            if (i == strWithoutSpaceLengthOfSquarePlusOne) {
                i = 0;
            }
            count++;
        }

        String result = "";
        for (int j = 0; j < stringBuilder.length; j++) {
            result += stringBuilder[j];
            result += " ";
        }

        return result;
    }

}
