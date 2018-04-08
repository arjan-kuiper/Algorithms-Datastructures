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
    public void addItemOnIndex() {
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add(items.get(500));
        linkedList.add(items.get(2234));

        //Check if replacing the head element causes issues.
        linkedList.add(0, items.get(233));
        assertEquals(items.get(233), linkedList.get(0));
        assertEquals(items.get(500), linkedList.get(1));

        //Check if replacing another element causes trouble.
        linkedList.add(2, items.get(2000));
        assertEquals(items.get(2000), linkedList.get(2));
        assertEquals(items.get(2234), linkedList.get(3));

    }

    @Test
    public void addAll()
    {
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.addAll(items);
        assertEquals(items.size(), linkedList.size());
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

        //Check whether removing a not 0 index object works.
        linkedList.remove(items.get(2234));
        assertFalse(linkedList.contains(items.get(2234)));
        assertTrue(linkedList.size() == 2);

        //Check whether removing the index 0 object works.
        linkedList.remove(items.get(500));
        assertFalse(linkedList.contains(items.get(500)));
        assertTrue(linkedList.size() == 1);
    }

    @Test
    public void removeNonExistingObject()
    {
        LinkedList<Object> linkedList = new LinkedList<>();
        assertFalse(linkedList.remove(items.get(500)));
    }

    @Test
    public void indexOf() {
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add(items.get(500));
        linkedList.add(items.get(2234));
        linkedList.add(items.get(0));

        assertEquals(2, linkedList.indexOf(items.get(0)));
        linkedList.remove(items.get(2234));
        assertEquals(1, linkedList.indexOf(items.get(0)));
        assertEquals(-1, linkedList.indexOf(null));
    }

    @Test
    public void setTest(){
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add(items.get(500));
        linkedList.add(items.get(2234));
        linkedList.add(items.get(0));

        linkedList.set(0, items.get(404));
        assertEquals(items.get(404), linkedList.get(0));


    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNodeIndexOutOfBoundsException() {
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.get(2);
    }
}