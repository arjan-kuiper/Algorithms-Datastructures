package Lists.Queue;

import Lists.LinkedList.LinkedList;
import Main.Item;
import Main.JSONHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class QueueTest {
    private ArrayList<Item> items = new ArrayList<>();

    @Before
    public void initialize(){
        items = JSONHandler.getItemsArrayList();
        System.out.println("All LEGO items were added to an ids array");
    }

    @Test
    public void addToQueue(){
        Queue<Item> queue = new Queue();
        queue.enqueue(items.get(500));
        queue.enqueue(items.get(404));
        assertFalse(queue.isEmpty());
    }

    @Test
    public void removeFromQueue(){
        Queue<Item> queue = new Queue();
        queue.enqueue(items.get(500));
        queue.enqueue(items.get(404));
        assertEquals(items.get(404) ,queue.dequeue());
        assertEquals(items.get(500), queue.peek());
    }

    @Test
    public void peekQueue(){
        Queue<Item> queue = new Queue();
        queue.enqueue(items.get(500));
        queue.enqueue(items.get(404));
        assertEquals(items.get(404) ,queue.peek());
    }

    @Test
    public void clearQueue(){
        Queue<Item> queue = new Queue();
        queue.enqueue(items.get(500));
        queue.enqueue(items.get(404));
        assertFalse(queue.isEmpty());
    }

    @Test
    public void checkSizeQueue(){
        Queue<Item> queue = new Queue();
        queue.enqueue(items.get(500));
        queue.enqueue(items.get(404));
        assertFalse(queue.isEmpty());
    }
}