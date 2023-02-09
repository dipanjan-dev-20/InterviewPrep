package utils;

import java.util.ArrayList;

public class ArrayUtils {
    public static void printListOfList(ArrayList<ArrayList<Integer>> list){
        list.forEach(lst->{
            lst.forEach(num->{
                System.out.print(num);
                System.out.print(",");
            });
            System.out.println();
        });
    }

    public static void printListOfString(ArrayList<String> list){
        list.forEach(str->{
            System.out.print(str);
            System.out.println();
        });
    }
}
