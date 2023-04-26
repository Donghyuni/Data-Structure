package ds_hw2.queue;

public class ArrayQueue<E> implements Queue<E> {
    private int front;
    private int rear;
    private int queueSize;
    private E[] queueArray;

    public ArrayQueue(int queueSize) {
        front = -1;    
        rear = -1;    
        this.queueSize = queueSize;  
        queueArray = (E[]) new Object[this.queueSize];  
    }

    @Override
    public void clear() {
        front = -1;
        rear = -1;
        queueArray = (E[]) new Object[this.queueSize];
    }

    @Override
    public void enqueue(E it) {
        queueArray[++rear] = it;
        rear=rear%queueSize;
    }

    @Override
    public E dequeue() {
        front = (front +1) % this.queueSize;
        return queueArray[front];
    }

    @Override
    public E frontValue() {
        return queueArray[front +1];
    }

    @Override
    public int length() {
        return queueSize;
    }


    public static void main(String args[]) {
        ArrayQueue arrqQueue = new ArrayQueue<>(5);
        arrqQueue.enqueue('9');
        System.out.println(arrqQueue.frontValue());
        arrqQueue.enqueue('6');
        arrqQueue.dequeue();
        System.out.println(arrqQueue.frontValue());
        arrqQueue.enqueue('7');
        arrqQueue.dequeue();
        System.out.println(arrqQueue.frontValue()); 
        arrqQueue.clear();
        System.out.println(arrqQueue.length());
    }
    
}
