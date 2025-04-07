package solvedClass.class2.p10814;

import java.io.*;
import java.util.*;

public class Main {

    public static class Join {
        int age;
        String name;

        Join(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Join[] joins = new Join[n];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            joins[i] = new Join(Integer.parseInt(inputs[0]), inputs[1]);
        }

        // 조건 1. 나이 순
        // 조건 2. 나이가 같다면 가입한 순
        Join[] sortedJoins = Arrays.stream(joins).sorted( (Comparator.comparingInt(o -> o.age))).toArray(Join[]::new);
        for (Join join : sortedJoins) {
            sb.append(join);
        }
        System.out.println(sb);
    }
}


