package Lists.BinarySearchTree;
import Main.Item;
import Main.JSONHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private ArrayList<Item> items = new ArrayList<>();
    private int[] ids;

    @Before
    public void initialize(){
        items = JSONHandler.getItemsArrayList();
        ids = new int[items.size()];
        for(int i = 0; i < ids.length; i++){
            ids[i] = items.get(i).getItemNr();
        }
        System.out.println("All LEGO items were added to an ids array");
    }

    @Test
    public void find() throws Exception {
        BinarySearchTree b = new BinarySearchTree();
        b.insertArray(ids);

        assertTrue(b.find(60085));
        assertTrue(b.find(88003));
        assertFalse(b.find(644));
        b.insert(644);
        assertTrue(b.find(644));
    }

    @Test
    public void delete() throws Exception {
        BinarySearchTree b = new BinarySearchTree();
        b.insertArray(ids);

        assertTrue(b.find(88003));
        b.delete(88003);
        assertFalse(b.find(88003));

        assertTrue(b.find(70754));
        assertTrue(b.find(10571));
        b.delete(70754);
        b.delete(10571);
        assertFalse(b.find(70754));
        assertFalse(b.find(10571));
    }

    @Test
    public void insert() throws Exception {
        BinarySearchTree b = new BinarySearchTree();
        b.insertArray(ids);

        assertTrue(b.find(850852));
        assertFalse(b.find(20));
        b.insert(20);
        assertTrue(b.find(20));
    }

    @Test
    public void insertArray() throws Exception {
        BinarySearchTree b = new BinarySearchTree();
        b.insertArray(ids);

        assertTrue(b.find(620));
        int[] someMore = new int[]{2, 4, 6, 8, 10};
        assertFalse(b.find(2));
        assertFalse(b.find(6));
        assertFalse(b.find(10));
        b.insertArray(someMore);
        assertTrue(b.find(2));
        assertTrue(b.find(6));
        assertTrue(b.find(10));
        b.delete(2);
        assertFalse(b.find(2));
        b.insertArray(new int[]{2});
        assertTrue(b.find(2));
    }

    @Test
    public void size() throws Exception {
        BinarySearchTree b = new BinarySearchTree();
        b.insertArray(ids);

        System.out.println(b.size(b.getRootNode()));
    }

    @Test
    public void isEmpty() throws Exception {

    }

    @Test
    public void clear() throws Exception {

    }

}
