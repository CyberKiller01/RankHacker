package Search;

import java.util.*;
import java.lang.*;

public class Pairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numIntegers = sc.nextInt();
        int difference = sc.nextInt();
        ArrayList<Integer> intArrayList = new ArrayList<>();
        for (int i = 0; i < numIntegers; i++) {
            intArrayList.add(sc.nextInt());
        }
        Collections.sort(intArrayList);
        int count = 0;
        int startPos = 0;
        int currentPos = 0;
        while (currentPos < intArrayList.size()) { // проходим по всему списку и ищем пару элементов перебором
            currentPos = startPos + 1;
            while (currentPos < intArrayList.size()) {
                int diff = Math.abs(intArrayList.get(currentPos) - intArrayList.get(startPos));
                if (diff == difference) {
                    count++;
                } else if (diff > difference) {
                    break;
                }
                currentPos++;

            }
            startPos++;
        }
        System.out.println(count);


    }
}