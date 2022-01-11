package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.stream.Collectors;

public class GreatestNumFromArrayElements {
    //https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
    public static void main(String[] args) {
        String[] s = {"54", "546", "548", "60"};
        Vector<String> input = new Vector<String>(Arrays.asList(s));
        calculateGreatestNum(input);
    }

    private static void calculateGreatestNum(Vector<String> input) {
        Collections.sort(input, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy = x + y;
                String yx = y + x;
                return xy.compareTo(yx) > 0? -1:1;
            }
        });
        for(String s: input) {
            System.out.print(s);
        }
    }
}
