import java.util.Timer;

import config.AppConfig;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import music.SongDownloadTask;

public class DownloadServer extends Application<DownloadConfiguration> {

  private final long MILLIS_IN_HOUR = 60 * 60 * 1000;

  public static void main(String[] args) throws Exception {
    new DownloadServer().run(args);
  }

  @Override
  public void initialize(Bootstrap<DownloadConfiguration> bootstrap) {
  }

  @Override
  public void run(DownloadConfiguration configuration, Environment environment) throws Exception {
    scheduleDownloader(configuration.getAppConfig());
    DownloadResource downloadResource = new DownloadResource(configuration.getAppConfig());
    environment.jersey().register(downloadResource);
  }

  private void scheduleDownloader(AppConfig conf) {
    Timer timer = new Timer();  //At this line a new Thread will be created
    timer.schedule(new SongDownloadTask(conf), 1 * MILLIS_IN_HOUR);
  }
}