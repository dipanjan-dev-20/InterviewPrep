package utils;

import java.util.ArrayList;

public class ArrayUtils {
    public static void printCharArrayOfArray(char[][] arr){
        int r = arr.length;
        int c = arr[0].length;
        for(int i =0;i<r;i++){
            for(int j =0;j<c;j++){
                System.out.print(arr[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
    }

    public static <T> void printList(ArrayList<T> list){
        list.forEach(obj->{
            System.out.println(obj.toString());
        });
    }

    public static <T> void printListOfList(ArrayList<ArrayList<T>> list){
        list.forEach(lst->{
            lst.forEach(num->{
                System.out.print(num);
                System.out.print(",");
            });
            System.out.println();
        });
    }
}
