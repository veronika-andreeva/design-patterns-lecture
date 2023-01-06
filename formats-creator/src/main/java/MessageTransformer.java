import com.epam.movie.Movie;

import java.io.File;

public interface MessageTransformer {


    //void writeMovieInFile(Movie movie, String fileLocation);

    void writeMovieInFile(Movie movie, String fileLocation, String fileName, String format);

}
