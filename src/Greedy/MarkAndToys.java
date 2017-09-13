package Greedy;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MarkAndToys {

        public static void main(String[] args) {
            Scanner stdin=new Scanner(System.in);
            int n=stdin.nextInt(),k=stdin.nextInt();
            int prices[]=new int[n];
            for(int i=0;i<n;i++) prices[i]=stdin.nextInt();

            int answer = 0;
            Arrays.sort(prices);

            int sum = 0;
            int i = 0;
            while(sum <=k){
                sum+=prices[i++];
            }
            System.out.println(i-1);
        }
    }