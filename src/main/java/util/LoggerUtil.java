package util;
import java.io.IOException;
import java.util.logging.*;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger("BookstoreApp");

    static {
        try {
            FileHandler fh = new FileHandler("bookstore.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            logger.severe("Failed to initialize logger: " + e.getMessage());
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}

