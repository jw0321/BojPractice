package solvedClass.class1.p10250;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int hMax = Integer.parseInt(input[0]);
            int wMax = Integer.parseInt(input[1]);
            int n = Integer.parseInt(input[2]);
            String result = "000";

            int h = 1 , w = 1;
            for (int j = 1; j <= n; j++) {
                if(w < 10) {
                   result = h + "0" + w;
                } else {
                    result = h + "" + w;
                }

                if (h < hMax) {
                    h++;
                } else {
                    h = 1;
                    w++;
                }
            }

            System.out.println(result);
        }
    }
}
