package processor;

import enums.LoggingCategory;

public class LogLevelInitializer {

    private static volatile LoggingCategory logLevel;

    public LogLevelInitializer() {
        if(logLevel == null) {
            synchronized (LogLevelInitializer.class) {
                if(logLevel == null) {
                    logLevel = LoggingCategory.INFO;
                }
            }
        }
    }

    public LogLevelInitializer(LoggingCategory loggingCategory) {
        if(logLevel == null) {
            synchronized (LogLevelInitializer.class) {
                if(logLevel == null) {
                    logLevel = loggingCategory;
                }
            }
        }
    }

    public static LoggingCategory getLogLevel() {
        return logLevel;
    }
}
