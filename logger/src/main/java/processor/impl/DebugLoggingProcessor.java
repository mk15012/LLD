package processor.impl;

import constants.Constants;
import enums.LoggingCategory;
import processor.LogLevelInitializer;
import processor.LOGGER;

public class DebugLoggingProcessor implements LOGGER {

    private boolean isLogEnabled;

    public DebugLoggingProcessor() {
        try {
            if (Constants.getLogLevel(LoggingCategory.DEBUG) <= Constants.getLogLevel(LogLevelInitializer.getLogLevel())) {
                isLogEnabled = true;
            }
        } catch (Exception e) {
            isLogEnabled = false;
        }
    }

    @Override
    public void log(LoggingCategory loggingCategory, String message) {
        if (isLogEnabled) {
            System.out.println("Debug: " + message);
        }
    }

}
