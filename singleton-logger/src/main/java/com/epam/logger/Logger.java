package com.epam.logger;

import java.io.File;

public interface Logger {

    void info(String message);
    void debug(String message);
    void error(String message);


    boolean writeInFile(String message);
}
