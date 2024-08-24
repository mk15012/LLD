package constants;

import enums.LoggingCategory;

import static enums.LoggingCategory.ERROR;
import static enums.LoggingCategory.FATAL;
import static enums.LoggingCategory.INFO;
import static enums.LoggingCategory.WARN;
import static enums.LoggingCategory.DEBUG;

public class Constants {

    public static final int fatal = 1;
    public static final int error = 2;
    public static final int warn = 3;
    public static final int info = 4;
    public static final int debug = 5;

    public static int getLogLevel(LoggingCategory logLevel) throws Exception {
        if (logLevel.equals(FATAL)) {
            return fatal;
        } else if (logLevel.equals(ERROR)) {
            return error;
        } else if (logLevel.equals(WARN)) {
            return warn;
        } else if (logLevel.equals(INFO)) {
            return info;
        } else if (logLevel.equals(DEBUG)) {
            return debug;
        } else {
            throw new Exception("Invalid log level defined");
        }
    }

}
