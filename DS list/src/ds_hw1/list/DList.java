package ds_hw1.list;

public class DList<E> implements List<E> {
    private DLink<E> head, tail;
    int size;


    DList() {
        head = new DLink<>(null,null,null);
        tail = new DLink<>(null,null,null);
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;
    }
    @Override
    public void clear() {
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;
    }

    @Override
    public void insert(int pos, E item) {
        DLink<E> curr = head;
        for (int i=0; i<pos; i++) curr = curr.next();
        curr.next().setPrev(new DLink<>(item,curr,curr.next()));
        curr.setNext(curr.next().prev());
        size++;
    }

    @Override
    public void append(E item) {
        tail.prev().setNext(new DLink<>(item, tail.prev(), tail));
        tail.setPrev(tail.prev().next());
        size++;
    }

    @Override
    public void update(int pos, E item) {
        DLink<E> curr = head;
        for (int i=0; i<pos; i++) curr = curr.next();
        curr.next().setItem(item);
    }

    @Override
    public E getValue(int pos) {
        DLink<E> curr = head;
        for (int i=0; i<pos; i++) curr = curr.next();
        return curr.next().item();
    }

    @Override
    public E remove(int pos) {
        DLink<E> curr = head;
        for (int i=0; i<pos; i++) curr = curr.next();
        E ret = curr.next().item();
        curr.setNext(curr.next().next());
        size--;
        return ret;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListIterator<E>() {
            DLink<E> curr = head;
            @Override
            public boolean hasNext() {
                return curr != tail.prev();
            }

            @Override
            public E next() {
                curr = curr.next();
                return curr.item();
            }

            @Override
            public boolean hasPrevious() {
                return curr != head.next();
            }

            @Override
            public E previous() {
                curr = curr.prev();
                return curr.item();
            }
        };
    }
}
