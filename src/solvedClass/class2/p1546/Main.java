package solvedClass.class2.p1546;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int max = Integer.parseInt(inputs[0]);
        for (String s : inputs) {
            int score = Integer.parseInt(s);
            if (score > max) {
                max = score;
            }
        }

        double newSum = 0;
        for (String s : inputs) {
            int score = Integer.parseInt(s);
            double newScore = (double) score / max * 100;
            newSum += newScore;
        }
        System.out.println(newSum/n);
    }
}
