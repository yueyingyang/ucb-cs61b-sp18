public class ArrayDeque<T> implements Deque<T> {
    private static final int INITIAL_CAPACITY = 8;
    private int size = 0;
    private T[] itemList = (T[]) new Object[INITIAL_CAPACITY];
    private int nextFirst = 4;
    private int nextLast = 5;

    public ArrayDeque() {

    }

    public ArrayDeque(T item) {

        size = 1;
        itemList[nextLast] = item;
        nextLast = plusOne(nextLast);

    }
    @Override
    public void addFirst(T item) {

        if (isFull()) {
            resize(size * 2);
        }
        itemList[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;

    }
    @Override
    public void addLast(T item) {

        if (isFull()) {
            resize(size * 2);
        }
        itemList[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;

    }
    @Override
    public boolean isEmpty() {

        if (size == 0) {
            return true;
        }
        return false;
    }
    @Override
    public int size() {

        return size;

    }
    @Override
    public void printDeque() {

        int i = size;
        int index = nextFirst + 1;
        while (i > 0) {

            System.out.print(itemList[index] + " ");
            i--;
            index = plusOne(index);

        }
        System.out.println();

    }
    @Override
    public T removeFirst() {

        nextFirst = plusOne(nextFirst);
        T a = itemList[nextFirst];
        if (isSparse()) {
            resize(size / 2);
        }
        size--;

        return a;

    }
    @Override
    public T removeLast() {

        nextLast = minusOne(nextLast);
        T a = itemList[nextLast];
        if (isSparse()) {
            resize(size / 2);
        }
        size--;

        return a;
    }
    @Override
    public T get(int index) {

        int i = index;
        int j = nextFirst;
        while (i > -1) {
            j = plusOne(nextFirst);
            i--;
        }
        return itemList[j];
    }


    public int minusOne(int index) {


        if (index == 0) {
            return itemList.length - 1;
        }
        index--;
        return index;

    }

    public int plusOne(int index) {


        if (index == itemList.length - 1) {
            return 0;
        }
        index++;
        return index;
    }

    public int plusOne(int index, int length) {


        if (index == length - 1) {
            return 0;
        }
        index++;
        return index;
    }


    private void resize(int capacity) {

        T[] a = (T[]) new Object[capacity];
        copy(a);

    }

    private boolean isFull() {
        if (size() == itemList.length) {
            return true;
        }
        return false;
    }

    private boolean isSparse() {
        if (size() > 8 && itemList.length / size > 4) {
            return true;
        }
        return false;
    }

    private void copy(T[] a) {

        /* new Array with new nextFirst and newLast !!! */
        int oldFirst = nextFirst;
        nextFirst = 4;
        nextLast = 5;
        int i = size;
        int newLength = a.length;
        while (i > 0) {
            oldFirst = plusOne(oldFirst);
            a[nextLast] = itemList[oldFirst];
            /* Note: new Array must be plus in a new size !!! */
            nextLast = plusOne(nextLast, newLength);
            i--;
        }
        itemList = a;

    }

}
