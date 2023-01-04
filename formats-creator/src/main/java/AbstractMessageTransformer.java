import com.epam.logger.LoggerSingleton;
import com.epam.movie.Movie;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class AbstractMessageTransformer implements MessageTransformer {

    private static final LoggerSingleton logger = LoggerSingleton.getInstance();

    //constructor using the abstract create method
    public AbstractMessageTransformer() {
        this.createTransformer();
    }

    // method used for the factory
    public abstract void createTransformer();

    protected abstract String transformMessage(Movie movie);


    // this method is used in all the children -> implementing it in the abstract class
    public void writeMovieInFile(Movie movie, String fileLocation, String fileName, String format) {
        String message = transformMessage(movie);

        String outputFilePath = fileLocation + "\\" + fileName + "." + format;

        Path logPath = Path.of(outputFilePath);
        try (BufferedWriter writer = new BufferedWriter(Files.newBufferedWriter(logPath))) {
            logger.info("Writing movie details into a " + format + " file.");
            logger.info("Output file: " + outputFilePath);
            writer.write(message);
        }

        catch (IOException e) {
            throw new RuntimeException("Error creating the log file.", e);
        }
    }



}
