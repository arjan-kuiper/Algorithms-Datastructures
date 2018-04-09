package lists;

import general.Item;
import general.JSONHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueueTest {

    private ArrayList<Item> items = new ArrayList<Item>();

    @Before
    public void initialize() {
        items = JSONHandler.getItemsArrayList();
        //System.out.println("All LEGO items were added to an ids array");
    }

    @Test
    public void addToQueue() {
        Queue<Item> queue = new Queue<Item>();
        queue.enqueue(items.get(500));
        queue.enqueue(items.get(404));
        assertFalse(queue.isEmpty());
    }

    @Test
    public void removeFromQueue() {
        Queue<Item> queue = new Queue<Item>();
        queue.enqueue(items.get(500));
        queue.enqueue(items.get(404));
        assertEquals(items.get(500), queue.dequeue());
        assertEquals(items.get(404), queue.peek());
    }

    @Test
    public void peekQueue() {
        Queue<Item> queue = new Queue<Item>();
        queue.enqueue(items.get(500));
        queue.enqueue(items.get(404));
        assertEquals(items.get(500), queue.peek());
    }

    @Test
    public void clearQueue() {
        Queue<Item> queue = new Queue<Item>();
        queue.enqueue(items.get(500));
        queue.enqueue(items.get(404));
        assertFalse(queue.isEmpty());
    }

    @Test
    public void checkSizeQueue() {
        Queue<Item> queue = new Queue<Item>();
        queue.enqueue(items.get(500));
        queue.enqueue(items.get(404));
        assertFalse(queue.isEmpty());
    }

    @Test
    public void clear(){
        Queue<Item> queue = new Queue<Item>();
        queue.enqueue(items.get(500));
        queue.enqueue(items.get(404));
        assertFalse(queue.isEmpty());
        queue.clear();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void firstElement(){
        Queue<Item> queue = new Queue<Item>();
        queue.enqueue(items.get(500));
        queue.enqueue(items.get(404));
        assertEquals(items.get(500), queue.element());
    }

}