package processor.impl;

import constants.Constants;
import enums.LoggingCategory;
import processor.LogLevelInitializer;
import processor.LOGGER;

public class InfoLoggingProcessor implements LOGGER {

    private boolean isLogEnabled;

    public InfoLoggingProcessor() {
        try {
            if (Constants.getLogLevel(LoggingCategory.INFO) <= Constants.getLogLevel(LogLevelInitializer.getLogLevel())) {
                isLogEnabled = true;
            }
        } catch (Exception e) {
            isLogEnabled = false;
        }
    }

    public void log(LoggingCategory loggingCategory, String message) {

        if (isLogEnabled) {
            System.out.println("Info: " + message);
        }
    }

}
