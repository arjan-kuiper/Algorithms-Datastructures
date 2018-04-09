package lists;

import general.Item;
import general.JSONHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private ArrayList<Item> items = new ArrayList<Item>();
    private int[] ids;

    @Before
    public void initialize() {
        items = JSONHandler.getItemsArrayList();
        ids = new int[items.size()];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = items.get(i).getItemNr();
        }
        //System.out.println("All LEGO items were added to an ids array");
    }

    @Test
    public void insert() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.insert(ids[50]);
        assertTrue(bst.find(ids[50]));
        assertFalse(bst.find(ids[10]));
        bst.insert(ids[10]);
        assertTrue(bst.find(ids[10]));
    }

    @Test(expected = NullPointerException.class)
    public void delete() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.insert(ids[50]);
        assertTrue(bst.find(ids[50]));
        bst.delete(ids[50]);
        bst.delete(ids[40]);
        assertFalse(bst.find(ids[40]));
        bst.insert(ids[40]);
        assertTrue(bst.find(ids[40]));
        bst.delete(ids[40]);
        assertFalse(bst.find(ids[40]));
    }

    @Test
    public void find() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        assertFalse(bst.find(ids[62]));
        bst.insert(ids[62]);
        assertTrue(bst.find(ids[62]));
        bst.delete(ids[62]);
        assertFalse(bst.find(ids[62]));
    }

    @Test
    public void height() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        assertEquals(-1, bst.height());
        bst.insert(ids[89]);
        assertNotEquals(-1, bst.height());
        assertEquals(0, bst.height());
        bst.insert(ids[99]);
        bst.insert(ids[51]);
        assertEquals(1, bst.height());
        bst.insert(ids[105]);
        assertEquals(2, bst.height());
        bst.delete(ids[105]);
        assertEquals(1, bst.height());
    }

    @Test
    public void countLeaves() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        assertEquals(0, bst.countLeaves());
        bst.insert(ids[89]);
        assertEquals(1, bst.countLeaves());
    }

    @Test
    public void width() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        assertEquals(0, bst.countLeaves());
        bst.insert(ids[89]);
        assertEquals(1, bst.countLeaves());
        bst.insert(ids[112]);
        bst.insert(ids[153]);
        bst.insert(ids[144]);
        assertEquals(1, bst.countLeaves());
        bst.insert(ids[55]);
        assertEquals(2, bst.countLeaves());
    }

    @Test
    public void clear() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        assertFalse(bst.find(ids[89]));
        bst.insert(ids[89]);
        assertTrue(bst.find(ids[89]));
        bst.insert(ids[24]);
        bst.insert(ids[52]);
        bst.insert(ids[73]);
        assertTrue(bst.find(ids[52]));
        bst.clear();
        assertFalse(bst.find(ids[52]));
        assertFalse(bst.find(ids[89]));
        assertFalse(bst.find(ids[24]));
        assertFalse(bst.find(ids[73]));
    }
}
