package Strings;
import java.util.*;

public class AlternativeCharacters {

    public static int consecutiveChars(String str) // поиск повторяющихся символов
    {
        StringBuilder mutableStr = new StringBuilder(str);
        int numDeletions = 0;
        int pos = 0;
        while(pos<mutableStr.length()-1){ //проход по всей строке
            if(mutableStr.charAt(pos)==mutableStr.charAt(pos+1)){
                mutableStr.deleteCharAt(pos);
                numDeletions++;
            }else{
                pos++;
            }
        }


        return numDeletions;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = Integer.parseInt(sc.nextLine());
        for(int i=0;i<numCases;i++){
            System.out.println(consecutiveChars(sc.nextLine()));
        }
    }
}
