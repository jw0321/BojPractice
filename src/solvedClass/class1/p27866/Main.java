package solvedClass.class1.p27866;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        int n = Integer.parseInt(br.readLine());

        System.out.println(input.charAt(n - 1));
    }

}
