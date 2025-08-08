package solvedClass.class4.p15666;

import java.io.*;
import java.util.*;

// 백트래킹 문제
public class Main {

    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] arr, temp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[n];
        temp = new int[m];

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 중복 체크
        int lastUsed = 0;
        for (int i = start; i < n; i++) {
            if (lastUsed != arr[i]) {
                lastUsed = arr[i];
                temp[depth] = arr[i];
                dfs(depth + 1, i);
            }
        }
    }
}
