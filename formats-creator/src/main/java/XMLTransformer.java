import com.epam.logger.LoggerSingleton;
import com.epam.movie.Movie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLTransformer extends AbstractMessageTransformer {

    private static final LoggerSingleton logger = LoggerSingleton.getInstance();

    private XmlMapper xmlMapper;

/*
    @Override
    public void writeMovieInFile(Movie movie, String fileLocation) {
        String message = transformMessage(movie);

        Path logPath = Path.of(fileLocation + "\\" + "movie.xml");
        try (BufferedWriter writer = new BufferedWriter(Files.newBufferedWriter(logPath))) {
            writer.write(message);
        }

        catch (IOException e) {
            throw new RuntimeException("Error creating the log file.", e);
        }
    }
*/


    @Override
    public void createTransformer() {
        logger.info("Creating a new XML mapper.");
        xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    protected String transformMessage(Movie movie) {
        try {
            return xmlMapper.writeValueAsString(movie);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
