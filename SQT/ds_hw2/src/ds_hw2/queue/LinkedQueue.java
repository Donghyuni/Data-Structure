package ds_hw2.queue;

public class LinkedQueue<E> implements Queue<E> {
    private static class Link<E> {
        public E item;
        public Link<E> next;
        public Link(E item, Link<E> next){
            this.item = item;
            this.next = next;
        }
    }
    Link <E> front,rear;
    int size;

    public LinkedQueue(){
        front = rear = new Link<E>(null, null);
        size = 0;
    }
    public LinkedQueue(int i) {
    }
    @Override
    public void clear() {
        front.next = null;
        rear=front;
        size=0;
    }

    @Override
    public void enqueue(E it) {
        Link<E> i = new Link<>(it, null);
        rear.next = i;
        rear=i;
        size++;
    }

    @Override
    public E dequeue() {
        E ret = front.next.item;
        front.next=front.next.next;
        size--;
        return ret;
    }

    @Override
    public E frontValue() {
        return front.next.item;
    }

    @Override
    public int length() {
        return size;
    }
    public static void main(String args[]) {
        LinkedQueue<Integer> linkQueue = new LinkedQueue();
        linkQueue.enqueue(9);
        System.out.println(linkQueue.frontValue());
        linkQueue.enqueue(6);
        linkQueue.dequeue();
        System.out.println(linkQueue.frontValue());
        linkQueue.enqueue(7);
        linkQueue.dequeue();
        System.out.println(linkQueue.frontValue()); 
        linkQueue.clear();
        System.out.println(linkQueue.length());
    }    
}
