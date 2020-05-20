import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'funWithAnagrams' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY text as parameter.
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
