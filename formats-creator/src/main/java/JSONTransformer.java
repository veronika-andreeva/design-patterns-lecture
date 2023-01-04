import com.epam.logger.LoggerSingleton;
import com.epam.movie.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONTransformer extends AbstractMessageTransformer {
    private static final LoggerSingleton logger = LoggerSingleton.getInstance();
    private static Gson gson;


    @Override
    public void createTransformer() {
        logger.info("Creating a new JSON mapper.");
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    protected String transformMessage(Movie movie) {
        return gson.toJson(movie);
    }





}
