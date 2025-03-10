package solvedClass.class2.p30802;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] sizes = br.readLine().split(" ");
        String[] tp = br.readLine().split(" ");

        int t = Integer.parseInt(tp[0]);
        int p = Integer.parseInt(tp[1]);

        int tOrder = 0;
        for (String size : sizes) {
            int s = Integer.parseInt(size);
            if ( s % t != 0 ) {
                tOrder += s / t + 1;
            } else {
                tOrder += s / t;
            }
        }

        sb.append(tOrder).append('\n');

        int pOrder = n/p;
        int pOrder1 = n%p;
        sb.append(pOrder).append(" ").append(pOrder1).append('\n');

        System.out.println(sb);
    }
}
