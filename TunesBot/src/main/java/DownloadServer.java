import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import music.SongDownloader;


public class DownloadServer extends Application<DownloadConfiguration> {

    public static void main(String[] args) throws Exception {
        new DownloadServer().run(args);
    }

    @Override
    public void initialize(Bootstrap<DownloadConfiguration> bootstrap) {
//        bootstrap.setName("songDownloader");
    }

    @Override
    public void run(DownloadConfiguration configuration, Environment environment) throws Exception {
        String musicLoc ="/Users/pragya.mittal/workspace/hackathon/deployment/music";
        String jsonFile = "/Users/pragya.mittal/workspace/hackathon/deployment/musicfile.json";

        SongDownloader songDownloader = new SongDownloader(musicLoc, jsonFile);
        songDownloader.createurlNDownloadFile();
        DownloadResource downloadResource = new DownloadResource(musicLoc, jsonFile);
        environment.jersey().register(downloadResource);

    }

}