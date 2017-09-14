package BitManipulations;


import java.util.*;

public class LonlyIntegers{

    public static void main(String[] args) {
        // проходим по списку в поиске числа, которое встречается один раз. если число не уникальное - удаляем. В итоге остаются только юник намберс

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        ArrayList<String> alStr = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
        String answer="";
        int pos = 0;
        while(alStr.size()>1){
            answer = alStr.get(0);
            alStr.remove(0);
            if(!alStr.contains(answer)){
                break;
            }else{
                alStr.remove(answer);
            }
            pos++;

        }
        System.out.println(alStr.size()!=1?answer:alStr.get(0));
    }
}