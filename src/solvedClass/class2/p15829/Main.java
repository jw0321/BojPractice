package solvedClass.class2.p15829;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        long answer = 0;
        long mod = 1234567891L;
        long power = 1;

        for (int i = 0; i < n; i++) {
            int c = (input.charAt(i) - 'a' + 1);
            answer = (answer + c * power) % mod;
            power = (power * 31) % mod;
        }

        System.out.println(answer);
    }
}
