package solvedClass.class3.p18870;

import java.io.*;
import java.util.*;

public class Main {
    // 좌표 압축 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];

        // 정렬 + TreeSet 사용
//        Set<Integer> sortedSet = new TreeSet<>();
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(input[i]);
//            sortedSet.add(arr[i]);
//        }
//
//        int[] order = new int[sortedSet.size()];
//        int orderIndex = 0;
//        for (int i : sortedSet) {
//            order[orderIndex++] = i;
//        }
//
//        for (int i = 0; i < n; i++) {
//            int idx = Arrays.binarySearch(order, arr[i]);
//            sb.append(idx).append(" ");
//        }
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // 정렬 + HashMap 사용
        int[] sortedArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArr);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int i : sortedArr) {
            if (!map.containsKey(i)) {
                map.put(i, rank);
                rank++;
            }
        }

        for (int i : arr) {
            sb.append(map.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
