package Greedy;
import java.util.*;

public class GreedyFlorist{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <Integer> flowerPriceList = new ArrayList<>();
        int numFlowers = sc.nextInt();
        int numFriends = sc.nextInt();
        for(int i = 0; i<numFlowers;i++){
            flowerPriceList.add(sc.nextInt());
        }

        //Сортируем список в обратном порядке, чтобы начать покупку с самых дорогих
        Collections.sort(flowerPriceList,Collections.reverseOrder());
        int flowersBought = 0;
        int friendNum = 0;
        int total = 0;
        for(int price:flowerPriceList){
            //проходим по всем ценам цветов и считаем общую стоимость
            total +=(flowersBought+1)*price;
            friendNum++;
            if(friendNum == numFriends){
                // если все друзья купили цветы, сбрасываем счетчик друзей и перезапускаем цикл
                friendNum = 0;
                flowersBought++;
            }
        }
        System.out.println(total);
    }
}