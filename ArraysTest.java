import HW6.ArraysMethods;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArraysTest {

    ArraysMethods am;

    @Before
    public void prepare() {
        am = new ArraysMethods();
    }

    @Test
    public void testExtract() {
        Assert.assertArrayEquals(new int[]{1, 7}, am.extract(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test
    public void testExtract2() {
        Assert.assertArrayEquals(new int[]{}, am.extract(new int[]{1, 4, 8, 0, 2, 3, 1, 1, 4}));
    }

    @Test(expected = RuntimeException.class)
    public void testExtract3() {
        am.extract(new int[]{1, 0, 5, 7, 12, 6, 3, 2});
    }

    @Test
    public void testExtract4() {
        Assert.assertArrayEquals(new int[]{0, 8, 0, 2, 3, 1, 1, 7}, am.extract(new int[]{4, 0, 8, 0, 2, 3, 1, 1, 7}));
    }

    @Test
    public void testCheckArray() {
        Assert.assertEquals(false, am.checkArray(new int[]{1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void testCheckArray2() {
        Assert.assertEquals(true, am.checkArray(new int[]{1, 1, 4, 1, 4, 4}));
    }

    @Test
    public void testCheckArray3() {
        Assert.assertEquals(false, am.checkArray(new int[]{4, 4, 4, 4}));
    }

    @Test
    public void testCheckArray4() {
        Assert.assertEquals(false, am.checkArray(new int[]{1, 4, 4, 1, 1, 4, 4, 1, 3}));
    }

}
