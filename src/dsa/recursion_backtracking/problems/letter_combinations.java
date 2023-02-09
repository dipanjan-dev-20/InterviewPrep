package dsa.recursion_backtracking.problems;

import utils.ArrayUtils;

import java.util.ArrayList;

public class letter_combinations {

    public static void main(String[] args) {
       ArrayList<String> strings =  letterCombinations("345");
       ArrayUtils.printListOfString(strings);
    }

    private static ArrayList<String> letterCombinations(String A) {
        String[] charMap = new String[10];
        charMap[0] = "0";
        charMap[1] = "1";
        charMap[2] = "abc";
        charMap[3] = "def";
        charMap[4] = "ghi";
        charMap[5] = "jkl";
        charMap[6] = "mno";
        charMap[7] = "pqrs";
        charMap[8] = "tuv";
        charMap[9] = "wxyz";
        ArrayList<String> ans = new ArrayList<>();
        recurse(charMap,A,0,"",ans);
        return ans;
    }

    private static void recurse(String[] charMap, String A, int i, String current, ArrayList<String> ans) {
        if (i == A.length()) {
            ans.add(current);
            return;
        }
        int index = A.charAt(i) - '0';
        for (int j = 0; j<charMap[index].length(); j++){
            current = current + charMap[index].charAt(j);
            recurse(charMap,A,i+1,new String(current),ans);
            current = removeLastChar(current);
        }
    }

    private static String removeLastChar(String s)
    {
        return s.substring(0, s.length() - 1);
    }


}
