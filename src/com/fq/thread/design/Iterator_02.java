package com.fq.thread.design;

public class Iterator_02 {

    static class Item{
        private String name;

        public Item(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    interface MyIterator<E>{
        boolean hasNext();

        E next();

    }

    static class MyList<E> {
        Object[] arr;
        int count=0;
        int pointer = 0;

        public MyList(int capacity) {
            arr = new Object[capacity];
        }

        public void add(E e){
            arr[count]=e;
            count++;
        }

        public Iterator_02.MyIterator<E> iterator() {
            return new MyIterator();
        }

        class MyIterator implements Iterator_02.MyIterator<E> {
            @Override
            public boolean hasNext() {
                if (count > 0 && pointer < count) {
                    return true;
                }
                return false;
            }

            @Override
            public E next() {
                E element = (E) arr[pointer];
                pointer++;
                return element;
            }
        }
    }

    public static void main(String[] args) {
        MyList<Item> myList = new MyList<>(4);
        myList.add(new Item("1"));
        myList.add(new Item("2"));
        myList.add(new Item("3"));
        MyIterator<Item> iterator = myList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }
    }
}
