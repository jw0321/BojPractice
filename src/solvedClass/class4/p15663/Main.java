package solvedClass.class4.p15663;

import java.io.*;
import java.util.*;

// 백트래킹 문제 - 중복되는 수가 있는 수열
public class Main {

    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        arr = new int[n];
        visited = new boolean[n];
        answer = new int[m];

        String[] inputs2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs2[i]);
        }
        Arrays.sort(arr);
        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 중복 체크
        int lastUsed = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && arr[i] != lastUsed) {
                visited[i] = true;
                answer[depth] = arr[i];
                lastUsed = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
