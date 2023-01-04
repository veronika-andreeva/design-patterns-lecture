import com.epam.logger.LoggerSingleton;
import com.epam.movie.Movie;

public class MessageTransformerDemo {

    private static final LoggerSingleton logger = LoggerSingleton.getInstance();


    public static void main(String[] args) {
        Movie movie = new Movie.Builder()
                .withName("Avatar: The Way of Water")
                .withDirector("James Cameron")
                .withYear(2022)
                .withGenre("Fantasy")
                .withRating(10)
                .build();


        String baseDirectory = "C:\\Users\\veronika_andreeva\\test\\design-pattern-examples";
        String outpuFileName = "movie";

        logger.info("Let's create a MessageTransformer of type JSON.");
        MessageTransformer jsonTransformer = MessageTransformerFactory.getMessageTransformer(FormatType.JSON);
        jsonTransformer.writeMovieInFile(movie, baseDirectory, outpuFileName, "json");

        logger.info("Let's create a MessageTransformer of type XML.");
        MessageTransformer xmlTransformer = MessageTransformerFactory.getMessageTransformer(FormatType.XML);
        xmlTransformer.writeMovieInFile(movie, baseDirectory, outpuFileName, "xml");
    }




}
