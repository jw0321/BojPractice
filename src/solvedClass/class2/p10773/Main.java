package solvedClass.class2.p10773;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int loc = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                arr[--loc] = 0;
                continue;
            }
            arr[loc] = num;
            loc++;
        }

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println(sum);
    }
}
