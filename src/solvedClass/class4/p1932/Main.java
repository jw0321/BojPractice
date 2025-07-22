package solvedClass.class4.p1932;

import java.io.*;
import java.util.*;

// DP 문제 - 바텀 업 방식
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                list.get(i).add(Integer.parseInt(input[j]));
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < list.get(i).size(); j++) {
                int bigger = Math.max((list.get(i + 1).get(j)),list.get(i + 1).get(j + 1));
                list.get(i).set(j, list.get(i).get(j) + bigger);
            }
        }

        int max = list.get(0).get(0);
        System.out.println(max);
    }
}
