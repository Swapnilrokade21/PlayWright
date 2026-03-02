package secondPackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog4J2 {

    static {
        System.setProperty("log4j.configurationFile", "src/test/resources/log4j2.properties");
    }

    private static final Logger log = LogManager.getLogger(TestLog4J2.class);

    public static void main(String[] args) {

        log.info("Website Open 1");
        log.debug("Properties File Loaded");
        log.error("Log in Site");
        log.warn("Log Out from Site");
        log.info("Again Log in to Site"); 

    }
}
