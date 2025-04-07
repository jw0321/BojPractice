package solvedClass.class2.p11866;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        // list 사용하여 구현
//        List<Integer> list = new LinkedList<>();
//        for (int i = 1; i <= n; i++) {
//            list.add(i);
//        }
//        int index = 0;
//        sb.append("<");
//        while (list.size() != 1) {
//            index = (index + k - 1) % list.size();
//            sb.append(list.remove(index)).append(", ");
//        }
//        sb.append(list.get(0)).append(">");

        // 원형 큐를 사용하여 구현
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        sb.append("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll());
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
