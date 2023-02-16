package com.sparta;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryLogger {

    public static final Logger logger = Logger.getLogger(BinaryLogger.class.getName());
    static ConsoleHandler consoleHandler = new ConsoleHandler();
    public static void createLog(String level, String msg){
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
        logger.addHandler(consoleHandler);
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new CustomFormatter());

        switch (level) {
            case "ALL" -> logger.log(Level.ALL, msg);
            case "INFO" -> logger.log(Level.INFO, msg);
            case "CONFIG" -> logger.log(Level.CONFIG, msg);
            case "FINE" -> logger.log(Level.FINE, msg);
            case "FINER" -> logger.log(Level.FINER, msg);
            case "FINEST" -> logger.log(Level.FINEST, msg);
            case "WARNING" -> logger.log(Level.WARNING, msg);
            case "SEVERE" -> logger.log(Level.SEVERE, msg);
        }

    }

}
