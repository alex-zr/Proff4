package session3;

public class ArrayUtilTest {
    private ArrayUtils arrayUtils;

    public static void main(String[] args) {
        ArrayUtilTest utils = new ArrayUtilTest();
        utils.testSumSuccess();
        utils.testSumEmpty();
        utils.testSumSingle();
        utils.testSumNull();
        utils.testSumNulls();
    }

    public void testSumSuccess() {
        arrayUtils = new ArrayUtils();
        int actual = arrayUtils.sum(new Integer[]{1, 2, 3});
        if (actual == 6) {
            System.out.println("Test Ok");
        } else {
            System.err.println("Test fail");
        }
    }

    public void testSumEmpty() {
        arrayUtils = new ArrayUtils();
        int actual = arrayUtils.sum(new Integer[]{});
        if (actual == 0) {
            System.out.println("Test Ok");
        } else {
            System.err.println("Test fail");
        }
    }

    public void testSumSingle() {
        arrayUtils = new ArrayUtils();
        int actual = arrayUtils.sum(new Integer[]{100});
        if (actual == 100) {
            System.out.println("Test Ok");
        } else {
            System.err.println("Test fail");
        }
    }

    public void testSumNull() {
        arrayUtils = new ArrayUtils();
        int actual = arrayUtils.sum(null);
        if (actual == 0) {
            System.out.println("Test Ok");
        } else {
            System.err.println("Test fail");
        }
    }

    public void testSumNulls() {
        arrayUtils = new ArrayUtils();
        int actual = arrayUtils.sum(new Integer[]{null});
        if (actual == 0) {
            System.out.println("Test Ok");
        } else {
            System.err.println("Test fail");
        }
    }
}
