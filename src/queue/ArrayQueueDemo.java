package queue;

import java.util.Scanner;

/**
 * @auther Zixin Su
 * @create 2022-06-29-10:26 AM
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
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

class ArrayQueue {
    private int maxSize; //表示数组的最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; // 用于存放数据，模拟队列

    //构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("Queue is full, not able to add data to Queue");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty, can not get data from Queue");
        }
        front++;
        return arr[front];
    }

    //现实队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, no data in Queue");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //现实队列的头数据，注意不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front+1];
    }
}
