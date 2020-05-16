import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class IOManagerTests {

    private IOManager manager;

    @Before
    public void setup() {
        manager = new IOManager(new Scanner(System.in));

    }

    @Test
    public void readBedsNumber_ShouldPass() {
        int result = manager.readBedsNumber();
        Assert.assertTrue("Input should be 4", 4 == result);
    }


}
