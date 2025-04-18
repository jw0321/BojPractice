package solvedClass.class2.p2108;

import java.io.*;
import java.util.*;

public class Main {
    // 만약 범위가 더 큰 경우에는 hashmap을 사용하는 방법도 있다.
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 1. 산술평균 (소숫점 첫째 자리에서 반올림)
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int avg = Math.round(sum / (float) n);
        sb.append(avg).append('\n');

        // 2. 중앙값
        Arrays.sort(arr);
        sb.append(arr[n / 2]).append('\n');

        // 3. 최빈값 (여러 개 있을 때는 두번째로 작은 값)
        int[] arr2 = new int[8001];
        for (int i : arr) {
            arr2[i + 4000]++;
        }
        int maxCount = 0;
        int ans = 0;
        boolean isSecond = false;
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] > maxCount) {
                maxCount = arr2[i];
                ans = i - 4000;
                isSecond = false;
            } else if (arr2[i] == maxCount && !isSecond){
                isSecond = true;
                ans = i - 4000;
            }
        }
        sb.append(ans).append('\n');

        // 4. 범위
        int min = arr[0];
        int max = arr[n-1];
        int range = max - min;
        sb.append(range);

        System.out.println(sb);
    }
}
