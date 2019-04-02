package session3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilsTest {

    private ArrayUtils arrayUtils;

    @Before
    public void setUp() {
        arrayUtils = new ArrayUtils();
    }

    @Test
    public void testSumSuccess() {
        int actual = arrayUtils.sum(new Integer[]{1, 2, 3});
        Assert.assertEquals(6, actual);
    }

    @Test
    public void testSumEmpty() {
        int actual = arrayUtils.sum(new Integer[]{});
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testSumSingle() {
        int actual = arrayUtils.sum(new Integer[]{100});
        Assert.assertEquals(100, actual);
    }

    @Test
    public void testSumNull() {
        int actual = arrayUtils.sum(null);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testSumNulls() {
        int actual = arrayUtils.sum(new Integer[]{null});
        Assert.assertEquals(0, actual);
    }
}