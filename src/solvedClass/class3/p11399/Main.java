package solvedClass.class3.p11399;

import java.io.*;
import java.util.*;

public class Main {
    // 그리디
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(arr);
        int sum = 0;
        int before = 0;
        for (int i = 0; i < n; i++) {
            before += arr[i];
            sum += before;
        }
        System.out.println(sum);
    }
}
