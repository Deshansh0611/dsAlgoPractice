package string;

public class RotateString {
    //Problem statement - https://leetcode.com/problems/rotate-string/
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "bcdea";
        if(isGoalPossibleByRotation(s, goal))
            System.out.println("Goal is achievable from input string rotation.");
        else
            System.out.println("Goal is not possible from input string rotation.");
    }

    private static boolean isGoalPossibleByRotation(String s, String goal) {
        // Idea is to check if goal exists in input + input. tldr; abcdeabcde.contains(bcdea)
        return goal.length() == s.length() && (s+s).contains(goal)? true: false;
    }
}
