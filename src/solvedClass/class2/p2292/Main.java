package solvedClass.class2.p2292;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int locate = 1;
        int count = 1;
        while (true) {
            if (n <= locate) {
                System.out.println(count);
                break;
            }
            locate += 6 * count;
            count++;
        }
    }
}
