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
    public void initialize() {
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
    public void addItemOnIndex() {
        DoublyLinkedList<Item> dll = new DoublyLinkedList<>();
        dll.add(items.get(500));
        dll.add(items.get(2234));

        //Check if replacing the head element causes issues.
        dll.add(0, items.get(233));
        assertEquals(items.get(233), dll.get(0));
        assertEquals(items.get(500), dll.get(1));

        //Check if replacing another element causes trouble.
        dll.add(2, items.get(2000));
        assertEquals(items.get(2000), dll.get(2));
        assertEquals(items.get(2234), dll.get(3));
    }

    @Test
    public void addAll() {
        DoublyLinkedList<Object> dll = new DoublyLinkedList<>();
        dll.addAll(items);
        assertEquals(items.size(), dll.size());
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
    public void removeByObject() {
        DoublyLinkedList<Object> dll = new DoublyLinkedList<>();
        assertEquals(0, dll.size());
        dll.add(items.get(0));
        dll.add(items.get(500));
        dll.add(items.get(404));
        dll.add(items.get(533));
        dll.add(items.get(2000));
        //Test if index 0 can be removed without breaking the code.
        dll.remove(items.get(0));
        assertEquals(4, dll.size());
        //Test if the last object can be removed without breaking the code.
        dll.remove(items.get(2000));
        assertEquals(3, dll.size());

        //Testing if anything in between the first and last object can be removed without breaking the code.
        dll.remove(items.get(404));
        assertEquals(2, dll.size());
    }

    @Test
    public void removeByIndex() {
        DoublyLinkedList<Object> dll = new DoublyLinkedList<>();
        assertEquals(0, dll.size());
        dll.add(items.get(0));
        dll.add(items.get(500));
        dll.add(items.get(404));
        dll.add(items.get(533));
        dll.add(items.get(2000));
        dll.remove(0);
        assertEquals(4, dll.size());
        dll.remove(3);
        assertEquals(3, dll.size());
        dll.remove(2);
        assertEquals(2, dll.size());

    }

    @Test
    public void removeNonExistingObject() {
        DoublyLinkedList<Object> dll = new DoublyLinkedList<>();
        assertFalse(dll.remove(items.get(500)));
    }

    @Test
    public void indexOf() {
        DoublyLinkedList<Object> dll = new DoublyLinkedList<>();
        dll.add(items.get(500));
        dll.add(items.get(2234));
        dll.add(items.get(0));

        //Check whether fetching the head doesnt cause trouble.
        assertEquals(0, dll.indexOf(items.get(500)));
        //Check whether a node inbetween doesn't cause trouble.
        assertEquals(1, dll.indexOf(items.get(2234)));
        //Check whether the fetching the tail doesn't cause trouble.
        assertEquals(2, dll.indexOf(items.get(0)));
        //Check whether trying to fetch an null object doesn't cause an exception.
        assertEquals(-1, dll.indexOf(null));
    }

    @Test
    public void size() {
        DoublyLinkedList<Object> dll = new DoublyLinkedList<>();
        dll.add(items.get(500));
        dll.add(items.get(2234));
        dll.add(items.get(0));
        assertEquals(3, dll.size());
    }

    @Test
    public void contains() {
        DoublyLinkedList<Object> dll = new DoublyLinkedList<>();
        assertFalse(dll.contains(items.get(500)));
        dll.add(items.get(500));
        assertTrue(dll.contains(items.get(500)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNodeIndexOutOfBoundsException() {
        DoublyLinkedList<Object> dll = new DoublyLinkedList<>();
        dll.get(2);
    }
}