package sparseArray;

/**
 * @auther Zixin Su
 * @create 2022-03-22-10:30 PM
 *
 *
 */
public class SparseArray {
    public static void main(String[] args) {
        /*
        创建一个原始的二维数组11*11
        0：没有棋子
        1：黑子
        2：篮子
         */

        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始二维数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        /*
        将二维数组 转 稀疏数组
        1. 遍历原始的二维数组，得到有效数据的个数sum
        2. 更具sum就可以创建稀疏数组 sparseArr int[sum+1][3]
        3. 将二维数组的有效数据存入稀疏数组
         */
        // 1
        int sum = 0;
        for (int[] row : chessArr1) {
            for (int data : row) {
                if (data != 0) sum++;
            }
        }
        //System.out.println(sum);
        // 2
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;
        // 3
        int r = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    r++;
                    sparseArr[r][0] = i;
                    sparseArr[r][1] = j;
                    sparseArr[r][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        /*
        将 稀疏数组 转 二维数组
        1. 先读取稀疏数组的第一行，更具第一行的数据，创建原始的二维数组，比如上面的 chessArr2 = int[11][11]
        2. 在读取稀疏数组后几行的数据，并付给原始的二维数组即可
         */
        // 1
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 2
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //输出恢复后的二维数组
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
