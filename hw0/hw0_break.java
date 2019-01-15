public class hw0_break {
    public static void windowPosSum(int[] a, int n) {
        /** your code here */
        int length = a.length;
        int i, j;
        // Loop for a
        for (i = 0; i < length; i++) {
            if (a[i] <= 0) {
                continue;
            } else {
                // Loop for a to a + n
                for (j = i + 1; j <= i + n; j++) {
                    if (j < length) {
                        a[i] += a[j];
                    } else {
                        // negative
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, -3, 4, 5, 4 };
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}