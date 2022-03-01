package string;

public class StringRotation {
    /*
    Problem statement - Given a string and number of times it needs to be left rotated and then right rotated
    Return the finally rotated string. For example - ramu, left rotation - 2, right rotation - 1
    ramu after 1 left rotation becomes amur and after 2 left rotations becomes mura
    Finally, mura after 1 right rotation becomes amur
     */
    public static void main(String[] args) {
        String str = "ramu";
        System.out.println("Rotate string is: " + leftRightRotate(str, 4, 50));
    }

    private static String leftRightRotate(String str, int leftRotate, int rightRotate) {
        // Rotating string by its length makes the original string. Hence, we just need to rotate by the remainder.
        leftRotate %= 4;
        rightRotate %= 4;
        String rotateString = leftRotate(str, leftRotate);
        rotateString = rightRotate(rotateString, rightRotate);
        return rotateString;
    }

    private static String leftRotate(String str, int leftRotate) {
        return (str.substring(leftRotate) + str.substring(0, leftRotate));
    }

    private static String rightRotate(String str, int rightRotate) {
        return leftRotate(str, str.length() - rightRotate);
    }
}
