package Sorting;
import java.util.*;

public class InsertionSort2 {

    public static void insertionSortPart2(int[] ar)
    {
        int pos = 1;
        while (pos < ar.length){
            int currentPos = pos;
            for(int i = pos-1; i>=0;i--){
                if(ar[currentPos]<ar[i]){
                    int temp = ar[currentPos];
                    ar[currentPos] = ar[i];
                    ar[i]=temp;
                    currentPos--;
                }
            }
            pos++;
            printArray(ar);
        }
    }




    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSortPart2(ar);

    }
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
