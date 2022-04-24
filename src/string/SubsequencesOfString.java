package string;

public class SubsequencesOfString {
    public static void main(String[] args) {
        String s = "ram";
        printAllSubsequences(s, 0, "");
    }

    private static void printAllSubsequences(String s, int index, String newString) {
        if(index >= s.length()) {
            System.out.println(newString);
            return;
        }
        char currChar = s.charAt(index);
        printAllSubsequences(s, index + 1, newString + currChar);
        printAllSubsequences(s, index + 1, newString);
    }
}
