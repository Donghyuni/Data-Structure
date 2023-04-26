package ds_hw1.list;

public class Link<E> {
    E item;
    Link<E> next;
    static Link<?> freelist = null;

    public Link(E item, Link<E> next) {
        this.item = item;
        this.next = next;
    }
    Link<E> next() {return next;}
    Link<E> setNext(Link<E> next) {return this.next = next;}
    E item() {return item;}
    E setItem(E item) {return this.item = item;}

    static <E> Link<E> get(E item, Link<E> next) {
        if(freelist == null)
            return new Link<>(item, next);

        Link<E> ret = (Link<E>) Link.freelist;
        freelist = freelist.next();

        ret.setItem(item);
        ret.setNext(next);

        return ret;
    }
    void release() {
        item = null;
        next = (Link<E>) Link.freelist;
        freelist = this;
    }
}
