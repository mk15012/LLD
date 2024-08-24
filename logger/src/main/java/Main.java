import enums.LoggingCategory;
import processor.LOGGER;
import processor.LogLevelInitializer;
import processor.impl.WarnLoggingProcessor;

public class Main {
    public static void main(String[] args) {

        LogLevelInitializer logLevelInitializer = new LogLevelInitializer(LoggingCategory.ERROR);
        LOGGER logger = new WarnLoggingProcessor();

        logger.log(LoggingCategory.WARN, "Hey warning 1");
        logger.log(LoggingCategory.ERROR, "Hey error");
        logger.log(LoggingCategory.DEBUG, "Hey debug");
        logger.log(LoggingCategory.INFO, "Hey info");
        logger.log(LoggingCategory.WARN, "Hey warning 2");


    }
}