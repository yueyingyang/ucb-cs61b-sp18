public class LinkedListDeque<T> implements Deque<T> {

    private StuffNode sentinel;
    private int size;

    public class StuffNode {

        public T item;
        public StuffNode prev;
        public StuffNode next;

        /**
         * Constructor of StuffNode
         * @param item The value
         * @param prev The prev Link
         * @param next The next Link
         */
        public StuffNode(T item, StuffNode prev, StuffNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Constructor With param
     * @param x
     */
    public LinkedListDeque(T x) {

        T a = (T) new Object();
        sentinel = new StuffNode(a, null, null);
        sentinel.next = new StuffNode(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;

    }

    /**
     * Creates an empty linked list deque
     */
    public LinkedListDeque() {

        T a = (T) new Object();
        sentinel = new StuffNode(a, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

    }

    /**
     * Adds an item of type T to the front of the deque.
     * @param item
     */
    @Override
    public void addFirst(T item) {

        StuffNode a = new StuffNode(item, sentinel, sentinel.next);
        sentinel.next = a;
        a.next.prev = a;
        size++;
    }

    /**
     * Adds an item of type T to the back of the deque.
     * @param item
     */
    @Override
    public void addLast(T item) {

        StuffNode a = new StuffNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = a;
        sentinel.prev = a;
        size++;

    }


    /**
     * Returns true if deque is empty, false otherwise.
     * @return
     */
    @Override
    public boolean isEmpty() {

        if (size != 0) {
            return false;
        }
        return true;

    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * @return
     */
    @Override
    public void printDeque() {

        StuffNode a = sentinel.next;
        int i = size;
        while (i != 0) {
            System.out.print(a.item + " ");
            a = a.next;
            i--;
        }
        System.out.println();


    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     * @return
     */
    @Override
    public T removeFirst() {
        StuffNode a = sentinel.next;
        a.next.prev = sentinel;
        sentinel.next = a.next;
        size--;
        return a.item;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * @return
     */
    @Override
    public T removeLast() {

        StuffNode a = sentinel.prev;
        sentinel.prev = a.prev;
        a.prev.next = sentinel;
        size--;

        return a.item;
    }


    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     * @param index
     * @return
     */
    @Override
    public T get(int index) {

        StuffNode a = sentinel;
        while (index > -1) {
            a = a.next;
            index--;
        }
        return a.item;

    }


    public T getRecursive(int index) {

        StuffNode a = sentinel.next;
        return getRecurHelper(index, a);

    }

    public T getRecurHelper(int index, StuffNode a) {
        if (index == 0) {
            return a.item;
        }
        return getRecurHelper(index - 1, a.next);
    }

}
