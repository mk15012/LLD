package processor.impl;

import constants.Constants;
import enums.LoggingCategory;
import processor.LogLevelInitializer;
import processor.LOGGER;

public class WarnLoggingProcessor implements LOGGER {

    private boolean isLogEnabled;

    public WarnLoggingProcessor() {
        try {
            if (Constants.getLogLevel(LoggingCategory.WARN) <= Constants.getLogLevel(LogLevelInitializer.getLogLevel())) {
                isLogEnabled = true;
            }
        } catch (Exception e) {
            isLogEnabled = false;
        }
    }


    @Override
    public void log(LoggingCategory loggingCategory, String message) {
        if (isLogEnabled) {
            System.out.println("Warn: " + message);
        }
    }

}
