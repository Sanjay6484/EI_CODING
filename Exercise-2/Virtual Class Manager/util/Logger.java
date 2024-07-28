package util;
import java.util.*;

public class Logger {
    private static final List<String> logs = new ArrayList<>();

    public static void log(String message) {
	logs.add(message);
        System.out.println(message);
    }
}
