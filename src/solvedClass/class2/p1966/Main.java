package solvedClass.class2.p1966;

import java.io.*;

public class Main {
    // 입력 범위가 작아서 배열을 사용하였지만 범위가 크다면 메모리 효율성을 위해 linkedlist나 arraydeque를 사용하는 것이 효율적이다.

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] input1 = br.readLine().split(" ");
            int n = Integer.parseInt(input1[0]);
            int m = Integer.parseInt(input1[1]);

            int[] arr = new int[2 * n];
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(input2[j]);
            }

            int start = 0;
            int end = n - 1;
            int count = 0;

            while (true) {
                int target = arr[start];
                boolean found = false;
                for (int j = start + 1; j <= end; j++) {
                    if (target < arr[j]) {
                        found = true;
                        end++;
                        arr[end] = target;
                        if (m == start) {
                            m = end;
                        }
                        start++;
                        break;
                    }
                }
                if (!found) {
                    start++;
                    count++;
                }
                if (m < start) {
                    break;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}
