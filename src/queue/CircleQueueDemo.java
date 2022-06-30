package queue;

import java.util.Scanner;

/**
 * @auther Zixin Su
 * @create 2022-06-30-8:01 AM
 */
public class CircleQueueDemo {
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(3);
        char key = ' ';
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): show Queue");
            System.out.println("e(exit): exit program");
            System.out.println("a(add): add data to Queue");
            System.out.println("g(get): get data from Queue");
            System.out.println("h(head): check front data");
            key = scan.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("input a number: ");
                    int value = scan.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g' :
                    try {
                        int res = queue.getQueue();
                        System.out.printf("data got from front is: %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("head data is: %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scan.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("program exit");
    }
}

class CircleQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleQueue(int maxSize) {
        arr = new int[maxSize];
        this.maxSize = maxSize;
        front = 0;
        rear = 0;
    }

    public boolean isFull() {
        return (rear + 1)%maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int num) {
        if (isFull()) {
            System.out.println("Queue is full, not able to add data to Queue");
            return;
        }
        arr[rear] = num;
        rear++;
        rear %= maxSize;

    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty, not able to get data to Queue");
        }
        int result = arr[front];
        //arr[front] = 0;
        front++;
        front %= maxSize;
        return result;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, no data in Queue");
            return;
        }
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

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];
    }

}