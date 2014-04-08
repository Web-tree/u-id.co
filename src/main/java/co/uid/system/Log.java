package co.uid.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * @author Max Levicky
 *         Date: 13.04.13
 *         Time: 20:40
 */
public class Log {
    private static final HashMap<String, Logger> loggers = new HashMap<>();

    public static Logger getLogger(Class clazz) {
        String name = clazz.getName();
        if (!loggers.containsKey(name)) {
            synchronized (loggers) {
                if (!loggers.containsKey(name)){
                    loggers.put(name, LoggerFactory.getLogger(name));
                }
            }
        }
        return loggers.get(name);
    }
}
