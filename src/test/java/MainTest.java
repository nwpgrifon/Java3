import lesson6.Main;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private static Main main;

    @BeforeAll
    public static void init() {
        main = new Main();
    }


    @Test
    public void fooTest() {
        int[]  arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[]  exitArr = {1, 7};
        assertNotNull(arr);
        assertEquals(main.foo(arr).get(0), exitArr[0]);
        assertEquals(main.foo(arr).get(1), exitArr[1]);

        System.out.println("This test is fooTest");
    }

    @Test
    public void barTest() {
        int[]  arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        assertTrue(main.bar(arr));

        int[]  arr1 = {2, 2, 3, 7};
        assertFalse(main.bar(arr1));

        System.out.println("This test is barTest");
    }

}
