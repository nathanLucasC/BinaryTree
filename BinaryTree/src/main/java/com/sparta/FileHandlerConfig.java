package com.sparta;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class FileHandlerConfig {
    static void getFileHandler() {
        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/BinaryTreelogFile.log", true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new CustomFormatter());
            BinaryLogger.logger.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}