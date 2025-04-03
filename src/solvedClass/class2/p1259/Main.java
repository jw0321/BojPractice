package solvedClass.class2.p1259;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals("0")) {
                break;
            }
            StringBuilder sb = new StringBuilder(s);
            String rs = sb.reverse().toString();

            if (s.equals(rs)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
