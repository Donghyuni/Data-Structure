package ds_hw2.stack;

import java.util.ArrayList;

public class ArrayStack<E> implements Stack<E> {
    private int maxSize;
    private int size;
    private int top;
    private E[] listArray;

    public ArrayStack(int maxsize){
        maxsize = 0;
        this.maxSize= maxSize;
        listArray = (E[]) new Object[maxSize];
        top = -1;
    }

    @Override
    public void clear() {
            size = 0;
        }

    @Override
    public void push(E it) {
            listArray[++top] = it;
            maxSize++;
        }

    @Override
    public E pop() {
            E ret = listArray[top];
            maxSize--;
            return listArray[top--];
        }

    @Override
    public E topValue() {
            return listArray[top];
        }

    @Override
    public int length() {
        return maxSize;
    }
    
    public static void main(String args[]) {
        ArrayStack<Integer> arrStack = new ArrayStack<>(5);
        arrStack.push('9');
        System.out.println(arrStack.pop());
        System.out.println(arrStack.topValue()); 
        arrStack.push('6');
        System.out.println(arrStack.pop());
        System.out.println(arrStack.topValue()); 
        arrStack.push('7');
        System.out.println(arrStack.pop());
        System.out.println(arrStack.topValue()); 
        System.out.println(arrStack.length()); 
        arrStack.clear();
        System.out.println(arrStack.pop());
        System.out.println(arrStack.topValue()); 
        System.out.println(arrStack.length()); 
    }
    
}
