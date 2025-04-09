package solvedClass.class2.p2869;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int up = Integer.parseInt(inputs[0]);
        int down = Integer.parseInt(inputs[1]);
        int length = Integer.parseInt(inputs[2]);

        int answer = (length - down) / (up - down);
        if ((length - down) % (up - down) != 0) {
            answer++;
        }
        System.out.println(answer);
    }
}
