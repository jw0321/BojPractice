package solvedClass.class4.p11053;

import java.io.*;
import java.util.*;

// 최장 증가 부분 수열 문제 - 이분 탐색 활용
// N이 더 커질 경우 이분 탐색을 사용해야 시간 초과를 방지할 수 있다.
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        List<Integer> lis = new ArrayList<>();

        lis.add(arr[0]);

        for (int i = 1; i < n; i++) {
            int currentNum = arr[i];

            if (currentNum > lis.get(lis.size() - 1)) {
                lis.add(currentNum);
            } else {
                int index = Collections.binarySearch(lis, currentNum);

                if (index < 0) {
                    index = -(index + 1);
                }

                lis.set(index, currentNum);
            }
        }

        System.out.println(lis.size());
    }
}

