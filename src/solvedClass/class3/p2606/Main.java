package solvedClass.class3.p2606;

import java.io.*;

public class Main {
    // 그래프 문제 -> DFS 사용
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정점의 갯수
        int n = Integer.parseInt(br.readLine());
        // 간선의 갯수
        int m = Integer.parseInt(br.readLine());

        // 인접 행렬
        boolean[][] matrix = new boolean[n][n];

        // 방문 여부
        boolean[] visited = new boolean[n];

        // 간선 추가 (무방향)
        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            matrix[a - 1][b - 1] = true;
            matrix[b - 1][a - 1] = true;
        }


        dfsSearch(matrix, visited, 0);
        int count = 0;
        for (boolean b : visited) {
            if (b) {
                count++;
            }
        }
        // 자기 자신을 제외
        System.out.println(count - 1);
    }

    // DFS 탐색 로직
    static void dfsSearch(boolean[][] matrix, boolean[] visited, int current) {
        visited[current] = true;
        for (int i = 0; i < visited.length; i++) {
            if (matrix[current][i] && !visited[i]) {
                dfsSearch(matrix, visited, i);
            }
        }
    }
}
