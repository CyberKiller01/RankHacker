package Strings;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GemStones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> dict = new HashMap<>(); // проходимся по строкам и заносим буквы в мапу.
        int numTestCases = Integer.parseInt(sc.nextLine());
        for(int i = 0;i<numTestCases;i++){
            String word = sc.nextLine();
            for(int j = 0; j<word.length();j++){
                if(i==0){
                    dict.put(""+word.charAt(j), 1);
                }else{
                    Integer val = dict.get(""+word.charAt(j));
                    if(val != null && val == i){
                        val+=1;
                        dict.put(""+word.charAt(j),val);
                    }
                }
            }

        }
        int count = 0;
        for(Integer val:dict.values()){
            if(val == numTestCases) count++; //проходимся по значениям мапы, если встречаем повторения, то увеличиваем счетчик
        }
        System.out.println(count);
    }
}