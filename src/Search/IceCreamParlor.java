package Search;

import java.util.*;

public class IceCreamParlor {

    public static void printCombination(ArrayList listArray, int money)
    {
        int startPos = 0;
        while(startPos<listArray.size()-1){ //проходимся и выбираем подходящие мороженки. Когда деньги заканчиваются выводим нужные
            for(int i = startPos+1;i<listArray.size();i++){
                int sum = (int) listArray.get(startPos)+(int) listArray.get(i);
                if(sum == money){
                    System.out.println((startPos+1)+" "+(i+1));
                    return;
                }
            }
            startPos++;
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();

        for(int i = 0;i<numTestCases;i++){
            int money = sc.nextInt();
            int numFlavors = sc.nextInt();
            ArrayList<Integer> costArrayList = new ArrayList<>();
            for(int j = 0; j<numFlavors;j++){
                costArrayList.add(sc.nextInt());
            }
            printCombination(costArrayList,money);

        }
    }
}