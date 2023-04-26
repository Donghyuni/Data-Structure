package ds_hw2.tree;

public class InternalNode<E> implements BinNode<E> {
   private E item;
   private BinNode<E> left;
   private BinNode<E> right;
   
   public InternalNode(){
    this(null,null,null);
   }
   public InternalNode(E item, BinNode<E> left, BinNode<E> right) {
    this.item = item;
    this.left = left;
    this.right= right;
   }

@Override
public E element() {
    return item;
}

@Override
public void setElement(E v) {
    item=v;
}

@Override
public BinNode<E> left() {
    return left;
}

@Override
public BinNode<E> right() {
    return right;
}

@Override
public boolean isLeaf() {
    return false;
}
}
