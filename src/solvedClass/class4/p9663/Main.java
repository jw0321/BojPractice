package solvedClass.class4.p9663;

import java.io.*;

// 백트래킹 문제
public class Main {

    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;
    static int n, count;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        col = new boolean[n + 1];
        diag1 = new boolean[2 * n + 1];
        diag2 = new boolean[2 * n + 1];
        count = 0;

        dfs(1);
        System.out.println(count);
    }


    public static void dfs(int depth) {
        if (depth > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!col[i] && !diag1[depth + i] && !diag2[depth - i + n]) {
                col[i] = true;
                diag1[depth + i] = true;
                diag2[depth - i + n] = true;
                dfs(depth + 1);
                col[i] = false;
                diag1[depth + i] = false;
                diag2[depth - i + n] = false;
            }
        }
    }
}
