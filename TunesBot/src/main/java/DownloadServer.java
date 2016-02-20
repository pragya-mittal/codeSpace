import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import music.SongDownloader;


public class DownloadServer extends Service<DownloadConfiguration> {

    public static void main(String[] args) throws Exception {
        new DownloadServer().run(new String[] { "server" });
    }

    @Override
    public void initialize(Bootstrap<DownloadConfiguration> bootstrap) {
        bootstrap.setName("blog");
    }

    @Override
    public void run(DownloadConfiguration configuration, Environment environment) throws Exception {
        String musicLoc ="/Users/pragya.mittal/workspace/hackathon/TunesBot/music/";
        String jsonFile = "src/main/resources/musicfile.json";

        SongDownloader songDownloader = new SongDownloader(musicLoc, jsonFile);
        songDownloader.createurlNDownloadFile();
        DownloadResource downloadResource = new DownloadResource("/Users/pragya.mittal/workspace/hackathon/TunesBot/music");
        environment.addResource(downloadResource);

    }

}