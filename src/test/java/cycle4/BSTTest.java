package cycle4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BSTTest {

    @Test public final void test0(){

        BST tree = new BST("4 2 3 1 6 5 7");

        assertEquals("1 2 3 4 5 6 7", tree.inOrder());
        assertEquals("4 2 1 3 6 5 7", tree.preOrder());
        assertEquals("1 3 2 5 7 6 4", tree.postOrder());
        assertEquals("4 2 6 1 3 5 7", tree.levelOrder());
    }

    @Test public final void test1(){

        BST tree = new BST("23 45 67 11 17 7 9 27");

        assertEquals("7 9 11 17 23 27 45 67", tree.inOrder());
        assertEquals("23 11 7 9 17 45 27 67", tree.preOrder());
        assertEquals("9 7 17 11 27 67 45 23", tree.postOrder());
        assertEquals("23 11 45 7 17 27 67 9", tree.levelOrder());
    }
}
