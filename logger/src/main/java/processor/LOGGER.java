package processor;

import enums.LoggingCategory;

public interface LOGGER {

    void log(LoggingCategory loggingCategory, String message);
}
