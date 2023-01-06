package com.epam.logger;

import com.epam.constants.Constants;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Clock;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Create a Singleton class.
 * Singleton classes can create only one object of that class.
 *
 * Implementation:
 * 1. Create a class and name it with the suffix 'Singleton'
 *
 * 2. Create a new instance. Should be private/static and should call the default constructor.
 * The reason is that we want the class to call itself.
 *
 *  Example:
 *      private static MySingleton instance = new MySingleton();
 *
 * 3. Create a private constructor so that nobody else (except for the instance in the previous step)
 * can create an object from this class with the operator 'new':
 *
 *  Example:
 *      private MySingleton() {
 *
 * 4. Create a public/static method for getting an instance of the class.
 * The naming convention is to call it getInstance().
 * Return the instance inside the method.
 *
 *  Example:
 *      public static MySingleton getInstance() {
 *          return instance;
 *      }
 *
 *  Check if you can:
 *  - create a class with the new operator
 *  - with the getInstance() method
 *
 *  Create another instance and print both - check if they are the same.
 *
 *  That is the basic creating of the singleton, but:
 *  - it is not thread-safe
 *  - we can improve the performance by making it lazy-loaded.
 *
 *
 *
 *  Improvements: make it lazy-loaded
 *  - lazy-loaded: objects are created when they are needed
 *  - eagerly-loaded: object are created on application startup
 *
 *  1. Make the instance null
 *      Example:
 *          private static MySingleton instance = null;
 *
 *  2. Create the new object when the method is called.
 *  Check first if it is not created already (if it is null).
 *
 *      Example:
        	public static MySingleton getInstance() {
 *              if (instance == null) {
 *                  instance = new MySingleton();
 *              }
 *          return instance;
 *
 *
 *
 *  Improvements: Male the Singleton class thread-safe
 *   1. Make the instance volatile
 *   Example:
 *   private static volatile MySingleton instance = null;
 *
 *   2.Protect the constructor from having a Reflection class create an instance of the class
 *      Example:
 *
 *      private MySingleton() {
 *          if (instance != null) {
 *              throw new RuntimeException("Please use the getInstance() method to create me.");
 *     }
 *
 *     3. Synchronise the code only block creating the instance only.
 *     That will improve performance.
 *     It will be used only one time eventually.
 *
 *     Example:
 *      public static DatabaseSingleton getInstance() {
 *          if (instance == null) {
 *              synchronized (DatabaseSingleton.class) {
 *                  if (instance == null) {
 *                      instance = new DatabaseSingleton();
 *                  }
 *              }
 *
 *          }
 *          return instance;
 *      }
 *
 * }
 *
 */
public class LoggerSingleton implements Logger {

    private static final Clock CLOCK_SOFIA = Clock.system(ZoneId.of("Europe/Sofia"));
    private static final String LOG_PATH = Constants.LOG_PATH;


    private static volatile LoggerSingleton instance = null;

    private LoggerSingleton() {

        if (instance != null) {
            throw new RuntimeException("Please use the getInstance() method to create me.");
        }
    }

    public static LoggerSingleton getInstance() {
        if (instance == null) {
            synchronized (LoggerSingleton.class) {
                if (instance == null) {
                    instance = new LoggerSingleton();
                }
            }
        }
        return instance;
    }

    @Override
    public void info(String message) {
        StringJoiner logMessage = createLogMessage(LogMessageType.INFO, message);

        System.out.println(logMessage);

        writeInFile(logMessage.toString());
    }

    @Override
    public void debug(String message) {

        StringJoiner logMessage = createLogMessage(LogMessageType.DEBUG, message);

        System.out.println(logMessage);

        writeInFile(logMessage.toString());

    }

    @Override
    public void error(String message) {
        StringJoiner logMessage = createLogMessage(LogMessageType.ERROR, message);

        System.out.println(logMessage);

        writeInFile(logMessage.toString());
    }

    @Override
    public boolean writeInFile(String message) {

        Path logPath = Path.of(LOG_PATH);

        if (!Files.exists(logPath)) {
            try {
                Files.createFile(logPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(Files.newBufferedWriter(logPath, StandardOpenOption.APPEND))) {

            writer.write(message);
            writer.write(System.lineSeparator());
        }

         catch (IOException e) {
            throw new RuntimeException("Error creating the log file.", e);
        }
        return false;
    }

    private StringJoiner createLogMessage(LogMessageType messageType, String message) {

        StringJoiner logMessage = new StringJoiner(" ")
                .add(CLOCK_SOFIA.instant().toString())
                .add(messageType.name())
                .add(Thread.currentThread().getStackTrace()[3].getClassName())
                .add("-")
                .add(message);

        return logMessage;

    }
}
