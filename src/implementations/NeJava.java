package implementations;

import java.util.Scanner;

public class NeJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int numCases=Integer.parseInt(sc.nextLine());
        int arr[] = new int[size];
        for(int i = 0; i < size;i++){
            arr[i] = sc.nextInt();
        }
    }
}
