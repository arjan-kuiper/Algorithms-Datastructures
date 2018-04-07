package Lists.LinkedList;

import Main.Item;
import Main.JSONHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LinkedListTest {
    private ArrayList<Item> items = new ArrayList<>();

    @Before
    public void initialize()
    {
        items = JSONHandler.getItemsArrayList();
        System.out.println("All LEGO items were added to an ids array");
    }

    @Test
    public void addNodes() {
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.clear();
        linkedList.addAll(items);

        assertTrue(linkedList.get(0).equals(items.get(0)));
        assertTrue(linkedList.get(linkedList.size() -1).equals(items.get(items.size() -1)));
    }

    @Test
    public void clearLinkedList() {
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add(items.get(500));
        linkedList.add(items.get(2234));
        linkedList.add(items.get(0));
        assertTrue(linkedList.size() == 3);
        linkedList.clear();
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void isEmpty() {
        LinkedList<Object> linkedList = new LinkedList<>();

        assertTrue(linkedList.isEmpty());
        linkedList.add(items.get(500));
        linkedList.add(items.get(2234));
        linkedList.add(items.get(0));
        assertFalse(linkedList.isEmpty());

    }

    @Test
    public void removeObject() {
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add(items.get(500));
        linkedList.add(items.get(2234));
        linkedList.add(items.get(0));

        linkedList.remove(items.get(2234));

        assertFalse(linkedList.contains(items.get(2234)));
        assertTrue(linkedList.size() == 2);
    }

    @Test
    public void indexOf() throws Exception {
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add(items.get(500));
        linkedList.add(items.get(2234));
        linkedList.add(items.get(0));

        assertEquals(2, linkedList.indexOf(items.get(0)));
        linkedList.remove(items.get(2234));
        assertEquals(1, linkedList.indexOf(items.get(0)));
    }
}