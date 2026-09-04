import java.util.*;

class ProductOfArrayExceptSelf {
    static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            ans[i] = product;
            product *= nums[i];
        }

        product = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= product;
            product *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = s.nextInt();

        int[] a = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();

        System.out.println("Answer: " + Arrays.toString(productExceptSelf(a)));
    }
}