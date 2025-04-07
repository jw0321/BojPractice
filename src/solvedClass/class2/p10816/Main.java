package solvedClass.class2.p10816;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(nums);

        int m = Integer.parseInt(br.readLine());
        String[] inputs2 = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(inputs2[i]);
            int lower = lowerBound(nums, target);
            int upper = upperBound(nums, target);
            sb.append(upper - lower).append(" ");
        }
        System.out.println(sb);
    }

    // 이진 검색을 2번 수행하여 상한 위치와 하한 위치를 찾아 갯수를 측정
    // -> 값의 범위가 작다면 카운팅 정렬 기법을 사용하는 것도 좋음
    public static int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int upperBound(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
