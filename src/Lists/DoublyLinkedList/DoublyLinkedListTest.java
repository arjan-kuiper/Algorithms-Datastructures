package Lists.DoublyLinkedList;

import Main.Item;
import Main.JSONHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    private ArrayList<Item> items = new ArrayList<>();


    @Before
    public void initialize()
    {
        items = JSONHandler.getItemsArrayList();
        System.out.println("All LEGO items were added to an ids array");
    }

    @Test
    public void addItems() {
        DoublyLinkedList<Item> dll = new DoublyLinkedList<>();
        dll.add(items.get(0));
        assertTrue(dll.size() == 1);
        dll.add(items.get(404));
        assertTrue(dll.size() == 2);
    }

    @Test
    public void clearList() {
        DoublyLinkedList<Object> dll = new DoublyLinkedList<>();
        dll.add(items.get(500));
        dll.add(items.get(2234));
        dll.add(items.get(0));
        assertTrue(dll.size() == 3);
        dll.clear();
        assertTrue(dll.isEmpty());
    }

    @Test
    public void isEmpty() {
        DoublyLinkedList<Object> dll = new DoublyLinkedList<>();
        assertTrue(dll.isEmpty());
        dll.add(items.get(0));
        assertFalse(dll.isEmpty());

    }

    @Test
    public void remove() {
        DoublyLinkedList<Object> dll = new DoublyLinkedList<>();
        assertEquals(0, dll.size());
        dll.add(items.get(0));
        dll.add(items.get(500));
        dll.remove(1);
        dll.remove(items.get(0));
        assertTrue(dll.isEmpty());
    }

    @Test
    public void indexOf() {
        DoublyLinkedList<Object> dll = new DoublyLinkedList<>();
        dll.add(items.get(500));
        dll.add(items.get(2234));
        dll.add(items.get(0));
        assertEquals(1, dll.indexOf(items.get(2234)));
    }
}