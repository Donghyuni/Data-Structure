package ds_hw2.tree;

public class LeafNode<E> implements BinNode<E> {
   public E item;
   public LeafNode(E item){
    this.item=item;
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
    return null;
}
@Override
public BinNode<E> right() {
    return null;
}
@Override
public boolean isLeaf() {
    return true;
}}
