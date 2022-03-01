import java.util.*;

public class RandomizedQueue<Item> implements Iterable<Item> {
    Random rand = new Random();
    Item[] items;
    int size;

    public RandomizedQueue() {
        size = 0;
        items = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // чи порожня?
    public int size() {
        return size;
    }

    // кількість елементів
    public void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException();
        if (size == items.length)
        {resize(items.length * 2);}
        items[size] = item;
        size++;

    }

    // додати елемент
    public Item dequeue() {
        if (size == 0)
            throw new java.util.NoSuchElementException();
        int num = rand.nextInt(size);
        Item item = items[num];
        items[num] = items[size - 1];
        items[size - 1] = null;
        size--;
        if (size <= items.length / 4)
            resize(items.length / 2);
        return item;
    }

    // видалити і повернути випадковий елемент
    public Item sample() {
        if (size == 0)
            throw new java.util.NoSuchElementException();
        return items[rand.nextInt(size)];
    }

    // повернути але не видалити випадковий елемент
    public Iterator<Item> iterator() {
        return new iterator();
    }

    private class iterator implements Iterator<Item> {
        private int curr = 0;
        private int[] it;

        public iterator() {
            if (size > 0) {
                it = new int[size];
                for (int i = 0; i < size; i++)
                    it[i] = i;
            }
            for (int i = it.length - 1; i > 0; --i) {
                int j = rand.nextInt(i + 1);
                int temp = it[i];
                it[i] = it[j];
                it[j] = temp;
            }
        }

        public boolean hasNext() {
            return curr < size;
        }


        public Item next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException();
            Item item = items[it[curr]];
            curr++;
            return item;
        }
    }

    // повернути ітератор по елементам з випадковою чергою
    private void resize(int newSize) {
        if (newSize < 1)
            return;
        Item[] newItems = (Item[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }
//змінити розмір масиву

    public static void main(String[] args) {
        RandomizedQueue<Integer> d = new RandomizedQueue<Integer>();
        d.enqueue(1000);
        d.enqueue(2000);
        d.enqueue(3000);
        d.enqueue(4000);
        d.enqueue(5000);
        d.dequeue();
        Iterator i = d.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println(d.sample());
        System.out.println(d.size());
    }
}
