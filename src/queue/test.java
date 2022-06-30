package queue;

/**
 * @auther Zixin Su
 * @create 2022-06-30-10:55 PM
 */
public class test {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};


        showQueue(0, 2, 4, arr);
    }

    public static void showQueue(int front, int rear, int maxSize, int[] arr) {
        int i = front;
        int index = 0;
        while (i != rear) {
            System.out.printf("arr[%d] = %d", index, arr[i]);
            System.out.println();
            index++;
            i++;
            i %= maxSize;
        }

    }
}
