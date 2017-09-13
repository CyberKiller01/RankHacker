package implementations;

import java.util.Arrays;
import java.util.Scanner;

public class AlmostSorted {

    private static boolean CheckSingleSwap(int[] A, int[] B)
    {
        /**
         * Метод проверяет введенный массив и делают свапы, если возможно
         */
        int L = A.length;
        int firstSwap = -1, secondSwap = -1; // -1 если свапов не было на элементе
        for(int i = 0; i < L; i++)
        {
            if(A[i] != B[i]) //если элементы различны
            {
                if (firstSwap == -1) // если первый свапа не было
                    firstSwap = i; // первый свап равен i-позиции
                else if (secondSwap == -1 && A[i] == B[firstSwap] && A[firstSwap] == B[i]) // если второго свапа не было и итый элемент в А равен позиции свапа Б и первый А свап равен Б
                    secondSwap = i; // второй свап на итой позиции
                else
                    return false; // иначе ноу
            }
        }
        if (firstSwap != -1 && secondSwap != -1) // если свап был то
        {
            System.out.println("yes");
            System.out.println("swap " + (firstSwap + 1) + " " + (secondSwap + 1));
            return true;
        }
        System.out.println("array is already sorted!");
        return false;
    }

    private static boolean CheckSingleReverse(int[] A, int[] B)
    {
        int L = A.length;
        int diffStart = -1, diffEnd = -1; boolean mid = false, found = false;
        for (int i = 0; i < L; i++)
        {
            if (A[i] != B[i])
            {
                if (found)
                {
                    if (i - diffEnd == 2 && !mid) // Если поиск ложно сработал (выловил не тот элемент). Если в центре reverse части появились одинаковые элементы
                    {
                        mid = true;
                        found = false;
                        diffEnd = -1;
                    }
                    else
                        return false;
                }
                else if (diffStart == -1) // ищем первый несовпавший элемент и делаем его началом
                    diffStart = i;
            }
            else
            if (diffStart != -1 && diffEnd == -1) // если элементы совпали, то предыдущий был концом.
            {
                found = true;
                diffEnd = i - 1;
            }
        }
        if (diffEnd == -1) // если в цикле не был определен конец
        {
            if (A[L - 1] != B[L - 1]) // если последние элементы не совпадают
                diffEnd = L - 1;
            else if (!found) // если отрезок не найден , т.е начальный массив в правильном порядке
            {
                System.out.println("array is already sorted!");
                return false;
            }
        }

        // find out if it's reversed
        int count = (diffEnd - diffStart + 1) / 2;
        for (int i = 0; i < count; i++) // проверяем поэлементно, является ли перевернутый отрезок равным отсортированному. Т.е проверка на целостность
        {
            int oneEnd = diffStart + i, otherEnd = diffEnd - i;
            if (!(A[oneEnd] == B[otherEnd] && A[otherEnd] == B[oneEnd]))
                return false;
        }
        System.out.println("yes");
        System.out.println("reverse " + (diffStart + 1) + " " + (diffEnd + 1));
        return true;
    }

    private static int[] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        arr = new int[N];

        for (int i = 0; i < N; i++)
        {
            arr[i] = in.nextInt();
        }

        int[] B = arr.clone();
        Arrays.sort(B);
        if(!CheckSingleSwap(arr,B)){
            if(!CheckSingleReverse(arr,B)){
                System.out.println("no");
            }
        }

    }
}
