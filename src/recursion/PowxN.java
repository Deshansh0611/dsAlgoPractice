package recursion;

public class PowxN {
    //Problem statement - https://leetcode.com/problems/powx-n/
    public static void main(String[] args) {
        double num = 2;
        int pow = 10;
        System.out.println(num + " to the power of " + pow + " is: " + calculatePow(num, pow));
    }

    private static double calculatePow(double num, int pow) {
        if(num == 1 || pow == 0)
            return 1;
        if(pow == 1)
            return num;
        else if(pow % 2 == 0)
            return calculatePow(num*num, pow/2);
        else if(pow % 2 == 1)
            return num*calculatePow(num, pow-1);
        else
            return 1/calculatePow(num, -pow);
    }
}
