package solvedClass.class2.p4153;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] inputs = br.readLine().split(" ");
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(inputs[0]);
            arr[1] = Integer.parseInt(inputs[1]);
            arr[2] = Integer.parseInt(inputs[2]);
            Arrays.sort(arr);

            int a = arr[0];
            int b = arr[1];
            int c = arr[2];

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            if (a * a + b * b == c * c) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }
        System.out.println(sb);
    }
}
