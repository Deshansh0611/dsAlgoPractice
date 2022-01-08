package string;

public class ReverseStringPreserveSpace {
    //https://www.geeksforgeeks.org/reverse-string-preserving-space-positions/
    public static void main(String[] args) {
        String input = "My name is Deshansh";
        System.out.println(reverse(input));
    }

    private static String reverse(String input) {
        char[] ch = input.toCharArray();
        int start = 0;
        int end = ch.length - 1;
        while(start<end) {
            if(ch[start] == ' ') {
                start++;
                continue;
            } else if(ch[end] == ' ') {
                end--;
                continue;
            } else {
                char temp;
                temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }
        return String.valueOf(ch);
    }
}
