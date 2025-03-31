package solvedClass.class1.p10818;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String[] arr = input.split(" ");

        int[] intarr = new int[n];
        for (int i = 0; i < n; i++) {
            intarr[i] = Integer.parseInt(arr[i]);
        }

        int max = intarr[0];
        int min = intarr[0];
        for (int i : intarr) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }

        sb.append(min).append(" ").append(max).append("\n");
        System.out.println(sb);
    }
}
