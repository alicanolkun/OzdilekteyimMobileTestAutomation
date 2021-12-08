package Utilities;

import com.thoughtworks.gauge.Logger;

public class Log4j {
    private static Logger Log = new Logger();

    public static void startLog() {
        Log.info("Test is Starting...");
    }


    public static void endLog() {
        Log.info("Test is Ending...");
    }

    //Info Level
    public static void info(String message) {
        Log.info(message);
    }
}
