package processor.impl;

import constants.Constants;
import enums.LoggingCategory;
import processor.LogLevelInitializer;
import processor.LOGGER;

public class ErrorLoggingProcessor implements LOGGER {

    private boolean isLogEnabled;

    public ErrorLoggingProcessor() {
        try {
            if (Constants.getLogLevel(LoggingCategory.ERROR) <= Constants.getLogLevel(LogLevelInitializer.getLogLevel())) {
                isLogEnabled = true;
            }
        } catch (Exception e) {
            isLogEnabled = false;
        }
    }

    @Override
    public void log(LoggingCategory loggingCategory, String message) {
        if (isLogEnabled) {
            System.out.println("Error: " + message);
        }
    }
}
