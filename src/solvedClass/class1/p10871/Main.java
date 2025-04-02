package solvedClass.class1.p10871;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr1 = br.readLine().split(" ");
        String[] arr2 = br.readLine().split(" ");

        int n = Integer.parseInt(arr1[0]);
        int s = Integer.parseInt(arr1[1]);

        int[] arr3 = new int[n];
        for (int i = 0; i < n; i++) {
            arr3[i] = Integer.parseInt(arr2[i]);
        }

        for (int i : arr3) {
            if (i < s) {
                sb.append(i).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
