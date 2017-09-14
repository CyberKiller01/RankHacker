package Sorting;

import java.util.Scanner;

public class InsertionSort {



    public static void insertIntoSorted(int[] ar)
    {
        int numToInsert = ar[ar.length-1];
        int pos = ar.length-2;
        while(pos>=0){
            if(ar[pos]>numToInsert){ //если текущий элемент больше последнего элемента
                ar[pos+1]=ar[pos];
                pos--;
                printArray(ar);

            }else{
                ar[pos+1]=numToInsert;
                printArray(ar);
                break;
            }
        }
        if(pos == -1){
            ar[0]=numToInsert;
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
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }


}
