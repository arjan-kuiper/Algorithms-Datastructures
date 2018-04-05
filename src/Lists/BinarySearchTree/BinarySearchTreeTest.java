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

}
