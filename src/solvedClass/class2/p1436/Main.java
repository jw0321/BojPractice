package solvedClass.class2.p1436;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int num = 666;
        while(true) {
            if (Integer.toString(num).contains("666")) {
                count++;
                if (count == n) {
                    System.out.println(num);
                    break;
                }
            }
            num++;
        }
    }
}
