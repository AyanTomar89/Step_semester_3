import java.util.*;

class MaximumSubarray {
    static int maxSubArray(int[] nums) {
        int sum = nums[0], max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = s.nextInt();

        int[] a = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();

        System.out.println("Maximum Subarray Sum: " + maxSubArray(a));
    }
}