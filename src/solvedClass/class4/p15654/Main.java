package solvedClass.class4.p15654;

import java.io.*;
import java.util.*;

// 백트래킹 문제
public class Main {

    static int n, m;
    static int[] arr;
    static int[] answer;
    static boolean[] visited = new boolean[10001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        arr = new int[n];
        answer = new int[m];

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(arr);

        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i : arr) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
