package ds_hw2.stack;

public class LinkedStack<E> implements Stack<E> {
    private static class Link<E> {
        private E it;
        private Link<E> next;
        Link(E it, Link<E> next){
            this.it = it; this.next=next;
        }
        E it(){return it;}
    }
    private int size;
    private Link<E> top;

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public void push(E it) {
        Link<E> i = new Link(it, top);
        top = i;
        size++;
    }

    @Override
    public E pop() {
        E ret = top.it();
        size--;
        return ret;
    }

    @Override
    public E topValue() {
        return top.it();
    }

    @Override
    public int length() {
        return size;
    }
    
    public static void main(String args[]) {
        LinkedStack LinkStack = new LinkedStack();

        LinkStack.push('9');
        System.out.println(LinkStack.pop());
        System.out.println(LinkStack.topValue()); 
        LinkStack.push('6');
        System.out.println(LinkStack.pop());
        System.out.println(LinkStack.topValue()); 
        LinkStack.push('7');
        System.out.println(LinkStack.pop());
        System.out.println(LinkStack.topValue()); 
        System.out.println(LinkStack.length()); 
        LinkStack.clear();
        System.out.println(LinkStack.pop());
        System.out.println(LinkStack.topValue()); 
        System.out.println(LinkStack.length()); 
    }
    
}
