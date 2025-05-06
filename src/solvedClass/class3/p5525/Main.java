package solvedClass.class3.p5525;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        String p = "IOI";

        int count = 0;
        int index = 0;
        int ans = 0;
        while (index < m - 2) {
            if (s.substring(index, index + 3).equals(p)) {
                count++;
                index += 2;
                if (count >= n) {
                    ans++;
                }
            } else {
                count = 0;
                index++;
            }
        }

        System.out.println(ans);
    }
}
