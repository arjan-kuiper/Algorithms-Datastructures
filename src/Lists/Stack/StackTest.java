package Lists.Stack;

import Main.Item;
import Main.JSONHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackTest {
    private ArrayList<Item> items = new ArrayList<>();

    @Before
    public void initialize()
    {
        items = JSONHandler.getItemsArrayList();
        System.out.println("All LEGO items were added to an ids array");
    }

    @Test
    public void pushToStack(){
        Stack<Item> stack = new Stack<>();
        stack.push(items.get(500));
        stack.push(items.get(404));
        assertFalse(stack.empty());

    }

    @Test
    public void peekStack(){
        Stack<Item> stack = new Stack<>();
        stack.push(items.get(500));
        stack.push(items.get(404));
        assertEquals(items.get(404) ,stack.peek());

    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyStackException() {
        Stack<Item> stack = new Stack<>();
        stack.peek();
    }

    @Test
    public void popStack(){
        Stack<Item> stack = new Stack<>();
        stack.push(items.get(500));
        stack.push(items.get(404));
        assertEquals(items.get(404) ,stack.pop());
        assertEquals(items.get(500), stack.peek());
    }

    @Test
    public void search(){
        Stack<Item> stack = new Stack<>();
        stack.push(items.get(500));
        stack.push(items.get(404));
        assertEquals(1, stack.search(items.get(500)));
    }

    @Test
    public void searchNonExisting(){
        Stack<Item> stack = new Stack<>();
        stack.push(items.get(500));
        stack.push(items.get(400));
        assertEquals(-1, stack.search(items.get(404)));
    }
}