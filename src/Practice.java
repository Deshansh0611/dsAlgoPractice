import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class Practice {
    public static void main(String[] args) {
        try {
            String[] arr = {"1", "2",  "3"};
            Arrays.stream(arr).forEach(i->System.out.printf(i));
        } finally {
            System.out.println("!111");
        }
        System.out.println(1);
    }

    private static void m1() throws Exception {
        throw new IOException();
    }

}
