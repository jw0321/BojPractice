package solvedClass.class1.p2562;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = arr[0];
        int index = 1;
        for (int i = 1; i < 9; i++ ) {
            if (arr[i] > max) {
                max = arr[i];
                index = i + 1;
            }
        }
        sb.append(max).append('\n').append(index);
        System.out.println(sb);
    }
}
