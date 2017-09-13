package GraphTheory;
import java.util.*;
/*
Я ЕЩЕ НЕ САБМИТИЛ И ВООБЩЕ ДУМАЮ, ЧТО ОНО ТОГО НЕ СТОИТ
 */
public class Huarongdao {
    static int n = 0;
    static int m = 0;
    static int k = 0;
    static int q = 0;
    static int[][] h = null;
    static int[][] dp = null;
    static int x1 = 0;
    static int y1 = 0;
    static int x2 = 0;
    static int y2 = 0;
    static int x3 = 0;
    static int y3 = 0;
    static int min = 0;
    static int[][] path = null;
    static int[][] pre = null;
    static int pathL = 0;
    static int pathR = 0;

    static int dpspace[][] = null;
    static int pathSpace[][] = null;
    static int pathSpaceL = 0;
    static int pathSpaceR = 0;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        q = in.nextInt();

        h = new int[n+2][m+2];
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                h[i][j] = in.nextInt();

        dp = new int[n+2][m+2];
        dpspace = new int[n+2][m+2];
        pathSpace = new int[40003][2];
        path = new int[40003][2];
        pre = new int[40003][2];

        while (q-- > 0) {
            x1 = in.nextInt();
            y1 = in.nextInt();
            x2 = in.nextInt();
            y2 = in.nextInt();
            x3 = in.nextInt();
            y3 = in.nextInt();

            for (int[] a : dp) {
                Arrays.fill(a, Integer.MAX_VALUE);
            }
            dp[x2][y2] = 0;
            min = Integer.MAX_VALUE;

            pathL = 0;
            pathR = 1;
            path[0][0] = x2;
            path[0][1] = y2;
            pre[0][0] = x1;
            pre[0][1] = y1;

            while(pathL < pathR) {
                bfsCao(path[pathL], pre[pathL]);
                pathL++;
            }

            if (dp[x3][y3] == Integer.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(dp[x3][y3]);
        }
    }

    static void bfsCao(int[] from, int[] space) {
        int fromX = from[0], fromY = from[1];
        int spaceX = space[0], spaceY = space[1];
        if (fromX == x3 && fromY == y3) {
            return;
        }

        if (h[fromX-1][fromY] != 0 && dp[fromX][fromY] < dp[fromX-1][fromY]) {
            int steps = dp[fromX][fromY] + bfsSpace(spaceX, spaceY, fromX-1, fromY, fromX, fromY) + 1;
            if (dp[fromX-1][fromY] > steps) {
                dp[fromX-1][fromY] = steps;
                path[pathR][0] = fromX -1; path[pathR][1] = fromY;
                pre[pathR][0] = fromX; pre[pathR][1] = fromY;
                pathR++;
            }
        }
        if (h[fromX][fromY-1] != 0 && dp[fromX][fromY] < dp[fromX][fromY-1]) {
            int steps = dp[fromX][fromY] + bfsSpace(spaceX, spaceY, fromX, fromY-1, fromX, fromY) + 1;
            if (dp[fromX][fromY-1] > steps) {
                dp[fromX][fromY-1] = steps;
                path[pathR][0] = fromX; path[pathR][1] = fromY-1;
                pre[pathR][0] = fromX; pre[pathR][1] = fromY;
                pathR++;
            }
        }
        if (h[fromX][fromY+1] != 0 && dp[fromX][fromY] < dp[fromX][fromY+1]) {
            int steps = dp[fromX][fromY] + bfsSpace(spaceX, spaceY, fromX, fromY+1, fromX, fromY) + 1;
            if (dp[fromX][fromY+1] > steps) {
                dp[fromX][fromY+1] = steps;
                path[pathR][0] = fromX; path[pathR][1] = fromY+1;
                pre[pathR][0] = fromX; pre[pathR][1] = fromY;
                pathR++;
            }
        }
        if (h[fromX+1][fromY] != 0 && dp[fromX][fromY] < dp[fromX+1][fromY]) {
            int steps = dp[fromX][fromY] + bfsSpace(spaceX, spaceY, fromX+1, fromY, fromX, fromY) + 1;
            if (dp[fromX+1][fromY] > steps) {
                dp[fromX+1][fromY] = steps;
                path[pathR][0] = fromX +1; path[pathR][1] = fromY;
                pre[pathR][0] = fromX; pre[pathR][1] = fromY;
                pathR++;
            }
        }
    }

    static int bfsSpace(int fromX, int fromY, int toX, int toY, int caoX, int caoY) {
        for(int[] a : dpspace)
            Arrays.fill(a, k);

        dpspace[fromX][fromY] = 0;
        pathSpaceL = 0;
        pathSpaceR = 1;
        pathSpace[0][0] = fromX;
        pathSpace[0][1] = fromY;

        while(pathSpaceL < pathSpaceR) {
            int myX = pathSpace[pathSpaceL][0], myY = pathSpace[pathSpaceL][1];
            if (myX == toX && myY == toY)
                break;
            if (dpspace[myX][myY] >= k) {
                pathSpaceL++;
                continue;
            }

            if (h[myX-1][myY] != 0 && ((myX-1) != caoX || myY != caoY) && dpspace[myX][myY] < dpspace[myX-1][myY]) {
                int steps = dpspace[myX][myY] + 1;
                if (dpspace[myX-1][myY] > steps) {
                    dpspace[myX-1][myY] = steps;
                    pathSpace[pathSpaceR][0] = myX-1; pathSpace[pathSpaceR][1] = myY;
                    pathSpaceR++;
                }
            }
            if (h[myX+1][myY] != 0 && ((myX+1) != caoX || myY != caoY) && dpspace[myX][myY] < dpspace[myX+1][myY]) {
                int steps = dpspace[myX][myY] + 1;
                if (dpspace[myX+1][myY] > steps) {
                    dpspace[myX+1][myY] = steps;
                    pathSpace[pathSpaceR][0] = myX+1; pathSpace[pathSpaceR][1] = myY;
                    pathSpaceR++;
                }
            }
            if (h[myX][myY-1] != 0 && (myX != caoX || (myY-1) != caoY) && dpspace[myX][myY] < dpspace[myX][myY-1]) {
                int steps = dpspace[myX][myY] + 1;
                if (dpspace[myX][myY-1] > steps) {
                    dpspace[myX][myY-1] = steps;
                    pathSpace[pathSpaceR][0] = myX; pathSpace[pathSpaceR][1] = myY-1;
                    pathSpaceR++;
                }
            }
            if (h[myX][myY+1] != 0 && (myX != caoX || (myY+1) != caoY) && dpspace[myX][myY] < dpspace[myX][myY+1]) {
                int steps = dpspace[myX][myY] + 1;
                if (dpspace[myX][myY+1] > steps) {
                    dpspace[myX][myY+1] = steps;
                    pathSpace[pathSpaceR][0] = myX; pathSpace[pathSpaceR][1] = myY+1;
                    pathSpaceR++;
                }
            }

            pathSpaceL++;
        }

        return Math.min(k, dpspace[toX][toY]);
    }
}