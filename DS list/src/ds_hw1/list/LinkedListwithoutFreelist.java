package ds_hw1.list;

public class LinkedListwithoutFreelist<E> implements List<E>{

    Link<E> head, tail;
    int size;

    public LinkedListwithoutFreelist(){
        head = tail = new Link(null, null);
        size = 0;
    }

    public void clear(){
        head.next = null;
        tail = head;
        size = 0;
    }
    public void insert(int pos, E item){
        Link<E> curr = head;
        for(int i=0; i<pos; i++){
            curr = curr.next;
        }
        Link<E> n = new Link<>(item, curr.next);
        curr.next = n;
        
        if (curr == tail){
            tail = curr.next;
        }

        size++;
    }
    public void append(E item){
        Link<E> n = new Link<>(item,null);
        tail.next = n;
        tail = n;
        size++;
    }
    public void update(int pos, E item){
        Link<E> curr = head;
        for(int i=0; i<pos; i++){
            curr = curr.next;
        }

        curr.next.item = item;

    }
    public E getValue(int pos){
        Link<E> curr = head;
        for(int i=0; i<pos; i++){
            curr = curr.next;
        }

        return curr.next.item;
    }
    public E remove(int pos){
        Link<E> curr = head;
        for(int i=0; i<pos; i++){
            curr = curr.next;
        }

        E ret = curr.next.item;

        if(curr.next == tail){
            tail = curr;
        }

        curr.next = curr.next.next;
        size--;
        return ret;
    }
    public int length(){
        return size;
    }
    
    public String toString(){
        String a = "";
        Link<E> curr = head;
        for(int i=0; i<size; i++){
            a += curr.next.item + ", ";
            curr = curr.next;
        }

        return a;
    }
    public static void main(String[] args){
        List<Integer> mylist = new LinkedListwithoutFreelist<>();

        mylist.append(5);
        System.out.println(mylist);
        mylist.insert(0,1);
        System.out.println(mylist);
        mylist.insert(1,4);
        System.out.println(mylist);
        mylist.append(10);
        System.out.println(mylist);
        mylist.update(0, 20);
        System.out.println(mylist);
    }

    public ListIterator<E> listIterator(){
        return new LinkedListIterator();
    }
    
    class LinkedListIterator implements ListIterator<E>{
        
        Link<E> curr = head;
        
        public boolean hasNext(){
            return curr != tail;
        }
        public E next(){
            curr = curr.next;
            return curr.item;
        }
        public boolean hasPrevious(){
            return curr != head;
        }
        public E previous(){
            Link<E> tmp = head;
            while(tmp.next != curr){
                tmp = tmp.next;
            }
            curr = tmp;
            return curr.next.item;
        }
    }
}