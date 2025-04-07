package solvedClass.class2.p1181;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] inputs = new String[n];

        for (int i = 0; i < n; i++) {
            inputs[i] = br.readLine();
        }

        // 중복 제거
        inputs = Arrays.stream(inputs).distinct().toArray(String[]::new);

//        // 조건 1. 길이가 짧은 순으로 정렬
//        // 조건 2. 길이가 같으면 사전 순으로 정렬
//        for (int i = 0; i < inputs.length; i++) {
//            for (int j = i + 1; j < inputs.length; j++) {
//                // 조건 1
//                if (inputs[i].length() > inputs[j].length()) {
//                    String temp = inputs[i];
//                    inputs[i] = inputs[j];
//                    inputs[j] = temp;
//                } else if (inputs[i].length() == inputs[j].length()) {
//                    // 조건 2
//                    for (int k = 0; k < inputs[i].length(); k++) {
//                        if (inputs[i].charAt(k) < inputs[j].charAt(k)) {
//                            String temp = inputs[i + 1];
//                            inputs[i + 1] = inputs[j];
//                            inputs[j] = temp;
//                            break;
//                        } else if (inputs[i].charAt(k) > inputs[j].charAt(k)) {
//                            if (i + 1 == j) {
//                                String temp = inputs[i];
//                                inputs[i] = inputs[j];
//                                inputs[j] = temp;
//                            } else {
//                                String temp = inputs[i + 1];
//                                inputs[i + 1] = inputs[i];
//                                inputs[i] = inputs[j];
//                                inputs[j] = temp;
//                            }
//                            break;
//                        }
//                    }
//                }
//            }
//            sb.append(inputs[i]).append("\n");
//        }

        // sort 메서드 사용 (람다식)
        Arrays.sort(inputs, (s1, s2) -> {
            // 조건 1 길이가 다르면 길이가 짧은 문자열이 앞에 오도록 정렬
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }
            // 조건 2 길이가 같으면 사전 순으로 정렬
            return s1.compareTo(s2);
        });

        for (String s : inputs) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
