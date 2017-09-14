
package implementations;

import java.util.Arrays;
import java.util.Scanner;

public class BreakingTheRecords {
    static int[] getRecord(int[] s){
        int minRecord = 0;
        int maxRecord = 0;
        int counterMax = 0;
        int counterMin = 0;

        for(int i = 1; i < s.length;i++){
            if(s[i]>s[i+1] && s[i]>s[i-1]){
                maxRecord = s[i];
                counterMax++;

            }
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }

}

