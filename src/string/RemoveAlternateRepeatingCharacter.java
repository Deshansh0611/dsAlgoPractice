package string;

import java.util.HashMap;

public class RemoveAlternateRepeatingCharacter {
    /*Task is to remove alternate instance of repeating character.
    * Example - Simppplr SSE -> 2nd instance of p and 2nd instance of S need to be removed.
    * Output would be - Simpplr SE*/
    public static void main(String[] args) {
        String inp = "Simppplr SSE";
        System.out.println(modify(inp));
    }

    private static String modify(String inp) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] ch = inp.toCharArray();
        int chInd = 0;
        char[] out = new char[ch.length];
        for(int i = 0; i<ch.length; i++) {
            if(map.containsKey(ch[i])){
                map.put(ch[i], map.get(ch[i]) + 1);
                if(map.get(ch[i]) % 2 == 0){
                    continue;
                } else {
                    out[chInd++] = ch[i];
                }
            } else {
                map.put(ch[i], 1);
                out[chInd++] = ch[i];
            }
        }
        return String.valueOf(out);
    }
}
