package stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by williamwillems on 06/01/16.
 */
public class StackTest {
    private Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = BoundedStack.make(2);
    }

    @Test
    public void newlyCreatedStack_ShouldBeEmpty() throws Exception {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }

    @Test
    public void AfterOnePush_StackSizeShouldBeOne() throws Exception {
        stack.push(1);
        assertEquals(1, stack.getSize());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void afterOnePushandOnePop_shouldBeEmpty() throws Exception {
        stack.push(1);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test(expected = BoundedStack.Overflow.class)
    public void test() throws Exception {
        stack.push(1);
        stack.push(1);
        stack.push(1);
    }

    @Test(expected = BoundedStack.Underflow.class)
    public void WhenEmptyStackispopped_throwUnderflow() throws Exception {
        stack.pop();
    }

    @Test
    public void WhenOneispushed_oneispopped() throws Exception {
        stack.push(1);
        assertEquals(1, stack.pop());

    }

    @Test
    public void whenoneandtwoarepushed_twoandonearepopped() throws Exception {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test(expected = BoundedStack.IllegalCapacity.class)
    public void whencreatingstackwithnegativesize_shouldthrowillegalcapacity() throws Exception {
        BoundedStack.make(-1);
    }

    @Test(expected = BoundedStack.Overflow.class)
    public void whencreatingstackwithzerocapacity_anypushshouldoverflow() throws Exception {
        stack = BoundedStack.make(0);
        stack.push(1);
    }

    @Test
    public void whenOneIspushed_oneisontop() throws Exception {
        stack.push(1);
        assertEquals(1, stack.top());
    }

    @Test(expected = Stack.Empty.class)
    public void whenstackisempty_topthrowsempty() throws Exception {
        stack.top();
    }

    @Test(expected = Stack.Empty.class)
    public void withzerocapacitystack_topthrowsemtpy() throws Exception {
        stack = BoundedStack.make(0);
        stack.top();
    }

    @Test
    public void givenstackwithonetwopushed_findoneandtwo() throws Exception {
        stack.push(1);
        stack.push(2);
        assertEquals(1, stack.find(1).intValue());
        assertEquals(0, stack.find(2).intValue());
    }

    @Test
    public void givenstackwithno2_findshouldreturnnull() throws Exception {
        assertNull(stack.find(2));
    }
}
