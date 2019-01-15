class triangle {
    public static void DrawTriangle(int N) {
        int col = 0;
        int row = 0;
        int SIZE = N;

        while (row < SIZE) {
            col = 0;
            // draw * row
            while (col <= row) {
                // 两种指针右移的方式 都要 col++
                while (col < row) {
                    System.out.print('*');
                    col = col + 1;
                }
                System.out.println('*');
                col = col + 1;
            }
            row = row + 1;
        }
    }

    public static void main(String[] args) {
        DrawTriangle(10);
    }
}