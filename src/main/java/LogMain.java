import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogMain {
    static Logger logger = LoggerFactory.getLogger("moj logger");

    public static void main(String[] args) {

        logger.warn("warning");
        logger.error("error");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");

    }
}
