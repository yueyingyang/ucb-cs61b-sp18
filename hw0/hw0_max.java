public class hw0_max {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int max = m[0];
        int length = m.length;
        int i = 1;
        while (i < length) {
            if (max < m[i]) {
                max = m[i];
            }
            i++;
        }
        return max;
    }

    public static int forMax(int[] m) {
        int length = m.length;
        int max = m[0];
        for (int i = 0; i < length; i++) {
            if (max < m[i]) {
                max = m[i];
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = new int[] { 9, 2, 15, 2, 22, 10, 6 };
        System.out.print(forMax(numbers));
    }
}