import org.junit.Assert;
import org.junit.Test;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    public void testConstructor() {

        LinkedListDeque<String> a = new LinkedListDeque();
        Assert.assertEquals(true, a.isEmpty());

    }

    @Test
    public void getTest() {

        LinkedListDeque<String> a = new LinkedListDeque("HUA");
        int i = 100;
        while (i > 0) {
            a.addFirst("CHENYU");
            i--;
        }
        a.addFirst("CHENYU");


        Assert.assertEquals("HUA", a.getRecursive(1));

        a.printDeque();


    }

}
