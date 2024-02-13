package util;

import java.time.LocalTime;

public class TimeUtil {

    private TimeUtil() {
    }

    public static LocalTime MockNow = LocalTime.of(0, 0, 0);

    public static LocalTime now() {
        return MockNow;
    }
}
