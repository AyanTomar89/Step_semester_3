import java.util.*;

class MergeTwoSortedArrays {
    static int[] mergeSortedArrays(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];
        }

        while (i < a.length)
            c[k++] = a[i++];

        while (j < b.length)
            c[k++] = b[j++];

        return c;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int n = s.nextInt();

        int[] a = new int[n];

        System.out.println("Enter first sorted array:");
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();

        System.out.print("Enter size of second array: ");
        int m = s.nextInt();

        int[] b = new int[m];

        System.out.println("Enter second sorted array:");
        for (int i = 0; i < m; i++)
            b[i] = s.nextInt();

        System.out.println("Merged Array: " + Arrays.toString(mergeSortedArrays(a, b)));
    }
}