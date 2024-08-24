import manager.FileSystem;
import manager.impl.Directory;
import manager.impl.File;

public class FileApplication {

    public static void main(String[] args) {

        Directory movieDirectory = new Directory("movie");

        FileSystem border = new File("Border");
        movieDirectory.add(border);

        Directory comedyMovieDirectory = new Directory("comedy");

        FileSystem hulchul = new File("hulchul");
        comedyMovieDirectory.add(hulchul);
        movieDirectory.add(comedyMovieDirectory);

        movieDirectory.ls();


    }
}
