package string;

public class LetterCombinationsOfPhone {
    //Problem statement - https://leetcode.com/problems/letter-combinations-of-a-phone-number/

    static String[] digitsMapping = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        printAllCombinations("23", 0, "");
    }

    private static void printAllCombinations(String digits, int index, String combination) {
        if(index >= digits.length()) {
            System.out.println(combination);
            return;
        }
        char currChar = digits.charAt(index);
        String mapping = digitsMapping[currChar - '0' - 2];
        for(int i = 0; i<mapping.length(); i++) {
            printAllCombinations(digits, index + 1, combination + mapping.charAt(i));
        }
    }
}
