package util;

/**
 * Mocking DB exec time. use this class instead of Thread.sleep()
 */

public class SleepUtil {

    private SleepUtil() {
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
