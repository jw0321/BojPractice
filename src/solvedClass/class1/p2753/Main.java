package solvedClass.class1.p2753;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        if (n % 400 == 0) {
            result = 1;
        } else if (n % 100 != 0 && n % 4 == 0) {
            result = 1;
        }
        System.out.println(result);
    }
}
