import java.io.*;
import java.math.*;

class Result {

    /*
    Delete word from a array if the word is an anagram of the previous. Return the first word
     */

    public static List<String> funWithAnagrams(List<String> text) {
        ArrayList<String> ans = new ArrayList();
        Set<String> set = new HashSet();
        for(int i = 0; i < text.size(); i++){
            String string = text.get(i);
            char[] a = string.toCharArray();
            Arrays.sort(a);
            String key = Arrays.toString(a);
            if(!set.contains(key)){ //does not contain
                ans.add(string);
                set.add(key);
            }
        }
        Collections.sort(ans);
        return ans;
    }

}

public class Solution {
