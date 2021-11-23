package preperation.crackingTheCodingInterview.chapterOneArraysAndStrings;

// Write a method to replace all spaces in a string with '%20.' You may assume that the string
// has sufficient space at the end of the string to hold the additional characters, and that you
// are given the "true" length of the string. (Note: if implementing in Java, please use a characters
// array so that you can perform this operation in place)

public class ReplaceSpaces {

    static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;

        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        if (trueLength < str.length) {
            str[trueLength] = '\0'; // end of the array
        }

        int newLength = trueLength + spaceCount * 2;
        char[] charArrayWithSpaces = new char[newLength];

        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                charArrayWithSpaces[newLength - 1] = '0';
                charArrayWithSpaces[newLength - 2] = '2';
                charArrayWithSpaces[newLength - 3] = '%';

                newLength -= 3;
            } else {
                charArrayWithSpaces[newLength - 1] = str[i];
                newLength--;
            }
        }

    }

}