import java.util.Iterator;
import java.util.NoSuchElementException;

class Deque<Item> implements Iterable<Item> {
    private class Node<Item>
    {
        Item item;
        Node prev, next;

        public Node (Item item)
        {
            if (item == null) { throw new NullPointerException(); }
            this.item = item;
            this.prev = this.next = null;

        }
    };

    Node<Item> first;
    Node<Item> last;
    int size;

    public Deque(){
        first = last = null;
        size = 0;
    }
    // створюється порожня дека
    public boolean isEmpty(){return (first == null);}
    // чи порожня?
    public int size(){return size;}
    // кількість елементів в деці
    public void addFirst(Item item){
        Node n = new Node<Item>(item);

        if (n == null)
            throw new NullPointerException();
        else {
            if (first == null)
                last = first = n;

            else {
                n.next = first;
                first.prev = n;
                first = n;
            }
            size++;
        }
    }
    // додаємо на початок
    public void addLast(Item item){
        Node n = new Node<Item>(item);

        if (n == null)
            throw new NullPointerException();
        else {

            if (last == null)
                first = last = n;

            else {
               n.prev = last;
                last.next = n;
                last = n;
            }

            size++;
        }
    }
    // додаємо в кінець
    public Item removeFirst(){
        Item deleted = first.item;
        if (isEmpty())
            throw new NoSuchElementException();

        else {
            first = first.next;

            if (first == null)
               last = null;
            else
                first.prev = null;

            size--;
        }
        return deleted;
    }
    // видаляємо і повертаємо перший
    public Item removeLast(){
        Item deleted = last.item;
        if (isEmpty())
            throw new NoSuchElementException();

        else {
            last = last.prev;

            if (last == null)
                first = null;
            else
                last.next = null;

            size--;
        }
        return deleted;
    }
    // видаляємо і повертаємо останній
    public Iterator<Item> iterator(){
         return new iterator();
    }
// повертаємо ітератор по елементам
    private class iterator implements Iterator<Item> {

        Node<Item> n = first;

        public boolean hasNext() {
            return n!= null;
        }

        public Item next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
            Item item = n.item;
            n = n.next;
            return item;
        }
    }
    public static void main(String[] args){
        Deque<String> d = new Deque<String>();
        d.addFirst("1000");
        d.addFirst("2000");
        d.addFirst("3000");
        d.removeLast();
        d.removeFirst();
        Iterator i = d.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
