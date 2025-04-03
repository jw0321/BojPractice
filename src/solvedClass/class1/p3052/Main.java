package solvedClass.class1.p3052;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> result = new HashSet<>();
        for (int j : arr) {
            int k = j % 42;
            result.add(k);
        }

        System.out.println(result.size());
    }
}
