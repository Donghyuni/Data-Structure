package ds_hw1.list;

class DLink<E>{    
    public E item;
    public DList<E> next;
    public DList<E> prev;
    DLink(E item, DList<E> prev, DList<E> next) {
        this.item = item; this.prev = prev; this.next = next;
    }
    DList<E> next() {return next;}
    DList<E> setNext(DList<E> next) {return this.next = next;}
    DList<E> prev() {return prev;}
    DList<E> setPrev(DList<E> prev) {return this.prev = prev;}
    E item() {return item;}
    E setItem(E item) {return this.item = item;}
}
