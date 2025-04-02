package solvedClass.class1.p2884;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");
        int hour = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);

        if (hour == 0) {
            if (min < 45) {
                hour = 23;
                min += 15;
            } else {
                min -= 45;
            }
        } else {
            if (min < 45) {
                hour--;
                min += 15;
            } else {
                min -= 45;
            }
        }

        sb.append(hour).append(" ").append(min);
        System.out.println(sb);
    }
}
