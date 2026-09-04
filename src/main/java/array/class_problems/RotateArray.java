import java.util.*;

class RotateArray {
    static int[] rotateArray(int[] nums, int k) {
        k = k % nums.length;

        int[] b = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
            b[(i + k) % nums.length] = nums[i];

        return b;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = s.nextInt();

        int[] a = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();

        System.out.print("Enter rotation value k: ");
        int k = s.nextInt();

        System.out.println("Rotated Array: " + Arrays.toString(rotateArray(a, k)));
    }
}