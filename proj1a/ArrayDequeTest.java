import org.junit.Assert;
import org.junit.Test;

public class ArrayDequeTest {


    @Test
    public void addTest() {

        ArrayDeque<String> a = new ArrayDeque("Hua");
        a.addFirst("ChengYu");
        a.addLast("Love Yueying Yang");
        int i = 100;
        while (i > 0) {
            a.addFirst("CHENYU");
            i--;
        }
        i = 100;
        while (i > 0) {
            a.removeFirst();
            i--;
        }
        System.out.println(a.removeLast());

        Assert.assertEquals(2, a.size());
        a.printDeque();


    }

}
