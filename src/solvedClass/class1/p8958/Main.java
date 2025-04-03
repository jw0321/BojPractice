package solvedClass.class1.p8958;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split("");
            int streak = 0;
            int score = 0;
            for (String s : input) {
                if (s.equals("O")) {
                    streak++;
                    score += streak;
                } else if (s.equals("X")) {
                    streak = 0;
                    score += streak;
                }
            }
            System.out.println(score);
        }
    }
}
